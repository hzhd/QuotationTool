package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.ZSensitivWord;

/**
 * sensitivMapper接口
 * 
 * @author zhoujie
 * @date 2022-11-25
 */
public interface ZSensitivWordMapper 
{
    /**
     * 查询sensitiv
     * 
     * @param sensitiveId sensitiv主键
     * @return sensitiv
     */
    public ZSensitivWord selectZSensitivWordBySensitiveId(Long sensitiveId);

    /**
     * 查询sensitiv列表
     * 
     * @param zSensitivWord sensitiv
     * @return sensitiv集合
     */
    public List<ZSensitivWord> selectZSensitivWordList(ZSensitivWord zSensitivWord);

    /**
     * 新增sensitiv
     * 
     * @param zSensitivWord sensitiv
     * @return 结果
     */
    public int insertZSensitivWord(ZSensitivWord zSensitivWord);

    /**
     * 修改sensitiv
     * 
     * @param zSensitivWord sensitiv
     * @return 结果
     */
    public int updateZSensitivWord(ZSensitivWord zSensitivWord);

    /**
     * 删除sensitiv
     * 
     * @param sensitiveId sensitiv主键
     * @return 结果
     */
    public int deleteZSensitivWordBySensitiveId(Long sensitiveId);

    /**
     * 批量删除sensitiv
     * 
     * @param sensitiveIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteZSensitivWordBySensitiveIds(Long[] sensitiveIds);
}
