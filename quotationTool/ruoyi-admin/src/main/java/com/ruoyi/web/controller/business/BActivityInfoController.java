package com.ruoyi.web.controller.business;

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
import com.ruoyi.business.domain.BActivityInfo;
import com.ruoyi.business.service.IBActivityInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 活动库数据Controller
 *
 * @author ruoyi
 * @date 2022-11-25
 */
@RestController
@RequestMapping("/business/activity")
public class BActivityInfoController extends BaseController
{
    @Autowired
    private IBActivityInfoService bActivityInfoService;

    /**
     * 查询活动库数据列表
     */
    @PreAuthorize("@ss.hasPermi('business:activity:list')")
    @GetMapping("/list")
    public TableDataInfo list(BActivityInfo bActivityInfo)
    {
        startPage();
        List<BActivityInfo> list = bActivityInfoService.selectBActivityInfoList(bActivityInfo);
        return getDataTable(list);
    }


    /**
     * 导出活动库数据列表
     */
    @PreAuthorize("@ss.hasPermi('business:activity:export')")
    @Log(title = "活动库数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, BActivityInfo bActivityInfo)
    {
        List<BActivityInfo> list = bActivityInfoService.selectBActivityInfoList(bActivityInfo);
        ExcelUtil<BActivityInfo> util = new ExcelUtil<BActivityInfo>(BActivityInfo.class);
        util.exportExcel(response, list, "活动库数据数据");
    }

    /**
     * 获取活动库数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:activity:query')")
    @GetMapping(value = "/{activityId}")
    public AjaxResult getInfo(@PathVariable("activityId") Long activityId)
    {
        return AjaxResult.success(bActivityInfoService.selectBActivityInfoByActivityId(activityId));
    }

    /**
     * 新增活动库数据
     */
    @PreAuthorize("@ss.hasPermi('business:activity:add')")
    @Log(title = "活动库数据", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody BActivityInfo bActivityInfo)
    {
        return toAjax(bActivityInfoService.insertBActivityInfo(bActivityInfo));
    }

    /**
     * 修改活动库数据
     */
    @PreAuthorize("@ss.hasPermi('business:activity:edit')")
    @Log(title = "活动库数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody BActivityInfo bActivityInfo)
    {
        return toAjax(bActivityInfoService.updateBActivityInfo(bActivityInfo));
    }

    /**
     * 删除活动库数据
     */
    @PreAuthorize("@ss.hasPermi('business:activity:remove')")
    @Log(title = "活动库数据", businessType = BusinessType.DELETE)
    @DeleteMapping("/{activityIds}")
    public AjaxResult remove(@PathVariable Long[] activityIds)
    {
        return toAjax(bActivityInfoService.deleteBActivityInfoByActivityIds(activityIds));
    }

    /**
     * 活动库首页展示
     */
    @GetMapping("/nums")
    public List<BActivityInfo> list()
    {
        List<BActivityInfo> list = bActivityInfoService.selectNums();
        return list;
    }



    /**
    *   查询出活动类型
    */
    @GetMapping("/actType")
    public TableDataInfo actType()
    {
        List<String> list = bActivityInfoService.actType();
        return getDataTable(list);
    }


    /**
     * 小程序文化活动页面，模糊查询 根据时间等
     */
    @PostMapping("/apiList")
    public TableDataInfo apiList(@RequestBody BActivityInfo bActivityInfo)
    {
        startPage();
        List<BActivityInfo> list = bActivityInfoService.selectBActivityInfoList(bActivityInfo);
        return getDataTable(list);
    }

    /**
     * 获取活动库数据
     */
    @GetMapping(value = "/details")
    public AjaxResult details(Long activityId)
    {
        return AjaxResult.success(bActivityInfoService.selectBActivityInfoByActivityId(activityId));
    }




}
