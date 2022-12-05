package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.DSubscribePeople;

/**
 * 场馆预约人数Service接口
 * 
 * @author ruoyi
 * @date 2022-09-22
 */
public interface IDSubscribePeopleService 
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
     * 批量删除场馆预约人数
     * 
     * @param ids 需要删除的场馆预约人数主键集合
     * @return 结果
     */
    public int deleteDSubscribePeopleByIds(Long[] ids);

    /**
     * 删除场馆预约人数信息
     * 
     * @param id 场馆预约人数主键
     * @return 结果
     */
    public int deleteDSubscribePeopleById(Long id);

    List<DSubscribePeople> selectAll(DSubscribePeople dSubscribePeople);
}
