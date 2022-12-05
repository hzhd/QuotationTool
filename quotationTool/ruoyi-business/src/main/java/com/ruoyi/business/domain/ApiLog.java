package com.ruoyi.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.annotation.Excel.ColumnType;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 接口推送日志 b_api_log
 * 
 * @author ruoyi
 */
public class ApiLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    @Excel(name = "序号", cellType = ColumnType.NUMERIC)
    private Long logId;

    /** 回话Id */
    @Excel(name = "会话ID")
    private String sessionId;

    /** 接口名称 */
    @Excel(name = "接口名称")
    private String logName;

    /** 接口标识 */
    @Excel(name = "接口标识")
    private String logType;

    /** 推送地址 */
    @Excel(name = "推送地址")
    private String url;

    /** code */
    @Excel(name = "code")
    private Integer code;

    /** 推送返回消息 */
    @Excel(name = "推送返回消息")
    private String msg;

    /** 状态 */
    @Excel(name = "状态")
    private Integer status;

    /** 推送时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "推送时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date notifiTime;

    /** 请求参数 */
    @Excel(name = "请求参数")
    private String requestData;

    /** 返回参数 */
    @Excel(name = "返回参数")
    private String responseData;

    /** 租户id */
    @Excel(name = "租户Id", cellType = ColumnType.NUMERIC)
    private Long tenantId;

    public Long getLogId() {
        return logId;
    }

    public void setLogId(Long logId) {
        this.logId = logId;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getLogName() {
        return logName;
    }

    public void setLogName(String logName) {
        this.logName = logName;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getNotifiTime() {
        return notifiTime;
    }

    public void setNotifiTime(Date notifiTime) {
        this.notifiTime = notifiTime;
    }

    public String getRequestData() {
        return requestData;
    }

    public void setRequestData(String requestData) {
        this.requestData = requestData;
    }

    public String getResponseData() {
        return responseData;
    }

    public void setResponseData(String responseData) {
        this.responseData = responseData;
    }

    public Long getTenantId() {
        return tenantId;
    }

    public void setTenantId(Long tenantId) {
        this.tenantId = tenantId;
    }
}
