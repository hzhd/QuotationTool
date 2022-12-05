package com.ruoyi.business.stadium.mapper;

import java.util.List;
import com.ruoyi.business.stadium.domain.Stadium;

/**
 * 场馆基本信息Mapper接口
 * 
 * @author zhouyz
 * @date 2022-11-27
 */
public interface StadiumMapper 
{
    /**
     * 查询场馆基本信息
     * 
     * @param id 场馆基本信息主键
     * @return 场馆基本信息
     */
    public Stadium selectStadiumById(Long id);

    /**
     * 查询场馆基本信息列表
     * 
     * @param stadium 场馆基本信息
     * @return 场馆基本信息集合
     */
    public List<Stadium> selectStadiumList(Stadium stadium);

    /**
     * 新增场馆基本信息
     * 
     * @param stadium 场馆基本信息
     * @return 结果
     */
    public int insertStadium(Stadium stadium);

    /**
     * 修改场馆基本信息
     * 
     * @param stadium 场馆基本信息
     * @return 结果
     */
    public int updateStadium(Stadium stadium);

    /**
     * 删除场馆基本信息
     * 
     * @param id 场馆基本信息主键
     * @return 结果
     */
    public int deleteStadiumById(Long id);

    /**
     * 批量删除场馆基本信息
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteStadiumByIds(Long[] ids);
}
