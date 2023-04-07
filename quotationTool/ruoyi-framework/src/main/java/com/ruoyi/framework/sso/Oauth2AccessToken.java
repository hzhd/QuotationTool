package com.ruoyi.framework.sso;

import lombok.Data;

import java.util.List;

@Data
public class Oauth2AccessToken {
    private String aud;
    private String iss;
    private Integer exp;
    private String client_id;
    private List<String> scope;
    private String sub;
    private Integer auth_time;
    private String idp;
    private String amr;
}
