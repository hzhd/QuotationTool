package com.ruoyi.business.media.service.impl;

import java.util.List;
import java.util.Map;

import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.media.mapper.PictureMapper;
import com.ruoyi.business.media.domain.Picture;
import com.ruoyi.business.media.service.IPictureService;

/**
 * 图片基本信息库Service业务层处理
 * 
 * @author zhouyz
 * @date 2022-11-27
 */
@Service
public class PictureServiceImpl implements IPictureService 
{
    @Autowired
    private PictureMapper pictureMapper;

    /**
     * 查询图片基本信息库
     * 
     * @param id 图片基本信息库主键
     * @return 图片基本信息库
     */
    @Override
    public Picture selectPictureById(Long id)
    {
        return pictureMapper.selectPictureById(id);
    }

    /**
     * 查询图片基本信息库列表
     * 
     * @param picture 图片基本信息库
     * @return 图片基本信息库
     */
    @Override
    public List<Picture> selectPictureList(Picture picture)
    {
        return pictureMapper.selectPictureList(picture);
    }

    /**
     * 新增图片基本信息库
     * 
     * @param picture 图片基本信息库
     * @return 结果
     */
    @Override
    public int insertPicture(Picture picture)
    {
        picture.setCreateTime(DateUtils.getNowDate());
        return pictureMapper.insertPicture(picture);
    }

    /**
     * 修改图片基本信息库
     * 
     * @param picture 图片基本信息库
     * @return 结果
     */
    @Override
    public int updatePicture(Picture picture)
    {
    	Long id=picture.getId();
    	if(id==null)
    		throw new IllegalArgumentException("缺少必需参数:id");
    	Picture oldPic=this.selectPictureById(id);
    	if(oldPic==null)
    		throw new IllegalArgumentException("没有查询到匹配的图片记录");
    	if(oldPic.getPicStatus()!=Picture.PicStatusInit &&
    			oldPic.getPicStatus()!=Picture.PicStatusRefused)
    		throw new IllegalArgumentException("图片已提交审核或审核已通过，无法修改！");
        picture.setUpdateTime(DateUtils.getNowDate());
        return pictureMapper.updatePicture(picture);
    }

    /**
     * 批量删除图片基本信息库
     * 
     * @param ids 需要删除的图片基本信息库主键
     * @return 结果
     */
    @Override
    public int deletePictureByIds(Long[] ids)
    {
        int count=0;
        for(Long id:ids){
        	count+=this.deletePictureById(id);
        }
        return count;
    }

    /**
     * 删除图片基本信息库信息
     * 
     * @param id 图片基本信息库主键
     * @return 结果
     */
    @Override
    public int deletePictureById(Long id)
    {
    	if(id==null)
    		throw new IllegalArgumentException("缺少必需参数:id");
    	Picture oldPic=this.selectPictureById(id);
    	if(oldPic==null)
    		throw new IllegalArgumentException("没有查询到匹配的图片记录");
    	if(oldPic.getPicStatus()!=Picture.PicStatusInit||
    			oldPic.getPicStatus()!=Picture.PicStatusRefused)
    		throw new IllegalArgumentException("图片已提交审核或审核已通过，无法删除！");
    	oldPic.setDelTag(1);
        return pictureMapper.updatePicture(oldPic);
    }



    /**
     * 查询场馆信息
     * @return
     */
    @Override
    public List<Map<String,Object>>  queryStadiumList() {
        return pictureMapper.queryStadiumList();
    }
}
