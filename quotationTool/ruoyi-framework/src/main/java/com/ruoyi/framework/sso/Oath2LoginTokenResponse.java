package com.ruoyi.framework.sso;

import lombok.Data;

import java.io.Serializable;

@Data
public class Oath2LoginTokenResponse implements Serializable {
    private String token_type;
    private String expires_in;
    private String refresh_token;
    private Oauth2IdToken idToken;
    private Oauth2AccessToken accessKoken;
    private String id_token;
    private String access_token;
}
