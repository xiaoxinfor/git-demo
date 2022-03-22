package com.javasm.bean;

import java.util.List;

/**
 * @Author：易鑫
 * @Version：1.0
 * @Date：2022/3/11-11:14
 * @Since:jdk1.8
 * @Description:
 */
public class PageInfo<T> {
    private Integer nowPage;//当前页
    private Integer pageSize;//每页显示几条数据
    private Integer startIndex;//起始下标
    private Integer count;//总条数
    private Integer sunPage;//总页数
    private List<T> dataList;//分页数据

    public List<T> getDataList() {
        return dataList;
    }

    public void setDataList(List<T> dataList) {
        this.dataList = dataList;
    }

    public PageInfo() {
    }

    public PageInfo(Integer nowPage, Integer pageSize, Integer count) {
        this.nowPage = nowPage < 1 ? 1 : nowPage;
        this.pageSize = pageSize <= 0 ? 3 : pageSize;
        this.count = count;
        //计算总页数
        this.sunPage = this.count % this.pageSize == 0 ? this.count/this.pageSize : (this.count/this.pageSize + 1);
        //判断nowPage是否大于sunPage
        this.nowPage = this.nowPage > this.sunPage ? this.sunPage : this.nowPage;
        //计算起始值
        this.startIndex = (this.nowPage - 1)*this.pageSize;
    }

    public Integer getNowPage() {
        return nowPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getStartIndex() {
        return startIndex;
    }

    public Integer getCount() {
        return count;
    }

    public Integer getSunPage() {
        return sunPage;
    }
}
