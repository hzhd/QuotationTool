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
import com.ruoyi.business.domain.DPeopleInfo;
import com.ruoyi.business.service.IDPeopleInfoService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 进出人数统计Controller
 * 
 * @author ruoyi
 * @date 2022-09-21
 */
@RestController
@RequestMapping("/business/people")
public class DPeopleInfoController extends BaseController
{
    @Autowired
    private IDPeopleInfoService dPeopleInfoService;

    /**
     * 查询进出人数统计列表
     */
    @PreAuthorize("@ss.hasPermi('business:people:list')")
    @GetMapping("/list")
    public TableDataInfo list(DPeopleInfo dPeopleInfo)
    {
        startPage();
        List<DPeopleInfo> list = dPeopleInfoService.selectDPeopleInfoList(dPeopleInfo);
        return getDataTable(list);
    }

    /**
     * 导出进出人数统计列表
     */
    @PreAuthorize("@ss.hasPermi('business:people:export')")
    @Log(title = "进出人数统计", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DPeopleInfo dPeopleInfo)
    {
        List<DPeopleInfo> list = dPeopleInfoService.selectDPeopleInfoList(dPeopleInfo);
        ExcelUtil<DPeopleInfo> util = new ExcelUtil<DPeopleInfo>(DPeopleInfo.class);
        util.exportExcel(response, list, "进出人数统计数据");
    }

    /**
     * 获取进出人数统计详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:people:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(dPeopleInfoService.selectDPeopleInfoById(id));
    }

    /**
     * 新增进出人数统计
     */
    @PreAuthorize("@ss.hasPermi('business:people:add')")
    @Log(title = "进出人数统计", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DPeopleInfo dPeopleInfo)
    {
        return toAjax(dPeopleInfoService.insertDPeopleInfo(dPeopleInfo));
    }

    /**
     * 修改进出人数统计
     */
    @PreAuthorize("@ss.hasPermi('business:people:edit')")
    @Log(title = "进出人数统计", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DPeopleInfo dPeopleInfo)
    {
        return toAjax(dPeopleInfoService.updateDPeopleInfo(dPeopleInfo));
    }

    /**
     * 删除进出人数统计
     */
    @PreAuthorize("@ss.hasPermi('business:people:remove')")
    @Log(title = "进出人数统计", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dPeopleInfoService.deleteDPeopleInfoByIds(ids));
    }


    /**
     * 进出人数统计
     * @author: liu
     * @date: 2022/9/21
     */
    @GetMapping("peopleNo")
    public List<DPeopleInfo> peopleNo(String type){
        List<DPeopleInfo> list = dPeopleInfoService.peopleNo(type);
        return list;
    }
}
