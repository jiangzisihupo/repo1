package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.domain.User;
import com.lagou.domain.UserVO;

import java.util.List;

/**************************************
 * @author pan
 * @version 2022/6/12 0:16
 **************************************/
public interface UserService {

    /*
     *  用户分页&条件查询
     * */
    public PageInfo<User> findAllUserByPage(UserVO userVo);

    /*
     * 用户登入
     * */
    public User login(User user) throws Exception;

    /*
     * 根据用户ID查询关联信息
     * */
    public List<Role> findUserRelationRoleById(Integer id);

    /*
    * 分配角色
    * */
    public void userContextRole(UserVO userVO);

    /*
    * 获取用户权限,进行菜单动态展示
    * */

    public ResponseResult getUserPermissions(Integer userId);


}
