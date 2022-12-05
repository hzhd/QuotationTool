package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.DMovieInfoMapper;
import com.ruoyi.business.domain.DMovieInfo;
import com.ruoyi.business.service.IDMovieInfoService;

/**
 * 电影统计Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-25
 */
@Service
public class DMovieInfoServiceImpl implements IDMovieInfoService 
{
    @Autowired
    private DMovieInfoMapper dMovieInfoMapper;

    /**
     * 查询电影统计
     * 
     * @param id 电影统计主键
     * @return 电影统计
     */
    @Override
    public DMovieInfo selectDMovieInfoById(Long id)
    {
        return dMovieInfoMapper.selectDMovieInfoById(id);
    }

    /**
     * 查询电影统计列表
     * 
     * @param dMovieInfo 电影统计
     * @return 电影统计
     */
    @Override
    public List<DMovieInfo> selectDMovieInfoList(DMovieInfo dMovieInfo)
    {
        return dMovieInfoMapper.selectDMovieInfoList(dMovieInfo);
    }

    /**
     * 新增电影统计
     * 
     * @param dMovieInfo 电影统计
     * @return 结果
     */
    @Override
    public int insertDMovieInfo(DMovieInfo dMovieInfo)
    {
        dMovieInfo.setCreateTime(DateUtils.getNowDate());
        return dMovieInfoMapper.insertDMovieInfo(dMovieInfo);
    }

    /**
     * 修改电影统计
     * 
     * @param dMovieInfo 电影统计
     * @return 结果
     */
    @Override
    public int updateDMovieInfo(DMovieInfo dMovieInfo)
    {
        dMovieInfo.setUpdateTime(DateUtils.getNowDate());
        return dMovieInfoMapper.updateDMovieInfo(dMovieInfo);
    }

    /**
     * 批量删除电影统计
     * 
     * @param ids 需要删除的电影统计主键
     * @return 结果
     */
    @Override
    public int deleteDMovieInfoByIds(Long[] ids)
    {
        return dMovieInfoMapper.deleteDMovieInfoByIds(ids);
    }

    /**
     * 删除电影统计信息
     * 
     * @param id 电影统计主键
     * @return 结果
     */
    @Override
    public int deleteDMovieInfoById(Long id)
    {
        return dMovieInfoMapper.deleteDMovieInfoById(id);
    }
}
