package com.lagou.dao;

import com.lagou.domain.ResourceCategory;

import java.util.List;

/**************************************
 * @author pan
 * @version 2022/6/14 21:52
 **************************************/
public interface ResourceCategoryMapper {

    /*
    * 查询所有资源分类
    * */
    public List<ResourceCategory> findAllResourceCategory();

}
