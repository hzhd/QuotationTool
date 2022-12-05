package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BIchInfoMapper;
import com.ruoyi.business.domain.BIchInfo;
import com.ruoyi.business.service.IBIchInfoService;

/**
 * 非遗库数据维护Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-20
 */
@Service
public class BIchInfoServiceImpl implements IBIchInfoService 
{
    @Autowired
    private BIchInfoMapper bIchInfoMapper;

    /**
     * 查询非遗库数据维护
     * 
     * @param ichId 非遗库数据维护主键
     * @return 非遗库数据维护
     */
    @Override
    public BIchInfo selectBIchInfoByIchId(Integer ichId)
    {
        return bIchInfoMapper.selectBIchInfoByIchId(ichId);
    }

    /**
     * 查询非遗库数据维护列表
     * 
     * @param bIchInfo 非遗库数据维护
     * @return 非遗库数据维护
     */
    @Override
    public List<BIchInfo> selectBIchInfoList(BIchInfo bIchInfo)
    {
        return bIchInfoMapper.selectBIchInfoList(bIchInfo);
    }

    /**
     * 查询非遗库数据维护列表
     *
     * @param bIchInfo 非遗库数据维护
     * @return 非遗库数据维护
     */
    @Override
    public List<BIchInfo> selectBIchInfoAllList(BIchInfo bIchInfo)
    {
        return bIchInfoMapper.selectBIchInfoList(bIchInfo);
    }

    /**
     * 新增非遗库数据维护
     * 
     * @param bIchInfo 非遗库数据维护
     * @return 结果
     */
    @Override
    public int insertBIchInfo(BIchInfo bIchInfo)
    {
        bIchInfo.setCreateTime(DateUtils.getNowDate());
        return bIchInfoMapper.insertBIchInfo(bIchInfo);
    }

    /**
     * 修改非遗库数据维护
     * 
     * @param bIchInfo 非遗库数据维护
     * @return 结果
     */
    @Override
    public int updateBIchInfo(BIchInfo bIchInfo)
    {
        return bIchInfoMapper.updateBIchInfo(bIchInfo);
    }

    /**
     * 批量删除非遗库数据维护
     * 
     * @param ichIds 需要删除的非遗库数据维护主键
     * @return 结果
     */
    @Override
    public int deleteBIchInfoByIchIds(Integer[] ichIds)
    {
        return bIchInfoMapper.deleteBIchInfoByIchIds(ichIds);
    }

    /**
     * 删除非遗库数据维护信息
     * 
     * @param ichId 非遗库数据维护主键
     * @return 结果
     */
    @Override
    public int deleteBIchInfoByIchId(Integer ichId)
    {
        return bIchInfoMapper.deleteBIchInfoByIchId(ichId);
    }
}
