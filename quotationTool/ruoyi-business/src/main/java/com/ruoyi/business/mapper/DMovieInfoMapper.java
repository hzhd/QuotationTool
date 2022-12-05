package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.DMovieInfo;

/**
 * 电影统计Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-25
 */
public interface DMovieInfoMapper 
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
     * 删除电影统计
     * 
     * @param id 电影统计主键
     * @return 结果
     */
    public int deleteDMovieInfoById(Long id);

    /**
     * 批量删除电影统计
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDMovieInfoByIds(Long[] ids);
}
