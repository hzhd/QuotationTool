package com.ruoyi.business.media.controller;

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
import com.github.pagehelper.util.StringUtil;
import com.ruoyi.business.mapper.CustMapper;
import com.ruoyi.business.media.domain.Screen;
import com.ruoyi.business.media.domain.ScreenFuncConfig;
import com.ruoyi.business.media.service.IScreenService;
import com.ruoyi.common.utils.poi.ExcelUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 大屏设备基本信息Controller
 * 
 * @author zhouyz
 * @date 2022-11-28
 */

@Api(tags="大屏管理")
@RestController
@RequestMapping("/media/screen")
public class ScreenController extends BaseController
{
    @Autowired
    private IScreenService screenService;
    @Autowired
    private CustMapper custMapper;

    /**
     * 查询大屏设备基本信息列表
     */
    @PreAuthorize("@ss.hasPermi('media:screen:list')")
    @GetMapping("/list")
    public TableDataInfo list(Screen screen)
    {
        startPage();
        List<Screen> list = screenService.selectScreenList(screen);
        return getDataTable(list);
    }

    /**
     * 导出大屏设备基本信息列表
     */
    @PreAuthorize("@ss.hasPermi('media:screen:export')")
    @Log(title = "大屏设备基本信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Screen screen)
    {
        List<Screen> list = screenService.selectScreenList(screen);
        ExcelUtil<Screen> util = new ExcelUtil<Screen>(Screen.class);
        util.exportExcel(response, list, "大屏设备基本信息数据");
    }

    /**
     * 获取大屏设备基本信息详细信息
     */
    @PreAuthorize("@ss.hasPermi('media:screen:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(screenService.selectScreenById(id));
    }

    /**
     * 新增大屏设备基本信息
     */
    @PreAuthorize("@ss.hasPermi('media:screen:add')")
    @Log(title = "大屏设备基本信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Screen screen)
    {
        return toAjax(screenService.insertScreen(screen));
    }

    /**
     * 修改大屏设备基本信息
     */
    @PreAuthorize("@ss.hasPermi('media:screen:edit')")
    @Log(title = "大屏设备基本信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Screen screen)
    {
        return toAjax(screenService.updateScreen(screen));
    }

    /**
     * 删除大屏设备基本信息
     */
    @PreAuthorize("@ss.hasPermi('media:screen:remove')")
    @Log(title = "大屏设备基本信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(screenService.deleteScreenByIds(ids));
    }
    /**
     * 设置大屏的功能参数
     * @param config
     * @return
     */
    @ApiOperation(value="设置大屏的功能参数")
    @PostMapping(value="/config/set")
    public AjaxResult setScreenFuncConfig(@RequestBody ScreenFuncConfig config){
    	if(StringUtil.isEmpty(config.getFuncCode()))
    		throw new IllegalArgumentException("缺少必需参数:funcCode");
    	this.custMapper.replaceScreenFuncConfig(config);
    	return AjaxResult.success();
    }
   
}
