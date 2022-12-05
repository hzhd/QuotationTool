package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.BActivityInfo;

/**
 * 活动库数据Service接口
 *
 * @author ruoyi
 * @date 2022-11-25
 */
public interface IBActivityInfoService
{
    /**
     * 查询活动库数据
     *
     * @param activityId 活动库数据主键
     * @return 活动库数据
     */
    public BActivityInfo selectBActivityInfoByActivityId(Long activityId);

    /**
     * 查询活动库数据列表
     *
     * @param bActivityInfo 活动库数据
     * @return 活动库数据集合
     */
    public List<BActivityInfo> selectBActivityInfoList(BActivityInfo bActivityInfo);

    /**
     * 新增活动库数据
     *
     * @param bActivityInfo 活动库数据
     * @return 结果
     */
    public int insertBActivityInfo(BActivityInfo bActivityInfo);

    /**
     * 修改活动库数据
     *
     * @param bActivityInfo 活动库数据
     * @return 结果
     */
    public int updateBActivityInfo(BActivityInfo bActivityInfo);

    /**
     * 批量删除活动库数据
     *
     * @param activityIds 需要删除的活动库数据主键集合
     * @return 结果
     */
    public int deleteBActivityInfoByActivityIds(Long[] activityIds);

    /**
     * 删除活动库数据信息
     *
     * @param activityId 活动库数据主键
     * @return 结果
     */
    public int deleteBActivityInfoByActivityId(Long activityId);

    List<BActivityInfo> selectNums();

    List<String> actType();
}
