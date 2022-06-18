package com.lagou.controller;

import com.lagou.domain.Menu;
import com.lagou.domain.ResponseResult;
import com.lagou.domain.Role;
import com.lagou.domain.RoleMenuVo;
import com.lagou.service.MenuService;
import com.lagou.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**************************************
 * @author pan
 * @version 2022/6/12 22:40
 **************************************/
@RestController
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @RequestMapping("/findAllRole")
    public ResponseResult findAllRole(@RequestBody Role role){
        List<Role> allRole = roleService.findAllRole(role);
        return new ResponseResult(true, 200, "响应成功", allRole);

    }

    @RequestMapping("/saveOrUpdateRole")
    public ResponseResult saveOrUpdateRole(@RequestBody Role role){

        role.setCreatedBy("system");
        role.setUpdatedBy("system");

        if(role.getId() !=null){
            roleService.updateRole(role);
            return new ResponseResult(true, 200, "修改成功", null);
        }else{
            roleService.saveRole(role);
            return new ResponseResult(true, 200, "新增成功", null);
        }
    }

    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu(){
        List<Menu> subMenuListByPid = menuService.findSubMenuListByPid(-1);

        HashMap<String, Object> map = new HashMap<>();
        map.put("parentMenuList",subMenuListByPid);

        return new ResponseResult(true, 200, "响应成功", map);
    }

    @RequestMapping("/findMenuByRoleId")
    public ResponseResult findMenuByRoleId (int roleId){
        List<Integer> menuByRoleId = roleService.findMenuByRoleId(roleId);
        return new ResponseResult(true, 200, "响应成功", menuByRoleId);
    }

    @RequestMapping("/RoleContextMenu")
    public ResponseResult RoleContextMenu (@RequestBody RoleMenuVo roleMenuVo){
        roleService.RoleContextMenu(roleMenuVo);
        return new ResponseResult(true, 200, "响应成功", null);
    }

    @RequestMapping("/deleteRole")
    public ResponseResult deleteRole(Integer id){
        roleService.deleteRole(id);
        return new ResponseResult(true, 200, "响应成功", null);
    }
}
