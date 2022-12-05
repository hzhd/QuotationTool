package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.ZStadiumInfo;

/**
 * 场馆信息Mapper接口
 * 
 * @author zhoujie
 * @date 2022-11-28
 */
public interface ZStadiumInfoMapper 
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
     * 删除场馆信息
     * 
     * @param stadiumId 场馆信息主键
     * @return 结果
     */
    public int deleteZStadiumInfoByStadiumId(Long stadiumId);

    /**
     * 批量删除场馆信息
     * 
     * @param stadiumIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteZStadiumInfoByStadiumIds(Long[] stadiumIds);
}
