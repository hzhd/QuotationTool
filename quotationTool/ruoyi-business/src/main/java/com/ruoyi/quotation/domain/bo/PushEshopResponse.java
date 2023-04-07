package com.ruoyi.quotation.domain.bo;

import lombok.Data;

@Data
public class PushEshopResponse {
    //是否推送成功，true:成功，false:失败
    private String status;
    //推送状态
    private String code;
    //提示信息概要
    private String tip;
    //提示信息详情
    private String detail;
    //数据版本
    private String version;
}
