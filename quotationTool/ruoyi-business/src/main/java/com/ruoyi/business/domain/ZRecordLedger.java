package com.ruoyi.business.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 档案台账对象 z_record_ledger
 * 
 * @author zhoujie
 * @date 2022-11-28
 */
public class ZRecordLedger extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long ledgerId;

    /** 档案id */
    @Excel(name = "档案id")
    private String recordId;

    /** 借阅日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "借阅日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date borrowDate;

    /** 借阅人 */
    @Excel(name = "借阅人")
    private String borrower;

    /** 预计归还日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预计归还日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date backDate;

    /** 归还状态(0未归还 1已归还) */
    @Excel(name = "归还状态(0未归还 1已归还)")
    private String backStatus;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 1代表删除） */
    private String delFlag;

    public void setLedgerId(Long ledgerId) 
    {
        this.ledgerId = ledgerId;
    }

    public Long getLedgerId() 
    {
        return ledgerId;
    }
    public void setRecordId(String recordId) 
    {
        this.recordId = recordId;
    }

    public String getRecordId() 
    {
        return recordId;
    }
    public void setBorrowDate(Date borrowDate) 
    {
        this.borrowDate = borrowDate;
    }

    public Date getBorrowDate() 
    {
        return borrowDate;
    }
    public void setBorrower(String borrower) 
    {
        this.borrower = borrower;
    }

    public String getBorrower() 
    {
        return borrower;
    }
    public void setBackDate(Date backDate) 
    {
        this.backDate = backDate;
    }

    public Date getBackDate() 
    {
        return backDate;
    }
    public void setBackStatus(String backStatus) 
    {
        this.backStatus = backStatus;
    }

    public String getBackStatus() 
    {
        return backStatus;
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
            .append("ledgerId", getLedgerId())
            .append("recordId", getRecordId())
            .append("borrowDate", getBorrowDate())
            .append("borrower", getBorrower())
            .append("backDate", getBackDate())
            .append("backStatus", getBackStatus())
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
