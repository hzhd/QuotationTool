package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BCultureInfoMapper;
import com.ruoyi.business.domain.BCultureInfo;
import com.ruoyi.business.service.IBCultureInfoService;

/**
 * 文化咨询库Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-25
 */
@Service
public class BCultureInfoServiceImpl implements IBCultureInfoService 
{
    @Autowired
    private BCultureInfoMapper bCultureInfoMapper;

    /**
     * 查询文化咨询库
     * 
     * @param id 文化咨询库主键
     * @return 文化咨询库
     */
    @Override
    public BCultureInfo selectBCultureInfoById(Long id)
    {
        return bCultureInfoMapper.selectBCultureInfoById(id);
    }

    /**
     * 查询文化咨询库列表
     * 
     * @param bCultureInfo 文化咨询库
     * @return 文化咨询库
     */
    @Override
    public List<BCultureInfo> selectBCultureInfoList(BCultureInfo bCultureInfo)
    {
        return bCultureInfoMapper.selectBCultureInfoList(bCultureInfo);
    }

    /**
     * 新增文化咨询库
     * 
     * @param bCultureInfo 文化咨询库
     * @return 结果
     */
    @Override
    public int insertBCultureInfo(BCultureInfo bCultureInfo)
    {
        bCultureInfo.setCreateTime(DateUtils.getNowDate());
        return bCultureInfoMapper.insertBCultureInfo(bCultureInfo);
    }

    /**
     * 修改文化咨询库
     * 
     * @param bCultureInfo 文化咨询库
     * @return 结果
     */
    @Override
    public int updateBCultureInfo(BCultureInfo bCultureInfo)
    {
        bCultureInfo.setUpdateTime(DateUtils.getNowDate());
        return bCultureInfoMapper.updateBCultureInfo(bCultureInfo);
    }

    /**
     * 批量删除文化咨询库
     * 
     * @param ids 需要删除的文化咨询库主键
     * @return 结果
     */
    @Override
    public int deleteBCultureInfoByIds(Long[] ids)
    {
        return bCultureInfoMapper.deleteBCultureInfoByIds(ids);
    }

    /**
     * 删除文化咨询库信息
     * 
     * @param id 文化咨询库主键
     * @return 结果
     */
    @Override
    public int deleteBCultureInfoById(Long id)
    {
        return bCultureInfoMapper.deleteBCultureInfoById(id);
    }
}
