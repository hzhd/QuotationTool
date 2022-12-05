package com.ruoyi.business.wxuser.service.impl;

import java.util.Date;
import java.util.List;

import com.ruoyi.business.wxuser.domain.ZAbucoderWxuser;
import com.ruoyi.business.wxuser.mapper.ZAbucoderWxuserMapper;
import com.ruoyi.business.wxuser.service.IZAbucoderWxuserService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 微信用户Service业务层处理
 * 
 * @author zhoujie
 * @date 2022-11-29
 */
@Service
public class ZAbucoderWxuserServiceImpl implements IZAbucoderWxuserService
{
    @Autowired
    private ZAbucoderWxuserMapper zAbucoderWxuserMapper;

    @Value("${wxapplet.wechatUrl}")
    private String wechatUrl;
    @Value("${wxapplet.appid}")
    private String appid;
    @Value("${wxapplet.secret}")
    private String secret;

    /**
     * 查询微信用户
     * 
     * @param id 微信用户主键
     * @return 微信用户
     */
    @Override
    public ZAbucoderWxuser selectZAbucoderWxuserById(Long id)
    {
        return zAbucoderWxuserMapper.selectZAbucoderWxuserById(id);
    }

    /**
     * 查询微信用户列表
     * 
     * @param zAbucoderWxuser 微信用户
     * @return 微信用户
     */
    @Override
    public List<ZAbucoderWxuser> selectZAbucoderWxuserList(ZAbucoderWxuser zAbucoderWxuser)
    {
        return zAbucoderWxuserMapper.selectZAbucoderWxuserList(zAbucoderWxuser);
    }

    /**
     * 新增微信用户
     * 
     * @param zAbucoderWxuser 微信用户
     * @return 结果
     */
    @Override
    public int insertZAbucoderWxuser(ZAbucoderWxuser zAbucoderWxuser)
    {
        zAbucoderWxuser.setCreateTime(DateUtils.getNowDate());
        return zAbucoderWxuserMapper.insertZAbucoderWxuser(zAbucoderWxuser);
    }

    /**
     * 修改微信用户
     * 
     * @param zAbucoderWxuser 微信用户
     * @return 结果
     */
    @Override
    public int updateZAbucoderWxuser(ZAbucoderWxuser zAbucoderWxuser)
    {
        zAbucoderWxuser.setUpdateTime(DateUtils.getNowDate());
        return zAbucoderWxuserMapper.updateZAbucoderWxuser(zAbucoderWxuser);
    }

    /**
     * 批量删除微信用户
     * 
     * @param ids 需要删除的微信用户主键
     * @return 结果
     */
    @Override
    public int deleteZAbucoderWxuserByIds(Long[] ids)
    {
        return zAbucoderWxuserMapper.deleteZAbucoderWxuserByIds(ids);
    }

    /**
     * 删除微信用户信息
     * 
     * @param id 微信用户主键
     * @return 结果
     */
    @Override
    public int deleteZAbucoderWxuserById(Long id)
    {
        return zAbucoderWxuserMapper.deleteZAbucoderWxuserById(id);
    }

    /**
     * 通过openid查询相关信息
     * @param openid
     * @return
     */
    @Override
    public ZAbucoderWxuser selectAbucoderWxuserOpenID(String openid) {
        return zAbucoderWxuserMapper.selectAbucoderWxuserOpenID(openid);
    }
    /**
     * 通过openId修改微信用户信息
     */
    @Override
    public int updateByOpenId(ZAbucoderWxuser zAbucoderWxuser) {
        zAbucoderWxuser.setUpdateTime(DateUtils.getNowDate());
        return zAbucoderWxuserMapper.updateByOpenId(zAbucoderWxuser);
    }
}
