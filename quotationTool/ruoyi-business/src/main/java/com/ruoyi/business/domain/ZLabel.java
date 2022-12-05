package com.ruoyi.business.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 标签库对象 z_label
 * 
 * @author zhoujie
 * @date 2022-11-25
 */
public class ZLabel extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 标签id */
    private Long labelId;

    /** 标签名称 */
    @Excel(name = "标签名称")
    private String labelName;

    /** 标签特征 */
    @Excel(name = "标签特征")
    private String labelFeatures;

    /** 标签类型 */
    @Excel(name = "标签类型")
    private String labelType;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 1代表删除） */
    private String delFlag;

    public void setLabelId(Long labelId) 
    {
        this.labelId = labelId;
    }

    public Long getLabelId() 
    {
        return labelId;
    }
    public void setLabelName(String labelName) 
    {
        this.labelName = labelName;
    }

    public String getLabelName() 
    {
        return labelName;
    }
    public void setLabelFeatures(String labelFeatures) 
    {
        this.labelFeatures = labelFeatures;
    }

    public String getLabelFeatures() 
    {
        return labelFeatures;
    }
    public void setLabelType(String labelType) 
    {
        this.labelType = labelType;
    }

    public String getLabelType() 
    {
        return labelType;
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
            .append("labelId", getLabelId())
            .append("labelName", getLabelName())
            .append("labelFeatures", getLabelFeatures())
            .append("labelType", getLabelType())
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
