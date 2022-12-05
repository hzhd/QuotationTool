package com.ruoyi.business.domain;

import java.math.BigDecimal;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 慕课库数据维护对象 b_mooc_course
 * 
 * @author huzd
 * @date 2022-09-20
 */
public class BMoocCourse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键id */
    private Long id;

    /** 课件名称 */
    @Excel(name = "课件名称")
    private String title;

    /** 课件内容 */
    @Excel(name = "课件内容")
    private String content;

    /** 课件报名条件 */
    @Excel(name = "课件报名条件")
    private String signCondition;

    /** 课件图片 */
    @Excel(name = "课件图片")
    private String imageUrl;

    /** 收费标准 */
    @Excel(name = "收费标准")
    private BigDecimal chargeStandard;

    /** 教师姓名 */
    @Excel(name = "教师姓名")
    private String teacherName;

    /** 教师照片 */
    @Excel(name = "教师照片")
    private String teacherImage;

    /** 教师介绍 */
    @Excel(name = "教师介绍")
    private String teacherIntroduce;

    /** 课程安排时间 */
    @Excel(name = "课程安排时间")
    private String classSchedule;

    /** 报名时间 */
    @Excel(name = "报名时间")
    private String signTime;

    /** 课时 */
    @Excel(name = "课时")
    private String period;

    /** 教室安排 */
    @Excel(name = "教室安排")
    private String classroom;

    /** 咨询电话 */
    @Excel(name = "咨询电话")
    private String telephone;

    /** 课程状态（0：未开始:1：进行中:2：已结束） */
    @Excel(name = "课程状态", readConverterExp = "0=：未开始:1：进行中:2：已结束")
    private Integer classStatus;

    /** 课堂笔记 */
    @Excel(name = "课堂笔记")
    private String note;

    /** 归属场馆 */
    @Excel(name = "归属场馆")
    private String place;

    /** 直播链接 */
    @Excel(name = "直播链接")
    private String liveUrl;

    /** 删除标志（0代表存在 2代表删除） */
    private String delFlag;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setTitle(String title) 
    {
        this.title = title;
    }

    public String getTitle() 
    {
        return title;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }
    public void setSignCondition(String signCondition) 
    {
        this.signCondition = signCondition;
    }

    public String getSignCondition() 
    {
        return signCondition;
    }
    public void setImageUrl(String imageUrl) 
    {
        this.imageUrl = imageUrl;
    }

    public String getImageUrl() 
    {
        return imageUrl;
    }
    public void setChargeStandard(BigDecimal chargeStandard) 
    {
        this.chargeStandard = chargeStandard;
    }

    public BigDecimal getChargeStandard() 
    {
        return chargeStandard;
    }
    public void setTeacherName(String teacherName) 
    {
        this.teacherName = teacherName;
    }

    public String getTeacherName() 
    {
        return teacherName;
    }
    public void setTeacherImage(String teacherImage) 
    {
        this.teacherImage = teacherImage;
    }

    public String getTeacherImage() 
    {
        return teacherImage;
    }
    public void setTeacherIntroduce(String teacherIntroduce) 
    {
        this.teacherIntroduce = teacherIntroduce;
    }

    public String getTeacherIntroduce() 
    {
        return teacherIntroduce;
    }
    public void setClassSchedule(String classSchedule) 
    {
        this.classSchedule = classSchedule;
    }

    public String getClassSchedule() 
    {
        return classSchedule;
    }
    public void setSignTime(String signTime) 
    {
        this.signTime = signTime;
    }

    public String getSignTime() 
    {
        return signTime;
    }
    public void setPeriod(String period) 
    {
        this.period = period;
    }

    public String getPeriod() 
    {
        return period;
    }
    public void setClassroom(String classroom) 
    {
        this.classroom = classroom;
    }

    public String getClassroom() 
    {
        return classroom;
    }
    public void setTelephone(String telephone) 
    {
        this.telephone = telephone;
    }

    public String getTelephone() 
    {
        return telephone;
    }
    public void setClassStatus(Integer classStatus) 
    {
        this.classStatus = classStatus;
    }

    public Integer getClassStatus() 
    {
        return classStatus;
    }
    public void setNote(String note) 
    {
        this.note = note;
    }

    public String getNote() 
    {
        return note;
    }
    public void setPlace(String place) 
    {
        this.place = place;
    }

    public String getPlace() 
    {
        return place;
    }
    public void setLiveUrl(String liveUrl) 
    {
        this.liveUrl = liveUrl;
    }

    public String getLiveUrl() 
    {
        return liveUrl;
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
            .append("title", getTitle())
            .append("content", getContent())
            .append("signCondition", getSignCondition())
            .append("imageUrl", getImageUrl())
            .append("chargeStandard", getChargeStandard())
            .append("teacherName", getTeacherName())
            .append("teacherImage", getTeacherImage())
            .append("teacherIntroduce", getTeacherIntroduce())
            .append("classSchedule", getClassSchedule())
            .append("signTime", getSignTime())
            .append("period", getPeriod())
            .append("classroom", getClassroom())
            .append("telephone", getTelephone())
            .append("classStatus", getClassStatus())
            .append("note", getNote())
            .append("place", getPlace())
            .append("liveUrl", getLiveUrl())
            .append("delFlag", getDelFlag())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
