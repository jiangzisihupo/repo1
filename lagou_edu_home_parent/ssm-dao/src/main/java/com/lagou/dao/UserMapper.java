package com.lagou.dao;

import com.lagou.domain.*;

import java.util.List;

/**************************************
 * @author pan
 * @version 2022/6/11 23:57
 **************************************/
public interface UserMapper {

    /*
    *  用户分页&条件查询
    * */
    public List<User> findAllUserByPage(UserVO userVo);

    /*
    * 用户登入
    * */
    public User login(User user);

    /*
    * 根据ID清空用户权限中间表
    * */
    public void deleteUserContextRole(Integer id);

    /*
    * 分配角色
    * */
    public void userContextRole(User_Role_relation user_role_relation);

    /*
     * 根据用户ID查询关联信息
     * */
    public List<Role> findUserRelationRoleById(Integer id);

    /*
    * 根据id查询顶级(父级)菜单
    * */
    public List<Menu> findParentMenuByRoleId(List<Integer> ids);

    /*
    * 根据Pid查询自己菜单
    * */
    public List<Menu> findSubMenuByPid (Integer Pid);

    /*
    * 根据用户ID查询所有资源
    * */
    public List<Resource> findResourceByRoleId (List<Integer> ids);

}
