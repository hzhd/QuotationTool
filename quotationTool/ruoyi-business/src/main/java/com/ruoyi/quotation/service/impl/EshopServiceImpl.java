package com.ruoyi.quotation.service.impl;

import java.util.List;

import com.ruoyi.common.constant.UserConstants;
import com.ruoyi.common.utils.DateUtils;
import com.ruoyi.quotation.domain.Eshop;
import com.ruoyi.quotation.mapper.EshopMapper;
import com.ruoyi.quotation.service.IEshopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 推送数据Service业务层处理
 * 
 * @author huzd
 * @date 2023-03-01
 */
@Service
public class EshopServiceImpl implements IEshopService
{
    @Autowired
    private EshopMapper eshopMapper;

    /**
     * 查询推送数据
     * 
     * @param id 推送数据主键
     * @return 推送数据
     */
    @Override
    public Eshop selectEshopById(Long id)
    {
        return eshopMapper.selectEshopById(id);
    }

    /**
     * 查询推送数据列表
     * 
     * @param eshop 推送数据
     * @return 推送数据
     */
    @Override
    public List<Eshop> selectEshopList(Eshop eshop)
    {
        return eshopMapper.selectEshopList(eshop);
    }

    /**
     * 新增推送数据
     * 
     * @param eshop 推送数据
     * @return 结果
     */
    @Override
    public int insertEshop(Eshop eshop)
    {
        eshop.setCreateTime(DateUtils.getNowDate());
        return eshopMapper.insertEshop(eshop);
    }

    /**
     * 修改推送数据
     * 
     * @param eshop 推送数据
     * @return 结果
     */
    @Override
    public int updateEshop(Eshop eshop)
    {
        eshop.setUpdateTime(DateUtils.getNowDate());
        return eshopMapper.updateEshop(eshop);
    }

    /**
     * 批量删除推送数据
     * 
     * @param ids 需要删除的推送数据主键
     * @return 结果
     */
    @Override
    public int deleteEshopByIds(Long[] ids)
    {
        return eshopMapper.deleteEshopByIds(ids);
    }

    /**
     * 删除推送数据信息
     * 
     * @param id 推送数据主键
     * @return 结果
     */
    @Override
    public int deleteEshopById(Long id)
    {
        return eshopMapper.deleteEshopById(id);
    }

    /**
     * 校验手机号是否唯一
     *
     * @param phone
     * @return 结果
     */
    @Override
    public String checkPhoneUnique(String phone)
    {
        int count = eshopMapper.checkPhoneUnique(phone);
        if (count > 0)
        {
            return "0";
        }
        return "1";
    }
}
