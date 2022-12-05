package com.ruoyi.business.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 电影统计对象 d_movie_info
 * 
 * @author ruoyi
 * @date 2022-11-25
 */
public class DMovieInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 电影名称 */
    @Excel(name = "电影名称")
    private String movieName;

    /** 电影介绍 */
    @Excel(name = "电影介绍")
    private String movieJieshao;

    /** 电影图片 */
    @Excel(name = "电影图片")
    private String movieMsg;

    /** 观影人数 */
    @Excel(name = "观影人数")
    private Long viewingNo;

    /** 观影热度 */
    @Excel(name = "观影热度")
    private BigDecimal viewingHot;

    /** 放映时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "放映时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date time;

    /** 放映地点 */
    @Excel(name = "放映地点")
    private String site;

    /** 逻辑删除 0正常 1删除 */
    @Excel(name = "逻辑删除 0正常 1删除")
    private String delStatus;

    /** 电影片段 */
    @Excel(name = "电影片段")
    private String moviePianduan;

    /** 温馨提示 */
    @Excel(name = "温馨提示")
    private String tishi;

    /** 最大观影人数 */
    @Excel(name = "最大观影人数")
    private String maxPeople;

    /** 电影归属场馆 */
    @Excel(name = "电影归属场馆")
    private String guishuAddr;

    /** 电影类型 */
    @Excel(name = "电影类型")
    private String movieType;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMovieName(String movieName) 
    {
        this.movieName = movieName;
    }

    public String getMovieName() 
    {
        return movieName;
    }
    public void setMovieJieshao(String movieJieshao) 
    {
        this.movieJieshao = movieJieshao;
    }

    public String getMovieJieshao() 
    {
        return movieJieshao;
    }
    public void setMovieMsg(String movieMsg) 
    {
        this.movieMsg = movieMsg;
    }

    public String getMovieMsg() 
    {
        return movieMsg;
    }
    public void setViewingNo(Long viewingNo) 
    {
        this.viewingNo = viewingNo;
    }

    public Long getViewingNo() 
    {
        return viewingNo;
    }
    public void setViewingHot(BigDecimal viewingHot) 
    {
        this.viewingHot = viewingHot;
    }

    public BigDecimal getViewingHot() 
    {
        return viewingHot;
    }
    public void setTime(Date time) 
    {
        this.time = time;
    }

    public Date getTime() 
    {
        return time;
    }
    public void setSite(String site) 
    {
        this.site = site;
    }

    public String getSite() 
    {
        return site;
    }
    public void setDelStatus(String delStatus) 
    {
        this.delStatus = delStatus;
    }

    public String getDelStatus() 
    {
        return delStatus;
    }
    public void setMoviePianduan(String moviePianduan) 
    {
        this.moviePianduan = moviePianduan;
    }

    public String getMoviePianduan() 
    {
        return moviePianduan;
    }
    public void setTishi(String tishi) 
    {
        this.tishi = tishi;
    }

    public String getTishi() 
    {
        return tishi;
    }
    public void setMaxPeople(String maxPeople) 
    {
        this.maxPeople = maxPeople;
    }

    public String getMaxPeople() 
    {
        return maxPeople;
    }
    public void setGuishuAddr(String guishuAddr) 
    {
        this.guishuAddr = guishuAddr;
    }

    public String getGuishuAddr() 
    {
        return guishuAddr;
    }
    public void setMovieType(String movieType) 
    {
        this.movieType = movieType;
    }

    public String getMovieType() 
    {
        return movieType;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("movieName", getMovieName())
            .append("movieJieshao", getMovieJieshao())
            .append("movieMsg", getMovieMsg())
            .append("viewingNo", getViewingNo())
            .append("viewingHot", getViewingHot())
            .append("time", getTime())
            .append("site", getSite())
            .append("delStatus", getDelStatus())
            .append("moviePianduan", getMoviePianduan())
            .append("tishi", getTishi())
            .append("maxPeople", getMaxPeople())
            .append("guishuAddr", getGuishuAddr())
            .append("movieType", getMovieType())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
