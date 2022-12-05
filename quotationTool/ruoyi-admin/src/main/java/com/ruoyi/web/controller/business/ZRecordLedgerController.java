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
import com.ruoyi.business.domain.ZRecordLedger;
import com.ruoyi.business.service.IZRecordLedgerService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 档案台账Controller
 * 
 * @author zhoujie
 * @date 2022-11-28
 */
@RestController
@RequestMapping("/business/ledger")
public class ZRecordLedgerController extends BaseController
{
    @Autowired
    private IZRecordLedgerService zRecordLedgerService;

    /**
     * 查询档案台账列表
     */
    @PreAuthorize("@ss.hasPermi('business:ledger:list')")
    @GetMapping("/list")
    public TableDataInfo list(ZRecordLedger zRecordLedger)
    {
        startPage();
        List<ZRecordLedger> list = zRecordLedgerService.selectZRecordLedgerList(zRecordLedger);
        return getDataTable(list);
    }

    /**
     * 导出档案台账列表
     */
    @PreAuthorize("@ss.hasPermi('business:ledger:export')")
    @Log(title = "档案台账", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, ZRecordLedger zRecordLedger)
    {
        List<ZRecordLedger> list = zRecordLedgerService.selectZRecordLedgerList(zRecordLedger);
        ExcelUtil<ZRecordLedger> util = new ExcelUtil<ZRecordLedger>(ZRecordLedger.class);
        util.exportExcel(response, list, "档案台账数据");
    }

    /**
     * 获取档案台账详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:ledger:query')")
    @GetMapping(value = "/{ledgerId}")
    public AjaxResult getInfo(@PathVariable("ledgerId") Long ledgerId)
    {
        return AjaxResult.success(zRecordLedgerService.selectZRecordLedgerByLedgerId(ledgerId));
    }

    /**
     * 新增档案台账
     */
    @PreAuthorize("@ss.hasPermi('business:ledger:add')")
    @Log(title = "档案台账", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody ZRecordLedger zRecordLedger)
    {
        return toAjax(zRecordLedgerService.insertZRecordLedger(zRecordLedger));
    }

    /**
     * 修改档案台账
     */
    @PreAuthorize("@ss.hasPermi('business:ledger:edit')")
    @Log(title = "档案台账", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody ZRecordLedger zRecordLedger)
    {
        return toAjax(zRecordLedgerService.updateZRecordLedger(zRecordLedger));
    }

    /**
     * 删除档案台账
     */
    @PreAuthorize("@ss.hasPermi('business:ledger:remove')")
    @Log(title = "档案台账", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ledgerIds}")
    public AjaxResult remove(@PathVariable Long[] ledgerIds)
    {
        return toAjax(zRecordLedgerService.deleteZRecordLedgerByLedgerIds(ledgerIds));
    }
}
