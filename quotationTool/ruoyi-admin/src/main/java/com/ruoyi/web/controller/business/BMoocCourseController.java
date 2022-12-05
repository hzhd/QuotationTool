package com.ruoyi.web.controller.business;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.business.domain.BMoocCourse;
import com.ruoyi.business.service.IBMoocCourseService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 慕课库数据维护Controller
 * 
 * @author huzd
 * @date 2022-09-20
 */
@RestController
@RequestMapping("/business/course")
public class BMoocCourseController extends BaseController
{
    @Autowired
    private IBMoocCourseService bMoocCourseService;

    /**
     * 查询慕课库数据维护列表
     */
    @PreAuthorize("@ss.hasPermi('business:course:list')")
    @GetMapping("/list")
    public TableDataInfo list(BMoocCourse bMoocCourse)
    {
        startPage();
        List<BMoocCourse> list = bMoocCourseService.selectBMoocCourseList(bMoocCourse);
        return getDataTable(list);
    }

    /**
     * 导出慕课库数据维护列表
     */
    @PreAuthorize("@ss.hasPermi('business:course:export')")
    @Log(title = "慕课库数据维护", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BMoocCourse bMoocCourse)
    {
        List<BMoocCourse> list = bMoocCourseService.selectBMoocCourseList(bMoocCourse);
        ExcelUtil<BMoocCourse> util = new ExcelUtil<BMoocCourse>(BMoocCourse.class);
        util.exportExcel(response, list, "慕课库数据维护数据");
    }

    /**
     * 获取慕课库数据维护详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:course:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(bMoocCourseService.selectBMoocCourseById(id));
    }

    /**
     * 新增慕课库数据维护
     */
    @PreAuthorize("@ss.hasPermi('business:course:add')")
    @Log(title = "慕课库数据维护", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BMoocCourse bMoocCourse)
    {
        return toAjax(bMoocCourseService.insertBMoocCourse(bMoocCourse));
    }

    /**
     * 修改慕课库数据维护
     */
    @PreAuthorize("@ss.hasPermi('business:course:edit')")
    @Log(title = "慕课库数据维护", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BMoocCourse bMoocCourse)
    {
        return toAjax(bMoocCourseService.updateBMoocCourse(bMoocCourse));
    }

    /**
     * 删除慕课库数据维护
     */
    @PreAuthorize("@ss.hasPermi('business:course:remove')")
    @Log(title = "慕课库数据维护", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bMoocCourseService.deleteBMoocCourseByIds(ids));
    }
}
