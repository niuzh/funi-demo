package com.funi.demo.supports;

/**
 * 分页查询对象
 * @author zhihuan.niu
 */
public class PageableQuery {
    //开始页码从1开始
    private int pageNum;
    //每页大小
    private int pageSize;
    //默认关键字
    private String keyword;

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }
}
