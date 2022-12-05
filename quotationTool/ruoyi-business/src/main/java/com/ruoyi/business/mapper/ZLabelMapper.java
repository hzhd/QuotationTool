package com.ruoyi.business.mapper;

import com.ruoyi.business.domain.ZLabel;

import java.util.List;

/**
 * 标签库Mapper接口
 * 
 * @author zhoujie
 * @date 2022-11-25
 */
public interface ZLabelMapper 
{
    /**
     * 查询标签库
     * 
     * @param labelId 标签库主键
     * @return 标签库
     */
    public ZLabel selectZLabelByLabelId(Long labelId);

    /**
     * 查询标签库列表
     * 
     * @param zLabel 标签库
     * @return 标签库集合
     */
    public List<ZLabel> selectZLabelList(ZLabel zLabel);

    /**
     * 新增标签库
     * 
     * @param zLabel 标签库
     * @return 结果
     */
    public int insertZLabel(ZLabel zLabel);

    /**
     * 修改标签库
     * 
     * @param zLabel 标签库
     * @return 结果
     */
    public int updateZLabel(ZLabel zLabel);

    /**
     * 删除标签库
     * 
     * @param labelId 标签库主键
     * @return 结果
     */
    public int deleteZLabelByLabelId(Long labelId);

    /**
     * 批量删除标签库
     * 
     * @param labelIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteZLabelByLabelIds(Long[] labelIds);
}
