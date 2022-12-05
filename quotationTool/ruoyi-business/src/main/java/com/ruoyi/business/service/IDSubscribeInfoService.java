package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.DSubscribeInfo;

/**
 * 预约统计Service接口
 * 
 * @author ruoyi
 * @date 2022-09-21
 */
public interface IDSubscribeInfoService 
{
    /**
     * 查询预约统计
     * 
     * @param id 预约统计主键
     * @return 预约统计
     */
    public DSubscribeInfo selectDSubscribeInfoById(Long id);

    /**
     * 查询预约统计列表
     * 
     * @param dSubscribeInfo 预约统计
     * @return 预约统计集合
     */
    public List<DSubscribeInfo> selectDSubscribeInfoList(DSubscribeInfo dSubscribeInfo);

    /**
     * 新增预约统计
     * 
     * @param dSubscribeInfo 预约统计
     * @return 结果
     */
    public int insertDSubscribeInfo(DSubscribeInfo dSubscribeInfo);

    /**
     * 修改预约统计
     * 
     * @param dSubscribeInfo 预约统计
     * @return 结果
     */
    public int updateDSubscribeInfo(DSubscribeInfo dSubscribeInfo);

    /**
     * 批量删除预约统计
     * 
     * @param ids 需要删除的预约统计主键集合
     * @return 结果
     */
    public int deleteDSubscribeInfoByIds(Long[] ids);

    /**
     * 删除预约统计信息
     * 
     * @param id 预约统计主键
     * @return 结果
     */
    public int deleteDSubscribeInfoById(Long id);

    List<String> names();

    List<DSubscribeInfo> selectorderby();
}
