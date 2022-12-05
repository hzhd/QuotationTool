package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.ZStadiumEquipmentMapper;
import com.ruoyi.business.domain.ZStadiumEquipment;
import com.ruoyi.business.service.IZStadiumEquipmentService;

/**
 * 租赁设备Service业务层处理
 * 
 * @author zhoujie
 * @date 2022-11-28
 */
@Service
public class ZStadiumEquipmentServiceImpl implements IZStadiumEquipmentService 
{
    @Autowired
    private ZStadiumEquipmentMapper zStadiumEquipmentMapper;

    /**
     * 查询租赁设备
     * 
     * @param equipmentId 租赁设备主键
     * @return 租赁设备
     */
    @Override
    public ZStadiumEquipment selectZStadiumEquipmentByEquipmentId(Long equipmentId)
    {
        return zStadiumEquipmentMapper.selectZStadiumEquipmentByEquipmentId(equipmentId);
    }

    /**
     * 查询租赁设备列表
     * 
     * @param zStadiumEquipment 租赁设备
     * @return 租赁设备
     */
    @Override
    public List<ZStadiumEquipment> selectZStadiumEquipmentList(ZStadiumEquipment zStadiumEquipment)
    {
        return zStadiumEquipmentMapper.selectZStadiumEquipmentList(zStadiumEquipment);
    }

    /**
     * 新增租赁设备
     * 
     * @param zStadiumEquipment 租赁设备
     * @return 结果
     */
    @Override
    public int insertZStadiumEquipment(ZStadiumEquipment zStadiumEquipment)
    {
        zStadiumEquipment.setCreateTime(DateUtils.getNowDate());
        return zStadiumEquipmentMapper.insertZStadiumEquipment(zStadiumEquipment);
    }

    /**
     * 修改租赁设备
     * 
     * @param zStadiumEquipment 租赁设备
     * @return 结果
     */
    @Override
    public int updateZStadiumEquipment(ZStadiumEquipment zStadiumEquipment)
    {
        zStadiumEquipment.setUpdateTime(DateUtils.getNowDate());
        return zStadiumEquipmentMapper.updateZStadiumEquipment(zStadiumEquipment);
    }

    /**
     * 批量删除租赁设备
     * 
     * @param equipmentIds 需要删除的租赁设备主键
     * @return 结果
     */
    @Override
    public int deleteZStadiumEquipmentByEquipmentIds(Long[] equipmentIds)
    {
        return zStadiumEquipmentMapper.deleteZStadiumEquipmentByEquipmentIds(equipmentIds);
    }

    /**
     * 删除租赁设备信息
     * 
     * @param equipmentId 租赁设备主键
     * @return 结果
     */
    @Override
    public int deleteZStadiumEquipmentByEquipmentId(Long equipmentId)
    {
        return zStadiumEquipmentMapper.deleteZStadiumEquipmentByEquipmentId(equipmentId);
    }
}
