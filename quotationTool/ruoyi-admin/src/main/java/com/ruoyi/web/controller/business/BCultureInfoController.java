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
import com.ruoyi.business.domain.BCultureInfo;
import com.ruoyi.business.service.IBCultureInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 文化咨询库Controller
 * 
 * @author ruoyi
 * @date 2022-11-25
 */
@RestController
@RequestMapping("/business/cultrue")
public class BCultureInfoController extends BaseController
{
    @Autowired
    private IBCultureInfoService bCultureInfoService;

    /**
     * 查询文化咨询库列表
     */
    @PreAuthorize("@ss.hasPermi('business:cultrue:list')")
    @GetMapping("/list")
    public TableDataInfo list(BCultureInfo bCultureInfo)
    {
        startPage();
        List<BCultureInfo> list = bCultureInfoService.selectBCultureInfoList(bCultureInfo);
        return getDataTable(list);
    }

    /**
     * 导出文化咨询库列表
     */
    @PreAuthorize("@ss.hasPermi('business:cultrue:export')")
    @Log(title = "文化咨询库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BCultureInfo bCultureInfo)
    {
        List<BCultureInfo> list = bCultureInfoService.selectBCultureInfoList(bCultureInfo);
        ExcelUtil<BCultureInfo> util = new ExcelUtil<BCultureInfo>(BCultureInfo.class);
        util.exportExcel(response, list, "文化咨询库数据");
    }

    /**
     * 获取文化咨询库详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:cultrue:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(bCultureInfoService.selectBCultureInfoById(id));
    }

    /**
     * 新增文化咨询库
     */
    @PreAuthorize("@ss.hasPermi('business:cultrue:add')")
    @Log(title = "文化咨询库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BCultureInfo bCultureInfo)
    {
        return toAjax(bCultureInfoService.insertBCultureInfo(bCultureInfo));
    }

    /**
     * 修改文化咨询库
     */
    @PreAuthorize("@ss.hasPermi('business:cultrue:edit')")
    @Log(title = "文化咨询库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BCultureInfo bCultureInfo)
    {
        return toAjax(bCultureInfoService.updateBCultureInfo(bCultureInfo));
    }

    /**
     * 删除文化咨询库
     */
    @PreAuthorize("@ss.hasPermi('business:cultrue:remove')")
    @Log(title = "文化咨询库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(bCultureInfoService.deleteBCultureInfoByIds(ids));
    }


    /**
     * 小程序 ---- 首页文化资讯展示
     */
    @GetMapping("/apilist")
    public TableDataInfo apilist(BCultureInfo bCultureInfo)
    {
        startPage();
        List<BCultureInfo> list = bCultureInfoService.selectBCultureInfoList(bCultureInfo);
        return getDataTable(list);
    }

    /**
     * 获取文化资讯信息（首页点击进入详情）
     */
    @GetMapping(value = "details")
    public AjaxResult details(Long id)
    {
        return AjaxResult.success(bCultureInfoService.selectBCultureInfoById(id));
    }
}
