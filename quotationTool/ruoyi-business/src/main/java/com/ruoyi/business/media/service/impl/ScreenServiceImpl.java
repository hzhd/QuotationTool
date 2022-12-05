package com.ruoyi.business.media.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.media.mapper.ScreenMapper;
import com.ruoyi.business.media.domain.Screen;
import com.ruoyi.business.media.service.IScreenService;

/**
 * 大屏设备基本信息Service业务层处理
 * 
 * @author zhouyz
 * @date 2022-11-28
 */
@Service
public class ScreenServiceImpl implements IScreenService 
{
    @Autowired
    private ScreenMapper screenMapper;

    /**
     * 查询大屏设备基本信息
     * 
     * @param id 大屏设备基本信息主键
     * @return 大屏设备基本信息
     */
    @Override
    public Screen selectScreenById(Integer id)
    {
        return screenMapper.selectScreenById(id);
    }

    /**
     * 查询大屏设备基本信息列表
     * 
     * @param screen 大屏设备基本信息
     * @return 大屏设备基本信息
     */
    @Override
    public List<Screen> selectScreenList(Screen screen)
    {
        return screenMapper.selectScreenList(screen);
    }

    /**
     * 新增大屏设备基本信息
     * 
     * @param screen 大屏设备基本信息
     * @return 结果
     */
    @Override
    public int insertScreen(Screen screen)
    {
        screen.setCreateTime(DateUtils.getNowDate());
        return screenMapper.insertScreen(screen);
    }

    /**
     * 修改大屏设备基本信息
     * 
     * @param screen 大屏设备基本信息
     * @return 结果
     */
    @Override
    public int updateScreen(Screen screen)
    {
        screen.setUpdateTime(DateUtils.getNowDate());
        return screenMapper.updateScreen(screen);
    }

    /**
     * 批量删除大屏设备基本信息
     * 
     * @param ids 需要删除的大屏设备基本信息主键
     * @return 结果
     */
    @Override
    public int deleteScreenByIds(Integer[] ids)
    {
        return screenMapper.deleteScreenByIds(ids);
    }

    /**
     * 删除大屏设备基本信息信息
     * 
     * @param id 大屏设备基本信息主键
     * @return 结果
     */
    @Override
    public int deleteScreenById(Integer id)
    {
        return screenMapper.deleteScreenById(id);
    }
}
