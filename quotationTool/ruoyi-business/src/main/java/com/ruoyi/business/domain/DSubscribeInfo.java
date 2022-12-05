package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 预约统计对象 d_subscribe_info
 * 
 * @author ruoyi
 * @date 2022-09-21
 */
public class DSubscribeInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 场馆名称 */
    @Excel(name = "场馆名称")
    private String siteName;

    /** 明日预约人数（人） */
    @Excel(name = "明日预约人数", readConverterExp = "人=")
    private String subscribeTomorrow;

    /** 本周活动（个） */
    @Excel(name = "本周活动", readConverterExp = "个=")
    private String weekActivities;

    /** 逻辑删除 1.正常 0删除 */
    @Excel(name = "逻辑删除 1.正常 0删除")
    private String delStatus;

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
    public void setSubscribeTomorrow(String subscribeTomorrow) 
    {
        this.subscribeTomorrow = subscribeTomorrow;
    }

    public String getSubscribeTomorrow() 
    {
        return subscribeTomorrow;
    }
    public void setWeekActivities(String weekActivities) 
    {
        this.weekActivities = weekActivities;
    }

    public String getWeekActivities() 
    {
        return weekActivities;
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
            .append("subscribeTomorrow", getSubscribeTomorrow())
            .append("weekActivities", getWeekActivities())
            .append("createTime", getCreateTime())
            .append("delStatus", getDelStatus())
            .toString();
    }
}
