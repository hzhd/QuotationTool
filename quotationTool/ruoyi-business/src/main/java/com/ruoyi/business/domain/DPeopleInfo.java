package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.beans.Transient;

/**
 * 进出人数统计对象 d_people_info
 * 
 * @author ruoyi
 * @date 2022-09-21
 */
public class DPeopleInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 场地名称 */
    @Excel(name = "场地名称")
    private String siteName;

    /** 日进入人数 */
    @Excel(name = "日进入人数")
    private Long inPeopleDay;

    /** 日出入人数 */
    @Excel(name = "日出入人数")
    private Long outPeopleDay;

    /** 周进入人数 */
    @Excel(name = "周进入人数")
    private Long inPeopleWeek;

    /** 周出入人数 */
    @Excel(name = "周出入人数")
    private Long outPeopleWeek;

    /** 月进入人数 */
    @Excel(name = "月进入人数")
    private Long inPeopleMonth;

    /** 月出入人数 */
    @Excel(name = "月出入人数")
    private Long outPeopleMonth;

    /** 年进入人数 */
    @Excel(name = "年进入人数")
    private Long inPeopleYear;

    /** 年出入人数 */
    @Excel(name = "年出入人数")
    private Long outPeopleYear;

    /** 逻辑删除 1正常  0删除 */
    @Excel(name = "逻辑删除 1正常  0删除")
    private String delStatus;

    private Long total;

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
    public void setInPeopleDay(Long inPeopleDay) 
    {
        this.inPeopleDay = inPeopleDay;
    }

    public Long getInPeopleDay() 
    {
        return inPeopleDay;
    }
    public void setOutPeopleDay(Long outPeopleDay) 
    {
        this.outPeopleDay = outPeopleDay;
    }

    public Long getOutPeopleDay() 
    {
        return outPeopleDay;
    }
    public void setInPeopleWeek(Long inPeopleWeek) 
    {
        this.inPeopleWeek = inPeopleWeek;
    }

    public Long getInPeopleWeek() 
    {
        return inPeopleWeek;
    }
    public void setOutPeopleWeek(Long outPeopleWeek) 
    {
        this.outPeopleWeek = outPeopleWeek;
    }

    public Long getOutPeopleWeek() 
    {
        return outPeopleWeek;
    }
    public void setInPeopleMonth(Long inPeopleMonth) 
    {
        this.inPeopleMonth = inPeopleMonth;
    }

    public Long getInPeopleMonth() 
    {
        return inPeopleMonth;
    }
    public void setOutPeopleMonth(Long outPeopleMonth) 
    {
        this.outPeopleMonth = outPeopleMonth;
    }

    public Long getOutPeopleMonth() 
    {
        return outPeopleMonth;
    }
    public void setInPeopleYear(Long inPeopleYear) 
    {
        this.inPeopleYear = inPeopleYear;
    }

    public Long getInPeopleYear() 
    {
        return inPeopleYear;
    }
    public void setOutPeopleYear(Long outPeopleYear) 
    {
        this.outPeopleYear = outPeopleYear;
    }

    public Long getOutPeopleYear() 
    {
        return outPeopleYear;
    }
    public void setDelStatus(String delStatus) 
    {
        this.delStatus = delStatus;
    }

    public String getDelStatus() 
    {
        return delStatus;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "DPeopleInfo{" +
                "id=" + id +
                ", siteName='" + siteName + '\'' +
                ", inPeopleDay=" + inPeopleDay +
                ", outPeopleDay=" + outPeopleDay +
                ", inPeopleWeek=" + inPeopleWeek +
                ", outPeopleWeek=" + outPeopleWeek +
                ", inPeopleMonth=" + inPeopleMonth +
                ", outPeopleMonth=" + outPeopleMonth +
                ", inPeopleYear=" + inPeopleYear +
                ", outPeopleYear=" + outPeopleYear +
                ", delStatus='" + delStatus + '\'' +
                ", total=" + total +
                '}';
    }
}
