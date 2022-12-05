package com.ruoyi.business.media.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 大屏设备基本信息对象 t_screen
 * 
 * @author zhouyz
 * @date 2022-11-28
 */
public class Screen extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 记录主键 */
    private Integer id;

    /** 设备名称 */
    @Excel(name = "设备名称")
    private String deviceName;

    /** 归属场馆 */
    @Excel(name = "归属场馆")
    private Integer stadiumId;

    /** 设备尺寸 */
    @Excel(name = "设备尺寸")
    private String deviceSize;

    /** 设备分辨率 */
    @Excel(name = "设备分辨率")
    private String deviceDpi;

    /** MAC地址 */
    @Excel(name = "MAC地址")
    private String macAdd;

    /** 设备IP */
    @Excel(name = "设备IP")
    private String deviceIp;

    /** 所在位置 */
    @Excel(name = "所在位置")
    private String deviceAdd;

    /** 入库时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "入库时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date registryTime;

    public void setId(Integer id) 
    {
        this.id = id;
    }

    public Integer getId() 
    {
        return id;
    }
    public void setDeviceName(String deviceName) 
    {
        this.deviceName = deviceName;
    }

    public String getDeviceName() 
    {
        return deviceName;
    }
    public void setStadiumId(Integer stadiumId) 
    {
        this.stadiumId = stadiumId;
    }

    public Integer getStadiumId() 
    {
        return stadiumId;
    }
    public void setDeviceSize(String deviceSize) 
    {
        this.deviceSize = deviceSize;
    }

    public String getDeviceSize() 
    {
        return deviceSize;
    }
    public void setDeviceDpi(String deviceDpi) 
    {
        this.deviceDpi = deviceDpi;
    }

    public String getDeviceDpi() 
    {
        return deviceDpi;
    }
    public void setMacAdd(String macAdd) 
    {
        this.macAdd = macAdd;
    }

    public String getMacAdd() 
    {
        return macAdd;
    }
    public void setDeviceIp(String deviceIp) 
    {
        this.deviceIp = deviceIp;
    }

    public String getDeviceIp() 
    {
        return deviceIp;
    }
    public void setDeviceAdd(String deviceAdd) 
    {
        this.deviceAdd = deviceAdd;
    }

    public String getDeviceAdd() 
    {
        return deviceAdd;
    }
    public void setRegistryTime(Date registryTime) 
    {
        this.registryTime = registryTime;
    }

    public Date getRegistryTime() 
    {
        return registryTime;
    }
   

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("deviceName", getDeviceName())
            .append("stadiumId", getStadiumId())
            .append("deviceSize", getDeviceSize())
            .append("deviceDpi", getDeviceDpi())
            .append("macAdd", getMacAdd())
            .append("deviceIp", getDeviceIp())
            .append("deviceAdd", getDeviceAdd())
            .append("registryTime", getRegistryTime())
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
