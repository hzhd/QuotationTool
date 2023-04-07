package com.ruoyi.quotation.domain.bo;

import lombok.Data;

/**
 * 销售人员视图
 * @author huzd
 * @date 2023-03-11 7:44
 */
@Data
public class SalesView {
    private String id;
    private String sales_code;
    private String sales_name;
    private String region_code;
    private String region_name;
    private String chanel_code;
    private String chanel_name;
    private String dept_code;
    private String dept_name;
    private String ismgr;
    private String mail;
    private String phone;
    private String account_status;
    private String mail_send_status;
    private String rbac_user_id;
    private String del_flag;
    private String create_time;
    private String create_user;
    private String update_time;
    private String update_user;
    private String cms_right;
    private String ons_channel;
}
