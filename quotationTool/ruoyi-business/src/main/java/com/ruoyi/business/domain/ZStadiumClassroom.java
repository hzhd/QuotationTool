package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 教室管理对象 z_stadium-classroom
 * 
 * @author zhoujie
 * @date 2022-11-28
 */
public class ZStadiumClassroom extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long classroomId;

    /** 所属场馆 */
    @Excel(name = "所属场馆")
    private Long stadiumId;

    /** 教室名称 */
    @Excel(name = "教室名称")
    private String classroomName;

    /** 教室地址 */
    @Excel(name = "教室地址")
    private String classroomAddress;

    /** 教室介绍 */
    @Excel(name = "教室介绍")
    private String classroomIntroduce;

    /** 是否可预约0是 1否 */
    @Excel(name = "是否可预约0是 1否")
    private String isAppointment;

    /** 可预约数 */
    @Excel(name = "可预约数")
    private String appointmentNum;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    private String classroomImg;

    public void setClassroomId(Long classroomId) 
    {
        this.classroomId = classroomId;
    }

    public Long getClassroomId() 
    {
        return classroomId;
    }
    public void setStadiumId(Long stadiumId) 
    {
        this.stadiumId = stadiumId;
    }

    public Long getStadiumId() 
    {
        return stadiumId;
    }
    public void setClassroomName(String classroomName) 
    {
        this.classroomName = classroomName;
    }

    public String getClassroomName() 
    {
        return classroomName;
    }
    public void setClassroomAddress(String classroomAddress) 
    {
        this.classroomAddress = classroomAddress;
    }

    public String getClassroomAddress() 
    {
        return classroomAddress;
    }
    public void setClassroomIntroduce(String classroomIntroduce) 
    {
        this.classroomIntroduce = classroomIntroduce;
    }

    public String getClassroomIntroduce() 
    {
        return classroomIntroduce;
    }
    public void setIsAppointment(String isAppointment) 
    {
        this.isAppointment = isAppointment;
    }

    public String getIsAppointment() 
    {
        return isAppointment;
    }
    public void setAppointmentNum(String appointmentNum) 
    {
        this.appointmentNum = appointmentNum;
    }

    public String getAppointmentNum() 
    {
        return appointmentNum;
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

    public String getClassroomImg() {
        return classroomImg;
    }

    public void setClassroomImg(String classroomImg) {
        this.classroomImg = classroomImg;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("classroomId", getClassroomId())
            .append("stadiumId", getStadiumId())
            .append("classroomName", getClassroomName())
            .append("classroomAddress", getClassroomAddress())
            .append("classroomIntroduce", getClassroomIntroduce())
            .append("isAppointment", getIsAppointment())
            .append("appointmentNum", getAppointmentNum())
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
