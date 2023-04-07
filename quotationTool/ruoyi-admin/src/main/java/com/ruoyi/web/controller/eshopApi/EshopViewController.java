package com.ruoyi.web.controller.eshopApi;

import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.quotation.domain.bo.DistributorView;
import com.ruoyi.quotation.domain.bo.SalesView;
import com.ruoyi.quotation.service.EshopViewService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 获取eshop视图提供的数据
 * @author huzd
 * @date 2023-03-11 7:39
 */
@RequestMapping("/eshop")
@RestController
public class EshopViewController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(EshopViewController.class);
    @Autowired
    private EshopViewService eshopViewService;

    /**
     * 获取销售人员视图数据
     */
    @GetMapping("/getSalesList")
    public AjaxResult getSalesList() {
        List<SalesView> getSalesList = eshopViewService.getSalesList();

        return AjaxResult.success(getSalesList);
    }

    /**
     * 获取经销商视图数据
     */
    @GetMapping("/getDistributorList")
    public AjaxResult getDistributorList() {
        List<DistributorView> getDistributorList = eshopViewService.getDistributorList();

        return AjaxResult.success(getDistributorList);
    }

}
