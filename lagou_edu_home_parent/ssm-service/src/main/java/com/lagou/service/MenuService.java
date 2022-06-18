package com.lagou.service;

import com.lagou.domain.Menu;

import java.util.List;

/**************************************
 * @author pan
 * @version 2022/6/12 23:49
 **************************************/
public interface MenuService {
    /*
     * 查询所有父子菜单信息
     * */
    public List<Menu> findSubMenuListByPid(int pid);

    /*
     * 查询所有菜单
     * */
    public List<Menu> findAllMenu();

    /*
     * 根据id查询所有菜单
     * */
    public Menu findMenuById(Integer id);

}
