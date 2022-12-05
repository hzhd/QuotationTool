package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.ZRecordLedgerMapper;
import com.ruoyi.business.domain.ZRecordLedger;
import com.ruoyi.business.service.IZRecordLedgerService;

/**
 * 档案台账Service业务层处理
 * 
 * @author zhoujie
 * @date 2022-11-28
 */
@Service
public class ZRecordLedgerServiceImpl implements IZRecordLedgerService 
{
    @Autowired
    private ZRecordLedgerMapper zRecordLedgerMapper;

    /**
     * 查询档案台账
     * 
     * @param ledgerId 档案台账主键
     * @return 档案台账
     */
    @Override
    public ZRecordLedger selectZRecordLedgerByLedgerId(Long ledgerId)
    {
        return zRecordLedgerMapper.selectZRecordLedgerByLedgerId(ledgerId);
    }

    /**
     * 查询档案台账列表
     * 
     * @param zRecordLedger 档案台账
     * @return 档案台账
     */
    @Override
    public List<ZRecordLedger> selectZRecordLedgerList(ZRecordLedger zRecordLedger)
    {
        return zRecordLedgerMapper.selectZRecordLedgerList(zRecordLedger);
    }

    /**
     * 新增档案台账
     * 
     * @param zRecordLedger 档案台账
     * @return 结果
     */
    @Override
    public int insertZRecordLedger(ZRecordLedger zRecordLedger)
    {
        zRecordLedger.setCreateTime(DateUtils.getNowDate());
        return zRecordLedgerMapper.insertZRecordLedger(zRecordLedger);
    }

    /**
     * 修改档案台账
     * 
     * @param zRecordLedger 档案台账
     * @return 结果
     */
    @Override
    public int updateZRecordLedger(ZRecordLedger zRecordLedger)
    {
        zRecordLedger.setUpdateTime(DateUtils.getNowDate());
        return zRecordLedgerMapper.updateZRecordLedger(zRecordLedger);
    }

    /**
     * 批量删除档案台账
     * 
     * @param ledgerIds 需要删除的档案台账主键
     * @return 结果
     */
    @Override
    public int deleteZRecordLedgerByLedgerIds(Long[] ledgerIds)
    {
        return zRecordLedgerMapper.deleteZRecordLedgerByLedgerIds(ledgerIds);
    }

    /**
     * 删除档案台账信息
     * 
     * @param ledgerId 档案台账主键
     * @return 结果
     */
    @Override
    public int deleteZRecordLedgerByLedgerId(Long ledgerId)
    {
        return zRecordLedgerMapper.deleteZRecordLedgerByLedgerId(ledgerId);
    }
}
