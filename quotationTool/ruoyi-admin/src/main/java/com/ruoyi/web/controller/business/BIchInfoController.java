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
import com.ruoyi.business.domain.BIchInfo;
import com.ruoyi.business.service.IBIchInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 非遗库数据维护Controller
 * 
 * @author ruoyi
 * @date 2022-09-20
 */
@RestController
@RequestMapping("/business/ichInfo")
public class BIchInfoController extends BaseController
{
    @Autowired
    private IBIchInfoService bIchInfoService;

    /**
     * 查询非遗库数据维护列表
     */
    @PreAuthorize("@ss.hasPermi('business:ichInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(BIchInfo bIchInfo)
    {
        startPage();
        List<BIchInfo> list = bIchInfoService.selectBIchInfoList(bIchInfo);
        return getDataTable(list);
    }

    /**
     * 导出非遗库数据维护列表
     */
    @PreAuthorize("@ss.hasPermi('business:ichInfo:export')")
    @Log(title = "非遗库数据维护", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BIchInfo bIchInfo)
    {
        List<BIchInfo> list = bIchInfoService.selectBIchInfoList(bIchInfo);
        ExcelUtil<BIchInfo> util = new ExcelUtil<BIchInfo>(BIchInfo.class);
        util.exportExcel(response, list, "非遗库数据维护数据");
    }

    /**
     * 获取非遗库数据维护详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:ichInfo:query')")
    @GetMapping(value = "/{ichId}")
    public AjaxResult getInfo(@PathVariable("ichId") Integer ichId)
    {
        return AjaxResult.success(bIchInfoService.selectBIchInfoByIchId(ichId));
    }

    /**
     * 新增非遗库数据维护
     */
    @PreAuthorize("@ss.hasPermi('business:ichInfo:add')")
    @Log(title = "非遗库数据维护", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BIchInfo bIchInfo)
    {
        return toAjax(bIchInfoService.insertBIchInfo(bIchInfo));
    }

    /**
     * 修改非遗库数据维护
     */
    @PreAuthorize("@ss.hasPermi('business:ichInfo:edit')")
    @Log(title = "非遗库数据维护", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BIchInfo bIchInfo)
    {
        return toAjax(bIchInfoService.updateBIchInfo(bIchInfo));
    }

    /**
     * 删除非遗库数据维护
     */
    @PreAuthorize("@ss.hasPermi('business:ichInfo:remove')")
    @Log(title = "非遗库数据维护", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ichIds}")
    public AjaxResult remove(@PathVariable Integer[] ichIds)
    {
        return toAjax(bIchInfoService.deleteBIchInfoByIchIds(ichIds));
    }
}
