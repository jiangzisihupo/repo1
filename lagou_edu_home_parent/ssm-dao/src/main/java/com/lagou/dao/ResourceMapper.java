package com.lagou.dao;

import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVO;

import java.util.List;

/**************************************
 * @author pan
 * @version 2022/6/14 21:10
 **************************************/
public interface ResourceMapper {

    /*
    * 资源信息分页&条件查询
    * */
    public List<Resource> findAllResourceByPage(ResourceVO resourceVO);
}
