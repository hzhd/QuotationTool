package com.ruoyi.business.team.domain;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.business.GlobalConstant;
import com.ruoyi.business.common.service.ICacheService;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 团队成员对象 t_team_member
 * 
 * @author zhouyz
 * @date 2022-11-28
 */
public class TeamMember extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**
     * 性别标签
     * @return
     */
    public String getMemberSexLabel(){
    	if(this.memberSex==null)
    		return "未知";
    	else if(this.memberSex==1)
    		return "男";
    	if(this.memberSex==2)
    		return "女";
    	else
    		return "未知";
    }
    /**
     * 归属团队标签
     * @return
     */
    public String getTeamLabel(){
    	if(this.teamId==null)
    		return "未知团队";
    	else
    		return GlobalConstant.cacheService.getDicItemLabel(ICacheService.DicCodeTeam, this.teamId+"");
    }
    //***********************************************
    
    /** 记录主键 */
    private Integer id;
    
    /** 团员姓名 */
    @Excel(name = "团员姓名")
    private String memberName;

    /** 团员性别,1=男 2=女 */
    @Excel(name = "团员性别,1=男 2=女")
    private Integer memberSex;

    /** 照片 */
    @Excel(name = "照片")
    private String memberPicture;

    /** 归属团队,关联t_team */
    @Excel(name = "归属团队,关联t_team")
    private Integer teamId;

    /** 入团时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入团时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date joinTime;

    /** 联系电话 */
    @Excel(name = "联系电话")
    private String phone;

    /** 电子邮箱 */
    @Excel(name = "电子邮箱")
    private String email;

    public void setMemberName(String memberName) 
    {
        this.memberName = memberName;
    }

    public String getMemberName() 
    {
        return memberName;
    }
    public void setMemberSex(Integer memberSex) 
    {
        this.memberSex = memberSex;
    }

    public Integer getMemberSex() 
    {
        return memberSex;
    }
    public void setMemberPicture(String memberPicture) 
    {
        this.memberPicture = memberPicture;
    }

    public String getMemberPicture() 
    {
        return memberPicture;
    }
    public void setTeamId(Integer teamId) 
    {
        this.teamId = teamId;
    }

    public Integer getTeamId() 
    {
        return teamId;
    }
    public void setJoinTime(Date joinTime) 
    {
        this.joinTime = joinTime;
    }

    public Date getJoinTime() 
    {
        return joinTime;
    }
    public void setPhone(String phone) 
    {
        this.phone = phone;
    }

    public String getPhone() 
    {
        return phone;
    }
    public void setEmail(String email) 
    {
        this.email = email;
    }

    public String getEmail() 
    {
        return email;
    }
   
    public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("memberName", getMemberName())
            .append("memberSex", getMemberSex())
            .append("memberPicture", getMemberPicture())
            .append("teamId", getTeamId())
            .append("joinTime", getJoinTime())
            .append("phone", getPhone())
            .append("email", getEmail())
            .append("creatorId", getCreatorId())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updatorId", getUpdatorId())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("delTag", getDelTag())
            .append("recVersion", getRecVersion())
            .toString();
    }
}
