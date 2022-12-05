package com.ruoyi.web.controller.screenSet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.business.domain.BIchInfo;
import com.ruoyi.business.service.IBIchInfoService;
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
import com.ruoyi.screenSet.domain.DHeritageComment;
import com.ruoyi.screenSet.service.IDHeritageCommentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 非遗评论Controller
 * 
 * @author huzd
 * @date 2022-09-21
 */
@RestController
@RequestMapping("/screenSet/heritageComment")
public class DHeritageCommentController extends BaseController
{
    @Autowired
    private IDHeritageCommentService dHeritageCommentService;

    @Autowired
    private IBIchInfoService bIchInfoService;

    /**
     * 查询非遗评论列表
     */
    @PreAuthorize("@ss.hasPermi('screenSet:heritageComment:list')")
    @GetMapping("/list")
    public TableDataInfo list(DHeritageComment dHeritageComment)
    {
        startPage();
        List<DHeritageComment> list = dHeritageCommentService.selectDHeritageCommentList(dHeritageComment);
        return getDataTable(list);
    }

    /**
     * 导出非遗评论列表
     */
    @PreAuthorize("@ss.hasPermi('screenSet:heritageComment:export')")
    @Log(title = "非遗评论", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DHeritageComment dHeritageComment)
    {
        List<DHeritageComment> list = dHeritageCommentService.selectDHeritageCommentList(dHeritageComment);
        ExcelUtil<DHeritageComment> util = new ExcelUtil<DHeritageComment>(DHeritageComment.class);
        util.exportExcel(response, list, "非遗评论数据");
    }

    /**
     * 获取非遗评论详细信息
     */
    @PreAuthorize("@ss.hasPermi('screenSet:heritageComment:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        DHeritageComment dHeritageComment = dHeritageCommentService.selectDHeritageCommentById(id);
        return AjaxResult.success(dHeritageComment);
    }

    /**
     * 获取项目列表
     */
    @GetMapping(value = "/getProject")
    public AjaxResult getProject()
    {
        List<BIchInfo> bIchInfoList = bIchInfoService.selectBIchInfoList(new BIchInfo());
        return AjaxResult.success(bIchInfoList);
    }

    /**
     * 新增非遗评论
     */
    @PreAuthorize("@ss.hasPermi('screenSet:heritageComment:add')")
    @Log(title = "非遗评论", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DHeritageComment dHeritageComment)
    {
        return toAjax(dHeritageCommentService.insertDHeritageComment(dHeritageComment));
    }

    /**
     * 修改非遗评论
     */
    @PreAuthorize("@ss.hasPermi('screenSet:heritageComment:edit')")
    @Log(title = "非遗评论", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DHeritageComment dHeritageComment)
    {
        return toAjax(dHeritageCommentService.updateDHeritageComment(dHeritageComment));
    }

    /**
     * 删除非遗评论
     */
    @PreAuthorize("@ss.hasPermi('screenSet:heritageComment:remove')")
    @Log(title = "非遗评论", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dHeritageCommentService.deleteDHeritageCommentByIds(ids));
    }
}
