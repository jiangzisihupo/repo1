package com.lagou.service;

import com.github.pagehelper.PageInfo;
import com.lagou.domain.PromotionAd;
import com.lagou.domain.PromotionAdVO;

import java.util.List;

/**************************************
 * @author pan
 * @version 2022/6/11 22:45
 **************************************/
public interface PromotionAdService {

    /*
    * 分页查询广告信息
    * */
    public PageInfo<PromotionAd> findAllPromotionAdByPage(PromotionAdVO promotionAdVO);

    /*
     * 广告动态上下限
     * */
    public void updatePromotionAdStatus(PromotionAd promotionAd);
}
