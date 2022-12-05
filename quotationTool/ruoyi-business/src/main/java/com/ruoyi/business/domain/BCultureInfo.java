package com.ruoyi.business.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 文化咨询库对象 b_culture_info
 * 
 * @author ruoyi
 * @date 2022-11-25
 */
public class BCultureInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 文化咨询标题 */
    @Excel(name = "文化咨询标题")
    private String culTitle;

    /** 文化咨询时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "文化咨询时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date culTime;

    /** 图文化资讯名称 */
    @Excel(name = "图文化资讯名称")
    private String culName;

    /** 文化资讯内容 */
    @Excel(name = "文化资讯内容")
    private String culMsg;

    /** 文化资讯链接 */
    @Excel(name = "文化资讯链接")
    private String culUrl;

    /** 归属场馆 */
    @Excel(name = "归属场馆")
    private String culAddr;

    /** 状态 */
    @Excel(name = "状态")
    private String delStatus;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCulTitle(String culTitle) 
    {
        this.culTitle = culTitle;
    }

    public String getCulTitle() 
    {
        return culTitle;
    }
    public void setCulTime(Date culTime) 
    {
        this.culTime = culTime;
    }

    public Date getCulTime() 
    {
        return culTime;
    }
    public void setCulName(String culName) 
    {
        this.culName = culName;
    }

    public String getCulName() 
    {
        return culName;
    }
    public void setCulMsg(String culMsg) 
    {
        this.culMsg = culMsg;
    }

    public String getCulMsg() 
    {
        return culMsg;
    }
    public void setCulUrl(String culUrl) 
    {
        this.culUrl = culUrl;
    }

    public String getCulUrl() 
    {
        return culUrl;
    }
    public void setCulAddr(String culAddr) 
    {
        this.culAddr = culAddr;
    }

    public String getCulAddr() 
    {
        return culAddr;
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
            .append("culTitle", getCulTitle())
            .append("culTime", getCulTime())
            .append("culName", getCulName())
            .append("culMsg", getCulMsg())
            .append("culUrl", getCulUrl())
            .append("culAddr", getCulAddr())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("delStatus", getDelStatus())
            .toString();
    }
}
