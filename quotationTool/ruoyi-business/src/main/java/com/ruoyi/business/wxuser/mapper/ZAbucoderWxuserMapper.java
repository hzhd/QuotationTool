package com.ruoyi.business.wxuser.mapper;

import java.util.List;
import com.ruoyi.business.wxuser.domain.ZAbucoderWxuser;

/**
 * 微信用户Mapper接口
 * 
 * @author zhoujie
 * @date 2022-11-29
 */
public interface ZAbucoderWxuserMapper 
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
     * 删除微信用户
     * 
     * @param id 微信用户主键
     * @return 结果
     */
    public int deleteZAbucoderWxuserById(Long id);

    /**
     * 批量删除微信用户
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteZAbucoderWxuserByIds(Long[] ids);

    /**
     * 通过openid查询相关信息
     * @param openid
     * @return
     */
    ZAbucoderWxuser selectAbucoderWxuserOpenID(String openid);

    int updateByOpenId(ZAbucoderWxuser zAbucoderWxuser);
}
