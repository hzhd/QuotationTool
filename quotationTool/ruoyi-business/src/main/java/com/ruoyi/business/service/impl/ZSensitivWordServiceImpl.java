package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.ZSensitivWordMapper;
import com.ruoyi.business.domain.ZSensitivWord;
import com.ruoyi.business.service.IZSensitivWordService;

/**
 * sensitivService业务层处理
 * 
 * @author zhoujie
 * @date 2022-11-25
 */
@Service
public class ZSensitivWordServiceImpl implements IZSensitivWordService 
{
    @Autowired
    private ZSensitivWordMapper zSensitivWordMapper;

    /**
     * 查询sensitiv
     * 
     * @param sensitiveId sensitiv主键
     * @return sensitiv
     */
    @Override
    public ZSensitivWord selectZSensitivWordBySensitiveId(Long sensitiveId)
    {
        return zSensitivWordMapper.selectZSensitivWordBySensitiveId(sensitiveId);
    }

    /**
     * 查询sensitiv列表
     * 
     * @param zSensitivWord sensitiv
     * @return sensitiv
     */
    @Override
    public List<ZSensitivWord> selectZSensitivWordList(ZSensitivWord zSensitivWord)
    {
        return zSensitivWordMapper.selectZSensitivWordList(zSensitivWord);
    }

    /**
     * 新增sensitiv
     * 
     * @param zSensitivWord sensitiv
     * @return 结果
     */
    @Override
    public int insertZSensitivWord(ZSensitivWord zSensitivWord)
    {
        zSensitivWord.setCreateTime(DateUtils.getNowDate());
        return zSensitivWordMapper.insertZSensitivWord(zSensitivWord);
    }

    /**
     * 修改sensitiv
     * 
     * @param zSensitivWord sensitiv
     * @return 结果
     */
    @Override
    public int updateZSensitivWord(ZSensitivWord zSensitivWord)
    {
        zSensitivWord.setUpdateTime(DateUtils.getNowDate());
        return zSensitivWordMapper.updateZSensitivWord(zSensitivWord);
    }

    /**
     * 批量删除sensitiv
     * 
     * @param sensitiveIds 需要删除的sensitiv主键
     * @return 结果
     */
    @Override
    public int deleteZSensitivWordBySensitiveIds(Long[] sensitiveIds)
    {
        return zSensitivWordMapper.deleteZSensitivWordBySensitiveIds(sensitiveIds);
    }

    /**
     * 删除sensitiv信息
     * 
     * @param sensitiveId sensitiv主键
     * @return 结果
     */
    @Override
    public int deleteZSensitivWordBySensitiveId(Long sensitiveId)
    {
        return zSensitivWordMapper.deleteZSensitivWordBySensitiveId(sensitiveId);
    }
}
