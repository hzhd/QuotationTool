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
import com.ruoyi.business.domain.DSubscribePeople;
import com.ruoyi.business.service.IDSubscribePeopleService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 场馆预约人数Controller
 * 
 * @author ruoyi
 * @date 2022-09-22
 */
@RestController
@RequestMapping("/business/subPeople")
public class DSubscribePeopleController extends BaseController
{
    @Autowired
    private IDSubscribePeopleService dSubscribePeopleService;

    /**
     * 查询场馆预约人数列表
     */
    @PreAuthorize("@ss.hasPermi('business:subPeople:list')")
    @GetMapping("/list")
    public TableDataInfo list(DSubscribePeople dSubscribePeople)
    {
        startPage();
        List<DSubscribePeople> list = dSubscribePeopleService.selectDSubscribePeopleList(dSubscribePeople);
        return getDataTable(list);
    }

    /**
     * 导出场馆预约人数列表
     */
    @PreAuthorize("@ss.hasPermi('business:subPeople:export')")
    @Log(title = "场馆预约人数", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DSubscribePeople dSubscribePeople)
    {
        List<DSubscribePeople> list = dSubscribePeopleService.selectDSubscribePeopleList(dSubscribePeople);
        ExcelUtil<DSubscribePeople> util = new ExcelUtil<DSubscribePeople>(DSubscribePeople.class);
        util.exportExcel(response, list, "场馆预约人数数据");
    }

    /**
     * 获取场馆预约人数详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:subPeople:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(dSubscribePeopleService.selectDSubscribePeopleById(id));
    }

    /**
     * 新增场馆预约人数
     */
    @PreAuthorize("@ss.hasPermi('business:subPeople:add')")
    @Log(title = "场馆预约人数", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DSubscribePeople dSubscribePeople)
    {
        return toAjax(dSubscribePeopleService.insertDSubscribePeople(dSubscribePeople));
    }

    /**
     * 修改场馆预约人数
     */
    @PreAuthorize("@ss.hasPermi('business:subPeople:edit')")
    @Log(title = "场馆预约人数", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DSubscribePeople dSubscribePeople)
    {
        return toAjax(dSubscribePeopleService.updateDSubscribePeople(dSubscribePeople));
    }

    /**
     * 删除场馆预约人数
     */
    @PreAuthorize("@ss.hasPermi('business:subPeople:remove')")
    @Log(title = "场馆预约人数", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(dSubscribePeopleService.deleteDSubscribePeopleByIds(ids));
    }


    /**
     * 查询场馆预约人数列表
     */
    @GetMapping("/nums")
    public TableDataInfo nums(DSubscribePeople dSubscribePeople)
    {
        startPage();
        List<DSubscribePeople> list = dSubscribePeopleService.selectAll(dSubscribePeople);
        return getDataTable(list);
    }

}
