package com.ruoyi.business.wxuser.service;

import java.util.List;
import com.ruoyi.business.wxuser.domain.ZAbucoderWxuser;

/**
 * 微信用户Service接口
 * 
 * @author zhoujie
 * @date 2022-11-29
 */
public interface IZAbucoderWxuserService 
{
    /**
     * 查询微信用户
     * 
     * @param id 微信用户主键
     * @return 微信用户
     */
    public ZAbucoderWxuser selectZAbucoderWxuserById(Long id);

    /**
     * 查询微信用户列表
     * 
     * @param zAbucoderWxuser 微信用户
     * @return 微信用户集合
     */
    public List<ZAbucoderWxuser> selectZAbucoderWxuserList(ZAbucoderWxuser zAbucoderWxuser);

    /**
     * 新增微信用户
     * 
     * @param zAbucoderWxuser 微信用户
     * @return 结果
     */
    public int insertZAbucoderWxuser(ZAbucoderWxuser zAbucoderWxuser);

    /**
     * 修改微信用户
     * 
     * @param zAbucoderWxuser 微信用户
     * @return 结果
     */
    public int updateZAbucoderWxuser(ZAbucoderWxuser zAbucoderWxuser);

    /**
     * 批量删除微信用户
     * 
     * @param ids 需要删除的微信用户主键集合
     * @return 结果
     */
    public int deleteZAbucoderWxuserByIds(Long[] ids);

    /**
     * 删除微信用户信息
     * 
     * @param id 微信用户主键
     * @return 结果
     */
    public int deleteZAbucoderWxuserById(Long id);

    /**
     * 通过openid查询相关信息
     * @param openid
     * @return
     */
    public ZAbucoderWxuser selectAbucoderWxuserOpenID(String openid);

    public int updateByOpenId(ZAbucoderWxuser zAbucoderWxuser);

}
