package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * sensitiv对象 z_sensitiv_word
 * 
 * @author zhoujie
 * @date 2022-11-25
 */
public class ZSensitivWord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 敏感词id */
    private Long sensitiveId;

    /** 词汇内容 */
    @Excel(name = "词汇内容")
    private String content;

    /** 次数 */
    @Excel(name = "次数")
    private Long count;

    /** 预警等级 */
    @Excel(name = "预警等级")
    private Long warningLevel;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 1代表删除） */
    private String delFlag;

    public void setSensitiveId(Long sensitiveId) 
    {
        this.sensitiveId = sensitiveId;
    }

    public Long getSensitiveId() 
    {
        return sensitiveId;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setCount(Long count) 
    {
        this.count = count;
    }

    public Long getCount() 
    {
        return count;
    }
    public void setWarningLevel(Long warningLevel) 
    {
        this.warningLevel = warningLevel;
    }

    public Long getWarningLevel() 
    {
        return warningLevel;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
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
            .append("sensitiveId", getSensitiveId())
            .append("content", getContent())
            .append("count", getCount())
            .append("warningLevel", getWarningLevel())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
