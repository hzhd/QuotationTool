package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 音视频库对象 z_audio
 * 
 * @author zhoujie
 * @date 2022-11-25
 */
public class ZAudio extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long audioId;

    /** 音频名称 */
    @Excel(name = "音频名称")
    private String audioName;

    /** 音频介绍 */
    @Excel(name = "音频介绍")
    private String audioIntroduce;

    /** 音频内容 */
    @Excel(name = "音频内容")
    private String voiceContent;

    /** 视频内容 */
    @Excel(name = "视频内容")
    private String movieContent;

    /** 温馨提示 */
    @Excel(name = "温馨提示")
    private String reminder;

    /** 发布状态 */
    @Excel(name = "发布状态")
    private String issueState;

    /** 归属场馆 */
    @Excel(name = "归属场馆")
    private Integer stadiumId;

    /** 数据来源 */
    @Excel(name = "数据来源")
    private String resource;

    /** 状态（0正常 1停用） */
    @Excel(name = "状态", readConverterExp = "0=正常,1=停用")
    private String status;

    /** 删除标志（0代表存在 1代表删除） */
    private String delFlag;

    public void setAudioId(Long audioId) 
    {
        this.audioId = audioId;
    }

    public Long getAudioId() 
    {
        return audioId;
    }
    public void setAudioName(String audioName) 
    {
        this.audioName = audioName;
    }

    public String getAudioName() 
    {
        return audioName;
    }
    public void setAudioIntroduce(String audioIntroduce) 
    {
        this.audioIntroduce = audioIntroduce;
    }

    public String getAudioIntroduce() 
    {
        return audioIntroduce;
    }
    public void setVoiceContent(String voiceContent) 
    {
        this.voiceContent = voiceContent;
    }

    public String getVoiceContent() 
    {
        return voiceContent;
    }
    public void setMovieContent(String movieContent) 
    {
        this.movieContent = movieContent;
    }

    public String getMovieContent() 
    {
        return movieContent;
    }
    public void setReminder(String reminder) 
    {
        this.reminder = reminder;
    }

    public String getReminder() 
    {
        return reminder;
    }
    public void setIssueState(String issueState) 
    {
        this.issueState = issueState;
    }

    public String getIssueState() 
    {
        return issueState;
    }

    public Integer getStadiumId() {
        return stadiumId;
    }

    public void setStadiumId(Integer stadiumId) {
        this.stadiumId = stadiumId;
    }

    public void setResource(String resource)
    {
        this.resource = resource;
    }

    public String getResource() 
    {
        return resource;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
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
            .append("audioId", getAudioId())
            .append("audioName", getAudioName())
            .append("audioIntroduce", getAudioIntroduce())
            .append("voiceContent", getVoiceContent())
            .append("movieContent", getMovieContent())
            .append("reminder", getReminder())
            .append("issueState", getIssueState())
            .append("stadiumId", getStadiumId())
            .append("resource", getResource())
            .append("status", getStatus())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
