package com.ruoyi.business.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 租赁设备对象 z_stadium-equipment
 * 
 * @author zhoujie
 * @date 2022-11-28
 */
public class ZStadiumEquipment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long equipmentId;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String equipmentName;

    /** 是否可租赁(0是 1否) */
    @Excel(name = "是否可租赁(0是 1否)")
    private String isLease;

    /** 租赁金额 */
    @Excel(name = "租赁金额")
    private Long leaseMoney;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    private String equipmentImg;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date maintainTime;

    public void setEquipmentId(Long equipmentId) 
    {
        this.equipmentId = equipmentId;
    }

    public Long getEquipmentId() 
    {
        return equipmentId;
    }
    public void setEquipmentName(String equipmentName) 
    {
        this.equipmentName = equipmentName;
    }

    public String getEquipmentName() 
    {
        return equipmentName;
    }
    public void setIsLease(String isLease) 
    {
        this.isLease = isLease;
    }

    public String getIsLease() 
    {
        return isLease;
    }
    public void setLeaseMoney(Long leaseMoney) 
    {
        this.leaseMoney = leaseMoney;
    }

    public Long getLeaseMoney() 
    {
        return leaseMoney;
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

    public String getEquipmentImg() {
        return equipmentImg;
    }

    public void setEquipmentImg(String equipmentImg) {
        this.equipmentImg = equipmentImg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("equipmentId", getEquipmentId())
            .append("equipmentName", getEquipmentName())
            .append("isLease", getIsLease())
            .append("leaseMoney", getLeaseMoney())
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
