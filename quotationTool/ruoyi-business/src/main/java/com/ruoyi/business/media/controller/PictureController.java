package com.ruoyi.business.media.controller;

import java.util.List;
import java.util.Map;
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
import com.ruoyi.business.media.domain.Picture;
import com.ruoyi.business.media.service.IPictureService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 图片基本信息库Controller
 * 
 * @author zhouyz
 * @date 2022-11-27
 */
@RestController
@RequestMapping("/media/picture")
public class PictureController extends BaseController
{
    @Autowired
    private IPictureService pictureService;

    /**
     * 查询图片基本信息库列表
     */
    @PreAuthorize("@ss.hasPermi('media:picture:list')")
    @GetMapping("/list")
    public TableDataInfo list(Picture picture)
    {
        startPage();
        List<Picture> list = pictureService.selectPictureList(picture);
        return getDataTable(list);
    }

    /**
     * 导出图片基本信息库列表
     */
    @PreAuthorize("@ss.hasPermi('media:picture:export')")
    @Log(title = "图片基本信息库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Picture picture)
    {
        List<Picture> list = pictureService.selectPictureList(picture);
        ExcelUtil<Picture> util = new ExcelUtil<Picture>(Picture.class);
        util.exportExcel(response, list, "图片基本信息库数据");
    }

    /**
     * 获取图片基本信息库详细信息
     */
    @PreAuthorize("@ss.hasPermi('media:picture:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(pictureService.selectPictureById(id));
    }

    /**
     * 新增图片基本信息库
     */
    @PreAuthorize("@ss.hasPermi('media:picture:add')")
    @Log(title = "图片基本信息库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Picture picture)
    {
        return toAjax(pictureService.insertPicture(picture));
    }

    /**
     * 修改图片基本信息库
     */
    @PreAuthorize("@ss.hasPermi('media:picture:edit')")
    @Log(title = "图片基本信息库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Picture picture)
    {
        return toAjax(pictureService.updatePicture(picture));
    }

    /**
     * 删除图片基本信息库
     */
    @PreAuthorize("@ss.hasPermi('media:picture:remove')")
    @Log(title = "图片基本信息库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(pictureService.deletePictureByIds(ids));
    }

    /**
     * 搜索场馆信息
     */
    @GetMapping(value = "queryStadium")
    public AjaxResult getStadium(){
        List<Map<String,Object>>  list =  pictureService.queryStadiumList();
        return AjaxResult.success(list);
    }


}
