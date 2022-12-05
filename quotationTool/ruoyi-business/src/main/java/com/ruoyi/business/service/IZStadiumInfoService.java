package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.ZStadiumInfo;

/**
 * 场馆信息Service接口
 * 
 * @author zhoujie
 * @date 2022-11-28
 */
public interface IZStadiumInfoService 
{
    /**
     * 查询场馆信息
     * 
     * @param stadiumId 场馆信息主键
     * @return 场馆信息
     */
    public ZStadiumInfo selectZStadiumInfoByStadiumId(Long stadiumId);

    /**
     * 查询场馆信息列表
     * 
     * @param zStadiumInfo 场馆信息
     * @return 场馆信息集合
     */
    public List<ZStadiumInfo> selectZStadiumInfoList(ZStadiumInfo zStadiumInfo);

    /**
     * 新增场馆信息
     * 
     * @param zStadiumInfo 场馆信息
     * @return 结果
     */
    public int insertZStadiumInfo(ZStadiumInfo zStadiumInfo);

    /**
     * 修改场馆信息
     * 
     * @param zStadiumInfo 场馆信息
     * @return 结果
     */
    public int updateZStadiumInfo(ZStadiumInfo zStadiumInfo);

    /**
     * 批量删除场馆信息
     * 
     * @param stadiumIds 需要删除的场馆信息主键集合
     * @return 结果
     */
    public int deleteZStadiumInfoByStadiumIds(Long[] stadiumIds);

    /**
     * 删除场馆信息信息
     * 
     * @param stadiumId 场馆信息主键
     * @return 结果
     */
    public int deleteZStadiumInfoByStadiumId(Long stadiumId);
}
