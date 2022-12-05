package com.ruoyi.web.controller.wechat.impl;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ruoyi.business.wxuser.domain.ZAbucoderWxuser;
import com.ruoyi.business.wxuser.service.impl.ZAbucoderWxuserServiceImpl;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.common.utils.http.HttpUtils;
import com.ruoyi.framework.web.service.SysWxLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class WxLoginService {

    @Autowired
    private SysWxLoginService service;
    @Autowired
    private ZAbucoderWxuserServiceImpl zAbucoderWxuserService;
    @Autowired
    private SysWxLoginService sysWxLoginService;

    @Value("${wxapplet.wechatUrl}")
    private String wechatUrl;
    @Value("${wxapplet.appid}")
    private String appid;
    @Value("${wxapplet.secret}")
    private String secret;

    public AjaxResult wxLogin(JSONObject object) throws Exception{
        //拼接请求参数
        String params = StrUtil.format("appid={}&secret={}&js_code={}&grant_type=authorization_code", appid, secret, object.get("code"));
        //发起网络请求
        String res = HttpUtils.sendGet(wechatUrl,params);
        //解析返回参数
        JSONObject jsonObject = JSON.parseObject(res);
        String session_key = (String) jsonObject.get("session_key");
        String openid = (String) jsonObject.get("openid");
        if (StrUtil.isEmpty(openid)) {
            return AjaxResult.error("未获取到openid");
        }
        Map<String, Object> data = new HashMap<>();
        data.put("session_key", session_key);
        data.put("state",true);
        /**先通过openid来查询是否存在*/
        ZAbucoderWxuser abucoderWxuser = zAbucoderWxuserService.selectAbucoderWxuserOpenID(openid);
        if (null == abucoderWxuser){
            /**如果不存在就插入到我们的数据库里*/
            ZAbucoderWxuser  wxuser = new ZAbucoderWxuser();
            wxuser.setOpenid(openid);
            wxuser.setCreateTime(DateUtils.getNowDate());
            zAbucoderWxuserService.insertZAbucoderWxuser(wxuser);
            data.put("nickName", "");
            data.put("avatarUrl", "");
        }else {
            /**如果存在就更新数据库里原有的数据*/
            abucoderWxuser.setUpdateTime(DateUtils.getNowDate());
            zAbucoderWxuserService.updateZAbucoderWxuser(abucoderWxuser);
            data.put("nickName", abucoderWxuser.getNickName());
            data.put("avatarUrl", abucoderWxuser.getAvatarUrl());
        }
        //添加生成微信用户token
        String token = sysWxLoginService.wxAuthLogin(openid, session_key);
        data.put("token", token);

        return AjaxResult.success(data);
    }
}
