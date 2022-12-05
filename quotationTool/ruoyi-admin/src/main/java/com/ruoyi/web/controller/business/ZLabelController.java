package com.ruoyi.web.controller.business;

import com.ruoyi.business.domain.ZLabel;
import com.ruoyi.business.service.IZLabelService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 标签库Controller
 * 
 * @author zhoujie
 * @date 2022-11-25
 */
@RestController
@RequestMapping("/business/label")
public class ZLabelController extends BaseController
{
    @Autowired
    private IZLabelService zLabelService;

    /**
     * 查询标签库列表
     */
    @PreAuthorize("@ss.hasPermi('business:label:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZLabel zLabel)
    {
        startPage();
        List<ZLabel> list = zLabelService.selectZLabelList(zLabel);
        return getDataTable(list);
    }

    /**
     * 导出标签库列表
     */
    @PreAuthorize("@ss.hasPermi('business:label:export')")
    @Log(title = "标签库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ZLabel zLabel)
    {
        List<ZLabel> list = zLabelService.selectZLabelList(zLabel);
        ExcelUtil<ZLabel> util = new ExcelUtil<ZLabel>(ZLabel.class);
        util.exportExcel(response, list, "标签库数据");
    }

    /**
     * 获取标签库详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:label:query')")
    @GetMapping(value = "/{labelId}")
    public AjaxResult getInfo(@PathVariable("labelId") Long labelId)
    {
        return AjaxResult.success(zLabelService.selectZLabelByLabelId(labelId));
    }

    /**
     * 新增标签库
     */
    @PreAuthorize("@ss.hasPermi('business:label:add')")
    @Log(title = "标签库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZLabel zLabel)
    {
        return toAjax(zLabelService.insertZLabel(zLabel));
    }

    /**
     * 修改标签库
     */
    @PreAuthorize("@ss.hasPermi('business:label:edit')")
    @Log(title = "标签库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZLabel zLabel)
    {
        return toAjax(zLabelService.updateZLabel(zLabel));
    }

    /**
     * 删除标签库
     */
    @PreAuthorize("@ss.hasPermi('business:label:remove')")
    @Log(title = "标签库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{labelIds}")
    public AjaxResult remove(@PathVariable Long[] labelIds)
    {
        return toAjax(zLabelService.deleteZLabelByLabelIds(labelIds));
    }
}
