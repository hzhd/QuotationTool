package com.ruoyi.business.wxuser.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.business.wxuser.domain.ZAbucoderWxuser;
import com.ruoyi.business.wxuser.service.IZAbucoderWxuserService;
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
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 微信用户Controller
 * 
 * @author zhoujie
 * @date 2022-11-29
 */
@RestController
@RequestMapping("/business/wxuser")
public class ZAbucoderWxuserController extends BaseController
{
    @Autowired
    private IZAbucoderWxuserService zAbucoderWxuserService;

    /**
     * 查询微信用户列表
     */
    @PreAuthorize("@ss.hasPermi('business:wxuser:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZAbucoderWxuser zAbucoderWxuser)
    {
        startPage();
        List<ZAbucoderWxuser> list = zAbucoderWxuserService.selectZAbucoderWxuserList(zAbucoderWxuser);
        return getDataTable(list);
    }

    /**
     * 导出微信用户列表
     */
    @PreAuthorize("@ss.hasPermi('business:wxuser:export')")
    @Log(title = "微信用户", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ZAbucoderWxuser zAbucoderWxuser)
    {
        List<ZAbucoderWxuser> list = zAbucoderWxuserService.selectZAbucoderWxuserList(zAbucoderWxuser);
        ExcelUtil<ZAbucoderWxuser> util = new ExcelUtil<ZAbucoderWxuser>(ZAbucoderWxuser.class);
        util.exportExcel(response, list, "微信用户数据");
    }

    /**
     * 获取微信用户详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:wxuser:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(zAbucoderWxuserService.selectZAbucoderWxuserById(id));
    }

    /**
     * 新增微信用户
     */
    @PreAuthorize("@ss.hasPermi('business:wxuser:add')")
    @Log(title = "微信用户", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZAbucoderWxuser zAbucoderWxuser)
    {
        return toAjax(zAbucoderWxuserService.insertZAbucoderWxuser(zAbucoderWxuser));
    }

    /**
     * 修改微信用户
     */
    @PreAuthorize("@ss.hasPermi('business:wxuser:edit')")
    @Log(title = "微信用户", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZAbucoderWxuser zAbucoderWxuser)
    {
        return toAjax(zAbucoderWxuserService.updateZAbucoderWxuser(zAbucoderWxuser));
    }

    /**
     * 删除微信用户
     */
    @PreAuthorize("@ss.hasPermi('business:wxuser:remove')")
    @Log(title = "微信用户", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(zAbucoderWxuserService.deleteZAbucoderWxuserByIds(ids));
    }
}
