package com.ruoyi.business.stadium.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 场馆基本信息对象 t_stadium
 * 
 * @author zhouyz
 * @date 2022-11-27
 */
public class Stadium extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录主键 */
    private Long id;

    /** 场馆名称 */
    @Excel(name = "场馆名称")
    private String stadiumName;

   

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setStadiumName(String stadiumName) 
    {
        this.stadiumName = stadiumName;
    }

    public String getStadiumName() 
    {
        return stadiumName;
    }
  

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("stadiumName", getStadiumName())
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
