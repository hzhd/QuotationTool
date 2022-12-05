package com.ruoyi.screenSet.service;

import java.util.List;
import com.ruoyi.screenSet.domain.DSetVisitor;

/**
 * 游客大屏配置Service接口
 * 
 * @author huzd
 * @date 2022-09-23
 */
public interface IDSetVisitorService 
{
    /**
     * 查询游客大屏配置
     * 
     * @param id 游客大屏配置主键
     * @return 游客大屏配置
     */
    public DSetVisitor selectDSetVisitorById(Long id);

    /**
     * 查询游客大屏配置列表
     * 
     * @param dSetVisitor 游客大屏配置
     * @return 游客大屏配置集合
     */
    public List<DSetVisitor> selectDSetVisitorList(DSetVisitor dSetVisitor);

    /**
     * 新增游客大屏配置
     * 
     * @param dSetVisitor 游客大屏配置
     * @return 结果
     */
    public int insertDSetVisitor(DSetVisitor dSetVisitor);

    /**
     * 修改游客大屏配置
     * 
     * @param dSetVisitor 游客大屏配置
     * @return 结果
     */
    public int updateDSetVisitor(DSetVisitor dSetVisitor);

    /**
     * 批量删除游客大屏配置
     * 
     * @param ids 需要删除的游客大屏配置主键集合
     * @return 结果
     */
    public int deleteDSetVisitorByIds(Long[] ids);

    /**
     * 删除游客大屏配置信息
     * 
     * @param id 游客大屏配置主键
     * @return 结果
     */
    public int deleteDSetVisitorById(Long id);
}
