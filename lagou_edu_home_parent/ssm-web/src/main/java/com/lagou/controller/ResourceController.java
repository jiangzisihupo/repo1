package com.lagou.controller;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.Resource;
import com.lagou.domain.ResourceVO;
import com.lagou.domain.ResponseResult;
import com.lagou.service.ResourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**************************************
 * @author pan
 * @version 2022/6/14 21:33
 **************************************/
@RestController
@RequestMapping("/resource")
public class ResourceController {

    @Autowired
    private ResourceService resourceService;

    @RequestMapping("/findAllResource")
    public ResponseResult findAllResource (@RequestBody ResourceVO resourceVO){
        PageInfo<Resource> allResourceByPage = resourceService.findAllResourceByPage(resourceVO);
        return new ResponseResult(true,200,"响应成功",allResourceByPage);
    }
}
