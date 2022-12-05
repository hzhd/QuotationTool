package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.ZRecordLedger;

/**
 * 档案台账Mapper接口
 * 
 * @author zhoujie
 * @date 2022-11-28
 */
public interface ZRecordLedgerMapper 
{
    /**
     * 查询档案台账
     * 
     * @param ledgerId 档案台账主键
     * @return 档案台账
     */
    public ZRecordLedger selectZRecordLedgerByLedgerId(Long ledgerId);

    /**
     * 查询档案台账列表
     * 
     * @param zRecordLedger 档案台账
     * @return 档案台账集合
     */
    public List<ZRecordLedger> selectZRecordLedgerList(ZRecordLedger zRecordLedger);

    /**
     * 新增档案台账
     * 
     * @param zRecordLedger 档案台账
     * @return 结果
     */
    public int insertZRecordLedger(ZRecordLedger zRecordLedger);

    /**
     * 修改档案台账
     * 
     * @param zRecordLedger 档案台账
     * @return 结果
     */
    public int updateZRecordLedger(ZRecordLedger zRecordLedger);

    /**
     * 删除档案台账
     * 
     * @param ledgerId 档案台账主键
     * @return 结果
     */
    public int deleteZRecordLedgerByLedgerId(Long ledgerId);

    /**
     * 批量删除档案台账
     * 
     * @param ledgerIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteZRecordLedgerByLedgerIds(Long[] ledgerIds);
}
