package com.ruoyi.web.controller.eshopApi;

import com.alibaba.fastjson.JSON;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.quotation.domain.bo.GetOrgListResponse;
import com.ruoyi.quotation.domain.bo.PushEshopRequest;
import com.ruoyi.quotation.domain.bo.PushEshopResponse;
import com.ruoyi.quotation.service.EshopApiService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * eshop接口对接
 * @author huzd
 * @date 2023-03-01 13:52
 */
@RequestMapping("/eshop")
@RestController
public class EshopApiController extends BaseController {
    private static final Logger log = LoggerFactory.getLogger(EshopApiController.class);
    @Autowired
    private EshopApiService eshopApiService;

    /**
     * 认证接口-获取Token
     */
    @GetMapping("/getToken")
    //可以抽离出方法供其他部分调用
    public AjaxResult getToken() {
        String token = eshopApiService.getToken();

        return AjaxResult.success("获取的token:" + token);
    }

    /**
     * eshop推送数据
     */
    @ResponseBody
    @GetMapping("/pushEshop")
    public AjaxResult pushEshop(@RequestBody Map<String,Object> map) {
        PushEshopRequest pushEshopRequest = JSON.parseObject(JSON.toJSONString(map), PushEshopRequest.class);
        PushEshopResponse pushEshopResponse = eshopApiService.pushEshop(pushEshopRequest);

        return AjaxResult.success(pushEshopResponse);
    }

    /**
     * 组织接口-获取组织结构
     */
    @GetMapping("/getOrgList")
    public AjaxResult getOrgList() {
        List<GetOrgListResponse> getOrgListResponseList = eshopApiService.getOrgList();

        return AjaxResult.success(getOrgListResponseList);
    }

    /**
     * 同步-组织列表信息
     */
    @GetMapping("/synOrgList")
    public AjaxResult synOrgList() {
        List<GetOrgListResponse> getOrgListResponseList = eshopApiService.getOrgList();
        int result = eshopApiService.synOrgList(getOrgListResponseList);
        if (result <= 0){
            return AjaxResult.error("未同步数据");
        }
        return AjaxResult.success("同步数据成功，同步的数据条数是：" + result);
    }

}
