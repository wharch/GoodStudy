package com.goodstudy.util;

import java.util.List;

public class Page<T> {
    private int currentPage;//当前页
    private int pageSize;//一页显示多少条数据
    private int totalDate;//一共是多少条数据
    private List<T> data;//显示数据

    public Page() {
    }

    public Page(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public Page(int currentPage, int pageSize, int totalDate, List<T> data) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalDate = totalDate;
        this.data = data;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalDate() {
        return totalDate;
    }

    public void setTotalDate(int totalDate) {
        this.totalDate = totalDate;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> date) {
        this.data = date;
    }
//    获取总页数
    public int totalPageCount(){
        return (totalDate%pageSize)==0?totalDate/pageSize:(totalDate/pageSize)+1;
    }
//   上一页
    public int prev(){
        return currentPage>1?currentPage-1:1;
    }
//    下一页
    public int next(){
        return currentPage<totalPageCount()?currentPage+1:totalPageCount();
    }
//    计算偏移量
    public int start(){
        return (currentPage-1)*pageSize;
    }
}
