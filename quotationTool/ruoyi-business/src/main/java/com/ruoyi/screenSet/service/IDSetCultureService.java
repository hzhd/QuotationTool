package com.ruoyi.screenSet.service;

import java.util.List;
import com.ruoyi.screenSet.domain.DSetCulture;

/**
 * 文化资讯配置Service接口
 * 
 * @author huzd
 * @date 2022-09-24
 */
public interface IDSetCultureService 
{
    /**
     * 查询文化资讯配置
     * 
     * @param id 文化资讯配置主键
     * @return 文化资讯配置
     */
    public DSetCulture selectDSetCultureById(Long id);

    /**
     * 查询文化资讯配置列表
     * 
     * @param dSetCulture 文化资讯配置
     * @return 文化资讯配置集合
     */
    public List<DSetCulture> selectDSetCultureList(DSetCulture dSetCulture);

    /**
     * 新增文化资讯配置
     * 
     * @param dSetCulture 文化资讯配置
     * @return 结果
     */
    public int insertDSetCulture(DSetCulture dSetCulture);

    /**
     * 修改文化资讯配置
     * 
     * @param dSetCulture 文化资讯配置
     * @return 结果
     */
    public int updateDSetCulture(DSetCulture dSetCulture);

    /**
     * 批量删除文化资讯配置
     * 
     * @param ids 需要删除的文化资讯配置主键集合
     * @return 结果
     */
    public int deleteDSetCultureByIds(Long[] ids);

    /**
     * 删除文化资讯配置信息
     * 
     * @param id 文化资讯配置主键
     * @return 结果
     */
    public int deleteDSetCultureById(Long id);
}
