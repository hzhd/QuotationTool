package com.ruoyi.screenSet.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文化资讯配置对象 d_set_culture
 * 
 * @author huzd
 * @date 2022-09-24
 */
public class DSetCulture extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 资讯图片 */
    @Excel(name = "资讯图片")
    private String zxImage;

    /** 资讯标题 */
    @Excel(name = "资讯标题")
    private String zxTitle;

    /** 资讯时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "资讯时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date zxTime;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setZxImage(String zxImage) 
    {
        this.zxImage = zxImage;
    }

    public String getZxImage() 
    {
        return zxImage;
    }
    public void setZxTitle(String zxTitle) 
    {
        this.zxTitle = zxTitle;
    }

    public String getZxTitle() 
    {
        return zxTitle;
    }
    public void setZxTime(Date zxTime) 
    {
        this.zxTime = zxTime;
    }

    public Date getZxTime() 
    {
        return zxTime;
    }
    public void setDelFlag(String delFlag) 
    {
        this.delFlag = delFlag;
    }

    public String getDelFlag() 
    {
        return delFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("zxImage", getZxImage())
            .append("zxTitle", getZxTitle())
            .append("zxTime", getZxTime())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
