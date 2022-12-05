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
import com.ruoyi.business.domain.ZRecordClassify;
import com.ruoyi.business.service.IZRecordClassifyService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 档案分类Controller
 * 
 * @author zhoujie
 * @date 2022-11-28
 */
@RestController
@RequestMapping("/business/classify")
public class ZRecordClassifyController extends BaseController
{
    @Autowired
    private IZRecordClassifyService zRecordClassifyService;

    /**
     * 查询档案分类列表
     */
    @PreAuthorize("@ss.hasPermi('business:classify:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZRecordClassify zRecordClassify)
    {
        startPage();
        List<ZRecordClassify> list = zRecordClassifyService.selectZRecordClassifyList(zRecordClassify);
        return getDataTable(list);
    }

    /**
     * 导出档案分类列表
     */
    @PreAuthorize("@ss.hasPermi('business:classify:export')")
    @Log(title = "档案分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ZRecordClassify zRecordClassify)
    {
        List<ZRecordClassify> list = zRecordClassifyService.selectZRecordClassifyList(zRecordClassify);
        ExcelUtil<ZRecordClassify> util = new ExcelUtil<ZRecordClassify>(ZRecordClassify.class);
        util.exportExcel(response, list, "档案分类数据");
    }

    /**
     * 获取档案分类详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:classify:query')")
    @GetMapping(value = "/{recordId}")
    public AjaxResult getInfo(@PathVariable("recordId") Long recordId)
    {
        return AjaxResult.success(zRecordClassifyService.selectZRecordClassifyByRecordId(recordId));
    }

    /**
     * 新增档案分类
     */
    @PreAuthorize("@ss.hasPermi('business:classify:add')")
    @Log(title = "档案分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZRecordClassify zRecordClassify)
    {
        return toAjax(zRecordClassifyService.insertZRecordClassify(zRecordClassify));
    }

    /**
     * 修改档案分类
     */
    @PreAuthorize("@ss.hasPermi('business:classify:edit')")
    @Log(title = "档案分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZRecordClassify zRecordClassify)
    {
        return toAjax(zRecordClassifyService.updateZRecordClassify(zRecordClassify));
    }

    /**
     * 删除档案分类
     */
    @PreAuthorize("@ss.hasPermi('business:classify:remove')")
    @Log(title = "档案分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{recordIds}")
    public AjaxResult remove(@PathVariable Long[] recordIds)
    {
        return toAjax(zRecordClassifyService.deleteZRecordClassifyByRecordIds(recordIds));
    }
}
