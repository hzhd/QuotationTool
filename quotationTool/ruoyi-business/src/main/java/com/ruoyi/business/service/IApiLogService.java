package com.ruoyi.business.service;

import com.ruoyi.business.domain.ApiLog;

import java.util.List;

/**
 * 推送接口日志
 * 
 * @author ruoyi
 */
public interface IApiLogService
{
    /**
     * 新增日志
     * 
     * @param apiLog
     */
    public void insertApiLog(ApiLog apiLog);

    /**
     * 查询系日志集合
     * 
     * @param apiLog
     * @return 记录集合
     */
    public List<ApiLog> selectApiLogList(ApiLog apiLog);

    /**
     * 查询系日志集合
     *
     * @param apiLog
     * @return 记录集合
     */
    public List<ApiLog> selectApiLogList2(ApiLog apiLog);

    /**
     * 批量删除日志
     * 
     * @param infoIds 需要删除的日志ID
     * @return 结果
     */
    public int deleteApiLogByIds(Long[] infoIds);

    /**
     * 清空系统登录日志
     */
    public void cleanApiLog();
}
