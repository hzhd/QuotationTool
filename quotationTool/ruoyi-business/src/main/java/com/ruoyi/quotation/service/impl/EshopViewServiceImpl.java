package com.ruoyi.quotation.service.impl;

import com.ruoyi.common.annotation.DataSource;
import com.ruoyi.common.enums.DataSourceType;
import com.ruoyi.quotation.domain.bo.*;
import com.ruoyi.quotation.mapper.EshopViewMapper;
import com.ruoyi.quotation.service.EshopViewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * eshop视图数据
 * @author huzd
 * @date 2023-03-11 13:52
 */
@Service
public class EshopViewServiceImpl implements EshopViewService {
    private static final Logger log = LoggerFactory.getLogger(EshopViewServiceImpl.class);

    @Autowired
    private EshopViewMapper eshopViewMapper;

    /**
     * 获取销售人员视图数据
     *
     * @return 销售人员
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<SalesView> getSalesList() {
        return eshopViewMapper.getSalesList();
    }

    /**
     * 获取经销商视图数据
     *
     * @return java.util.List<com.ruoyi.quotation.domain.bo.Distributor>
     * @author huzd
     * @date 2023-03-11 8:06
     */
    @Override
    @DataSource(value = DataSourceType.SLAVE)
    public List<DistributorView> getDistributorList() {
        return eshopViewMapper.getDistributorList();
    }
}
