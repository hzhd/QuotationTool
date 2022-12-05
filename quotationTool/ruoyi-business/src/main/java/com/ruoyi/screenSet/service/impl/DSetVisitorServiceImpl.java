package com.ruoyi.screenSet.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.screenSet.mapper.DSetVisitorMapper;
import com.ruoyi.screenSet.domain.DSetVisitor;
import com.ruoyi.screenSet.service.IDSetVisitorService;

/**
 * 游客大屏配置Service业务层处理
 * 
 * @author huzd
 * @date 2022-09-23
 */
@Service
public class DSetVisitorServiceImpl implements IDSetVisitorService 
{
    @Autowired
    private DSetVisitorMapper dSetVisitorMapper;

    /**
     * 查询游客大屏配置
     * 
     * @param id 游客大屏配置主键
     * @return 游客大屏配置
     */
    @Override
    public DSetVisitor selectDSetVisitorById(Long id)
    {
        return dSetVisitorMapper.selectDSetVisitorById(id);
    }

    /**
     * 查询游客大屏配置列表
     * 
     * @param dSetVisitor 游客大屏配置
     * @return 游客大屏配置
     */
    @Override
    public List<DSetVisitor> selectDSetVisitorList(DSetVisitor dSetVisitor)
    {
        return dSetVisitorMapper.selectDSetVisitorList(dSetVisitor);
    }

    /**
     * 新增游客大屏配置
     * 
     * @param dSetVisitor 游客大屏配置
     * @return 结果
     */
    @Override
    public int insertDSetVisitor(DSetVisitor dSetVisitor)
    {
        return dSetVisitorMapper.insertDSetVisitor(dSetVisitor);
    }

    /**
     * 修改游客大屏配置
     * 
     * @param dSetVisitor 游客大屏配置
     * @return 结果
     */
    @Override
    public int updateDSetVisitor(DSetVisitor dSetVisitor)
    {
        return dSetVisitorMapper.updateDSetVisitor(dSetVisitor);
    }

    /**
     * 批量删除游客大屏配置
     * 
     * @param ids 需要删除的游客大屏配置主键
     * @return 结果
     */
    @Override
    public int deleteDSetVisitorByIds(Long[] ids)
    {
        return dSetVisitorMapper.deleteDSetVisitorByIds(ids);
    }

    /**
     * 删除游客大屏配置信息
     * 
     * @param id 游客大屏配置主键
     * @return 结果
     */
    @Override
    public int deleteDSetVisitorById(Long id)
    {
        return dSetVisitorMapper.deleteDSetVisitorById(id);
    }
}
