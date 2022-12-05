package com.ruoyi.web.controller.business;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.utils.PageUtils;
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
import com.ruoyi.business.domain.DInfluenceInfo;
import com.ruoyi.business.service.IDInfluenceInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 影响力统计Controller
 * 
 * @author Liu
 * @date 2022-09-21
 */
@RestController
@RequestMapping("/business/info")
public class DInfluenceInfoController extends BaseController
{
    @Autowired
    private IDInfluenceInfoService dInfluenceInfoService;

    /**
     * 查询影响力统计列表
     */
    @PreAuthorize("@ss.hasPermi('business:info:list')")
    @GetMapping("/list")
    public TableDataInfo list(DInfluenceInfo dInfluenceInfo)
    {
        startPage();
        List<DInfluenceInfo> list = dInfluenceInfoService.selectDInfluenceInfoList(dInfluenceInfo);
        return getDataTable(list);
    }

    /**
     * 导出影响力统计列表
     */
    @PreAuthorize("@ss.hasPermi('business:info:export')")
    @Log(title = "影响力统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DInfluenceInfo dInfluenceInfo)
    {
        List<DInfluenceInfo> list = dInfluenceInfoService.selectDInfluenceInfoList(dInfluenceInfo);
        ExcelUtil<DInfluenceInfo> util = new ExcelUtil<DInfluenceInfo>(DInfluenceInfo.class);
        util.exportExcel(response, list, "影响力统计数据");
    }

    /**
     * 获取影响力统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:info:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(dInfluenceInfoService.selectDInfluenceInfoById(id));
    }

    /**
     * 新增影响力统计
     */
    @PreAuthorize("@ss.hasPermi('business:info:add')")
    @Log(title = "影响力统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DInfluenceInfo dInfluenceInfo)
    {
        return toAjax(dInfluenceInfoService.insertDInfluenceInfo(dInfluenceInfo));
    }

    /**
     * 修改影响力统计
     */
    @PreAuthorize("@ss.hasPermi('business:info:edit')")
    @Log(title = "影响力统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DInfluenceInfo dInfluenceInfo)
    {
        return toAjax(dInfluenceInfoService.updateDInfluenceInfo(dInfluenceInfo));
    }

    /**
     * 删除影响力统计
     */
    @PreAuthorize("@ss.hasPermi('business:info:remove')")
    @Log(title = "影响力统计", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dInfluenceInfoService.deleteDInfluenceInfoByIds(ids));
    }


    /**
     * 获取日月周年数据     (管理端大屏接口)
     * @Param type  1 日 2 周 3月 4 年
     */
    @GetMapping("days")
    public List<DInfluenceInfo> getDays(String type){
        List<DInfluenceInfo> days = dInfluenceInfoService.getDays(type);
        return days;
    }

    /**
     * 获取日月周年数据     (首页大屏接口)
     * @Param type  1 日 2 周 3月 4 年
     */
    @GetMapping("names")
    public List<DInfluenceInfo> getNames(){
        List<DInfluenceInfo> days = dInfluenceInfoService.getNames();
        return days;
    }


}
