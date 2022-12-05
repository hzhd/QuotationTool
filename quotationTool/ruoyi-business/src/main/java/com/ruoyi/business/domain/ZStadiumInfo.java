package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;
import org.springframework.data.redis.connection.RedisServer;

import java.math.BigDecimal;

/**
 * 场馆信息对象 z_stadium-info
 * 
 * @author zhoujie
 * @date 2022-11-28
 */
public class ZStadiumInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long stadiumId;

    /** 场馆名称 */
    @Excel(name = "场馆名称")
    private String stadiumName;

    /** 场馆地址 */
    @Excel(name = "场馆地址")
    private String stadiumAddress;

    /** 场馆介绍 */
    @Excel(name = "场馆介绍")
    private String stadiumIntroduce;

    /** 场馆可预约数 */
    @Excel(name = "场馆可预约数")
    private String appointmentNum;

    /** 是否可预约0是 1否 */
    @Excel(name = "是否可预约0是 1否")
    private String isAppointment;

    /** 场馆类型 */
    @Excel(name = "场馆类型")
    private String stadiumType;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    private String stadiumImg;

    private String stadiumPeople;

    private String scheduleAppointment;

    private Integer stadiumPrice;

    public Integer getStadiumPrice() {
        return stadiumPrice;
    }

    public void setStadiumPrice(Integer stadiumPrice) {
        this.stadiumPrice = stadiumPrice;
    }

    public void setStadiumId(Long stadiumId)
    {
        this.stadiumId = stadiumId;
    }

    public Long getStadiumId() 
    {
        return stadiumId;
    }
    public void setStadiumName(String stadiumName) 
    {
        this.stadiumName = stadiumName;
    }

    public String getStadiumName() 
    {
        return stadiumName;
    }
    public void setStadiumAddress(String stadiumAddress) 
    {
        this.stadiumAddress = stadiumAddress;
    }

    public String getStadiumAddress() 
    {
        return stadiumAddress;
    }

    public String getStadiumIntroduce() {
        return stadiumIntroduce;
    }

    public void setStadiumIntroduce(String stadiumIntroduce) {
        this.stadiumIntroduce = stadiumIntroduce;
    }

    public void setAppointmentNum(String appointmentNum)
    {
        this.appointmentNum = appointmentNum;
    }

    public String getAppointmentNum() 
    {
        return appointmentNum;
    }
    public void setIsAppointment(String isAppointment) 
    {
        this.isAppointment = isAppointment;
    }

    public String getIsAppointment() 
    {
        return isAppointment;
    }
    public void setStadiumType(String stadiumType) 
    {
        this.stadiumType = stadiumType;
    }

    public String getStadiumType() 
    {
        return stadiumType;
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

    public String getStadiumImg() {
        return stadiumImg;
    }

    public void setStadiumImg(String stadiumImg) {
        this.stadiumImg = stadiumImg;
    }

    public String getStadiumPeople() {
        return stadiumPeople;
    }

    public void setStadiumPeople(String stadiumPeople) {
        this.stadiumPeople = stadiumPeople;
    }

    public String getScheduleAppointment() {
        return scheduleAppointment;
    }

    public void setScheduleAppointment(String scheduleAppointment) {
        this.scheduleAppointment = scheduleAppointment;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("stadiumId", getStadiumId())
            .append("stadiumName", getStadiumName())
            .append("stadiumAddress", getStadiumAddress())
            .append("stadium-introduce", getStadiumIntroduce())
            .append("appointmentNum", getAppointmentNum())
            .append("isAppointment", getIsAppointment())
            .append("stadiumType", getStadiumType())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .append("stadiumPeople", getStadiumPeople())
            .append("scheduleAppointment", getScheduleAppointment())
            .toString();
    }
}
