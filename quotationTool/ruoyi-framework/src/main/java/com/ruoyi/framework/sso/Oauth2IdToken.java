package com.ruoyi.framework.sso;

import lombok.Data;

import java.util.List;

@Data
public class Oauth2IdToken {
    private String iss;
    private String aud;
    private Integer exp;
    private Integer nbf;
    private String nonce;
    private Integer iat;
    private String sid;
    private String sub;
    private String auth_time;
    private String idp;
    private String name;
    private Boolean email_verified;
    private String email;
    private List<String> amr;
    private String phone_number;
    private Boolean phone_number_verified;
    private String country_code;
}
