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
import com.ruoyi.business.domain.DSubscribeInfo;
import com.ruoyi.business.service.IDSubscribeInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 预约统计Controller
 * 
 * @author ruoyi
 * @date 2022-09-21
 */
@RestController
@RequestMapping("/business/subscribe")
public class DSubscribeInfoController extends BaseController
{
    @Autowired
    private IDSubscribeInfoService dSubscribeInfoService;

    /**
     * 查询预约统计列表
     */
    @PreAuthorize("@ss.hasPermi('business:subscribe:list')")
    @GetMapping("/list")
    public TableDataInfo list(DSubscribeInfo dSubscribeInfo)
    {
        startPage();
        List<DSubscribeInfo> list = dSubscribeInfoService.selectDSubscribeInfoList(dSubscribeInfo);
        return getDataTable(list);
    }

    /**
     * 导出预约统计列表
     */
    @PreAuthorize("@ss.hasPermi('business:subscribe:export')")
    @Log(title = "预约统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DSubscribeInfo dSubscribeInfo)
    {
        List<DSubscribeInfo> list = dSubscribeInfoService.selectDSubscribeInfoList(dSubscribeInfo);
        ExcelUtil<DSubscribeInfo> util = new ExcelUtil<DSubscribeInfo>(DSubscribeInfo.class);
        util.exportExcel(response, list, "预约统计数据");
    }

    /**
     * 获取预约统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:subscribe:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(dSubscribeInfoService.selectDSubscribeInfoById(id));
    }

    /**
     * 新增预约统计
     */
    @PreAuthorize("@ss.hasPermi('business:subscribe:add')")
    @Log(title = "预约统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DSubscribeInfo dSubscribeInfo)
    {
        return toAjax(dSubscribeInfoService.insertDSubscribeInfo(dSubscribeInfo));
    }

    /**
     * 修改预约统计
     */
    @PreAuthorize("@ss.hasPermi('business:subscribe:edit')")
    @Log(title = "预约统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DSubscribeInfo dSubscribeInfo)
    {
        return toAjax(dSubscribeInfoService.updateDSubscribeInfo(dSubscribeInfo));
    }

    /**
     * 删除预约统计
     */
    @PreAuthorize("@ss.hasPermi('business:subscribe:remove')")
    @Log(title = "预约统计", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dSubscribeInfoService.deleteDSubscribeInfoByIds(ids));
    }


    /**
     * 查询预约统计列表  （开放的白名单，供大屏使用）
     */
    @GetMapping("/nums")
    public TableDataInfo nums()
    {
        startPage();
        List<DSubscribeInfo> list = dSubscribeInfoService.selectorderby();
        return getDataTable(list);
    }

    /**
     * 查询预约统计列表
     */
    @GetMapping("/names")
    public List<String> names(){
        List<String> list = dSubscribeInfoService.names();
        return list;
    }
}
