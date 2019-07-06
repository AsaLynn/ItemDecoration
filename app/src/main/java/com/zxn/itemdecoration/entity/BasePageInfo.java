package com.zxn.itemdecoration.entity;

import java.util.List;

/**
 * 分页使用.T为实体类型.
 * Created by zxn on 2019/4/18.
 */
public class BasePageInfo<M> extends BaseInfo {
    public int totalCount;//	总记录数,全部记录数
    public int pageCount;//总页数
    public int totalPage;//总页数
    public int pageSize;//每页记录数
    public int currentPage;//当前页号
    public int pageNumber;//当前页号
    public List<M> items;//数据集合,会员等级列表
    public List<M> points;//数据集合.
    public List<M> orderDetails;//数据集合.
    public List<M> statisticsList;//今日订单统计.
    public List<M> payCodeList;//支付码列表.
    public List<M> result;//区域列表.桌台列表.

    public long totalPoint;

}


