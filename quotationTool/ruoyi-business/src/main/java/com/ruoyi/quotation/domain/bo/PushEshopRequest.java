package com.ruoyi.quotation.domain.bo;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class PushEshopRequest {
    //唯一标识
    private String id;
    //数据来源
    private String dataSource;
    //线索编号
    private String clueNo;
    //线索产生时间
    private Date clueQenerationTime;
    //大区编码
    private String regionCode;
    //大区名称
    private String regionName;
    //状态编码
    private String statusCode;
    //状态名称
    private String statusName;
    //线索来源
    private String clueSource;
    //产品
    private String product;
    //配件型号
    private String accessoryModel;
    //丢单原因
    private String lostOrderReason;
    //对单原因备注
    private String lostOrderRemark;
    //客户姓名
    private String customerName;
    //客户称谓
    private String customerAppellation;
    //客户类型
    private String customerType;
    //客户电话
    private String customerPhone;
    //省
    private String province;
    //省份编码
    private String provinceCode;
    //市
    private String city;
    //城市代码
    private String cityCode;
    //区
    private String county;
    //区代码
    private String countyCode;
    //地址
    private String address;
    //安装类型编码
    private String installationTypeCode;
    //安装类型名称
    private String installationTypeName;
    //心仪采暖方式
    private String favoriteHeating;
    //房屋建筑面积
    private String buildingArea;
    //花洒数量
    private Long sprinklerQuantity;
    //锅炉类型
    private String boilerType;
    //辅材类型
    private String auxiliaryMaterialsType;
    //归属门店
    private String belongingStore;
    //锅炉功率
    private String boilerPower;
    //激活状态
    private String activationStatus;
    //销售渠道
    private String distributionChannel;
    //负责人
    private String responsiblePerson;
    //负责人联系方式
    private String responsiblePersonPhone;
    //门店详细地址
    private String storeAddress;
    //经销商编号
    private String distributorId;
    //经销商名称
    private String distributorName;
    //问题描述
    private String problemDescription;
    //推荐产品方案
    private List<RecommendProducts> recommendProducts;


}
