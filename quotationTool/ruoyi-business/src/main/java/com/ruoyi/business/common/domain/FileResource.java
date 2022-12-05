package com.ruoyi.business.common.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 资源文件对象 t_file_resource
 * 
 * @author ruoyi
 * @date 2022-11-28
 */
public class FileResource extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /**
     * 微信客户端首页轮播图
     */
    public static String BizTypeWXHomeSlideshow="200";
    /**
     * 团队风采图片
     */
    public static String BizTypeTeamMinePic="100";
    /**
     * 团队风采视频
     */
    public static String BizTypeTeamMineVideo="101";
    
    public static int ContentTypeAudio=1;
    public static int ContentTypeVideo=2;
    public static int ContentTypePic=3;
    //*****************************************
    /** 记录主键 */
    private Integer id;

    /** 资源的业务类型 */
    @Excel(name = "资源的业务类型")
    private String bizType;

    /** 业务记录ID,关联其他业务表 */
    @Excel(name = "业务记录ID,关联其他业务表")
    private Integer bizId;

    /** 资源内容类型,1=音频 2=视频 3=图片 */
    @Excel(name = "资源内容类型,1=音频 2=视频 3=图片")
    private Integer contentType;

    /** 资源文件的路径文件 */
    @Excel(name = "资源文件的路径文件")
    private String filePath;


    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setBizType(String bizType) 
    {
        this.bizType = bizType;
    }

    public String getBizType() 
    {
        return bizType;
    }
    public void setBizId(Integer bizId) 
    {
        this.bizId = bizId;
    }

    public Integer getBizId() 
    {
        return bizId;
    }
    public void setContentType(Integer contentType) 
    {
        this.contentType = contentType;
    }

    public Integer getContentType() 
    {
        return contentType;
    }
    public void setFilePath(String filePath) 
    {
        this.filePath = filePath;
    }

    public String getFilePath() 
    {
        return filePath;
    }
   



    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("bizType", getBizType())
            .append("bizId", getBizId())
            .append("contentType", getContentType())
            .append("filePath", getFilePath())
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
