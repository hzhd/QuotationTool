package com.ruoyi.business.mapper;

import com.ruoyi.business.domain.ApiLog;

import java.util.List;

/**
 * 接口推送日志
 * 
 * @author ruoyi
 */
public interface ApiLogMapper
{
    /**
     * 新增推送日志
     * 
     * @param apiLog
     */
    public void insertApiLog(ApiLog apiLog);

    /**
     * 查询推送日志集合
     * 
     * @param apiLog
     * @return 推送记录集合
     */
    public List<ApiLog> selectApiLogList(ApiLog apiLog);

    /**
     * 查询推送日志集合
     *
     * @param apiLog
     * @return 推送记录集合
     */
    public List<ApiLog> selectApiLogList2(ApiLog apiLog);

    /**
     * 批量删除推送日志
     * 
     * @param infoIds 需要删除的日志ID
     * @return 结果
     */
    public int deleteApiLogByIds(Long[] infoIds);

    /**
     * 清空推送日志
     * 
     * @return 结果
     */
    public int cleanApiLog();
}
