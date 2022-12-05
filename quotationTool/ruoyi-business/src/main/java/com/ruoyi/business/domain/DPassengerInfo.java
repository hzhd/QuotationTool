package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 客流统计对象 d_passenger_info
 * 
 * @author ruoyi
 * @date 2022-09-21
 */
public class DPassengerInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 时间段预约数 */
    @Excel(name = "时间段预约数")
    private String subscribeToday;

    /** 时间段客流数 */
    @Excel(name = "时间段客流数")
    private String passengerTime;

    /** 时间段 */
    @Excel(name = "时间段")
    private String timeLine;

    /** 逻辑删除  1正常 0删除 */
    @Excel(name = "逻辑删除  1正常 0删除")
    private String delStatus;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSubscribeToday(String subscribeToday) 
    {
        this.subscribeToday = subscribeToday;
    }

    public String getSubscribeToday() 
    {
        return subscribeToday;
    }
    public void setPassengerTime(String passengerTime) 
    {
        this.passengerTime = passengerTime;
    }

    public String getPassengerTime() 
    {
        return passengerTime;
    }
    public void setTimeLine(String timeLine) 
    {
        this.timeLine = timeLine;
    }

    public String getTimeLine() 
    {
        return timeLine;
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
            .append("subscribeToday", getSubscribeToday())
            .append("passengerTime", getPassengerTime())
            .append("timeLine", getTimeLine())
            .append("delStatus", getDelStatus())
            .toString();
    }
}
