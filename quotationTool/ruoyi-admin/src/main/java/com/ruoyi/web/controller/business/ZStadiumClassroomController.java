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
import com.ruoyi.business.domain.ZStadiumClassroom;
import com.ruoyi.business.service.IZStadiumClassroomService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 教室管理Controller
 * 
 * @author zhoujie
 * @date 2022-11-28
 */
@RestController
@RequestMapping("/business/classroom")
public class ZStadiumClassroomController extends BaseController
{
    @Autowired
    private IZStadiumClassroomService zStadiumClassroomService;

    /**
     * 查询教室管理列表
     */
    @PreAuthorize("@ss.hasPermi('business:classroom:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZStadiumClassroom zStadiumClassroom)
    {
        startPage();
        List<ZStadiumClassroom> list = zStadiumClassroomService.selectZStadiumClassroomList(zStadiumClassroom);
        return getDataTable(list);
    }

    /**
     * 导出教室管理列表
     */
        @PreAuthorize("@ss.hasPermi('business:classroom:export')")
    @Log(title = "教室管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ZStadiumClassroom zStadiumClassroom)
    {
        List<ZStadiumClassroom> list = zStadiumClassroomService.selectZStadiumClassroomList(zStadiumClassroom);
        ExcelUtil<ZStadiumClassroom> util = new ExcelUtil<ZStadiumClassroom>(ZStadiumClassroom.class);
        util.exportExcel(response, list, "教室管理数据");
    }

    /**
     * 获取教室管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:classroom:query')")
    @GetMapping(value = "/{classroomId}")
    public AjaxResult getInfo(@PathVariable("classroomId") Long classroomId)
    {
        return AjaxResult.success(zStadiumClassroomService.selectZStadiumClassroomByClassroomId(classroomId));
    }

    /**
     * 新增教室管理
     */
    @PreAuthorize("@ss.hasPermi('business:classroom:add')")
    @Log(title = "教室管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZStadiumClassroom zStadiumClassroom)
    {
        return toAjax(zStadiumClassroomService.insertZStadiumClassroom(zStadiumClassroom));
    }

    /**
     * 修改教室管理
     */
    @PreAuthorize("@ss.hasPermi('business:classroom:edit')")
    @Log(title = "教室管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZStadiumClassroom zStadiumClassroom)
    {
        return toAjax(zStadiumClassroomService.updateZStadiumClassroom(zStadiumClassroom));
    }

    /**
     * 删除教室管理
     */
    @PreAuthorize("@ss.hasPermi('business:classroom:remove')")
    @Log(title = "教室管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{classroomIds}")
    public AjaxResult remove(@PathVariable Long[] classroomIds)
    {
        return toAjax(zStadiumClassroomService.deleteZStadiumClassroomByClassroomIds(classroomIds));
    }
}
