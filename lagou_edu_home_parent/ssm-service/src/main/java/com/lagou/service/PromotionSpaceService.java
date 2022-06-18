package com.lagou.service;

import com.lagou.domain.PromotionSpace;

import java.util.List;

/**************************************
 * @author pan
 * @version 2022/6/9 22:11
 **************************************/
public interface PromotionSpaceService {

    /*
     * 获取或有广告位
     * */
    public List<PromotionSpace> findAllPromotionSpace();

    /*
     * 添加广告位
     * */
    public void savePromotionSpace(PromotionSpace promotionSpace);

    /*
     * 修改广告位
     * */
    public void updatePromotionSpace(PromotionSpace promotionSpace);

    /*
     * 根据id 回显广告位信息
     * */
    public PromotionSpace findPromotionSpaceById(Integer id);

}
