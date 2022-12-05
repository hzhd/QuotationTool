package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.ZStadiumClassroom;

/**
 * 教室管理Service接口
 * 
 * @author zhoujie
 * @date 2022-11-28
 */
public interface IZStadiumClassroomService 
{
    /**
     * 查询教室管理
     * 
     * @param classroomId 教室管理主键
     * @return 教室管理
     */
    public ZStadiumClassroom selectZStadiumClassroomByClassroomId(Long classroomId);

    /**
     * 查询教室管理列表
     * 
     * @param zStadiumClassroom 教室管理
     * @return 教室管理集合
     */
    public List<ZStadiumClassroom> selectZStadiumClassroomList(ZStadiumClassroom zStadiumClassroom);

    /**
     * 新增教室管理
     * 
     * @param zStadiumClassroom 教室管理
     * @return 结果
     */
    public int insertZStadiumClassroom(ZStadiumClassroom zStadiumClassroom);

    /**
     * 修改教室管理
     * 
     * @param zStadiumClassroom 教室管理
     * @return 结果
     */
    public int updateZStadiumClassroom(ZStadiumClassroom zStadiumClassroom);

    /**
     * 批量删除教室管理
     * 
     * @param classroomIds 需要删除的教室管理主键集合
     * @return 结果
     */
    public int deleteZStadiumClassroomByClassroomIds(Long[] classroomIds);

    /**
     * 删除教室管理信息
     * 
     * @param classroomId 教室管理主键
     * @return 结果
     */
    public int deleteZStadiumClassroomByClassroomId(Long classroomId);
}
