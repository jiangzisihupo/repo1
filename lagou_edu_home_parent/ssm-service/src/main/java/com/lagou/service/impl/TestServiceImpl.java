package com.lagou.service.impl;

import com.lagou.dao.TestMapper;
import com.lagou.domain.Test;
import com.lagou.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**************************************
 * @author pan
 * @version 2022/6/3 23:31
 **************************************/
@Service
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> findAllTest() {
        List<Test> allTest = testMapper.findAllTest();

        return allTest;

    }
}
