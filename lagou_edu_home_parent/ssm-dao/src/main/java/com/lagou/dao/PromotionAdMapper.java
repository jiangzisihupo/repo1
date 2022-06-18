package com.lagou.dao;

import com.lagou.domain.PromotionAd;

import java.util.List;

/**************************************
 * @author pan
 * @version 2022/6/11 21:42
 **************************************/
public interface PromotionAdMapper {

    /*
    * 分页查询广告信息
    * */
    public List<PromotionAd> findAllPromotionAdByPage();

    /*
    * 广告动态上下限
    * */
    public void updatePromotionAdStatus(PromotionAd promotionAd);

}
