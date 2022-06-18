package com.lagou.service;

import com.lagou.domain.ResourceCategory;

import java.util.List;

/**************************************
 * @author pan
 * @version 2022/6/14 21:58
 **************************************/
public interface ResourceCategoryService {

    /*
     * 查询所有资源分类
     * */
    public List<ResourceCategory> findAllResourceCategory();
}
