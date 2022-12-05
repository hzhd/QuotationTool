package com.ruoyi.business.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.DPassengerInfoMapper;
import com.ruoyi.business.domain.DPassengerInfo;
import com.ruoyi.business.service.IDPassengerInfoService;

/**
 * 客流统计Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-21
 */
@Service
public class DPassengerInfoServiceImpl implements IDPassengerInfoService 
{
    @Autowired
    private DPassengerInfoMapper dPassengerInfoMapper;

    /**
     * 查询客流统计
     * 
     * @param id 客流统计主键
     * @return 客流统计
     */
    @Override
    public DPassengerInfo selectDPassengerInfoById(Long id)
    {
        return dPassengerInfoMapper.selectDPassengerInfoById(id);
    }

    /**
     * 查询客流统计列表
     * 
     * @param dPassengerInfo 客流统计
     * @return 客流统计
     */
    @Override
    public List<DPassengerInfo> selectDPassengerInfoList(DPassengerInfo dPassengerInfo)
    {
        return dPassengerInfoMapper.selectDPassengerInfoList(dPassengerInfo);
    }

    /**
     * 新增客流统计
     * 
     * @param dPassengerInfo 客流统计
     * @return 结果
     */
    @Override
    public int insertDPassengerInfo(DPassengerInfo dPassengerInfo)
    {
        return dPassengerInfoMapper.insertDPassengerInfo(dPassengerInfo);
    }

    /**
     * 修改客流统计
     * 
     * @param dPassengerInfo 客流统计
     * @return 结果
     */
    @Override
    public int updateDPassengerInfo(DPassengerInfo dPassengerInfo)
    {
        return dPassengerInfoMapper.updateDPassengerInfo(dPassengerInfo);
    }

    /**
     * 批量删除客流统计
     * 
     * @param ids 需要删除的客流统计主键
     * @return 结果
     */
    @Override
    public int deleteDPassengerInfoByIds(Long[] ids)
    {
        return dPassengerInfoMapper.deleteDPassengerInfoByIds(ids);
    }

    /**
     * 删除客流统计信息
     * 
     * @param id 客流统计主键
     * @return 结果
     */
    @Override
    public int deleteDPassengerInfoById(Long id)
    {
        return dPassengerInfoMapper.deleteDPassengerInfoById(id);
    }


    /**
     * 查询总客流
     * @author: liu
     * @date: 2022/9/21
     */
    @Override
    public List<DPassengerInfo> nums() {
        List<DPassengerInfo> list = dPassengerInfoMapper.nums();
        return list;
    }
}
