package com.sql.ehr.util;

import com.baomidou.mybatisplus.core.metadata.IPage;

import java.util.List;
/*
* 自定义分页器
* */
public class IPageImp<T> implements IPage{
    List<T> list;
    long size=10;
    long current;
    //获取记录数据
    @Override
    public List getRecords() {
        return list;
    }
    //设置记录数据
    @Override
    public IPage setRecords(List records) {
        list=records;

        return this;
    }
    //获得总记录数
    @Override
    public long getTotal() {
        return list.size();
    }
    //设置总记录数
    @Override
    public IPage setTotal(long total) {
        return this;
    }
    //获得每页记录数
    @Override
    public long getSize() {
        return size;
    }
    //设置每页记录数
    @Override
    public IPage setSize(long size) {
        this.size=size;
        return this;
    }
    //获得当前页数
    @Override
    public long getCurrent() {
        return current;
    }
    //设置当前页数
    @Override
    public IPage setCurrent(long current) {
        this.current=current;
        return this;
    }
    /**
     * 总页数 getPages()方法自动计算不用重写
     */
}
