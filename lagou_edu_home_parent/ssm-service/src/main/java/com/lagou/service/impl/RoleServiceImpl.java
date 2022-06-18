package com.lagou.service.impl;

import com.lagou.dao.RoleMapper;
import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVo;
import com.lagou.domain.Role_menu_relation;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**************************************
 * @author pan
 * @version 2022/6/12 22:39
 **************************************/
@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public List<Role> findAllRole(Role role) {
        List<Role> allRole = roleMapper.findAllRole(role);
        return allRole;
    }

    @Override
    public void saveRole(Role role) {
        Date date = new Date();
        role.setCreatedTime(date);
        role.setUpdatedTime(date);
        roleMapper.saveRole(role);
    }

    @Override
    public void updateRole(Role role) {
        Date date = new Date();
        role.setUpdatedTime(date);
        roleMapper.updateRole(role);
    }

    @Override
    public List<Integer> findMenuByRoleId(int roleId) {
        List<Integer> menuByRoleId = roleMapper.findMenuByRoleId(roleId);
        return menuByRoleId;
    }

    @Override
    public void RoleContextMenu(RoleMenuVo roleMenuVo) {
        roleMapper.deleteRoleContextMenu(roleMenuVo.getRoleId());

        Date date = new Date();
        Role_menu_relation role_menu_relation = new Role_menu_relation();
        role_menu_relation.setUpdatedTime(date);
        role_menu_relation.setCreatedTime(date);
        role_menu_relation.setRoleId(roleMenuVo.getRoleId());
        role_menu_relation.setCreatedBy("system1");
        role_menu_relation.setUpdatedBy("system1");
        for (Integer mid : roleMenuVo.getMenuIdList()) {
            role_menu_relation.setMenuId(mid);
            roleMapper.RoleContextMenu(role_menu_relation);
        }
    }

    @Override
    public void deleteRole(Integer roleId) {
        roleMapper.deleteRoleContextMenu(roleId);
        roleMapper.deleteRole(roleId);
    }
}
