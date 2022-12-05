package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.DSubscribePeopleMapper;
import com.ruoyi.business.domain.DSubscribePeople;
import com.ruoyi.business.service.IDSubscribePeopleService;

/**
 * 场馆预约人数Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-22
 */
@Service
public class DSubscribePeopleServiceImpl implements IDSubscribePeopleService 
{
    @Autowired
    private DSubscribePeopleMapper dSubscribePeopleMapper;

    /**
     * 查询场馆预约人数
     * 
     * @param id 场馆预约人数主键
     * @return 场馆预约人数
     */
    @Override
    public DSubscribePeople selectDSubscribePeopleById(Long id)
    {
        return dSubscribePeopleMapper.selectDSubscribePeopleById(id);
    }

    /**
     * 查询场馆预约人数列表
     * 
     * @param dSubscribePeople 场馆预约人数
     * @return 场馆预约人数
     */
    @Override
    public List<DSubscribePeople> selectDSubscribePeopleList(DSubscribePeople dSubscribePeople)
    {
        return dSubscribePeopleMapper.selectDSubscribePeopleList(dSubscribePeople);
    }

    /**
     * 新增场馆预约人数
     * 
     * @param dSubscribePeople 场馆预约人数
     * @return 结果
     */
    @Override
    public int insertDSubscribePeople(DSubscribePeople dSubscribePeople)
    {
        dSubscribePeople.setCreateTime(DateUtils.getNowDate());
        return dSubscribePeopleMapper.insertDSubscribePeople(dSubscribePeople);
    }

    /**
     * 修改场馆预约人数
     * 
     * @param dSubscribePeople 场馆预约人数
     * @return 结果
     */
    @Override
    public int updateDSubscribePeople(DSubscribePeople dSubscribePeople)
    {
        return dSubscribePeopleMapper.updateDSubscribePeople(dSubscribePeople);
    }

    /**
     * 批量删除场馆预约人数
     * 
     * @param ids 需要删除的场馆预约人数主键
     * @return 结果
     */
    @Override
    public int deleteDSubscribePeopleByIds(Long[] ids)
    {
        return dSubscribePeopleMapper.deleteDSubscribePeopleByIds(ids);
    }

    /**
     * 删除场馆预约人数信息
     * 
     * @param id 场馆预约人数主键
     * @return 结果
     */
    @Override
    public int deleteDSubscribePeopleById(Long id)
    {
        return dSubscribePeopleMapper.deleteDSubscribePeopleById(id);
    }

    /**
     * 查询所有信息
     * @author: liu
     * @date: 2022/9/27
     */
    @Override
    public List<DSubscribePeople> selectAll(DSubscribePeople dSubscribePeople) {
        return dSubscribePeopleMapper.selectAll();
    }
}
