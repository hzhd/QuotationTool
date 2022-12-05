package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BActivityInfoMapper;
import com.ruoyi.business.domain.BActivityInfo;
import com.ruoyi.business.service.IBActivityInfoService;

/**
 * 活动库数据Service业务层处理
 *
 * @author ruoyi
 * @date 2022-11-25
 */
@Service
public class BActivityInfoServiceImpl implements IBActivityInfoService
{
    @Autowired
    private BActivityInfoMapper bActivityInfoMapper;

    /**
     * 查询活动库数据
     *
     * @param activityId 活动库数据主键
     * @return 活动库数据
     */
    @Override
    public BActivityInfo selectBActivityInfoByActivityId(Long activityId)
    {
        return bActivityInfoMapper.selectBActivityInfoByActivityId(activityId);
    }

    /**
     * 查询活动库数据列表
     *
     * @param bActivityInfo 活动库数据
     * @return 活动库数据
     */
    @Override
    public List<BActivityInfo> selectBActivityInfoList(BActivityInfo bActivityInfo)
    {
        return bActivityInfoMapper.selectBActivityInfoList(bActivityInfo);
    }

    /**
     * 新增活动库数据
     *
     * @param bActivityInfo 活动库数据
     * @return 结果
     */
    @Override
    public int insertBActivityInfo(BActivityInfo bActivityInfo)
    {
        bActivityInfo.setCreateTime(DateUtils.getNowDate());
        return bActivityInfoMapper.insertBActivityInfo(bActivityInfo);
    }

    /**
     * 修改活动库数据
     *
     * @param bActivityInfo 活动库数据
     * @return 结果
     */
    @Override
    public int updateBActivityInfo(BActivityInfo bActivityInfo)
    {
        return bActivityInfoMapper.updateBActivityInfo(bActivityInfo);
    }

    /**
     * 批量删除活动库数据
     *
     * @param activityIds 需要删除的活动库数据主键
     * @return 结果
     */
    @Override
    public int deleteBActivityInfoByActivityIds(Long[] activityIds)
    {
        return bActivityInfoMapper.deleteBActivityInfoByActivityIds(activityIds);
    }

    /**
     * 删除活动库数据信息
     *
     * @param activityId 活动库数据主键
     * @return 结果
     */
    @Override
    public int deleteBActivityInfoByActivityId(Long activityId)
    {
        return bActivityInfoMapper.deleteBActivityInfoByActivityId(activityId);
    }


    @Override
    public List<BActivityInfo> selectNums() {
        return bActivityInfoMapper.selectNums();
    }

    @Override
    public List<String> actType() {
        return bActivityInfoMapper.actType();
    }
}
