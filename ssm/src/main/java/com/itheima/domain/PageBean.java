package com.itheima.domain;

/**
 * @Author: tch
 * @Date: 2019/2/13 下午 09:44
 */
public class PageBean {
    private Integer currPage;
    private Integer totalPage;
    private Integer totalCount;
    private Integer pageSize;
    private Integer begin;

    @Override
    public String toString() {
        return "PageBean{" +
                "currPage=" + currPage +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", pageSize=" + pageSize +
                ", begin=" + begin +
                '}';
    }

    public Integer getBegin() {
        return begin;
    }

    public void setBegin(Integer begin) {
        this.begin = begin;
    }

    public Integer getCurrPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
