package com.ruoyi.framework.sso;


import com.auth0.jwk.JwkException;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public interface Oauth2LoginTokenService {
    public AdfsHttpResponse<LoginResponse> getOauth2Token(Oath2LoginRequest oath2LoginRequest) throws NoSuchAlgorithmException, InvalidKeySpecException, JwkException, UnsupportedEncodingException, JwkException;
    public String getAuthorizeUrl(HttpServletRequest httpServletRequest) throws UnsupportedEncodingException, NoSuchAlgorithmException;
}
