package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.ZStadiumInfoMapper;
import com.ruoyi.business.domain.ZStadiumInfo;
import com.ruoyi.business.service.IZStadiumInfoService;

/**
 * 场馆信息Service业务层处理
 * 
 * @author zhoujie
 * @date 2022-11-28
 */
@Service
public class ZStadiumInfoServiceImpl implements IZStadiumInfoService 
{
    @Autowired
    private ZStadiumInfoMapper zStadiumInfoMapper;

    /**
     * 查询场馆信息
     * 
     * @param stadiumId 场馆信息主键
     * @return 场馆信息
     */
    @Override
    public ZStadiumInfo selectZStadiumInfoByStadiumId(Long stadiumId)
    {
        return zStadiumInfoMapper.selectZStadiumInfoByStadiumId(stadiumId);
    }

    /**
     * 查询场馆信息列表
     * 
     * @param zStadiumInfo 场馆信息
     * @return 场馆信息
     */
    @Override
    public List<ZStadiumInfo> selectZStadiumInfoList(ZStadiumInfo zStadiumInfo)
    {
        return zStadiumInfoMapper.selectZStadiumInfoList(zStadiumInfo);
    }

    /**
     * 新增场馆信息
     * 
     * @param zStadiumInfo 场馆信息
     * @return 结果
     */
    @Override
    public int insertZStadiumInfo(ZStadiumInfo zStadiumInfo)
    {
        zStadiumInfo.setCreateTime(DateUtils.getNowDate());
        return zStadiumInfoMapper.insertZStadiumInfo(zStadiumInfo);
    }

    /**
     * 修改场馆信息
     * 
     * @param zStadiumInfo 场馆信息
     * @return 结果
     */
    @Override
    public int updateZStadiumInfo(ZStadiumInfo zStadiumInfo)
    {
        zStadiumInfo.setUpdateTime(DateUtils.getNowDate());
        return zStadiumInfoMapper.updateZStadiumInfo(zStadiumInfo);
    }

    /**
     * 批量删除场馆信息
     * 
     * @param stadiumIds 需要删除的场馆信息主键
     * @return 结果
     */
    @Override
    public int deleteZStadiumInfoByStadiumIds(Long[] stadiumIds)
    {
        return zStadiumInfoMapper.deleteZStadiumInfoByStadiumIds(stadiumIds);
    }

    /**
     * 删除场馆信息信息
     * 
     * @param stadiumId 场馆信息主键
     * @return 结果
     */
    @Override
    public int deleteZStadiumInfoByStadiumId(Long stadiumId)
    {
        return zStadiumInfoMapper.deleteZStadiumInfoByStadiumId(stadiumId);
    }
}
