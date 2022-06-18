package com.lagou.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.lagou.dao.UserMapper;
import com.lagou.domain.*;
import com.lagou.service.UserService;
import com.lagou.utils.Md5;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**************************************
 * @author pan
 * @version 2022/6/12 0:17
 **************************************/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<User> findAllUserByPage( UserVO userVo) {

        PageHelper.startPage(userVo.getCurrentPage(),userVo.getPageSize());
        List<User> allUserByPage = userMapper.findAllUserByPage(userVo);
        PageInfo<User> userPageInfo = new PageInfo<>(allUserByPage);
        return userPageInfo;
    }

    @Override
    public User login(User user) throws Exception {
        User login = userMapper.login(user);

        if(login !=null && Md5.verify(user.getPassword(),"lagou",login.getPassword())){
            return login;
        }else{
            return null;
        }

    }

    @Override
    public List<Role> findUserRelationRoleById(Integer id) {
        List<Role> roles = userMapper.findUserRelationRoleById(id);

        return roles;
    }

    @Override
    public void userContextRole( UserVO userVO) {
        userMapper.deleteUserContextRole(userVO.getUserId());
        User_Role_relation user_role_relation = new User_Role_relation();
        user_role_relation.setUserId(userVO.getUserId());
        Date date = new Date();
        user_role_relation.setCreatedTime(date);
        user_role_relation.setUpdatedTime(date);
        user_role_relation.setCreatedBy("system");
        user_role_relation.setUpdatedBy("system");

        for (Integer integer : userVO.getRoleIdList()) {
            user_role_relation.setRoleId(integer);
            userMapper.userContextRole(user_role_relation);
        }
    }

    @Override
    public ResponseResult getUserPermissions(Integer userId) {
        //1.根据userID 获取多个角色
        List<Role> roleList = userMapper.findUserRelationRoleById(userId);
        ArrayList<Integer> roleIds = new ArrayList<>();
        //2.遍历出角色ID
        for (Role role : roleList) {
            roleIds.add(role.getId());
        }
        //3.获取主菜单
        List<Menu> menuList = userMapper.findParentMenuByRoleId(roleIds);

        //4.获取对应子菜单
        for (Menu menu : menuList) {
            List<Menu> subMenuList = userMapper.findSubMenuByPid(menu.getId());
            menu.setSubMenuList(subMenuList);
        }
        //5.获取资源
        List<Resource> resourceList = userMapper.findResourceByRoleId(roleIds);

        HashMap<String, Object> map = new HashMap<>();
        map.put("menuList",menuList);
        map.put("resourceList",resourceList);

        return new ResponseResult(true,200,"响应成功",map);

    }


}
