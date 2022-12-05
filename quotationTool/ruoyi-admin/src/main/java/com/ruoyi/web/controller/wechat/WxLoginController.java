package com.ruoyi.web.controller.wechat;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.business.wxuser.domain.ZAbucoderWxuser;
import com.ruoyi.business.wxuser.service.IZAbucoderWxuserService;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.model.LoginUser;
import com.ruoyi.framework.web.service.TokenService;
import com.ruoyi.web.controller.wechat.impl.WxLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * 微信小程序登录授权接口
 */
@RestController
@RequestMapping("/wxapi")
public class WxLoginController {

    @Autowired
    IZAbucoderWxuserService izAbucoderWxuserService;
    @Autowired
    WxLoginService wxLoginService;


    /**
     * 微信登录
     * @param object
     * @return
     */
    @PostMapping("/wxLogin")
    public AjaxResult wxLogin(@RequestBody JSONObject object) throws Exception{
        return wxLoginService.wxLogin(object);
    }

    @Autowired
    TokenService tokenService;
    /**
     * 上传用户头像/昵称
     */
    @PostMapping("/uploadInfo")
    public AjaxResult uploadInfo(HttpServletRequest request, @RequestBody ZAbucoderWxuser zAbucoderWxuser) {
        LoginUser loginUser = tokenService.getLoginUser(request);
        if(null == loginUser.getWxUser()){
            return AjaxResult.error("获取用户信息失败！");
        }
        zAbucoderWxuser.setOpenid(loginUser.getWxUser().getOpenId());
        return  AjaxResult.success(izAbucoderWxuserService.updateByOpenId(zAbucoderWxuser));
    }
}
