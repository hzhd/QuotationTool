package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.DSubscribePeople;

/**
 * 场馆预约人数Mapper接口
 * 
 * @author ruoyi
 * @date 2022-09-22
 */
public interface DSubscribePeopleMapper 
{
    /**
     * 查询场馆预约人数
     * 
     * @param id 场馆预约人数主键
     * @return 场馆预约人数
     */
    public DSubscribePeople selectDSubscribePeopleById(Long id);

    /**
     * 查询场馆预约人数列表
     * 
     * @param dSubscribePeople 场馆预约人数
     * @return 场馆预约人数集合
     */
    public List<DSubscribePeople> selectDSubscribePeopleList(DSubscribePeople dSubscribePeople);

    /**
     * 新增场馆预约人数
     * 
     * @param dSubscribePeople 场馆预约人数
     * @return 结果
     */
    public int insertDSubscribePeople(DSubscribePeople dSubscribePeople);

    /**
     * 修改场馆预约人数
     * 
     * @param dSubscribePeople 场馆预约人数
     * @return 结果
     */
    public int updateDSubscribePeople(DSubscribePeople dSubscribePeople);

    /**
     * 删除场馆预约人数
     * 
     * @param id 场馆预约人数主键
     * @return 结果
     */
    public int deleteDSubscribePeopleById(Long id);

    /**
     * 批量删除场馆预约人数
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDSubscribePeopleByIds(Long[] ids);

    List<DSubscribePeople> selectAll();
}
