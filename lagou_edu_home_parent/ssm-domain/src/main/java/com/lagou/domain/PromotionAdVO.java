package com.lagou.domain;

/**************************************
 * @author pan
 * @version 2022/6/11 22:47
 **************************************/
public class PromotionAdVO {
    //当前页
    private Integer currentPage;
    //每页显示条数
    private Integer pageSize;

    @Override
    public String toString() {
        return "PromotionAdVO{" +
                "currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                '}';
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
