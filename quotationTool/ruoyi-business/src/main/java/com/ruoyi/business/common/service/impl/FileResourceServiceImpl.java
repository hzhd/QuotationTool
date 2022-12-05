package com.ruoyi.business.common.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.common.mapper.FileResourceMapper;
import com.ruoyi.business.common.domain.FileResource;
import com.ruoyi.business.common.service.IFileResourceService;

/**
 * 资源文件Service业务层处理
 * 
 * @author ruoyi
 * @date 2022-11-28
 */
@Service
public class FileResourceServiceImpl implements IFileResourceService 
{
    @Autowired
    private FileResourceMapper fileResourceMapper;

    
    /**
     * 替换原有的文件资源<br>
     * <li>删除原有的文件资源记录
     * <li>新增当前的文件资源记录
     * @param bizId 业务记录ID
     * @param bizType 业务记录类型
     * @param contentType 文件类型
     * @param files 文件路径列表
     */
    @Override
    public void replaceFileResource(Integer bizId,String bizType,Integer contentType,List<String> files){    	
    	//***************************删除原有的文件资源记录
    	FileResource args=new FileResource();
    	args.setBizType(bizType);
    	args.setBizId(bizId);    	
    	args.setContentType(contentType);
    	List<FileResource> oldList=this.fileResourceMapper.selectFileResourceList(args);
    	if(oldList!=null&&oldList.size()>0){
    		Integer ids[]=new Integer[oldList.size()];
    		int index=0;
    		for(FileResource file:oldList){
    			ids[index]=file.getId();
    			index+=1;
    		}
    		this.fileResourceMapper.deleteFileResourceByIds(ids);
    	}
    	//***************************新增当前的文件资源记录
    	if(files==null||files.size()==0)
    		return;
    	for(String path:files){
    		FileResource file=new FileResource();
    		file.setBizId(bizId);
    		file.setBizType(bizType);
    		file.setContentType(contentType);
    		file.setFilePath(path);
    		this.fileResourceMapper.insertFileResource(file);
    	}
    	
    	
    	
    }
    /**
     * 查询资源文件
     * 
     * @param id 资源文件主键
     * @return 资源文件
     */
    @Override
    public FileResource selectFileResourceById(Integer id)
    {
        return fileResourceMapper.selectFileResourceById(id);
    }

    /**
     * 查询资源文件列表
     * 
     * @param fileResource 资源文件
     * @return 资源文件
     */
    @Override
    public List<FileResource> selectFileResourceList(FileResource fileResource)
    {
        return fileResourceMapper.selectFileResourceList(fileResource);
    }

    /**
     * 新增资源文件
     * 
     * @param fileResource 资源文件
     * @return 结果
     */
    @Override
    public int insertFileResource(FileResource fileResource)
    {
        fileResource.setCreateTime(DateUtils.getNowDate());
        return fileResourceMapper.insertFileResource(fileResource);
    }

    /**
     * 修改资源文件
     * 
     * @param fileResource 资源文件
     * @return 结果
     */
    @Override
    public int updateFileResource(FileResource fileResource)
    {
        fileResource.setUpdateTime(DateUtils.getNowDate());
        return fileResourceMapper.updateFileResource(fileResource);
    }

    /**
     * 批量删除资源文件
     * 
     * @param ids 需要删除的资源文件主键
     * @return 结果
     */
    @Override
    public int deleteFileResourceByIds(Integer[] ids)
    {
        return fileResourceMapper.deleteFileResourceByIds(ids);
    }

    /**
     * 删除资源文件信息
     * 
     * @param id 资源文件主键
     * @return 结果
     */
    @Override
    public int deleteFileResourceById(Integer id)
    {
        return fileResourceMapper.deleteFileResourceById(id);
    }
}
