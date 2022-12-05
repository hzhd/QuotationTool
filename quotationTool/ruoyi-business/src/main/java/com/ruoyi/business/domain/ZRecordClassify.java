package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 档案分类对象 z_record_classify
 * 
 * @author zhoujie
 * @date 2022-11-28
 */
public class ZRecordClassify extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long recordId;

    /** 档案名称 */
    @Excel(name = "档案名称")
    private String recordName;

    /** 档案编号 */
    @Excel(name = "档案编号")
    private String recordCode;

    /** 档案类型 */
    @Excel(name = "档案类型")
    private String recordType;

    /** 档案二维码 */
    @Excel(name = "档案二维码")
    private String recordQr;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 1代表删除） */
    private String delFlag;

    public void setRecordId(Long recordId) 
    {
        this.recordId = recordId;
    }

    public Long getRecordId() 
    {
        return recordId;
    }
    public void setRecordName(String recordName) 
    {
        this.recordName = recordName;
    }

    public String getRecordName() 
    {
        return recordName;
    }
    public void setRecordCode(String recordCode) 
    {
        this.recordCode = recordCode;
    }

    public String getRecordCode() 
    {
        return recordCode;
    }
    public void setRecordType(String recordType) 
    {
        this.recordType = recordType;
    }

    public String getRecordType() 
    {
        return recordType;
    }
    public void setRecordQr(String recordQr) 
    {
        this.recordQr = recordQr;
    }

    public String getRecordQr() 
    {
        return recordQr;
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
            .append("recordId", getRecordId())
            .append("recordName", getRecordName())
            .append("recordCode", getRecordCode())
            .append("recordType", getRecordType())
            .append("recordQr", getRecordQr())
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
