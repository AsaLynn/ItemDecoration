package com.zxn.itemdecoration.entity;


import com.zxn.itemdecoration.R;

import java.util.ArrayList;
import java.util.List;

/**
 * 首页条目实体类.
 * Created by zxn on 2019/4/2.
 */
public class HomeOptionsEntity {

    public String id;
    public String name;
    public int resId;
    public int textId;

    /**
     * 根据角色产生实体类集合
     *
     * @param role 0总部(核心账号)-->[订单,数据报表,计次卡管理,到账]
     *             1门店管理员(门店)or3店长(门店)or 2员工(收银员)-->[订单,数据报表,交接班,计次卡管理]
     * @return 选项实体集.
     */
    public static List<HomeOptionsEntity> create(int role) {
        List<HomeOptionsEntity> data = new ArrayList<>();
        if (role == 0) {
            data.add(createOrder());
            data.add(createDataReport());
            data.add(createAddCardManage());
            data.add(createTransferIntoAccount());
        } else if (role == 1 || role == 2 || role == 3) {
            data.add(createOrder());
            data.add(createDataReport());
            data.add(createShiftOverShift());
            data.add(createAddCardManage());
        }
        return data;
    }

    public static HomeOptionsEntity createOrder() {
        HomeOptionsEntity orderInfo = new HomeOptionsEntity();
        orderInfo.textId = R.string.text_home_order;
        orderInfo.resId = R.mipmap.ic_launcher_round;
        return orderInfo;
    }

    public static HomeOptionsEntity createDataReport() {
        HomeOptionsEntity reportInfo = new HomeOptionsEntity();
        reportInfo.textId = R.string.text_home_data_report;
        reportInfo.resId = R.mipmap.ic_launcher_round;
        return reportInfo;
    }

    public static HomeOptionsEntity createAddCardManage() {
        HomeOptionsEntity cardInfo = new HomeOptionsEntity();
        cardInfo.textId = R.string.text_home_add_card_manage;
        cardInfo.resId = R.mipmap.ic_launcher_round;
        return cardInfo;
    }

    public static HomeOptionsEntity createTransferIntoAccount() {
        HomeOptionsEntity intoAccountInfo = new HomeOptionsEntity();
        intoAccountInfo.textId = R.string.text_home_transfer_into_account;
        intoAccountInfo.resId = R.mipmap.ic_launcher_round;
        return intoAccountInfo;
    }

    public static HomeOptionsEntity createShiftOverShift() {
        HomeOptionsEntity shiftInfo = new HomeOptionsEntity();
        shiftInfo.textId = R.string.text_home_transfer_into_account;
        shiftInfo.resId = R.mipmap.ic_launcher_round;
        return shiftInfo;
    }

}
