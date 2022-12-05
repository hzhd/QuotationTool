package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.BCultureInfo;

/**
 * 文化咨询库Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-25
 */
public interface BCultureInfoMapper 
{
    /**
     * 查询文化咨询库
     * 
     * @param id 文化咨询库主键
     * @return 文化咨询库
     */
    public BCultureInfo selectBCultureInfoById(Long id);

    /**
     * 查询文化咨询库列表
     * 
     * @param bCultureInfo 文化咨询库
     * @return 文化咨询库集合
     */
    public List<BCultureInfo> selectBCultureInfoList(BCultureInfo bCultureInfo);

    /**
     * 新增文化咨询库
     * 
     * @param bCultureInfo 文化咨询库
     * @return 结果
     */
    public int insertBCultureInfo(BCultureInfo bCultureInfo);

    /**
     * 修改文化咨询库
     * 
     * @param bCultureInfo 文化咨询库
     * @return 结果
     */
    public int updateBCultureInfo(BCultureInfo bCultureInfo);

    /**
     * 删除文化咨询库
     * 
     * @param id 文化咨询库主键
     * @return 结果
     */
    public int deleteBCultureInfoById(Long id);

    /**
     * 批量删除文化咨询库
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteBCultureInfoByIds(Long[] ids);
}
