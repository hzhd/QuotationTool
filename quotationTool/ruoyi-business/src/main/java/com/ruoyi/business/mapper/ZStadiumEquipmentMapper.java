package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.ZStadiumEquipment;

/**
 * 租赁设备Mapper接口
 * 
 * @author zhoujie
 * @date 2022-11-28
 */
public interface ZStadiumEquipmentMapper 
{
    /**
     * 查询租赁设备
     * 
     * @param equipmentId 租赁设备主键
     * @return 租赁设备
     */
    public ZStadiumEquipment selectZStadiumEquipmentByEquipmentId(Long equipmentId);

    /**
     * 查询租赁设备列表
     * 
     * @param zStadiumEquipment 租赁设备
     * @return 租赁设备集合
     */
    public List<ZStadiumEquipment> selectZStadiumEquipmentList(ZStadiumEquipment zStadiumEquipment);

    /**
     * 新增租赁设备
     * 
     * @param zStadiumEquipment 租赁设备
     * @return 结果
     */
    public int insertZStadiumEquipment(ZStadiumEquipment zStadiumEquipment);

    /**
     * 修改租赁设备
     * 
     * @param zStadiumEquipment 租赁设备
     * @return 结果
     */
    public int updateZStadiumEquipment(ZStadiumEquipment zStadiumEquipment);

    /**
     * 删除租赁设备
     * 
     * @param equipmentId 租赁设备主键
     * @return 结果
     */
    public int deleteZStadiumEquipmentByEquipmentId(Long equipmentId);

    /**
     * 批量删除租赁设备
     * 
     * @param equipmentIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteZStadiumEquipmentByEquipmentIds(Long[] equipmentIds);
}
