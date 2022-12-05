package com.ruoyi.web.controller.screenSet;

import com.ruoyi.business.domain.BIchInfo;
import com.ruoyi.business.domain.BMoocCourse;
import com.ruoyi.business.service.IBIchInfoService;
import com.ruoyi.business.service.IBMoocCourseService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.screenSet.domain.DHeritageComment;
import com.ruoyi.screenSet.service.IDHeritageCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 慕课信息大屏设置Controller
 * 
 * @author huzd
 * @date 2022-09-21
 */
@RestController
@RequestMapping("/screenSet/course")
public class CourseSetController extends BaseController
{
    @Autowired
    private IBMoocCourseService ibMoocCourseService;

    /**
     * 慕课信息配置
     * @author huzd
     * @date 2022-09-21 14:59
     * @param bMoocCourse
     * @return com.ruoyi.common.core.page.TableDataInfo
     */
    @GetMapping("/listCourse")
    public AjaxResult listCourse(BMoocCourse bMoocCourse){
        List<BMoocCourse> list = ibMoocCourseService.selectBMoocCourseAllList(bMoocCourse);
        return AjaxResult.success(list);
    }

}
