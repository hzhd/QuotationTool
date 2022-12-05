package com.ruoyi.business.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.DInfluenceInfoMapper;
import com.ruoyi.business.domain.DInfluenceInfo;
import com.ruoyi.business.service.IDInfluenceInfoService;

/**
 * 影响力统计Service业务层处理
 * 
 * @author Liu
 * @date 2022-09-21
 */
@Service
public class DInfluenceInfoServiceImpl implements IDInfluenceInfoService 
{
    @Autowired
    private DInfluenceInfoMapper dInfluenceInfoMapper;

    /**
     * 查询影响力统计
     * 
     * @param id 影响力统计主键
     * @return 影响力统计
     */
    @Override
    public DInfluenceInfo selectDInfluenceInfoById(Long id)
    {
        return dInfluenceInfoMapper.selectDInfluenceInfoById(id);
    }

    /**
     * 查询影响力统计列表
     * 
     * @param dInfluenceInfo 影响力统计
     * @return 影响力统计
     */
    @Override
    public List<DInfluenceInfo> selectDInfluenceInfoList(DInfluenceInfo dInfluenceInfo)
    {
        return dInfluenceInfoMapper.selectDInfluenceInfoList(dInfluenceInfo);
    }

    /**
     * 新增影响力统计
     * 
     * @param dInfluenceInfo 影响力统计
     * @return 结果
     */
    @Override
    public int insertDInfluenceInfo(DInfluenceInfo dInfluenceInfo)
    {
        return dInfluenceInfoMapper.insertDInfluenceInfo(dInfluenceInfo);
    }

    /**
     * 修改影响力统计
     * 
     * @param dInfluenceInfo 影响力统计
     * @return 结果
     */
    @Override
    public int updateDInfluenceInfo(DInfluenceInfo dInfluenceInfo)
    {
        return dInfluenceInfoMapper.updateDInfluenceInfo(dInfluenceInfo);
    }

    /**
     * 批量删除影响力统计
     * 
     * @param ids 需要删除的影响力统计主键
     * @return 结果
     */
    @Override
    public int deleteDInfluenceInfoByIds(Long[] ids)
    {
        return dInfluenceInfoMapper.deleteDInfluenceInfoByIds(ids);
    }

    /**
     * 删除影响力统计信息
     * 
     * @param id 影响力统计主键
     * @return 结果
     */
    @Override
    public int deleteDInfluenceInfoById(Long id)
    {
        return dInfluenceInfoMapper.deleteDInfluenceInfoById(id);
    }

    /**
     * 获取日月周年数据
     * @author: liu
     * @date: 2022/9/21
     */
    @Override
    public List<DInfluenceInfo> getDays(String type) {
        List<DInfluenceInfo> list = new ArrayList<>();
        if("1".equals(type)){
            list = dInfluenceInfoMapper.selectDays();
        }else if("2".equals(type)){
            list = dInfluenceInfoMapper.selectWeeks();
        }else if ("3".equals(type)){
            list = dInfluenceInfoMapper.selectMonths();
        }else if("4".equals(type)){
            list = dInfluenceInfoMapper.selectYears();
        }
        return list;
    }

    /**
     * 根据影响力排序
     * @author: liu
     * @date: 2022/9/22
     */
    @Override
    public List<DInfluenceInfo> getNames() {
        return dInfluenceInfoMapper.selectNames();
    }
}
