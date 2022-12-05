package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.BMoocCourse;

/**
 * 慕课库数据维护Service接口
 * 
 * @author huzd
 * @date 2022-09-20
 */
public interface IBMoocCourseService 
{
    /**
     * 查询慕课库数据维护
     * 
     * @param id 慕课库数据维护主键
     * @return 慕课库数据维护
     */
    public BMoocCourse selectBMoocCourseById(Long id);

    /**
     * 查询慕课库数据维护列表
     * 
     * @param bMoocCourse 慕课库数据维护
     * @return 慕课库数据维护集合
     */
    public List<BMoocCourse> selectBMoocCourseList(BMoocCourse bMoocCourse);

    /**
     * 查询慕课库数据维护列表
     *
     * @param bMoocCourse 慕课库数据维护
     * @return 慕课库数据维护集合
     */
    public List<BMoocCourse> selectBMoocCourseAllList(BMoocCourse bMoocCourse);

    /**
     * 新增慕课库数据维护
     * 
     * @param bMoocCourse 慕课库数据维护
     * @return 结果
     */
    public int insertBMoocCourse(BMoocCourse bMoocCourse);

    /**
     * 修改慕课库数据维护
     * 
     * @param bMoocCourse 慕课库数据维护
     * @return 结果
     */
    public int updateBMoocCourse(BMoocCourse bMoocCourse);

    /**
     * 批量删除慕课库数据维护
     * 
     * @param ids 需要删除的慕课库数据维护主键集合
     * @return 结果
     */
    public int deleteBMoocCourseByIds(Long[] ids);

    /**
     * 删除慕课库数据维护信息
     * 
     * @param id 慕课库数据维护主键
     * @return 结果
     */
    public int deleteBMoocCourseById(Long id);
}
