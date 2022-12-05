package com.ruoyi.business.stadium.controller;

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
import com.ruoyi.business.stadium.domain.Stadium;
import com.ruoyi.business.stadium.service.IStadiumService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 场馆基本信息Controller
 * 
 * @author zhouyz
 * @date 2022-11-27
 */
@RestController
@RequestMapping("/stadium")
public class StadiumController extends BaseController
{
    @Autowired
    private IStadiumService stadiumService;

    /**
     * 查询场馆基本信息列表
     */
   // @PreAuthorize("@ss.hasPermi('stadium:stadium:list')")
    @GetMapping("/list")
    public TableDataInfo list(Stadium stadium)
    {
     //   startPage();
        List<Stadium> list = stadiumService.selectStadiumList(stadium);
        return getDataTable(list);
    }

    /**
     * 导出场馆基本信息列表
     */
    @PreAuthorize("@ss.hasPermi('stadium:stadium:export')")
    @Log(title = "场馆基本信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Stadium stadium)
    {
        List<Stadium> list = stadiumService.selectStadiumList(stadium);
        ExcelUtil<Stadium> util = new ExcelUtil<Stadium>(Stadium.class);
        util.exportExcel(response, list, "场馆基本信息数据");
    }

    /**
     * 获取场馆基本信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('stadium:stadium:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(stadiumService.selectStadiumById(id));
    }

    /**
     * 新增场馆基本信息
     */
    @PreAuthorize("@ss.hasPermi('stadium:stadium:add')")
    @Log(title = "场馆基本信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Stadium stadium)
    {
        return toAjax(stadiumService.insertStadium(stadium));
    }

    /**
     * 修改场馆基本信息
     */
    @PreAuthorize("@ss.hasPermi('stadium:stadium:edit')")
    @Log(title = "场馆基本信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Stadium stadium)
    {
        return toAjax(stadiumService.updateStadium(stadium));
    }

    /**
     * 删除场馆基本信息
     */
    @PreAuthorize("@ss.hasPermi('stadium:stadium:remove')")
    @Log(title = "场馆基本信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(stadiumService.deleteStadiumByIds(ids));
    }
}
