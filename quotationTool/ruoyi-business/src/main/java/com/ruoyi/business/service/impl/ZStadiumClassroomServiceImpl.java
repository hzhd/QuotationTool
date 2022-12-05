package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.ZStadiumClassroomMapper;
import com.ruoyi.business.domain.ZStadiumClassroom;
import com.ruoyi.business.service.IZStadiumClassroomService;

/**
 * 教室管理Service业务层处理
 * 
 * @author zhoujie
 * @date 2022-11-28
 */
@Service
public class ZStadiumClassroomServiceImpl implements IZStadiumClassroomService 
{
    @Autowired
    private ZStadiumClassroomMapper zStadiumClassroomMapper;

    /**
     * 查询教室管理
     * 
     * @param classroomId 教室管理主键
     * @return 教室管理
     */
    @Override
    public ZStadiumClassroom selectZStadiumClassroomByClassroomId(Long classroomId)
    {
        return zStadiumClassroomMapper.selectZStadiumClassroomByClassroomId(classroomId);
    }

    /**
     * 查询教室管理列表
     * 
     * @param zStadiumClassroom 教室管理
     * @return 教室管理
     */
    @Override
    public List<ZStadiumClassroom> selectZStadiumClassroomList(ZStadiumClassroom zStadiumClassroom)
    {
        return zStadiumClassroomMapper.selectZStadiumClassroomList(zStadiumClassroom);
    }

    /**
     * 新增教室管理
     * 
     * @param zStadiumClassroom 教室管理
     * @return 结果
     */
    @Override
    public int insertZStadiumClassroom(ZStadiumClassroom zStadiumClassroom)
    {
        zStadiumClassroom.setCreateTime(DateUtils.getNowDate());
        return zStadiumClassroomMapper.insertZStadiumClassroom(zStadiumClassroom);
    }

    /**
     * 修改教室管理
     * 
     * @param zStadiumClassroom 教室管理
     * @return 结果
     */
    @Override
    public int updateZStadiumClassroom(ZStadiumClassroom zStadiumClassroom)
    {
        zStadiumClassroom.setUpdateTime(DateUtils.getNowDate());
        return zStadiumClassroomMapper.updateZStadiumClassroom(zStadiumClassroom);
    }

    /**
     * 批量删除教室管理
     * 
     * @param classroomIds 需要删除的教室管理主键
     * @return 结果
     */
    @Override
    public int deleteZStadiumClassroomByClassroomIds(Long[] classroomIds)
    {
        return zStadiumClassroomMapper.deleteZStadiumClassroomByClassroomIds(classroomIds);
    }

    /**
     * 删除教室管理信息
     * 
     * @param classroomId 教室管理主键
     * @return 结果
     */
    @Override
    public int deleteZStadiumClassroomByClassroomId(Long classroomId)
    {
        return zStadiumClassroomMapper.deleteZStadiumClassroomByClassroomId(classroomId);
    }
}
