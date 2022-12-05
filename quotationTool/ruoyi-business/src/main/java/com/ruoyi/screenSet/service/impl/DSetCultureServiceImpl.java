package com.ruoyi.screenSet.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.screenSet.mapper.DSetCultureMapper;
import com.ruoyi.screenSet.domain.DSetCulture;
import com.ruoyi.screenSet.service.IDSetCultureService;

/**
 * 文化资讯配置Service业务层处理
 * 
 * @author huzd
 * @date 2022-09-24
 */
@Service
public class DSetCultureServiceImpl implements IDSetCultureService 
{
    @Autowired
    private DSetCultureMapper dSetCultureMapper;

    /**
     * 查询文化资讯配置
     * 
     * @param id 文化资讯配置主键
     * @return 文化资讯配置
     */
    @Override
    public DSetCulture selectDSetCultureById(Long id)
    {
        return dSetCultureMapper.selectDSetCultureById(id);
    }

    /**
     * 查询文化资讯配置列表
     * 
     * @param dSetCulture 文化资讯配置
     * @return 文化资讯配置
     */
    @Override
    public List<DSetCulture> selectDSetCultureList(DSetCulture dSetCulture)
    {
        return dSetCultureMapper.selectDSetCultureList(dSetCulture);
    }

    /**
     * 新增文化资讯配置
     * 
     * @param dSetCulture 文化资讯配置
     * @return 结果
     */
    @Override
    public int insertDSetCulture(DSetCulture dSetCulture)
    {
        dSetCulture.setCreateTime(DateUtils.getNowDate());
        return dSetCultureMapper.insertDSetCulture(dSetCulture);
    }

    /**
     * 修改文化资讯配置
     * 
     * @param dSetCulture 文化资讯配置
     * @return 结果
     */
    @Override
    public int updateDSetCulture(DSetCulture dSetCulture)
    {
        dSetCulture.setUpdateTime(DateUtils.getNowDate());
        return dSetCultureMapper.updateDSetCulture(dSetCulture);
    }

    /**
     * 批量删除文化资讯配置
     * 
     * @param ids 需要删除的文化资讯配置主键
     * @return 结果
     */
    @Override
    public int deleteDSetCultureByIds(Long[] ids)
    {
        return dSetCultureMapper.deleteDSetCultureByIds(ids);
    }

    /**
     * 删除文化资讯配置信息
     * 
     * @param id 文化资讯配置主键
     * @return 结果
     */
    @Override
    public int deleteDSetCultureById(Long id)
    {
        return dSetCultureMapper.deleteDSetCultureById(id);
    }
}
