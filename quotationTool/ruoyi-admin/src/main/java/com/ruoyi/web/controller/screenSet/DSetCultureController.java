package com.ruoyi.web.controller.screenSet;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.screenSet.domain.DSetVisitor;
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
import com.ruoyi.screenSet.domain.DSetCulture;
import com.ruoyi.screenSet.service.IDSetCultureService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文化资讯配置Controller
 * 
 * @author huzd
 * @date 2022-09-24
 */
@RestController
@RequestMapping("/screenSet/culture")
public class DSetCultureController extends BaseController
{
    @Autowired
    private IDSetCultureService dSetCultureService;


    /**
     * 活动信息配置
     * @author huzd
     * @date 2022-09-21 14:59
     * @param dSetCulture
     * @return com.ruoyi.common.core.page.TableDataInfo
     */
    @GetMapping("/listCulture")
    public AjaxResult listCulture(DSetCulture dSetCulture){
        List<DSetCulture> list = dSetCultureService.selectDSetCultureList(dSetCulture);
        return AjaxResult.success(list);
    }

    /**
     * 查询文化资讯配置列表
     */
    @PreAuthorize("@ss.hasPermi('setScreen:culture:list')")
    @GetMapping("/list")
    public TableDataInfo list(DSetCulture dSetCulture)
    {
        startPage();
        List<DSetCulture> list = dSetCultureService.selectDSetCultureList(dSetCulture);
        return getDataTable(list);
    }

    /**
     * 导出文化资讯配置列表
     */
    @PreAuthorize("@ss.hasPermi('setScreen:culture:export')")
    @Log(title = "文化资讯配置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DSetCulture dSetCulture)
    {
        List<DSetCulture> list = dSetCultureService.selectDSetCultureList(dSetCulture);
        ExcelUtil<DSetCulture> util = new ExcelUtil<DSetCulture>(DSetCulture.class);
        util.exportExcel(response, list, "文化资讯配置数据");
    }

    /**
     * 获取文化资讯配置详细信息
     */
    @PreAuthorize("@ss.hasPermi('setScreen:culture:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(dSetCultureService.selectDSetCultureById(id));
    }

    /**
     * 新增文化资讯配置
     */
    @PreAuthorize("@ss.hasPermi('setScreen:culture:add')")
    @Log(title = "文化资讯配置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DSetCulture dSetCulture)
    {
        return toAjax(dSetCultureService.insertDSetCulture(dSetCulture));
    }

    /**
     * 修改文化资讯配置
     */
    @PreAuthorize("@ss.hasPermi('setScreen:culture:edit')")
    @Log(title = "文化资讯配置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DSetCulture dSetCulture)
    {
        return toAjax(dSetCultureService.updateDSetCulture(dSetCulture));
    }

    /**
     * 删除文化资讯配置
     */
    @PreAuthorize("@ss.hasPermi('setScreen:culture:remove')")
    @Log(title = "文化资讯配置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dSetCultureService.deleteDSetCultureByIds(ids));
    }
}
