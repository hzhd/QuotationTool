package com.ruoyi.quotation.service;

import com.ruoyi.quotation.domain.Eshop;
import com.ruoyi.quotation.mapper.EshopMapper;

import java.util.List;

/**
 * 推送数据Service接口
 * 
 * @author huzd
 * @date 2023-03-01
 */
public interface IEshopService 
{
    /**
     * 查询推送数据
     * 
     * @param id 推送数据主键
     * @return 推送数据
     */
    public Eshop selectEshopById(Long id);

    /**
     * 查询推送数据列表
     * 
     * @param eshop 推送数据
     * @return 推送数据集合
     */
    public List<Eshop> selectEshopList(Eshop eshop);

    /**
     * 新增推送数据
     * 
     * @param eshop 推送数据
     * @return 结果
     */
    public int insertEshop(Eshop eshop);

    /**
     * 修改推送数据
     * 
     * @param eshop 推送数据
     * @return 结果
     */
    public int updateEshop(Eshop eshop);

    /**
     * 批量删除推送数据
     * 
     * @param ids 需要删除的推送数据主键集合
     * @return 结果
     */
    public int deleteEshopByIds(Long[] ids);

    /**
     * 删除推送数据信息
     * 
     * @param id 推送数据主键
     * @return 结果
     */
    public int deleteEshopById(Long id);

    /**
     * 校验手机号是否唯一
     *
     * @param phone
     * @return 结果
     */
    public String checkPhoneUnique(String phone);

}
