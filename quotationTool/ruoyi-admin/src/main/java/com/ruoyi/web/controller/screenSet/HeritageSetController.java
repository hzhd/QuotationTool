package com.ruoyi.web.controller.screenSet;

import com.ruoyi.business.domain.BIchInfo;
import com.ruoyi.business.service.IBIchInfoService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.screenSet.domain.DHeritageComment;
import com.ruoyi.screenSet.service.IDHeritageCommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 非遗大屏设置Controller
 * 
 * @author huzd
 * @date 2022-09-21
 */
@RestController
@RequestMapping("/screenSet/heritageSet")
public class HeritageSetController extends BaseController
{
    @Autowired
    private IDHeritageCommentService dHeritageCommentService;

    @Autowired
    private IBIchInfoService ibIchInfoService;

    /**
     * 非遗评论列表
     * @author huzd
     * @date 2022-09-21 14:59
     * @param dHeritageComment
     * @return com.ruoyi.common.core.page.TableDataInfo
     */
    @GetMapping("/listComment")
    public AjaxResult listComment(DHeritageComment dHeritageComment){
        List<DHeritageComment> list = dHeritageCommentService.selectDHeritageCommentList(dHeritageComment);
        return AjaxResult.success(list);
    }

    /**
     * 非遗列表
     * @author huzd
     * @date 2022-09-21 14:59
     * @param bIchInfo
     * @return com.ruoyi.common.core.page.TableDataInfo
     */
    @GetMapping("/listHeritage")
    public AjaxResult listHeritage(BIchInfo bIchInfo){
        List<BIchInfo> list = ibIchInfoService.selectBIchInfoList(bIchInfo);
        /*DHeritageComment dHeritageComment = new DHeritageComment();
        for(BIchInfo item : list){
            dHeritageComment.setProjectId(Long.valueOf(item.getIchId()));
            List<DHeritageComment> dHeritageCommentList = dHeritageCommentService.selectDHeritageCommentList(dHeritageComment);
            item.setHeritageCommentList(dHeritageCommentList);
        }*/
        return AjaxResult.success(list);
    }

    /**
     * 查询非遗评论列表
     */
    @PreAuthorize("@ss.hasPermi('screenSet:heritageComment:list')")
    @GetMapping("/list")
    public TableDataInfo list(DHeritageComment dHeritageComment)
    {
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
        return AjaxResult.success(dHeritageCommentService.selectDHeritageCommentById(id));
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
