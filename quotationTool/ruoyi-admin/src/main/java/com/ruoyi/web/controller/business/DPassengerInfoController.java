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
import com.ruoyi.business.domain.DPassengerInfo;
import com.ruoyi.business.service.IDPassengerInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 客流统计Controller
 * 
 * @author ruoyi
 * @date 2022-09-21
 */
@RestController
@RequestMapping("/business/passenger")
public class DPassengerInfoController extends BaseController
{
    @Autowired
    private IDPassengerInfoService dPassengerInfoService;

    /**
     * 查询客流统计列表
     */
    @PreAuthorize("@ss.hasPermi('business:passenger:list')")
    @GetMapping("/list")
    public TableDataInfo list(DPassengerInfo dPassengerInfo)
    {
        startPage();
        List<DPassengerInfo> list = dPassengerInfoService.selectDPassengerInfoList(dPassengerInfo);
        return getDataTable(list);
    }

    /**
     * 导出客流统计列表
     */
    @PreAuthorize("@ss.hasPermi('business:passenger:export')")
    @Log(title = "客流统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DPassengerInfo dPassengerInfo)
    {
        List<DPassengerInfo> list = dPassengerInfoService.selectDPassengerInfoList(dPassengerInfo);
        ExcelUtil<DPassengerInfo> util = new ExcelUtil<DPassengerInfo>(DPassengerInfo.class);
        util.exportExcel(response, list, "客流统计数据");
    }

    /**
     * 获取客流统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:passenger:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(dPassengerInfoService.selectDPassengerInfoById(id));
    }

    /**
     * 新增客流统计
     */
    @PreAuthorize("@ss.hasPermi('business:passenger:add')")
    @Log(title = "客流统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DPassengerInfo dPassengerInfo)
    {
        return toAjax(dPassengerInfoService.insertDPassengerInfo(dPassengerInfo));
    }

    /**
     * 修改客流统计
     */
    @PreAuthorize("@ss.hasPermi('business:passenger:edit')")
    @Log(title = "客流统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DPassengerInfo dPassengerInfo)
    {
        return toAjax(dPassengerInfoService.updateDPassengerInfo(dPassengerInfo));
    }

    /**
     * 删除客流统计
     */
    @PreAuthorize("@ss.hasPermi('business:passenger:remove')")
    @Log(title = "客流统计", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dPassengerInfoService.deleteDPassengerInfoByIds(ids));
    }



    /**
     * 查询客流统计列表
     */
    @GetMapping("/nums")
    public List<DPassengerInfo> nums()
    {
        List<DPassengerInfo> list = dPassengerInfoService.nums();
        return list;
    }
}
