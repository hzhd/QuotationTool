package com.ruoyi.business.stadium.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.stadium.mapper.StadiumMapper;
import com.ruoyi.business.stadium.domain.Stadium;
import com.ruoyi.business.stadium.service.IStadiumService;

/**
 * 场馆基本信息Service业务层处理
 * 
 * @author zhouyz
 * @date 2022-11-27
 */
@Service
public class StadiumServiceImpl implements IStadiumService 
{
    @Autowired
    private StadiumMapper stadiumMapper;

    /**
     * 查询场馆基本信息
     * 
     * @param id 场馆基本信息主键
     * @return 场馆基本信息
     */
    @Override
    public Stadium selectStadiumById(Long id)
    {
        return stadiumMapper.selectStadiumById(id);
    }

    /**
     * 查询场馆基本信息列表
     * 
     * @param stadium 场馆基本信息
     * @return 场馆基本信息
     */
    @Override
    public List<Stadium> selectStadiumList(Stadium stadium)
    {
        return stadiumMapper.selectStadiumList(stadium);
    }

    /**
     * 新增场馆基本信息
     * 
     * @param stadium 场馆基本信息
     * @return 结果
     */
    @Override
    public int insertStadium(Stadium stadium)
    {
        stadium.setCreateTime(DateUtils.getNowDate());
        return stadiumMapper.insertStadium(stadium);
    }

    /**
     * 修改场馆基本信息
     * 
     * @param stadium 场馆基本信息
     * @return 结果
     */
    @Override
    public int updateStadium(Stadium stadium)
    {
        stadium.setUpdateTime(DateUtils.getNowDate());
        return stadiumMapper.updateStadium(stadium);
    }

    /**
     * 批量删除场馆基本信息
     * 
     * @param ids 需要删除的场馆基本信息主键
     * @return 结果
     */
    @Override
    public int deleteStadiumByIds(Long[] ids)
    {
        return stadiumMapper.deleteStadiumByIds(ids);
    }

    /**
     * 删除场馆基本信息信息
     * 
     * @param id 场馆基本信息主键
     * @return 结果
     */
    @Override
    public int deleteStadiumById(Long id)
    {
        return stadiumMapper.deleteStadiumById(id);
    }
}
