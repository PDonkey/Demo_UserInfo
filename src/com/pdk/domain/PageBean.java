package com.pdk.domain;

import java.util.List;

public class PageBean<T> {
    private int totalCount;//总条数
    private int totalPage;//总页数
    private List<T> lis;
    private int currentPage;//当前页数
    private int rows;//当前页多少条数据

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getLis() {
        return lis;
    }

    public void setLis(List<T> lis) {
        this.lis = lis;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", lis=" + lis +
                ", currentPage=" + currentPage +
                ", rows=" + rows +
                '}';
    }
}
