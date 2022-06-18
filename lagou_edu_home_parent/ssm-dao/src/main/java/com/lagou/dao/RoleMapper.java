package com.lagou.dao;

import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVo;
import com.lagou.domain.Role_menu_relation;

import java.util.List;

/**************************************
 * @author pan
 * @version 2022/6/12 22:31
 **************************************/
public interface RoleMapper {

    /*
    * 查询所有角色@根据条件查询
    * */
    public List<Role> findAllRole(Role role);

    /*
    * 新增角色
    * */
    public void saveRole(Role role);

    /*
    * 修改角色
    * */
    public void updateRole(Role role);

    /*
    * 根据角色ID查询关键菜单信息id
    * */
    public List<Integer> findMenuByRoleId(int roleId);

    /*
    * 根据roleId清空中间表
    * */
    public void deleteRoleContextMenu(Integer roleId);

    /*
    * 为角色分配菜单
    * */
    public void RoleContextMenu(Role_menu_relation role_menu_relation);

    /*
    * 删除角色
    * */
    public void deleteRole(Integer roleId);


}
