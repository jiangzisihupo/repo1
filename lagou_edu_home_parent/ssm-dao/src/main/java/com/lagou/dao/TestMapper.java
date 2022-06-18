package com.lagou.dao;

import com.lagou.domain.Test;

import java.util.List;

/**************************************
 * @author pan
 * @version 2022/6/3 22:53
 **************************************/
public interface TestMapper {
    /*
    * 对test表进行查询所有
    *
    * */

    public List<Test> findAllTest();

}
