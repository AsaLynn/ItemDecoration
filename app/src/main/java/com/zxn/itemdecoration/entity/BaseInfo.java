package com.zxn.itemdecoration.entity;

/**
 * Created by zxn on 2019/4/11.
 */
public class BaseInfo {
    public String rawJson;  //原始json
    private static final String SUCCESS = "SUCCESS";
    public static final String RMB = "¥";
    /**
     * code : SUCCESS
     * msg : 查询成功
     * random : 123
     * sign : a4770ec9de86518857f33dc0d592484f
     * totalCount : 4
     * totalPage : 1
     * pageNumber : 1
     */
    //通用字段.
    public String code;//SUCCESS/FAILED
    public String msg;//返回信息

    //部分使用.
    public String random;//随机数
    public String sign;//签名
    public String subCode;//错误代码（失败时返回）
    public String subMsg;//	错误代码描述（失败时返回）
    public boolean isSucceed() {
        return SUCCESS.equals(code);
    }

}
