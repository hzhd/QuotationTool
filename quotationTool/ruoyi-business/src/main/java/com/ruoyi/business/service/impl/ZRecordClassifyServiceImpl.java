package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.ZRecordClassifyMapper;
import com.ruoyi.business.domain.ZRecordClassify;
import com.ruoyi.business.service.IZRecordClassifyService;

/**
 * 档案分类Service业务层处理
 * 
 * @author zhoujie
 * @date 2022-11-28
 */
@Service
public class ZRecordClassifyServiceImpl implements IZRecordClassifyService 
{
    @Autowired
    private ZRecordClassifyMapper zRecordClassifyMapper;

    /**
     * 查询档案分类
     * 
     * @param recordId 档案分类主键
     * @return 档案分类
     */
    @Override
    public ZRecordClassify selectZRecordClassifyByRecordId(Long recordId)
    {
        return zRecordClassifyMapper.selectZRecordClassifyByRecordId(recordId);
    }

    /**
     * 查询档案分类列表
     * 
     * @param zRecordClassify 档案分类
     * @return 档案分类
     */
    @Override
    public List<ZRecordClassify> selectZRecordClassifyList(ZRecordClassify zRecordClassify)
    {
        return zRecordClassifyMapper.selectZRecordClassifyList(zRecordClassify);
    }

    /**
     * 新增档案分类
     * 
     * @param zRecordClassify 档案分类
     * @return 结果
     */
    @Override
    public int insertZRecordClassify(ZRecordClassify zRecordClassify)
    {
        zRecordClassify.setCreateTime(DateUtils.getNowDate());
        return zRecordClassifyMapper.insertZRecordClassify(zRecordClassify);
    }

    /**
     * 修改档案分类
     * 
     * @param zRecordClassify 档案分类
     * @return 结果
     */
    @Override
    public int updateZRecordClassify(ZRecordClassify zRecordClassify)
    {
        zRecordClassify.setUpdateTime(DateUtils.getNowDate());
        return zRecordClassifyMapper.updateZRecordClassify(zRecordClassify);
    }

    /**
     * 批量删除档案分类
     * 
     * @param recordIds 需要删除的档案分类主键
     * @return 结果
     */
    @Override
    public int deleteZRecordClassifyByRecordIds(Long[] recordIds)
    {
        return zRecordClassifyMapper.deleteZRecordClassifyByRecordIds(recordIds);
    }

    /**
     * 删除档案分类信息
     * 
     * @param recordId 档案分类主键
     * @return 结果
     */
    @Override
    public int deleteZRecordClassifyByRecordId(Long recordId)
    {
        return zRecordClassifyMapper.deleteZRecordClassifyByRecordId(recordId);
    }
}
