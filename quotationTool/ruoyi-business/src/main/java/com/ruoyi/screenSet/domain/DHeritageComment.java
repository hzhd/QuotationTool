package com.ruoyi.screenSet.domain;

import com.ruoyi.business.domain.BIchInfo;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import java.util.List;

/**
 * 非遗评论对象 d_heritage_comment
 * 
 * @author huzd
 * @date 2022-09-21
 */
public class DHeritageComment extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 评论用户 */
    @Excel(name = "评论用户")
    private String userName;

    /** 评论内容 */
    @Excel(name = "评论内容")
    private String content;

    /** 头像 */
    @Excel(name = "头像")
    private String photo;

    /** 星级 */
    @Excel(name = "星级")
    private Integer starLevel;

    /** 模块类型 */
    @Excel(name = "模块类型")
    private String moduleType;

    /**
     * 项目id
     */
    private Long projectId;

    private List<BIchInfo> projectList;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public List<BIchInfo> getProjectList() {
        return projectList;
    }

    public void setProjectList(List<BIchInfo> projectList) {
        this.projectList = projectList;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setPhoto(String photo) 
    {
        this.photo = photo;
    }

    public String getPhoto() 
    {
        return photo;
    }
    public void setStarLevel(Integer starLevel) 
    {
        this.starLevel = starLevel;
    }

    public Integer getStarLevel() 
    {
        return starLevel;
    }
    public void setModuleType(String moduleType) 
    {
        this.moduleType = moduleType;
    }

    public String getModuleType() 
    {
        return moduleType;
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
            .append("userName", getUserName())
            .append("content", getContent())
            .append("photo", getPhoto())
            .append("starLevel", getStarLevel())
            .append("moduleType", getModuleType())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
