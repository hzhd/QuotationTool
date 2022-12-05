package com.ruoyi.business.media.service;

import java.util.List;
import java.util.Map;

import com.ruoyi.business.media.domain.Picture;

/**
 * 图片基本信息库Service接口
 * 
 * @author zhouyz
 * @date 2022-11-27
 */
public interface IPictureService 
{
    /**
     * 查询图片基本信息库
     * 
     * @param id 图片基本信息库主键
     * @return 图片基本信息库
     */
    public Picture selectPictureById(Long id);

    /**
     * 查询图片基本信息库列表
     * 
     * @param picture 图片基本信息库
     * @return 图片基本信息库集合
     */
    public List<Picture> selectPictureList(Picture picture);

    /**
     * 新增图片基本信息库
     * 
     * @param picture 图片基本信息库
     * @return 结果
     */
    public int insertPicture(Picture picture);

    /**
     * 修改图片基本信息库
     * 
     * @param picture 图片基本信息库
     * @return 结果
     */
    public int updatePicture(Picture picture);

    /**
     * 批量删除图片基本信息库
     * 
     * @param ids 需要删除的图片基本信息库主键集合
     * @return 结果
     */
    public int deletePictureByIds(Long[] ids);

    /**
     * 删除图片基本信息库信息
     * 
     * @param id 图片基本信息库主键
     * @return 结果
     */
    public int deletePictureById(Long id);

    /**
     * 查询场馆信息
     * @return
     */
    List<Map<String,Object>>  queryStadiumList();
}
