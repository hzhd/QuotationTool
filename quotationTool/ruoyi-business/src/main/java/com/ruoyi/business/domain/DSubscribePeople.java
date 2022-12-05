package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 场馆预约人数对象 d_subscribe_people
 * 
 * @author ruoyi
 * @date 2022-09-22
 */
public class DSubscribePeople extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 预约场馆 */
    @Excel(name = "预约场馆")
    private String siteName;

    /** 预约账号 */
    @Excel(name = "预约账号")
    private String account;

    /** 联系方式 */
    @Excel(name = "联系方式")
    private String phone;

    /** 预约人数 */
    @Excel(name = "预约人数")
    private String peopleNo;

    /** 预约项目活动 */
    @Excel(name = "预约项目活动")
    private String appointmentTime;

    /** 逻辑删除 1正常  0删除 */
    @Excel(name = "逻辑删除 1正常  0删除")
    private String delStatus;

    private Integer peopleNoSum;

    public Integer getPeopleNoSum() {
        return peopleNoSum;
    }

    public void setPeopleNoSum(Integer peopleNoSum) {
        this.peopleNoSum = peopleNoSum;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSiteName(String siteName) 
    {
        this.siteName = siteName;
    }

    public String getSiteName() 
    {
        return siteName;
    }
    public void setAccount(String account) 
    {
        this.account = account;
    }

    public String getAccount() 
    {
        return account;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setPeopleNo(String peopleNo) 
    {
        this.peopleNo = peopleNo;
    }

    public String getPeopleNo() 
    {
        return peopleNo;
    }
    public void setAppointmentTime(String appointmentTime) 
    {
        this.appointmentTime = appointmentTime;
    }

    public String getAppointmentTime() 
    {
        return appointmentTime;
    }
    public void setDelStatus(String delStatus) 
    {
        this.delStatus = delStatus;
    }

    public String getDelStatus() 
    {
        return delStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("siteName", getSiteName())
            .append("account", getAccount())
            .append("phone", getPhone())
            .append("peopleNo", getPeopleNo())
            .append("createTime", getCreateTime())
            .append("appointmentTime", getAppointmentTime())
            .append("delStatus", getDelStatus())
            .toString();
    }
}
