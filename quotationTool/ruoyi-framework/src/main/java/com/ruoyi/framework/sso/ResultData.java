package com.ruoyi.framework.sso;

import java.util.HashMap;
import java.util.Map;

public class ResultData {
    private Object code;
    private String message;
    private Map<String, Object> data = new HashMap();

    public ResultData() {
    }

    public ResultData(Object code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultData(Object code, String message, Map<String, Object> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public Object getCode() {
        return this.code;
    }

    public void setCode(Object code) {
        this.code = code;
    }

    public Object getData() {
        return this.data;
    }

    public void setData(Map<String, Object> message) {
        this.data = message;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultData putDataValue(String key, Object value) {
        this.data.put(key, value);
        return this;
    }

    public static ResultData ok() {
        return new ResultData(HttpResponseEnum.SUCCESS.getResponseCode(), HttpResponseEnum.SUCCESS.getResponseMSG());
    }

    public static ResultData notFound() {
        return new ResultData(HttpResponseEnum.NOT_FOND.getResponseCode(), HttpResponseEnum.NOT_FOND.getResponseMSG());
    }

    public static ResultData errorRequest() {
        return new ResultData(HttpResponseEnum.ERROR_REQUEST.getResponseCode(), HttpResponseEnum.ERROR_REQUEST.getResponseMSG());
    }

    public static ResultData forbidden() {
        return new ResultData(HttpResponseEnum.FORBIDDEN.getResponseCode(), HttpResponseEnum.FORBIDDEN.getResponseMSG());
    }

    public static ResultData unauthorized() {
        return new ResultData(HttpResponseEnum.UNAUTHORIZED.getResponseCode(), HttpResponseEnum.UNAUTHORIZED.getResponseMSG());
    }

    public static ResultData serverError() {
        return new ResultData(HttpResponseEnum.SERVER_ERROR.getResponseCode(), HttpResponseEnum.SERVER_ERROR.getResponseMSG());
    }
}
