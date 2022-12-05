package com.ruoyi.web.controller.business;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.business.stadium.domain.Stadium;
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
import com.ruoyi.business.domain.ZStadiumInfo;
import com.ruoyi.business.service.IZStadiumInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 场馆信息Controller
 * 
 * @author zhoujie
 * @date 2022-11-28
 */
@RestController
@RequestMapping("/business/stadiumInfo")
public class ZStadiumInfoController extends BaseController
{
    @Autowired
    private IZStadiumInfoService zStadiumInfoService;

    /**
     * 查询场馆信息列表
     */
    @PreAuthorize("@ss.hasPermi('business:stadiumInfo:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZStadiumInfo zStadiumInfo)
    {
        startPage();
        List<ZStadiumInfo> list = zStadiumInfoService.selectZStadiumInfoList(zStadiumInfo);
        return getDataTable(list);
    }

    /**
     * 导出场馆信息列表
     */
    @PreAuthorize("@ss.hasPermi('business:stadiumInfo:export')")
    @Log(title = "场馆信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ZStadiumInfo zStadiumInfo)
    {
        List<ZStadiumInfo> list = zStadiumInfoService.selectZStadiumInfoList(zStadiumInfo);
        ExcelUtil<ZStadiumInfo> util = new ExcelUtil<ZStadiumInfo>(ZStadiumInfo.class);
        util.exportExcel(response, list, "场馆信息数据");
    }

    /**
     * 获取场馆信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:stadiumInfo:query')")
    @GetMapping(value = "/{stadiumId}")
    public AjaxResult getInfo(@PathVariable("stadiumId") Long stadiumId)
    {
        return AjaxResult.success(zStadiumInfoService.selectZStadiumInfoByStadiumId(stadiumId));
    }

    /**
     * 新增场馆信息
     */
    @PreAuthorize("@ss.hasPermi('business:stadiumInfo:add')")
    @Log(title = "场馆信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZStadiumInfo zStadiumInfo)
    {
        return toAjax(zStadiumInfoService.insertZStadiumInfo(zStadiumInfo));
    }

    /**
     * 修改场馆信息
     */
    @PreAuthorize("@ss.hasPermi('business:stadiumInfo:edit')")
    @Log(title = "场馆信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZStadiumInfo zStadiumInfo)
    {
        return toAjax(zStadiumInfoService.updateZStadiumInfo(zStadiumInfo));
    }

    /**
     * 删除场馆信息
     */
    @PreAuthorize("@ss.hasPermi('business:stadiumInfo:remove')")
    @Log(title = "场馆信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{stadiumIds}")
    public AjaxResult remove(@PathVariable Long[] stadiumIds)
    {
        return toAjax(zStadiumInfoService.deleteZStadiumInfoByStadiumIds(stadiumIds));
    }

    /**
     * 查询场馆信息列表
     */
    @PreAuthorize("@ss.hasPermi('business:stadiumInfo:list')")
    @GetMapping("/queryStadiumList")
    public List<ZStadiumInfo> queryStadiumList()
    {
        List<ZStadiumInfo> list = zStadiumInfoService.selectZStadiumInfoList(new ZStadiumInfo());
        return list;
    }
}
