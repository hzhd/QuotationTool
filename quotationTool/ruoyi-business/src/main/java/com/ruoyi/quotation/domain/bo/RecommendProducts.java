package com.ruoyi.quotation.domain.bo;

import lombok.Data;

/**
 * @author huzd
 * @date 2023-03-01 19:48
 */
@Data
public class RecommendProducts {
    //唯一标识
    private String id;
    //方案名称
    private String caseName;
    //产品系列名称
    private String productGroup;
    //产品型号名称
    private String product;
    //报价
    private String price;
}
