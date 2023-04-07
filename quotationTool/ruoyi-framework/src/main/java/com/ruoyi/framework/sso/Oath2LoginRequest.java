package com.ruoyi.framework.sso;

import lombok.Data;

import java.io.Serializable;

@Data
public class Oath2LoginRequest implements Serializable {
    private String state;
    private String code;
    private String scope;
    private String sessionState;
    private String clientId;
}
