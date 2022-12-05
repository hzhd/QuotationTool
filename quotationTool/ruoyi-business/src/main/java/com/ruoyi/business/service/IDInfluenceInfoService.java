package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.DInfluenceInfo;

/**
 * 影响力统计Service接口
 * 
 * @author Liu
 * @date 2022-09-21
 */
public interface IDInfluenceInfoService 
{
    /**
     * 查询影响力统计
     * 
     * @param id 影响力统计主键
     * @return 影响力统计
     */
    public DInfluenceInfo selectDInfluenceInfoById(Long id);

    /**
     * 查询影响力统计列表
     * 
     * @param dInfluenceInfo 影响力统计
     * @return 影响力统计集合
     */
    public List<DInfluenceInfo> selectDInfluenceInfoList(DInfluenceInfo dInfluenceInfo);

    /**
     * 新增影响力统计
     * 
     * @param dInfluenceInfo 影响力统计
     * @return 结果
     */
    public int insertDInfluenceInfo(DInfluenceInfo dInfluenceInfo);

    /**
     * 修改影响力统计
     * 
     * @param dInfluenceInfo 影响力统计
     * @return 结果
     */
    public int updateDInfluenceInfo(DInfluenceInfo dInfluenceInfo);

    /**
     * 批量删除影响力统计
     * 
     * @param ids 需要删除的影响力统计主键集合
     * @return 结果
     */
    public int deleteDInfluenceInfoByIds(Long[] ids);

    /**
     * 删除影响力统计信息
     * 
     * @param id 影响力统计主键
     * @return 结果
     */
    public int deleteDInfluenceInfoById(Long id);

    List<DInfluenceInfo> getDays(String type);

    List<DInfluenceInfo> getNames();
}
