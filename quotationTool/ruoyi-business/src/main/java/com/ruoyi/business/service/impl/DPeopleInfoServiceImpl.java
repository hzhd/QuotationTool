package com.ruoyi.business.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.DPeopleInfoMapper;
import com.ruoyi.business.domain.DPeopleInfo;
import com.ruoyi.business.service.IDPeopleInfoService;

/**
 * 进出人数统计Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-09-21
 */
@Service
public class DPeopleInfoServiceImpl implements IDPeopleInfoService 
{
    @Autowired
    private DPeopleInfoMapper dPeopleInfoMapper;

    /**
     * 查询进出人数统计
     * 
     * @param id 进出人数统计主键
     * @return 进出人数统计
     */
    @Override
    public DPeopleInfo selectDPeopleInfoById(Long id)
    {
        return dPeopleInfoMapper.selectDPeopleInfoById(id);
    }

    /**
     * 查询进出人数统计列表
     * 
     * @param dPeopleInfo 进出人数统计
     * @return 进出人数统计
     */
    @Override
    public List<DPeopleInfo> selectDPeopleInfoList(DPeopleInfo dPeopleInfo)
    {
        return dPeopleInfoMapper.selectDPeopleInfoList(dPeopleInfo);
    }

    /**
     * 新增进出人数统计
     * 
     * @param dPeopleInfo 进出人数统计
     * @return 结果
     */
    @Override
    public int insertDPeopleInfo(DPeopleInfo dPeopleInfo)
    {
        return dPeopleInfoMapper.insertDPeopleInfo(dPeopleInfo);
    }

    /**
     * 修改进出人数统计
     * 
     * @param dPeopleInfo 进出人数统计
     * @return 结果
     */
    @Override
    public int updateDPeopleInfo(DPeopleInfo dPeopleInfo)
    {
        return dPeopleInfoMapper.updateDPeopleInfo(dPeopleInfo);
    }

    /**
     * 批量删除进出人数统计
     * 
     * @param ids 需要删除的进出人数统计主键
     * @return 结果
     */
    @Override
    public int deleteDPeopleInfoByIds(Long[] ids)
    {
        return dPeopleInfoMapper.deleteDPeopleInfoByIds(ids);
    }

    /**
     * 删除进出人数统计信息
     * 
     * @param id 进出人数统计主键
     * @return 结果
     */
    @Override
    public int deleteDPeopleInfoById(Long id)
    {
        return dPeopleInfoMapper.deleteDPeopleInfoById(id);
    }

    /**
     * 方法描述
     */
    @Override
    public List<DPeopleInfo> peopleNo(String type) {
        List<DPeopleInfo> list = new ArrayList<>();
        if("1".equals(type)){
            list = dPeopleInfoMapper.selectDays();
        }else if("2".equals(type)){
            list = dPeopleInfoMapper.selectWeeks();
        }else if ("3".equals(type)){
            list = dPeopleInfoMapper.selectMonths();
        }else if("4".equals(type)){
            list = dPeopleInfoMapper.selectYears();
        }
        return list;
    }
}
