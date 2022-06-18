package com.lagou.controller;

import com.lagou.domain.Menu;
import com.lagou.domain.ResponseResult;
import com.lagou.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

/**************************************
 * @author pan
 * @version 2022/6/14 20:15
 **************************************/
@RestController
@RequestMapping("/menu")
public class MenuController {
    @Autowired
    private MenuService menuService;

    @RequestMapping("/findAllMenu")
    public ResponseResult findAllMenu(){
        List<Menu> allMenu = menuService.findAllMenu();
        ResponseResult result = new ResponseResult(true, 200, "响应成功", allMenu);
        return result;
    }

    @RequestMapping("/findMenuInfoById")
    public ResponseResult findMenuInfoById(Integer id){
        List<Menu> parentMenuList = menuService.findSubMenuListByPid(-1);
        for (Menu menu : parentMenuList) {
            menu.setSubMenuList(null);
        }
        HashMap<String, Object> map = new HashMap<>();
        map.put("parentMenuList",parentMenuList);

        if(id !=-1 && id !=null){
            Menu menuById = menuService.findMenuById(id);
            map.put("menuInfo",menuById);
        }else{
            map.put("menuInfo",null);
        }
        return new ResponseResult(true, 200, "响应成功", map);
    }
}
