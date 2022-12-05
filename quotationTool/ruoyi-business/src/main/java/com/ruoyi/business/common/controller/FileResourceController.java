package com.ruoyi.business.common.controller;

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
import com.ruoyi.business.common.domain.FileResource;
import com.ruoyi.business.common.service.IFileResourceService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 资源文件Controller
 * 
 * @author ruoyi
 * @date 2022-11-28
 */
@RestController
@RequestMapping("/media/resource")
public class FileResourceController extends BaseController
{
    @Autowired
    private IFileResourceService fileResourceService;

    /**
     * 查询资源文件列表
     */
    @PreAuthorize("@ss.hasPermi('media:resource:list')")
    @GetMapping("/list")
    public TableDataInfo list(FileResource fileResource)
    {
        startPage();
        List<FileResource> list = fileResourceService.selectFileResourceList(fileResource);
        return getDataTable(list);
    }

    /**
     * 导出资源文件列表
     */
    @PreAuthorize("@ss.hasPermi('media:resource:export')")
    @Log(title = "资源文件", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, FileResource fileResource)
    {
        List<FileResource> list = fileResourceService.selectFileResourceList(fileResource);
        ExcelUtil<FileResource> util = new ExcelUtil<FileResource>(FileResource.class);
        util.exportExcel(response, list, "资源文件数据");
    }

    /**
     * 获取资源文件详细信息
     */
    @PreAuthorize("@ss.hasPermi('media:resource:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(fileResourceService.selectFileResourceById(id));
    }

    /**
     * 新增资源文件
     */
    @PreAuthorize("@ss.hasPermi('media:resource:add')")
    @Log(title = "资源文件", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody FileResource fileResource)
    {
        return toAjax(fileResourceService.insertFileResource(fileResource));
    }

    /**
     * 修改资源文件
     */
    @PreAuthorize("@ss.hasPermi('media:resource:edit')")
    @Log(title = "资源文件", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody FileResource fileResource)
    {
        return toAjax(fileResourceService.updateFileResource(fileResource));
    }

    /**
     * 删除资源文件
     */
    @PreAuthorize("@ss.hasPermi('media:resource:remove')")
    @Log(title = "资源文件", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(fileResourceService.deleteFileResourceByIds(ids));
    }
}
