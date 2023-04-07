package com.ruoyi.business.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 生成二维码对象 q_barcode
 * 
 * @author huzd
 * @date 2023-02-13
 */
public class Barcode extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 大区 */
    @Excel(name = "大区")
    private String area;

    /** 省份 */
    @Excel(name = "省份")
    private String provence;

    /** 城市 */
    @Excel(name = "城市")
    private String city;

    /** 销售编号 */
    @Excel(name = "销售编号")
    private Long salesCode;

    /** 销售名称 */
    @Excel(name = "销售名称")
    private String salesName;

    /** 经销商编号 */
    @Excel(name = "经销商编号")
    private Long dealerCode;

    /** 经销商名称 */
    @Excel(name = "经销商名称")
    private String dealerName;

    /** 活动名称 */
    @Excel(name = "活动名称")
    private String activityName;

    /** 活动开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "活动开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date startTime;

    /** 活动结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "活动结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date endTime;

    /** 信息来源 */
    @Excel(name = "信息来源")
    private String source;

    /** 图片路经 */
    @Excel(name = "图片路经")
    private String barcodePath;

    /** 删除标志（0代表存在 1代表删除） */
    private String delFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setArea(String area) 
    {
        this.area = area;
    }

    public String getArea() 
    {
        return area;
    }
    public void setProvence(String provence) 
    {
        this.provence = provence;
    }

    public String getProvence() 
    {
        return provence;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setSalesCode(Long salesCode) 
    {
        this.salesCode = salesCode;
    }

    public Long getSalesCode() 
    {
        return salesCode;
    }
    public void setSalesName(String salesName) 
    {
        this.salesName = salesName;
    }

    public String getSalesName() 
    {
        return salesName;
    }
    public void setDealerCode(Long dealerCode) 
    {
        this.dealerCode = dealerCode;
    }

    public Long getDealerCode() 
    {
        return dealerCode;
    }
    public void setDealerName(String dealerName) 
    {
        this.dealerName = dealerName;
    }

    public String getDealerName() 
    {
        return dealerName;
    }
    public void setActivityName(String activityName) 
    {
        this.activityName = activityName;
    }

    public String getActivityName() 
    {
        return activityName;
    }
    public void setStartTime(Date startTime) 
    {
        this.startTime = startTime;
    }

    public Date getStartTime() 
    {
        return startTime;
    }
    public void setEndTime(Date endTime) 
    {
        this.endTime = endTime;
    }

    public Date getEndTime() 
    {
        return endTime;
    }
    public void setSource(String source) 
    {
        this.source = source;
    }

    public String getSource() 
    {
        return source;
    }
    public void setBarcodePath(String barcodePath) 
    {
        this.barcodePath = barcodePath;
    }

    public String getBarcodePath() 
    {
        return barcodePath;
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
            .append("id", getId())
            .append("area", getArea())
            .append("provence", getProvence())
            .append("city", getCity())
            .append("salesCode", getSalesCode())
            .append("salesName", getSalesName())
            .append("dealerCode", getDealerCode())
            .append("dealerName", getDealerName())
            .append("activityName", getActivityName())
            .append("startTime", getStartTime())
            .append("endTime", getEndTime())
            .append("source", getSource())
            .append("barcodePath", getBarcodePath())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
