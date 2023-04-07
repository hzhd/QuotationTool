package com.ruoyi.quotation.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 推送数据对象 q_eshop
 * 
 * @author huzd
 * @date 2023-03-01
 */
public class Eshop extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    //二维码id
    private Long qrcodeId;

    /** 数据来源 */
    @Excel(name = "数据来源")
    private String datasource;

    /** 线索编号 */
    @Excel(name = "线索编号")
    private String clueno;

    /** 线索产生时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "线索产生时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date clueqenerationtime;

    /** 大区编码 */
    @Excel(name = "大区编码")
    private String regioncode;

    /** 大区名称 */
    @Excel(name = "大区名称")
    private String regionname;

    /** 状态编码 */
    @Excel(name = "状态编码")
    private String statuscode;

    /** 状态名称 */
    @Excel(name = "状态名称")
    private String statusname;

    /** 线索来源 */
    @Excel(name = "线索来源")
    private String cluesource;

    /** 产品 */
    @Excel(name = "产品")
    private String product;

    /** 配件型号 */
    @Excel(name = "配件型号")
    private String accessorymodel;

    /** 对单原因 */
    @Excel(name = "对单原因")
    private String lostorderreason;

    /** 丢单原因备注 */
    @Excel(name = "丢单原因备注")
    private String lostorderremark;

    /** 客户姓名 */
    @Excel(name = "客户姓名")
    private String customername;

    /** 客户称谓 */
    @Excel(name = "客户称谓")
    private String customerappellation;

    /** 客户类型 */
    @Excel(name = "客户类型")
    private String customertype;

    /** 客户电话 */
    @Excel(name = "客户电话")
    private String customerphone;

    /** 省 */
    @Excel(name = "省")
    private String province;

    /** 省份代码 */
    @Excel(name = "省份代码")
    private String provincecode;

    /** 市 */
    @Excel(name = "市")
    private String city;

    /** 城市代码 */
    @Excel(name = "城市代码")
    private String citycode;

    /** 区 */
    @Excel(name = "区")
    private String county;

    /** 区代码 */
    @Excel(name = "区代码")
    private String countycode;

    /** 地址 */
    @Excel(name = "地址")
    private String address;

    /** 安装类型编码 */
    @Excel(name = "安装类型编码")
    private String installationtypecode;

    /** 安装类型名称 */
    @Excel(name = "安装类型名称")
    private String installationtypename;

    /** 心仪采暖方式 */
    @Excel(name = "心仪采暖方式")
    private String favoriteheating;

    /** 房屋建筑面积 */
    @Excel(name = "房屋建筑面积")
    private String buildingarea;

    /** 花洒数量 */
    @Excel(name = "花洒数量")
    private Long sprinklerquantity;

    /** 锅炉类型 */
    @Excel(name = "锅炉类型")
    private String boilertype;

    /** 辅材类型 */
    @Excel(name = "辅材类型")
    private String auxiliarymaterialstype;

    /** 归属门店 */
    @Excel(name = "归属门店")
    private String belongingstore;

    /** 锅炉功率 */
    @Excel(name = "锅炉功率")
    private String boilerpower;

    /** 激活状态 */
    @Excel(name = "激活状态")
    private String activationstatus;

    /** 销售渠道 */
    @Excel(name = "销售渠道")
    private String distributionchannel;

    /** 负责人 */
    @Excel(name = "负责人")
    private String responsibleperson;

    /** 负责人联系方式 */
    @Excel(name = "负责人联系方式")
    private String responsiblepersonphone;

    /** 门店详细地址 */
    @Excel(name = "门店详细地址")
    private String storeaddress;

    /** 经销商编号 */
    @Excel(name = "经销商编号")
    private String distributorid;

    /** 经销商名称 */
    @Excel(name = "经销商名称")
    private String distributorname;

    /** 问题描述 */
    @Excel(name = "问题描述")
    private String problemdescription;

    /** 方案1 */
    @Excel(name = "方案1")
    private String casename1;

    /** 方案2 */
    @Excel(name = "方案2")
    private String casename2;

    /** 产品系列1 */
    @Excel(name = "产品系列1")
    private String productgroup1;

    /** 产品系列2 */
    @Excel(name = "产品系列2")
    private String productgroup2;

    /** 产品型号1 */
    @Excel(name = "产品型号1")
    private String product1;

    /** 产品型号2 */
    @Excel(name = "产品型号2")
    private String product2;

    /** 报价1 */
    @Excel(name = "报价1")
    private String price1;

    /** 报价2 */
    @Excel(name = "报价2")
    private String price2;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setDatasource(String datasource) 
    {
        this.datasource = datasource;
    }

    public String getDatasource() 
    {
        return datasource;
    }
    public void setClueno(String clueno) 
    {
        this.clueno = clueno;
    }

    public String getClueno() 
    {
        return clueno;
    }
    public void setClueqenerationtime(Date clueqenerationtime) 
    {
        this.clueqenerationtime = clueqenerationtime;
    }

    public Date getClueqenerationtime() 
    {
        return clueqenerationtime;
    }
    public void setRegioncode(String regioncode) 
    {
        this.regioncode = regioncode;
    }

    public String getRegioncode() 
    {
        return regioncode;
    }
    public void setRegionname(String regionname) 
    {
        this.regionname = regionname;
    }

    public String getRegionname() 
    {
        return regionname;
    }
    public void setStatuscode(String statuscode) 
    {
        this.statuscode = statuscode;
    }

    public String getStatuscode() 
    {
        return statuscode;
    }
    public void setStatusname(String statusname) 
    {
        this.statusname = statusname;
    }

    public String getStatusname() 
    {
        return statusname;
    }
    public void setCluesource(String cluesource) 
    {
        this.cluesource = cluesource;
    }

    public String getCluesource() 
    {
        return cluesource;
    }
    public void setProduct(String product) 
    {
        this.product = product;
    }

    public String getProduct() 
    {
        return product;
    }
    public void setAccessorymodel(String accessorymodel) 
    {
        this.accessorymodel = accessorymodel;
    }

    public String getAccessorymodel() 
    {
        return accessorymodel;
    }
    public void setLostorderreason(String lostorderreason) 
    {
        this.lostorderreason = lostorderreason;
    }

    public String getLostorderreason() 
    {
        return lostorderreason;
    }
    public void setLostorderremark(String lostorderremark) 
    {
        this.lostorderremark = lostorderremark;
    }

    public String getLostorderremark() 
    {
        return lostorderremark;
    }
    public void setCustomername(String customername) 
    {
        this.customername = customername;
    }

    public String getCustomername() 
    {
        return customername;
    }
    public void setCustomerappellation(String customerappellation) 
    {
        this.customerappellation = customerappellation;
    }

    public String getCustomerappellation() 
    {
        return customerappellation;
    }
    public void setCustomertype(String customertype) 
    {
        this.customertype = customertype;
    }

    public String getCustomertype() 
    {
        return customertype;
    }
    public void setCustomerphone(String customerphone) 
    {
        this.customerphone = customerphone;
    }

    public String getCustomerphone() 
    {
        return customerphone;
    }
    public void setProvince(String province) 
    {
        this.province = province;
    }

    public String getProvince() 
    {
        return province;
    }
    public void setProvincecode(String provincecode) 
    {
        this.provincecode = provincecode;
    }

    public String getProvincecode() 
    {
        return provincecode;
    }
    public void setCity(String city) 
    {
        this.city = city;
    }

    public String getCity() 
    {
        return city;
    }
    public void setCitycode(String citycode) 
    {
        this.citycode = citycode;
    }

    public String getCitycode() 
    {
        return citycode;
    }
    public void setCounty(String county) 
    {
        this.county = county;
    }

    public String getCounty() 
    {
        return county;
    }
    public void setCountycode(String countycode) 
    {
        this.countycode = countycode;
    }

    public String getCountycode() 
    {
        return countycode;
    }
    public void setAddress(String address) 
    {
        this.address = address;
    }

    public String getAddress() 
    {
        return address;
    }
    public void setInstallationtypecode(String installationtypecode) 
    {
        this.installationtypecode = installationtypecode;
    }

    public String getInstallationtypecode() 
    {
        return installationtypecode;
    }
    public void setInstallationtypename(String installationtypename) 
    {
        this.installationtypename = installationtypename;
    }

    public String getInstallationtypename() 
    {
        return installationtypename;
    }
    public void setFavoriteheating(String favoriteheating) 
    {
        this.favoriteheating = favoriteheating;
    }

    public String getFavoriteheating() 
    {
        return favoriteheating;
    }
    public void setBuildingarea(String buildingarea) 
    {
        this.buildingarea = buildingarea;
    }

    public String getBuildingarea() 
    {
        return buildingarea;
    }
    public void setSprinklerquantity(Long sprinklerquantity) 
    {
        this.sprinklerquantity = sprinklerquantity;
    }

    public Long getSprinklerquantity() 
    {
        return sprinklerquantity;
    }
    public void setBoilertype(String boilertype) 
    {
        this.boilertype = boilertype;
    }

    public String getBoilertype() 
    {
        return boilertype;
    }
    public void setAuxiliarymaterialstype(String auxiliarymaterialstype) 
    {
        this.auxiliarymaterialstype = auxiliarymaterialstype;
    }

    public String getAuxiliarymaterialstype() 
    {
        return auxiliarymaterialstype;
    }
    public void setBelongingstore(String belongingstore) 
    {
        this.belongingstore = belongingstore;
    }

    public String getBelongingstore() 
    {
        return belongingstore;
    }
    public void setBoilerpower(String boilerpower) 
    {
        this.boilerpower = boilerpower;
    }

    public String getBoilerpower() 
    {
        return boilerpower;
    }
    public void setActivationstatus(String activationstatus) 
    {
        this.activationstatus = activationstatus;
    }

    public String getActivationstatus() 
    {
        return activationstatus;
    }
    public void setDistributionchannel(String distributionchannel) 
    {
        this.distributionchannel = distributionchannel;
    }

    public String getDistributionchannel() 
    {
        return distributionchannel;
    }
    public void setResponsibleperson(String responsibleperson) 
    {
        this.responsibleperson = responsibleperson;
    }

    public String getResponsibleperson() 
    {
        return responsibleperson;
    }
    public void setResponsiblepersonphone(String responsiblepersonphone) 
    {
        this.responsiblepersonphone = responsiblepersonphone;
    }

    public String getResponsiblepersonphone() 
    {
        return responsiblepersonphone;
    }
    public void setStoreaddress(String storeaddress) 
    {
        this.storeaddress = storeaddress;
    }

    public String getStoreaddress() 
    {
        return storeaddress;
    }
    public void setDistributorid(String distributorid) 
    {
        this.distributorid = distributorid;
    }

    public String getDistributorid() 
    {
        return distributorid;
    }
    public void setDistributorname(String distributorname) 
    {
        this.distributorname = distributorname;
    }

    public String getDistributorname() 
    {
        return distributorname;
    }
    public void setProblemdescription(String problemdescription) 
    {
        this.problemdescription = problemdescription;
    }

    public String getProblemdescription() 
    {
        return problemdescription;
    }
    public void setCasename1(String casename1) 
    {
        this.casename1 = casename1;
    }

    public String getCasename1() 
    {
        return casename1;
    }
    public void setCasename2(String casename2) 
    {
        this.casename2 = casename2;
    }

    public String getCasename2() 
    {
        return casename2;
    }
    public void setProductgroup1(String productgroup1) 
    {
        this.productgroup1 = productgroup1;
    }

    public String getProductgroup1() 
    {
        return productgroup1;
    }
    public void setProductgroup2(String productgroup2) 
    {
        this.productgroup2 = productgroup2;
    }

    public String getProductgroup2() 
    {
        return productgroup2;
    }
    public void setProduct1(String product1) 
    {
        this.product1 = product1;
    }

    public String getProduct1() 
    {
        return product1;
    }
    public void setProduct2(String product2) 
    {
        this.product2 = product2;
    }

    public String getProduct2() 
    {
        return product2;
    }
    public void setPrice1(String price1) 
    {
        this.price1 = price1;
    }

    public String getPrice1() 
    {
        return price1;
    }
    public void setPrice2(String price2) 
    {
        this.price2 = price2;
    }

    public String getPrice2() 
    {
        return price2;
    }

    public Long getQrcodeId() {
        return qrcodeId;
    }

    public void setQrcodeId(Long qrcodeId) {
        this.qrcodeId = qrcodeId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("datasource", getDatasource())
            .append("clueno", getClueno())
            .append("clueqenerationtime", getClueqenerationtime())
            .append("regioncode", getRegioncode())
            .append("regionname", getRegionname())
            .append("statuscode", getStatuscode())
            .append("statusname", getStatusname())
            .append("cluesource", getCluesource())
            .append("product", getProduct())
            .append("accessorymodel", getAccessorymodel())
            .append("lostorderreason", getLostorderreason())
            .append("lostorderremark", getLostorderremark())
            .append("customername", getCustomername())
            .append("customerappellation", getCustomerappellation())
            .append("customertype", getCustomertype())
            .append("customerphone", getCustomerphone())
            .append("province", getProvince())
            .append("provincecode", getProvincecode())
            .append("city", getCity())
            .append("citycode", getCitycode())
            .append("county", getCounty())
            .append("countycode", getCountycode())
            .append("address", getAddress())
            .append("installationtypecode", getInstallationtypecode())
            .append("installationtypename", getInstallationtypename())
            .append("favoriteheating", getFavoriteheating())
            .append("buildingarea", getBuildingarea())
            .append("sprinklerquantity", getSprinklerquantity())
            .append("boilertype", getBoilertype())
            .append("auxiliarymaterialstype", getAuxiliarymaterialstype())
            .append("belongingstore", getBelongingstore())
            .append("boilerpower", getBoilerpower())
            .append("activationstatus", getActivationstatus())
            .append("distributionchannel", getDistributionchannel())
            .append("responsibleperson", getResponsibleperson())
            .append("responsiblepersonphone", getResponsiblepersonphone())
            .append("storeaddress", getStoreaddress())
            .append("distributorid", getDistributorid())
            .append("distributorname", getDistributorname())
            .append("problemdescription", getProblemdescription())
            .append("casename1", getCasename1())
            .append("casename2", getCasename2())
            .append("productgroup1", getProductgroup1())
            .append("productgroup2", getProductgroup2())
            .append("product1", getProduct1())
            .append("product2", getProduct2())
            .append("price1", getPrice1())
            .append("price2", getPrice2())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("remark", getRemark())
            .toString();
    }
}
