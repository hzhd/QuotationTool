package com.ruoyi.business.service;

import com.ruoyi.business.domain.Barcode;

import java.util.List;

/**
 * 生成二维码Service接口
 * 
 * @author huzd
 * @date 2023-02-13
 */
public interface IBarcodeService 
{
    /**
     * 查询生成二维码
     * 
     * @param id 生成二维码主键
     * @return 生成二维码
     */
    public Barcode selectBarcodeById(Long id);

    /**
     * 查询生成二维码列表
     * 
     * @param barcode 生成二维码
     * @return 生成二维码集合
     */
    public List<Barcode> selectBarcodeList(Barcode barcode);

    /**
     * 新增生成二维码
     * 
     * @param barcode 生成二维码
     * @return 结果
     */
    public int insertBarcode(Barcode barcode);

    /**
     * 修改生成二维码
     * 
     * @param barcode 生成二维码
     * @return 结果
     */
    public int updateBarcode(Barcode barcode);

    /**
     * 批量删除生成二维码
     * 
     * @param ids 需要删除的生成二维码主键集合
     * @return 结果
     */
    public int deleteBarcodeByIds(Long[] ids);

    /**
     * 删除生成二维码信息
     * 
     * @param id 生成二维码主键
     * @return 结果
     */
    public int deleteBarcodeById(Long id);
}
