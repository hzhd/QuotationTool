package com.ruoyi.business.media.service;

import java.util.List;
import com.ruoyi.business.media.domain.Screen;

/**
 * 大屏设备基本信息Service接口
 * 
 * @author zhouyz
 * @date 2022-11-28
 */
public interface IScreenService 
{
    /**
     * 查询大屏设备基本信息
     * 
     * @param id 大屏设备基本信息主键
     * @return 大屏设备基本信息
     */
    public Screen selectScreenById(Integer id);

    /**
     * 查询大屏设备基本信息列表
     * 
     * @param screen 大屏设备基本信息
     * @return 大屏设备基本信息集合
     */
    public List<Screen> selectScreenList(Screen screen);

    /**
     * 新增大屏设备基本信息
     * 
     * @param screen 大屏设备基本信息
     * @return 结果
     */
    public int insertScreen(Screen screen);

    /**
     * 修改大屏设备基本信息
     * 
     * @param screen 大屏设备基本信息
     * @return 结果
     */
    public int updateScreen(Screen screen);

    /**
     * 批量删除大屏设备基本信息
     * 
     * @param ids 需要删除的大屏设备基本信息主键集合
     * @return 结果
     */
    public int deleteScreenByIds(Integer[] ids);

    /**
     * 删除大屏设备基本信息信息
     * 
     * @param id 大屏设备基本信息主键
     * @return 结果
     */
    public int deleteScreenById(Integer id);
}
