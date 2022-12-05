package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.DPeopleInfo;

/**
 * 进出人数统计Service接口
 * 
 * @author ruoyi
 * @date 2022-09-21
 */
public interface IDPeopleInfoService 
{
    /**
     * 查询进出人数统计
     * 
     * @param id 进出人数统计主键
     * @return 进出人数统计
     */
    public DPeopleInfo selectDPeopleInfoById(Long id);

    /**
     * 查询进出人数统计列表
     * 
     * @param dPeopleInfo 进出人数统计
     * @return 进出人数统计集合
     */
    public List<DPeopleInfo> selectDPeopleInfoList(DPeopleInfo dPeopleInfo);

    /**
     * 新增进出人数统计
     * 
     * @param dPeopleInfo 进出人数统计
     * @return 结果
     */
    public int insertDPeopleInfo(DPeopleInfo dPeopleInfo);

    /**
     * 修改进出人数统计
     * 
     * @param dPeopleInfo 进出人数统计
     * @return 结果
     */
    public int updateDPeopleInfo(DPeopleInfo dPeopleInfo);

    /**
     * 批量删除进出人数统计
     * 
     * @param ids 需要删除的进出人数统计主键集合
     * @return 结果
     */
    public int deleteDPeopleInfoByIds(Long[] ids);

    /**
     * 删除进出人数统计信息
     * 
     * @param id 进出人数统计主键
     * @return 结果
     */
    public int deleteDPeopleInfoById(Long id);

    List<DPeopleInfo> peopleNo(String type);
}
