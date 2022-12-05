package com.ruoyi.web.controller.business;

import com.ruoyi.business.domain.ZAudio;
import com.ruoyi.business.service.IZAudioService;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 音视频库Controller
 * 
 * @author zhoujie
 * @date 2022-11-25
 */
@RestController
@RequestMapping("/business/audio")
public class ZAudioController extends BaseController
{
    @Autowired
    private IZAudioService zAudioService;

    /**
     * 查询音视频库列表
     */
    @PreAuthorize("@ss.hasPermi('business:audio:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZAudio zAudio)
    {
        startPage();
        List<ZAudio> list = zAudioService.selectZAudioList(zAudio);
        return getDataTable(list);
    }

    /**
     * 导出音视频库列表
     */
    @PreAuthorize("@ss.hasPermi('business:audio:export')")
    @Log(title = "音视频库", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ZAudio zAudio)
    {
        List<ZAudio> list = zAudioService.selectZAudioList(zAudio);
        ExcelUtil<ZAudio> util = new ExcelUtil<ZAudio>(ZAudio.class);
        util.exportExcel(response, list, "音视频库数据");
    }

    /**
     * 获取音视频库详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:audio:query')")
    @GetMapping(value = "/{audioId}")
    public AjaxResult getInfo(@PathVariable("audioId") Long audioId)
    {
        return AjaxResult.success(zAudioService.selectZAudioByAudioId(audioId));
    }

    /**
     * 新增音视频库
     */
    @PreAuthorize("@ss.hasPermi('business:audio:add')")
    @Log(title = "音视频库", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZAudio zAudio)
    {
        return toAjax(zAudioService.insertZAudio(zAudio));
    }

    /**
     * 修改音视频库
     */
    @PreAuthorize("@ss.hasPermi('business:audio:edit')")
    @Log(title = "音视频库", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZAudio zAudio)
    {
        return toAjax(zAudioService.updateZAudio(zAudio));
    }

    /**
     * 删除音视频库
     */
    @PreAuthorize("@ss.hasPermi('business:audio:remove')")
    @Log(title = "音视频库", businessType = BusinessType.DELETE)
	@DeleteMapping("/{audioIds}")
    public AjaxResult remove(@PathVariable Long[] audioIds)
    {
        return toAjax(zAudioService.deleteZAudioByAudioIds(audioIds));
    }
}
