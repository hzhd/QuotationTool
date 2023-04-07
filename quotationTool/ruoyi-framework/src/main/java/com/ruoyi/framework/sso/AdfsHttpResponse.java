package com.ruoyi.framework.sso;

import lombok.Data;

import java.io.Serializable;

@Data
public class AdfsHttpResponse<T> implements Serializable {
    private static final long serialVersionUID = 1L;

    int status;
    String message;
    T data;

    public AdfsHttpResponse(){
        setSuccess();
    }

    public AdfsHttpResponse(T data){
        this.data = data;
    }


    public void setSuccess() {
        status = HttpResponseEnum.SUCCESS.getResponseCode();
        message = HttpResponseEnum.SUCCESS.getResponseMSG();
    }

    public void setSuccess(T data) {
        setSuccess();
        this.setData(data);
    }


    public void setFailed() {
        status = HttpResponseEnum.FAILED.getResponseCode();
        message = HttpResponseEnum.FAILED.getResponseMSG();
    }

    public void setFailed(HttpResponseEnum failType) {
        status = failType.getResponseCode();
        message = failType.getResponseMSG();
    }
}
