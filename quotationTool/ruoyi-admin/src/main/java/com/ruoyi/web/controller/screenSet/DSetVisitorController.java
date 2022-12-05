package com.ruoyi.web.controller.screenSet;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.business.domain.BActivityInfo;
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
import com.ruoyi.screenSet.domain.DSetVisitor;
import com.ruoyi.screenSet.service.IDSetVisitorService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 游客大屏配置Controller
 * 
 * @author huzd
 * @date 2022-09-23
 */
@RestController
@RequestMapping("/screenSet/visitor")
public class DSetVisitorController extends BaseController
{
    @Autowired
    private IDSetVisitorService dSetVisitorService;

    /**
     * 活动信息配置
     * @author huzd
     * @date 2022-09-21 14:59
     * @param dSetVisitor
     * @return com.ruoyi.common.core.page.TableDataInfo
     */
    @GetMapping("/listVisitor")
    public AjaxResult listVisitor(DSetVisitor dSetVisitor){
        List<DSetVisitor> list = dSetVisitorService.selectDSetVisitorList(dSetVisitor);
        return AjaxResult.success(list);
    }

    /**
     * 查询游客大屏配置列表
     */
    @PreAuthorize("@ss.hasPermi('screenSet:visitor:list')")
    @GetMapping("/list")
    public TableDataInfo list(DSetVisitor dSetVisitor)
    {
        startPage();
        List<DSetVisitor> list = dSetVisitorService.selectDSetVisitorList(dSetVisitor);
        return getDataTable(list);
    }

    /**
     * 导出游客大屏配置列表
     */
    @PreAuthorize("@ss.hasPermi('screenSet:visitor:export')")
    @Log(title = "游客大屏配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DSetVisitor dSetVisitor)
    {
        List<DSetVisitor> list = dSetVisitorService.selectDSetVisitorList(dSetVisitor);
        ExcelUtil<DSetVisitor> util = new ExcelUtil<DSetVisitor>(DSetVisitor.class);
        util.exportExcel(response, list, "游客大屏配置数据");
    }

    /**
     * 获取游客大屏配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('screenSet:visitor:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(dSetVisitorService.selectDSetVisitorById(id));
    }

    /**
     * 新增游客大屏配置
     */
    @PreAuthorize("@ss.hasPermi('screenSet:visitor:add')")
    @Log(title = "游客大屏配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DSetVisitor dSetVisitor)
    {
        return toAjax(dSetVisitorService.insertDSetVisitor(dSetVisitor));
    }

    /**
     * 修改游客大屏配置
     */
    @PreAuthorize("@ss.hasPermi('screenSet:visitor:edit')")
    @Log(title = "游客大屏配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DSetVisitor dSetVisitor)
    {
        return toAjax(dSetVisitorService.updateDSetVisitor(dSetVisitor));
    }

    /**
     * 删除游客大屏配置
     */
    @PreAuthorize("@ss.hasPermi('screenSet:visitor:remove')")
    @Log(title = "游客大屏配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dSetVisitorService.deleteDSetVisitorByIds(ids));
    }
}
