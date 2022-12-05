package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BMoocCourseMapper;
import com.ruoyi.business.domain.BMoocCourse;
import com.ruoyi.business.service.IBMoocCourseService;

/**
 * 慕课库数据维护Service业务层处理
 * 
 * @author huzd
 * @date 2022-09-20
 */
@Service
public class BMoocCourseServiceImpl implements IBMoocCourseService 
{
    @Autowired
    private BMoocCourseMapper bMoocCourseMapper;

    /**
     * 查询慕课库数据维护
     * 
     * @param id 慕课库数据维护主键
     * @return 慕课库数据维护
     */
    @Override
    public BMoocCourse selectBMoocCourseById(Long id)
    {
        return bMoocCourseMapper.selectBMoocCourseById(id);
    }

    /**
     * 查询慕课库数据维护列表
     * 
     * @param bMoocCourse 慕课库数据维护
     * @return 慕课库数据维护
     */
    @Override
    public List<BMoocCourse> selectBMoocCourseList(BMoocCourse bMoocCourse)
    {
        return bMoocCourseMapper.selectBMoocCourseList(bMoocCourse);
    }

    /**
     * 查询慕课库数据维护列表
     *
     * @param bMoocCourse 慕课库数据维护
     * @return 慕课库数据维护
     */
    @Override
    public List<BMoocCourse> selectBMoocCourseAllList(BMoocCourse bMoocCourse)
    {
        return bMoocCourseMapper.selectBMoocCourseList(bMoocCourse);
    }

    /**
     * 新增慕课库数据维护
     * 
     * @param bMoocCourse 慕课库数据维护
     * @return 结果
     */
    @Override
    public int insertBMoocCourse(BMoocCourse bMoocCourse)
    {
        bMoocCourse.setCreateTime(DateUtils.getNowDate());
        return bMoocCourseMapper.insertBMoocCourse(bMoocCourse);
    }

    /**
     * 修改慕课库数据维护
     * 
     * @param bMoocCourse 慕课库数据维护
     * @return 结果
     */
    @Override
    public int updateBMoocCourse(BMoocCourse bMoocCourse)
    {
        bMoocCourse.setUpdateTime(DateUtils.getNowDate());
        return bMoocCourseMapper.updateBMoocCourse(bMoocCourse);
    }

    /**
     * 批量删除慕课库数据维护
     * 
     * @param ids 需要删除的慕课库数据维护主键
     * @return 结果
     */
    @Override
    public int deleteBMoocCourseByIds(Long[] ids)
    {
        return bMoocCourseMapper.deleteBMoocCourseByIds(ids);
    }

    /**
     * 删除慕课库数据维护信息
     * 
     * @param id 慕课库数据维护主键
     * @return 结果
     */
    @Override
    public int deleteBMoocCourseById(Long id)
    {
        return bMoocCourseMapper.deleteBMoocCourseById(id);
    }
}
