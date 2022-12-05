package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.DPassengerInfo;

/**
 * 客流统计Service接口
 * 
 * @author ruoyi
 * @date 2022-09-21
 */
public interface IDPassengerInfoService 
{
    /**
     * 查询客流统计
     * 
     * @param id 客流统计主键
     * @return 客流统计
     */
    public DPassengerInfo selectDPassengerInfoById(Long id);

    /**
     * 查询客流统计列表
     * 
     * @param dPassengerInfo 客流统计
     * @return 客流统计集合
     */
    public List<DPassengerInfo> selectDPassengerInfoList(DPassengerInfo dPassengerInfo);

    /**
     * 新增客流统计
     * 
     * @param dPassengerInfo 客流统计
     * @return 结果
     */
    public int insertDPassengerInfo(DPassengerInfo dPassengerInfo);

    /**
     * 修改客流统计
     * 
     * @param dPassengerInfo 客流统计
     * @return 结果
     */
    public int updateDPassengerInfo(DPassengerInfo dPassengerInfo);

    /**
     * 批量删除客流统计
     * 
     * @param ids 需要删除的客流统计主键集合
     * @return 结果
     */
    public int deleteDPassengerInfoByIds(Long[] ids);

    /**
     * 删除客流统计信息
     * 
     * @param id 客流统计主键
     * @return 结果
     */
    public int deleteDPassengerInfoById(Long id);

    List<DPassengerInfo> nums();
}
