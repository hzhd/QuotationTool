package com.ruoyi.screenSet.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 游客大屏配置对象 d_set_visitor
 * 
 * @author huzd
 * @date 2022-09-23
 */
public class DSetVisitor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 视频 */
    @Excel(name = "视频")
    private String video;

    /** 直播照片 */
    @Excel(name = "直播照片")
    private String zbImage;

    /** 直播标题 */
    @Excel(name = "直播标题")
    private String zbTitle;

    /** 直播时间 */
    //@JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "直播时间")
    private String zbTime;

    /** 直播人数 */
    @Excel(name = "直播人数")
    private String zbCount;

    /** 资讯图片 */
    @Excel(name = "资讯图片")
    private String zxImage;

    /** 资讯标题 */
    @Excel(name = "资讯标题")
    private String zxTitle;

    /** 资讯时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "资讯时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date zxTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setVideo(String video) 
    {
        this.video = video;
    }

    public String getVideo() 
    {
        return video;
    }
    public void setZbImage(String zbImage) 
    {
        this.zbImage = zbImage;
    }

    public String getZbImage() 
    {
        return zbImage;
    }
    public void setZbTitle(String zbTitle) 
    {
        this.zbTitle = zbTitle;
    }

    public String getZbTitle() 
    {
        return zbTitle;
    }

    public String getZbTime() {
        return zbTime;
    }

    public void setZbTime(String zbTime) {
        this.zbTime = zbTime;
    }

    public void setZbCount(String zbCount)
    {
        this.zbCount = zbCount;
    }

    public String getZbCount() 
    {
        return zbCount;
    }
    public void setZxImage(String zxImage) 
    {
        this.zxImage = zxImage;
    }

    public String getZxImage() 
    {
        return zxImage;
    }
    public void setZxTitle(String zxTitle) 
    {
        this.zxTitle = zxTitle;
    }

    public String getZxTitle() 
    {
        return zxTitle;
    }
    public void setZxTime(Date zxTime) 
    {
        this.zxTime = zxTime;
    }

    public Date getZxTime() 
    {
        return zxTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("video", getVideo())
            .append("zbImage", getZbImage())
            .append("zbTitle", getZbTitle())
            .append("zbTime", getZbTime())
            .append("zbCount", getZbCount())
            .append("zxImage", getZxImage())
            .append("zxTitle", getZxTitle())
            .append("zxTime", getZxTime())
            .toString();
    }
}
