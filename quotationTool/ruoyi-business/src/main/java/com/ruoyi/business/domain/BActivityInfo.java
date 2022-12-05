package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.Date;

/**
 * 活动库数据对象 b_activity_info
 *
 * @author ruoyi
 * @date 2022-11-25
 */
public class BActivityInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long activityId;

    /** 活动名称 */
    @Excel(name = "活动名称")
    private String name;

    /** 图片 */
    @Excel(name = "图片")
    private String activityImg;

    /** 活动详情 */
    @Excel(name = "活动详情")
    private String activityDetails;

    /** 活动介绍视频 */
    @Excel(name = "活动介绍视频")
    private String activityVideo;

    /** 活动地址 */
    @Excel(name = "活动地址")
    private String activityAddr;

    /** 活动承办方 */
    @Excel(name = "活动承办方")
    private String activityContractor;

    /** 活动周期 */
    @Excel(name = "活动周期")
    private String period;

    /** 温馨提示 */
    @Excel(name = "温馨提示")
    private String hint;

    /** 活动最大参与人数 */
    @Excel(name = "活动最大参与人数")
    private String maxPeople;

    /** 活动状态 */
    @Excel(name = "活动状态")
    private String activityType;

    /** 归属场馆 */
    @Excel(name = "归属场馆")
    private String attrSite;

    @Excel(name = "入库时间")
    private Date createTime;

    /** 逻辑删除  0删除  1存在 */
    @Excel(name = "逻辑删除  0删除  1存在")
    private String delStatus;

    public void setActivityId(Long activityId)
    {
        this.activityId = activityId;
    }

    public BActivityInfo() {
    }

    @Override
    public Date getCreateTime() {
        return createTime;
    }

    @Override
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public BActivityInfo(Long activityId, String name, String activityImg, String activityDetails, String activityVideo, String activityAddr, String activityContractor, String period, String hint, String maxPeople, String activityType, String attrSite, Date createTime, String delStatus) {
        this.activityId = activityId;
        this.name = name;
        this.activityImg = activityImg;
        this.activityDetails = activityDetails;
        this.activityVideo = activityVideo;
        this.activityAddr = activityAddr;
        this.activityContractor = activityContractor;
        this.period = period;
        this.hint = hint;
        this.maxPeople = maxPeople;
        this.activityType = activityType;
        this.attrSite = attrSite;
        this.createTime = createTime;
        this.delStatus = delStatus;
    }

    public Long getActivityId()
    {
        return activityId;
    }
    public void setName(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
    public void setActivityImg(String activityImg)
    {
        this.activityImg = activityImg;
    }

    public String getActivityImg()
    {
        return activityImg;
    }
    public void setActivityDetails(String activityDetails)
    {
        this.activityDetails = activityDetails;
    }

    public String getActivityDetails()
    {
        return activityDetails;
    }
    public void setActivityVideo(String activityVideo)
    {
        this.activityVideo = activityVideo;
    }

    public String getActivityVideo()
    {
        return activityVideo;
    }
    public void setActivityAddr(String activityAddr)
    {
        this.activityAddr = activityAddr;
    }

    public String getActivityAddr()
    {
        return activityAddr;
    }
    public void setActivityContractor(String activityContractor)
    {
        this.activityContractor = activityContractor;
    }

    public String getActivityContractor()
    {
        return activityContractor;
    }
    public void setPeriod(String period)
    {
        this.period = period;
    }

    public String getPeriod()
    {
        return period;
    }
    public void setHint(String hint)
    {
        this.hint = hint;
    }

    public String getHint()
    {
        return hint;
    }
    public void setMaxPeople(String maxPeople)
    {
        this.maxPeople = maxPeople;
    }

    public String getMaxPeople()
    {
        return maxPeople;
    }
    public void setActivityType(String activityType)
    {
        this.activityType = activityType;
    }

    public String getActivityType()
    {
        return activityType;
    }
    public void setAttrSite(String attrSite)
    {
        this.attrSite = attrSite;
    }

    public String getAttrSite()
    {
        return attrSite;
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
                .append("activityId", getActivityId())
                .append("name", getName())
                .append("activityImg", getActivityImg())
                .append("activityDetails", getActivityDetails())
                .append("activityVideo", getActivityVideo())
                .append("activityAddr", getActivityAddr())
                .append("activityContractor", getActivityContractor())
                .append("period", getPeriod())
                .append("hint", getHint())
                .append("maxPeople", getMaxPeople())
                .append("activityType", getActivityType())
                .append("attrSite", getAttrSite())
                .append("createTime", getCreateTime())
                .append("delStatus", getDelStatus())
                .toString();
    }
}
