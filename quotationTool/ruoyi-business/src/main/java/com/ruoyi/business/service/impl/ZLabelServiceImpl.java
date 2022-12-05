package com.ruoyi.business.service.impl;

import com.ruoyi.business.domain.ZLabel;
import com.ruoyi.business.mapper.ZLabelMapper;
import com.ruoyi.business.service.IZLabelService;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 标签库Service业务层处理
 * 
 * @author zhoujie
 * @date 2022-11-25
 */
@Service
public class ZLabelServiceImpl implements IZLabelService 
{
    @Autowired
    private ZLabelMapper zLabelMapper;

    /**
     * 查询标签库
     * 
     * @param labelId 标签库主键
     * @return 标签库
     */
    @Override
    public ZLabel selectZLabelByLabelId(Long labelId)
    {
        return zLabelMapper.selectZLabelByLabelId(labelId);
    }

    /**
     * 查询标签库列表
     * 
     * @param zLabel 标签库
     * @return 标签库
     */
    @Override
    public List<ZLabel> selectZLabelList(ZLabel zLabel)
    {
        return zLabelMapper.selectZLabelList(zLabel);
    }

    /**
     * 新增标签库
     * 
     * @param zLabel 标签库
     * @return 结果
     */
    @Override
    public int insertZLabel(ZLabel zLabel)
    {
        zLabel.setCreateTime(DateUtils.getNowDate());
        return zLabelMapper.insertZLabel(zLabel);
    }

    /**
     * 修改标签库
     * 
     * @param zLabel 标签库
     * @return 结果
     */
    @Override
    public int updateZLabel(ZLabel zLabel)
    {
        zLabel.setUpdateTime(DateUtils.getNowDate());
        return zLabelMapper.updateZLabel(zLabel);
    }

    /**
     * 批量删除标签库
     * 
     * @param labelIds 需要删除的标签库主键
     * @return 结果
     */
    @Override
    public int deleteZLabelByLabelIds(Long[] labelIds)
    {
        return zLabelMapper.deleteZLabelByLabelIds(labelIds);
    }

    /**
     * 删除标签库信息
     * 
     * @param labelId 标签库主键
     * @return 结果
     */
    @Override
    public int deleteZLabelByLabelId(Long labelId)
    {
        return zLabelMapper.deleteZLabelByLabelId(labelId);
    }
}
