package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.ZRecordClassify;

/**
 * 档案分类Mapper接口
 * 
 * @author zhoujie
 * @date 2022-11-28
 */
public interface ZRecordClassifyMapper 
{
    /**
     * 查询档案分类
     * 
     * @param recordId 档案分类主键
     * @return 档案分类
     */
    public ZRecordClassify selectZRecordClassifyByRecordId(Long recordId);

    /**
     * 查询档案分类列表
     * 
     * @param zRecordClassify 档案分类
     * @return 档案分类集合
     */
    public List<ZRecordClassify> selectZRecordClassifyList(ZRecordClassify zRecordClassify);

    /**
     * 新增档案分类
     * 
     * @param zRecordClassify 档案分类
     * @return 结果
     */
    public int insertZRecordClassify(ZRecordClassify zRecordClassify);

    /**
     * 修改档案分类
     * 
     * @param zRecordClassify 档案分类
     * @return 结果
     */
    public int updateZRecordClassify(ZRecordClassify zRecordClassify);

    /**
     * 删除档案分类
     * 
     * @param recordId 档案分类主键
     * @return 结果
     */
    public int deleteZRecordClassifyByRecordId(Long recordId);

    /**
     * 批量删除档案分类
     * 
     * @param recordIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteZRecordClassifyByRecordIds(Long[] recordIds);
}
