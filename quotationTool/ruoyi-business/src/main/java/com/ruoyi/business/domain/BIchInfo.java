package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 非遗库数据维护对象 b_ich_info
 * 
 * @author ruoyi
 * @date 2022-11-25
 */
public class BIchInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long ichId;

    /** 项目名称 */
    @Excel(name = "项目名称")
    private String projectName;

    /** 项目内容 */
    @Excel(name = "项目内容")
    private String projectContent;

    /** 项目介绍语音 */
    @Excel(name = "项目介绍语音")
    private String projectVoice;

    /** 项目图片 */
    @Excel(name = "项目图片")
    private String projectMsg;

    /** 项目介绍视频 */
    @Excel(name = "项目介绍视频")
    private String projectVodeo;

    /** 项目标签 */
    @Excel(name = "项目标签")
    private String projectLabel;

    /** 项目评论 */
    @Excel(name = "项目评论")
    private String projectComment;

    /** 归属场馆 */
    @Excel(name = "归属场馆")
    private String attrSite;

    /** 逻辑删除 0:删除 1存在 */
    @Excel(name = "逻辑删除 0:删除 1存在")
    private String delStatus;

    /** 项目类型 */
    @Excel(name = "项目类型")
    private String projectType;

    /** 温馨提示 */
    @Excel(name = "温馨提示")
    private String tipContent;

    /** 项目状态，0=待发布 1=已发布 */
    @Excel(name = "项目状态，0=待发布 1=已发布")
    private Long projectStatus;

    /** 是否推送到宣传大屏 */
    @Excel(name = "是否推送到宣传大屏")
    private Long xcdpFlag;

    public void setIchId(Long ichId) 
    {
        this.ichId = ichId;
    }

    public Long getIchId() 
    {
        return ichId;
    }
    public void setProjectName(String projectName) 
    {
        this.projectName = projectName;
    }

    public String getProjectName() 
    {
        return projectName;
    }
    public void setProjectContent(String projectContent) 
    {
        this.projectContent = projectContent;
    }

    public String getProjectContent() 
    {
        return projectContent;
    }
    public void setProjectVoice(String projectVoice) 
    {
        this.projectVoice = projectVoice;
    }

    public String getProjectVoice() 
    {
        return projectVoice;
    }
    public void setProjectMsg(String projectMsg) 
    {
        this.projectMsg = projectMsg;
    }

    public String getProjectMsg() 
    {
        return projectMsg;
    }
    public void setProjectVodeo(String projectVodeo) 
    {
        this.projectVodeo = projectVodeo;
    }

    public String getProjectVodeo() 
    {
        return projectVodeo;
    }
    public void setProjectLabel(String projectLabel) 
    {
        this.projectLabel = projectLabel;
    }

    public String getProjectLabel() 
    {
        return projectLabel;
    }
    public void setProjectComment(String projectComment) 
    {
        this.projectComment = projectComment;
    }

    public String getProjectComment() 
    {
        return projectComment;
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
    public void setProjectType(String projectType) 
    {
        this.projectType = projectType;
    }

    public String getProjectType() 
    {
        return projectType;
    }
    public void setTipContent(String tipContent) 
    {
        this.tipContent = tipContent;
    }

    public String getTipContent() 
    {
        return tipContent;
    }
    public void setProjectStatus(Long projectStatus) 
    {
        this.projectStatus = projectStatus;
    }

    public Long getProjectStatus() 
    {
        return projectStatus;
    }
    public void setXcdpFlag(Long xcdpFlag) 
    {
        this.xcdpFlag = xcdpFlag;
    }

    public Long getXcdpFlag() 
    {
        return xcdpFlag;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("ichId", getIchId())
            .append("projectName", getProjectName())
            .append("projectContent", getProjectContent())
            .append("projectVoice", getProjectVoice())
            .append("projectMsg", getProjectMsg())
            .append("projectVodeo", getProjectVodeo())
            .append("projectLabel", getProjectLabel())
            .append("projectComment", getProjectComment())
            .append("attrSite", getAttrSite())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delStatus", getDelStatus())
            .append("remark", getRemark())
            .append("projectType", getProjectType())
            .append("tipContent", getTipContent())
            .append("projectStatus", getProjectStatus())
            .append("xcdpFlag", getXcdpFlag())
            .toString();
    }
}
