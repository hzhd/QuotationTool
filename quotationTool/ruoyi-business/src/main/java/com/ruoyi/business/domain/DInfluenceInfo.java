package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 影响力统计对象 d_influence_info
 * 
 * @author Liu
 * @date 2022-09-21
 */
public class DInfluenceInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 影响力名称 */
    @Excel(name = "影响力名称")
    private String influenceName;

    /** 热门信息 */
    @Excel(name = "热门信息")
    private String hotMsg;

    /** 日影响力统计 */
    @Excel(name = "日影响力统计")
    private Long dayNo;

    /** 周影响力统计 */
    @Excel(name = "周影响力统计")
    private Long weekNo;

    /** 月影响力统计 */
    @Excel(name = "月影响力统计")
    private Long monthNo;

    /** 年影响力统计 */
    @Excel(name = "年影响力统计")
    private Long yearNo;

    /** 逻辑删除  1正常  0删除 */
    @Excel(name = "逻辑删除  1正常  0删除")
    private String delStatus;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setInfluenceName(String influenceName) 
    {
        this.influenceName = influenceName;
    }

    public String getInfluenceName() 
    {
        return influenceName;
    }
    public void setHotMsg(String hotMsg) 
    {
        this.hotMsg = hotMsg;
    }

    public String getHotMsg() 
    {
        return hotMsg;
    }
    public void setDayNo(Long dayNo) 
    {
        this.dayNo = dayNo;
    }

    public Long getDayNo() 
    {
        return dayNo;
    }
    public void setWeekNo(Long weekNo) 
    {
        this.weekNo = weekNo;
    }

    public Long getWeekNo() 
    {
        return weekNo;
    }
    public void setMonthNo(Long monthNo) 
    {
        this.monthNo = monthNo;
    }

    public Long getMonthNo() 
    {
        return monthNo;
    }
    public void setYearNo(Long yearNo) 
    {
        this.yearNo = yearNo;
    }

    public Long getYearNo() 
    {
        return yearNo;
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
            .append("influenceName", getInfluenceName())
            .append("hotMsg", getHotMsg())
            .append("dayNo", getDayNo())
            .append("weekNo", getWeekNo())
            .append("monthNo", getMonthNo())
            .append("yearNo", getYearNo())
            .append("delStatus", getDelStatus())
            .toString();
    }
}
