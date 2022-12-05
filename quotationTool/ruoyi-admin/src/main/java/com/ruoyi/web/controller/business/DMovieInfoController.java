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
import com.ruoyi.business.domain.DMovieInfo;
import com.ruoyi.business.service.IDMovieInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 电影统计Controller
 * 
 * @author ruoyi
 * @date 2022-11-25
 */
@RestController
@RequestMapping("/business/viewing")
public class DMovieInfoController extends BaseController
{
    @Autowired
    private IDMovieInfoService dMovieInfoService;

    /**
     * 查询电影统计列表
     */
    @PreAuthorize("@ss.hasPermi('business:viewing:list')")
    @GetMapping("/list")
    public TableDataInfo list(DMovieInfo dMovieInfo)
    {
        startPage();
        List<DMovieInfo> list = dMovieInfoService.selectDMovieInfoList(dMovieInfo);
        return getDataTable(list);
    }

    /**
     * 导出电影统计列表
     */
    @PreAuthorize("@ss.hasPermi('business:viewing:export')")
    @Log(title = "电影统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DMovieInfo dMovieInfo)
    {
        List<DMovieInfo> list = dMovieInfoService.selectDMovieInfoList(dMovieInfo);
        ExcelUtil<DMovieInfo> util = new ExcelUtil<DMovieInfo>(DMovieInfo.class);
        util.exportExcel(response, list, "电影统计数据");
    }

    /**
     * 获取电影统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:viewing:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(dMovieInfoService.selectDMovieInfoById(id));
    }

    /**
     * 新增电影统计
     */
    @PreAuthorize("@ss.hasPermi('business:viewing:add')")
    @Log(title = "电影统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DMovieInfo dMovieInfo)
    {
        return toAjax(dMovieInfoService.insertDMovieInfo(dMovieInfo));
    }

    /**
     * 修改电影统计
     */
    @PreAuthorize("@ss.hasPermi('business:viewing:edit')")
    @Log(title = "电影统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DMovieInfo dMovieInfo)
    {
        return toAjax(dMovieInfoService.updateDMovieInfo(dMovieInfo));
    }

    /**
     * 删除电影统计
     */
    @PreAuthorize("@ss.hasPermi('business:viewing:remove')")
    @Log(title = "电影统计", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dMovieInfoService.deleteDMovieInfoByIds(ids));
    }


    /**
     * 获取所有数据 （大屏接口）(api接口)
     * @author: liu
     * @date: 2022/9/21
     */
    @GetMapping("/nums")
    public TableDataInfo nums(DMovieInfo dMovieInfo) {
        startPage();
        List<DMovieInfo> list = dMovieInfoService.selectDMovieInfoList(dMovieInfo);
        //return list;
        return getDataTable(list);
    }

    /**
     * 获取电影统计详细信息 (api接口)
     */
    @GetMapping(value = "details")
    public AjaxResult details(Long id)
    {
        return AjaxResult.success(dMovieInfoService.selectDMovieInfoById(id));
    }
}
