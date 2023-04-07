package com.ruoyi.quotation.mapper;

import com.ruoyi.quotation.domain.bo.DistributorView;
import com.ruoyi.quotation.domain.bo.SalesView;

import java.util.List;

/**
 * eshop视图数据
 * 
 * @author huzd
 * @date 2023-03-11
 */
public interface EshopViewMapper {

    /**
     * 获取销售人员视图数据
     *
     * @return 销售人员
     */
    public List<SalesView> getSalesList();

    /**
     * 获取经销商视图数据
     * @author huzd
     * @date 2023-03-11 8:06
     * @return java.util.List<com.ruoyi.quotation.domain.bo.Distributor>
     */
    public List<DistributorView> getDistributorList();

}
