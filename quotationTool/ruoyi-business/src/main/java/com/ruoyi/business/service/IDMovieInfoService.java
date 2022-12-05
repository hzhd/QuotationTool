package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.DMovieInfo;

/**
 * 电影统计Service接口
 * 
 * @author ruoyi
 * @date 2022-11-25
 */
public interface IDMovieInfoService 
{
    /**
     * 查询电影统计
     * 
     * @param id 电影统计主键
     * @return 电影统计
     */
    public DMovieInfo selectDMovieInfoById(Long id);

    /**
     * 查询电影统计列表
     * 
     * @param dMovieInfo 电影统计
     * @return 电影统计集合
     */
    public List<DMovieInfo> selectDMovieInfoList(DMovieInfo dMovieInfo);

    /**
     * 新增电影统计
     * 
     * @param dMovieInfo 电影统计
     * @return 结果
     */
    public int insertDMovieInfo(DMovieInfo dMovieInfo);

    /**
     * 修改电影统计
     * 
     * @param dMovieInfo 电影统计
     * @return 结果
     */
    public int updateDMovieInfo(DMovieInfo dMovieInfo);

    /**
     * 批量删除电影统计
     * 
     * @param ids 需要删除的电影统计主键集合
     * @return 结果
     */
    public int deleteDMovieInfoByIds(Long[] ids);

    /**
     * 删除电影统计信息
     * 
     * @param id 电影统计主键
     * @return 结果
     */
    public int deleteDMovieInfoById(Long id);
}
