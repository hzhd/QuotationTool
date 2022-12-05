package com.ruoyi.business.media.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.ruoyi.business.GlobalConstant;
import com.ruoyi.business.common.service.ICacheService;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 图片基本信息库对象 t_picture
 * 
 * @author zhouyz
 * @date 2022-11-27
 */
public class Picture extends BaseEntity
{
    private static final long serialVersionUID = 1L;
    //图片状态：0=待审核、1=审核中、2=审核未通过、3=待发布、4=已发布
    public static int PicStatusInit=0;
    public static int PicStatusAuditing=1;
    public static int PicStatusRefused=2;
    public static int PicStatusNoPublish=3;
    public static int PicStatusPublished=4;
    public String getPicTypeLabel(){
    	return GlobalConstant.cacheService.getDicItemLabel(ICacheService.DicCodePicType,this.picType);
    }
    public String getPicStatusLabel(){
    	if(this.picStatus==null)
    		return "未知";
    	else if(this.picStatus==Picture.PicStatusInit)
    		return "待审核";
    	else if(this.picStatus==Picture.PicStatusAuditing)
    		return "审核中";
    	else if(this.picStatus==Picture.PicStatusRefused)
    		return "审核未通过";
    	else if(this.picStatus==Picture.PicStatusNoPublish)
    		return "待发布";
    	else if(this.picStatus==Picture.PicStatusPublished)
    		return "已发布";
    	else
    		return "未定义";
    }
    public String getStadiumLabel(){ 
    	if(this.stadiumId==null)
    		return "未知场馆";
    	else
    		return GlobalConstant.cacheService.getDicItemLabel(ICacheService.DicCodeStadium, this.stadiumId+"");
    }
    //******************************************

    /** 记录主键 */
    private Long id;

    /** 图片名称 */
    @Excel(name = "图片名称", readConverterExp = "$column.readConverterExp()")
    private String picName;

    /** 图片类型 */
    @Excel(name = "图片类型", readConverterExp = "$column.readConverterExp()")
    private String picType;

    /** 归属场馆，关联场馆记录 */
    @Excel(name = "归属场馆，关联场馆记录", readConverterExp = "$column.readConverterExp()")
    private Long stadiumId;
    /**  归属场馆（文字转换） **/
    @Excel(name = " 归属场馆（文字转换）", readConverterExp = "$column.readConverterExp()")
    private String stadiumLabel;


    /** 图片标签 */
    @Excel(name = "图片标签", readConverterExp = "$column.readConverterExp()")
    private String picTag;

    /** 图片介绍 */
    @Excel(name = "图片介绍", readConverterExp = "$column.readConverterExp()")
    private String picIntro;

    /** 图片路径 */
    @Excel(name = "图片路径", readConverterExp = "$column.readConverterExp()")
    private String picPath;

    /** 温馨提示 */
    @Excel(name = "温馨提示", readConverterExp = "$column.readConverterExp()")
    private String picTip;

    /** 图片状态，0=待审核、1=审核中、2=审核未通过、3=待发布、4=已发布 */
    @Excel(name = "图片状态，0=待审核、1=审核中、2=审核未通过、3=待发布、4=已发布", readConverterExp = "$column.readConverterExp()")
    private Integer picStatus;


    public void setStadiumLabel(String stadiumLabel) {
        this.stadiumLabel = stadiumLabel;
    }


    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setPicName(String picName) 
    {
        this.picName = picName;
    }

    public String getPicName() 
    {
        return picName;
    }
    public void setPicType(String picType) 
    {
        this.picType = picType;
    }

    public String getPicType() 
    {
        return picType;
    }
    public void setStadiumId(Long stadiumId) 
    {
        this.stadiumId = stadiumId;
    }

    public Long getStadiumId() 
    {
        return stadiumId;
    }
    public void setPicTag(String picTag) 
    {
        this.picTag = picTag;
    }

    public String getPicTag() 
    {
        return picTag;
    }
    public void setPicIntro(String picIntro) 
    {
        this.picIntro = picIntro;
    }

    public String getPicIntro() 
    {
        return picIntro;
    }
    public void setPicPath(String picPath) 
    {
        this.picPath = picPath;
    }

    public String getPicPath() 
    {
        return picPath;
    }
    public void setPicTip(String picTip) 
    {
        this.picTip = picTip;
    }

    public String getPicTip() 
    {
        return picTip;
    }
    public void setPicStatus(Integer picStatus) 
    {
        this.picStatus = picStatus;
    }

    public Integer getPicStatus() 
    {
        return picStatus;
    }
    

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("picName", getPicName())
            .append("picType", getPicTypeLabel())
            .append("stadiumId", this.getStadiumLabel())
            .append("picTag", getPicTag())
            .append("picIntro", getPicIntro())
            .append("picPath", getPicPath())
            .append("picTip", getPicTip())
            .append("picStatus", this.getPicStatusLabel())
            .toString();
    }
}
