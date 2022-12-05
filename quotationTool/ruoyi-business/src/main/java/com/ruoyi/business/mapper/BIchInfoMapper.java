package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.BIchInfo;

/**
 * 非遗库数据维护Mapper接口
 * 
 * @author ruoyi
 * @date 2022-09-20
 */
public interface BIchInfoMapper 
{
    /**
     * 查询非遗库数据维护
     * 
     * @param ichId 非遗库数据维护主键
     * @return 非遗库数据维护
     */
    public BIchInfo selectBIchInfoByIchId(Integer ichId);

    /**
     * 查询非遗库数据维护列表
     * 
     * @param bIchInfo 非遗库数据维护
     * @return 非遗库数据维护集合
     */
    public List<BIchInfo> selectBIchInfoList(BIchInfo bIchInfo);

    /**
     * 新增非遗库数据维护
     * 
     * @param bIchInfo 非遗库数据维护
     * @return 结果
     */
    public int insertBIchInfo(BIchInfo bIchInfo);

    /**
     * 修改非遗库数据维护
     * 
     * @param bIchInfo 非遗库数据维护
     * @return 结果
     */
    public int updateBIchInfo(BIchInfo bIchInfo);

    /**
     * 删除非遗库数据维护
     * 
     * @param ichId 非遗库数据维护主键
     * @return 结果
     */
    public int deleteBIchInfoByIchId(Integer ichId);

    /**
     * 批量删除非遗库数据维护
     * 
     * @param ichIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBIchInfoByIchIds(Integer[] ichIds);
}
