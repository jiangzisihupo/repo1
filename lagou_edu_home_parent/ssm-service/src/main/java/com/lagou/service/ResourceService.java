package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVO;

import java.util.List;

/**************************************
 * @author pan
 * @version 2022/6/14 21:24
 **************************************/
public interface ResourceService {

    /*
     * 资源信息分页&条件查询
     * */
    public PageInfo<Resource> findAllResourceByPage(ResourceVO resourceVO);
}
