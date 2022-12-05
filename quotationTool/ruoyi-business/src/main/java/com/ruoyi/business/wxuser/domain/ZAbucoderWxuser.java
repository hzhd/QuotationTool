package com.ruoyi.business.wxuser.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 微信用户对象 z_abucoder_wxuser
 * 
 * @author zhoujie
 * @date 2022-11-29
 */
public class ZAbucoderWxuser extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** ID */
    private Long id;

    /** 微信名称 */
    @Excel(name = "微信名称")
    private String nickName;

    /** 头像 */
    @Excel(name = "头像")
    private String avatarUrl;

    /** 微信唯一标识符 */
    @Excel(name = "微信唯一标识符")
    private String openid;

    /** 性别 */
    @Excel(name = "性别")
    private Integer gender;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public void setOpenid(String openid)
    {
        this.openid = openid;
    }

    public String getOpenid() 
    {
        return openid;
    }
    public void setGender(Integer gender) 
    {
        this.gender = gender;
    }

    public Integer getGender() 
    {
        return gender;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("nickName", getNickName())
            .append("avatarUrl", getAvatarUrl())
            .append("openid", getOpenid())
            .append("gender", getGender())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
