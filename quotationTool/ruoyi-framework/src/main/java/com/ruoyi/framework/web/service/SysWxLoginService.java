package com.ruoyi.framework.web.service;

import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.common.core.domain.model.WxUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SysWxLoginService {

    @Autowired
    private TokenService tokenService;

    /**
     * 微信登录验证
     *
     * @param openId 微信唯一标识
     * @param sessionKey 微信会话密钥
     * @return 结果
     */
    public String wxAuthLogin(String openId, String sessionKey)
    {
        LoginUser loginUser = null;
        try {
            loginUser = new LoginUser(new WxUser(openId, sessionKey));
            UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(openId, sessionKey);
            authenticationToken.setDetails(loginUser);
            SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 生成token
        String token = tokenService.createToken(loginUser);
        return token;
    }
}
