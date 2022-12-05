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
import com.ruoyi.business.domain.ZSensitivWord;
import com.ruoyi.business.service.IZSensitivWordService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * sensitivController
 * 
 * @author zhoujie
 * @date 2022-11-25
 */
@RestController
@RequestMapping("/business/sensitiv")
public class ZSensitivWordController extends BaseController
{
    @Autowired
    private IZSensitivWordService zSensitivWordService;

    /**
     * 查询sensitiv列表
     */
    @PreAuthorize("@ss.hasPermi('business:sensitiv:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZSensitivWord zSensitivWord)
    {
        startPage();
        List<ZSensitivWord> list = zSensitivWordService.selectZSensitivWordList(zSensitivWord);
        return getDataTable(list);
    }

    /**
     * 导出sensitiv列表
     */
    @PreAuthorize("@ss.hasPermi('business:sensitiv:export')")
    @Log(title = "sensitiv", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ZSensitivWord zSensitivWord)
    {
        List<ZSensitivWord> list = zSensitivWordService.selectZSensitivWordList(zSensitivWord);
        ExcelUtil<ZSensitivWord> util = new ExcelUtil<ZSensitivWord>(ZSensitivWord.class);
        util.exportExcel(response, list, "sensitiv数据");
    }

    /**
     * 获取sensitiv详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:sensitiv:query')")
    @GetMapping(value = "/{sensitiveId}")
    public AjaxResult getInfo(@PathVariable("sensitiveId") Long sensitiveId)
    {
        return AjaxResult.success(zSensitivWordService.selectZSensitivWordBySensitiveId(sensitiveId));
    }

    /**
     * 新增sensitiv
     */
    @PreAuthorize("@ss.hasPermi('business:sensitiv:add')")
    @Log(title = "sensitiv", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZSensitivWord zSensitivWord)
    {
        return toAjax(zSensitivWordService.insertZSensitivWord(zSensitivWord));
    }

    /**
     * 修改sensitiv
     */
    @PreAuthorize("@ss.hasPermi('business:sensitiv:edit')")
    @Log(title = "sensitiv", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZSensitivWord zSensitivWord)
    {
        return toAjax(zSensitivWordService.updateZSensitivWord(zSensitivWord));
    }

    /**
     * 删除sensitiv
     */
    @PreAuthorize("@ss.hasPermi('business:sensitiv:remove')")
    @Log(title = "sensitiv", businessType = BusinessType.DELETE)
	@DeleteMapping("/{sensitiveIds}")
    public AjaxResult remove(@PathVariable Long[] sensitiveIds)
    {
        return toAjax(zSensitivWordService.deleteZSensitivWordBySensitiveIds(sensitiveIds));
    }
}
