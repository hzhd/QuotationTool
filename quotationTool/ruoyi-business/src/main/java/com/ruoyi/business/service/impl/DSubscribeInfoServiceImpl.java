package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.DSubscribeInfoMapper;
import com.ruoyi.business.domain.DSubscribeInfo;
import com.ruoyi.business.service.IDSubscribeInfoService;

/**
 * 预约统计Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-21
 */
@Service
public class DSubscribeInfoServiceImpl implements IDSubscribeInfoService 
{
    @Autowired
    private DSubscribeInfoMapper dSubscribeInfoMapper;

    /**
     * 查询预约统计
     * 
     * @param id 预约统计主键
     * @return 预约统计
     */
    @Override
    public DSubscribeInfo selectDSubscribeInfoById(Long id)
    {
        return dSubscribeInfoMapper.selectDSubscribeInfoById(id);
    }

    /**
     * 查询预约统计列表
     * 
     * @param dSubscribeInfo 预约统计
     * @return 预约统计
     */
    @Override
    public List<DSubscribeInfo> selectDSubscribeInfoList(DSubscribeInfo dSubscribeInfo)
    {
        return dSubscribeInfoMapper.selectDSubscribeInfoList(dSubscribeInfo);
    }

    /**
     * 新增预约统计
     * 
     * @param dSubscribeInfo 预约统计
     * @return 结果
     */
    @Override
    public int insertDSubscribeInfo(DSubscribeInfo dSubscribeInfo)
    {
        dSubscribeInfo.setCreateTime(DateUtils.getNowDate());
        return dSubscribeInfoMapper.insertDSubscribeInfo(dSubscribeInfo);
    }

    /**
     * 修改预约统计
     * 
     * @param dSubscribeInfo 预约统计
     * @return 结果
     */
    @Override
    public int updateDSubscribeInfo(DSubscribeInfo dSubscribeInfo)
    {
        return dSubscribeInfoMapper.updateDSubscribeInfo(dSubscribeInfo);
    }

    /**
     * 批量删除预约统计
     * 
     * @param ids 需要删除的预约统计主键
     * @return 结果
     */
    @Override
    public int deleteDSubscribeInfoByIds(Long[] ids)
    {
        return dSubscribeInfoMapper.deleteDSubscribeInfoByIds(ids);
    }

    /**
     * 删除预约统计信息
     * 
     * @param id 预约统计主键
     * @return 结果
     */
    @Override
    public int deleteDSubscribeInfoById(Long id)
    {
        return dSubscribeInfoMapper.deleteDSubscribeInfoById(id);
    }

    /**
     * 查询所有分管名称
     * @author: liu
     * @date: 2022/9/22
     */
    @Override
    public List<String> names() {
        return dSubscribeInfoMapper.selectNames();
    }

    @Override
    public List<DSubscribeInfo> selectorderby() {
        return dSubscribeInfoMapper.selectorderby();
    }
}
