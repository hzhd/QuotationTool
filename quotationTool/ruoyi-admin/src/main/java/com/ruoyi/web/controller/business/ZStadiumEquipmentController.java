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
import com.ruoyi.business.domain.ZStadiumEquipment;
import com.ruoyi.business.service.IZStadiumEquipmentService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 租赁设备Controller
 * 
 * @author zhoujie
 * @date 2022-11-28
 */
@RestController
@RequestMapping("/business/equipment")
public class ZStadiumEquipmentController extends BaseController
{
    @Autowired
    private IZStadiumEquipmentService zStadiumEquipmentService;

    /**
     * 查询租赁设备列表
     */
    @PreAuthorize("@ss.hasPermi('business:equipment:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZStadiumEquipment zStadiumEquipment)
    {
        startPage();
        List<ZStadiumEquipment> list = zStadiumEquipmentService.selectZStadiumEquipmentList(zStadiumEquipment);
        return getDataTable(list);
    }

    /**
     * 导出租赁设备列表
     */
    @PreAuthorize("@ss.hasPermi('business:equipment:export')")
    @Log(title = "租赁设备", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ZStadiumEquipment zStadiumEquipment)
    {
        List<ZStadiumEquipment> list = zStadiumEquipmentService.selectZStadiumEquipmentList(zStadiumEquipment);
        ExcelUtil<ZStadiumEquipment> util = new ExcelUtil<ZStadiumEquipment>(ZStadiumEquipment.class);
        util.exportExcel(response, list, "租赁设备数据");
    }

    /**
     * 获取租赁设备详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:equipment:query')")
    @GetMapping(value = "/{equipmentId}")
    public AjaxResult getInfo(@PathVariable("equipmentId") Long equipmentId)
    {
        return AjaxResult.success(zStadiumEquipmentService.selectZStadiumEquipmentByEquipmentId(equipmentId));
    }

    /**
     * 新增租赁设备
     */
    @PreAuthorize("@ss.hasPermi('business:equipment:add')")
    @Log(title = "租赁设备", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZStadiumEquipment zStadiumEquipment)
    {
        return toAjax(zStadiumEquipmentService.insertZStadiumEquipment(zStadiumEquipment));
    }

    /**
     * 修改租赁设备
     */
    @PreAuthorize("@ss.hasPermi('business:equipment:edit')")
    @Log(title = "租赁设备", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZStadiumEquipment zStadiumEquipment)
    {
        return toAjax(zStadiumEquipmentService.updateZStadiumEquipment(zStadiumEquipment));
    }

    /**
     * 删除租赁设备
     */
    @PreAuthorize("@ss.hasPermi('business:equipment:remove')")
    @Log(title = "租赁设备", businessType = BusinessType.DELETE)
	@DeleteMapping("/{equipmentIds}")
    public AjaxResult remove(@PathVariable Long[] equipmentIds)
    {
        return toAjax(zStadiumEquipmentService.deleteZStadiumEquipmentByEquipmentIds(equipmentIds));
    }
}
