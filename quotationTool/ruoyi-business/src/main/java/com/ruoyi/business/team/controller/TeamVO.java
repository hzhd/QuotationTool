package com.ruoyi.business.team.controller;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.business.GlobalConstant;
import com.ruoyi.business.common.service.ICacheService;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 团队管理对象 t_team
 * 
 * @author zhouyz
 * @date 2022-11-28
 */
public class TeamVO extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    
    /**
     * 团队类型label
     * @return
     */
    public String getTeamTypeLabel(){
    	if(this.teamType==null)
    		return "未知";
    	String[] types=this.teamType.split(",");
    	StringBuilder label=new StringBuilder();
    	for(String type:types){
    		label.append(GlobalConstant.cacheService.getDicItemLabel(ICacheService.DicCodeTeamType,type)).append(",");
    	}    			
    	return label.toString().substring(0,label.length()-1);
    }
    /*团队风采图片列表*/
    
    private List<String> minePic;
    /*团队风采视频列表*/
    private List<String> mineVideo;   
    /**
     * 成员人数的最小/大值
     */
    private Integer minMemberNum,maxMemberNum;
	//****************************************
    /** 记录主键 */
    private Integer id;

    /** 团队名称 */
    @Excel(name = "团队名称")
    private String teamName;

    /** 团队类型 */
    @Excel(name = "团队类型")
    private String teamType;

    /** 团队介绍 */
    @Excel(name = "团队介绍，富文本形式")
    private String teamIntro;
    /** 成员数 */
    @Excel(name = "成员数")
    private Integer memberNum;

    /** 团队图片路径 */
    @Excel(name = "团队图片路径")
    private String teamPic;

    /** 团队视频路径 */
    @Excel(name = "团队视频路径")
    private String teamVideo;

    /** 团队风采介绍 */
    @Excel(name = "团队风采介绍")
    private String teamMine;


    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setTeamName(String teamName) 
    {
        this.teamName = teamName;
    }

    public String getTeamName() 
    {
        return teamName;
    }
    public void setTeamType(String teamType) 
    {
        this.teamType = teamType;
    }

    public String getTeamType() 
    {
        return teamType;
    }
    public void setTeamIntro(String teamIntro) 
    {
        this.teamIntro = teamIntro;
    }

    public String getTeamIntro() 
    {
        return teamIntro;
    }
    public void setTeamPic(String teamPic) 
    {
        this.teamPic = teamPic;
    }

    public String getTeamPic() 
    {
        return teamPic;
    }
    public void setTeamVideo(String teamVideo) 
    {
        this.teamVideo = teamVideo;
    }

    public String getTeamVideo() 
    {
        return teamVideo;
    }
    public void setTeamMine(String teamMine) 
    {
        this.teamMine = teamMine;
    }

    public String getTeamMine() 
    {
        return teamMine;
    }
   

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("teamName", getTeamName())
            .append("teamType", getTeamType())
            .append("teamIntro", getTeamIntro())
            .append("teamPic", getTeamPic())
            .append("teamVideo", getTeamVideo())
            .append("teamMine", getTeamMine())
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

    public List<String> getMinePic() {
		return minePic;
	}

	public void setMinePic(List<String> minePic) {
		this.minePic = minePic;
	}

	public List<String> getMineVideo() {
		return mineVideo;
	}

	public void setMineVideo(List<String> mineVideo) {
		this.mineVideo = mineVideo;
	}

	public Integer getMemberNum() {
		return memberNum;
	}

	public void setMemberNum(Integer memberNum) {
		this.memberNum = memberNum;
	}

	public Integer getMinMemberNum() {
		return minMemberNum;
	}

	public void setMinMemberNum(Integer minMemberNum) {
		this.minMemberNum = minMemberNum;
	}

	public Integer getMaxMemberNum() {
		return maxMemberNum;
	}

	public void setMaxMemberNum(Integer maxMemberNum) {
		this.maxMemberNum = maxMemberNum;
	}
}
