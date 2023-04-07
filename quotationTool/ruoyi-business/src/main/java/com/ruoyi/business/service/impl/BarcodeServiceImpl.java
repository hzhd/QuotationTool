package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.BarcodeMapper;
import com.ruoyi.business.domain.Barcode;
import com.ruoyi.business.service.IBarcodeService;

/**
 * 生成二维码Service业务层处理
 * 
 * @author huzd
 * @date 2023-02-13
 */
@Service
public class BarcodeServiceImpl implements IBarcodeService 
{
    @Autowired
    private BarcodeMapper barcodeMapper;

    /**
     * 查询生成二维码
     * 
     * @param id 生成二维码主键
     * @return 生成二维码
     */
    @Override
    public Barcode selectBarcodeById(Long id)
    {
        return barcodeMapper.selectBarcodeById(id);
    }

    /**
     * 查询生成二维码列表
     * 
     * @param barcode 生成二维码
     * @return 生成二维码
     */
    @Override
    public List<Barcode> selectBarcodeList(Barcode barcode)
    {
        return barcodeMapper.selectBarcodeList(barcode);
    }

    /**
     * 新增生成二维码
     * 
     * @param barcode 生成二维码
     * @return 结果
     */
    @Override
    public int insertBarcode(Barcode barcode)
    {
        barcode.setCreateTime(DateUtils.getNowDate());
        return barcodeMapper.insertBarcode(barcode);
    }

    /**
     * 修改生成二维码
     * 
     * @param barcode 生成二维码
     * @return 结果
     */
    @Override
    public int updateBarcode(Barcode barcode)
    {
        barcode.setUpdateTime(DateUtils.getNowDate());
        return barcodeMapper.updateBarcode(barcode);
    }

    /**
     * 批量删除生成二维码
     * 
     * @param ids 需要删除的生成二维码主键
     * @return 结果
     */
    @Override
    public int deleteBarcodeByIds(Long[] ids)
    {
        return barcodeMapper.deleteBarcodeByIds(ids);
    }

    /**
     * 删除生成二维码信息
     * 
     * @param id 生成二维码主键
     * @return 结果
     */
    @Override
    public int deleteBarcodeById(Long id)
    {
        return barcodeMapper.deleteBarcodeById(id);
    }
}
