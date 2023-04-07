package com.ruoyi.quotation.service;

import com.ruoyi.quotation.domain.bo.GetOrgListResponse;
import com.ruoyi.quotation.domain.bo.PushEshopRequest;
import com.ruoyi.quotation.domain.bo.PushEshopResponse;

import java.util.List;

/**
 * eshop接口对接
 * @author huzd
 * @date 2023-03-01 13:52
 */
public interface EshopApiService {

    /**
     * 认证接口-获取Token
     *
     * @return token
     */
    public String getToken();

    /**
     * eshop推送数据
     *
     * @return 推送结果
     */
    public PushEshopResponse pushEshop(PushEshopRequest pushEshopRequest);

    /**
     * 组织接口-获取组织结构
     *
     * @return 组织结构列表
     */
    public List<GetOrgListResponse> getOrgList();

    /**
     * 同步-组织列表信息
     *
     * @param getOrgListResponseList
     * @return int
     */
    public int synOrgList(List<GetOrgListResponse> getOrgListResponseList);
}
