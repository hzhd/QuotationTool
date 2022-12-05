package com.ruoyi.business.common.service;

import java.util.List;
import com.ruoyi.business.common.domain.FileResource;

/**
 * 资源文件Service接口
 * 
 * @author ruoyi
 * @date 2022-11-28
 */
public interface IFileResourceService 
{
	/**
     * 替换原有的文件资源<br>
     * @param bizId 业务记录ID
     * @param bizType 业务记录类型
     * @param contentType 文件类型
     * @param files 文件路径列表
     */
    public void replaceFileResource(Integer bizId,String bizType,Integer contentType,List<String> files);
    /**
     * 查询资源文件
     * 
     * @param id 资源文件主键
     * @return 资源文件
     */
    public FileResource selectFileResourceById(Integer id);

    /**
     * 查询资源文件列表
     * 
     * @param fileResource 资源文件
     * @return 资源文件集合
     */
    public List<FileResource> selectFileResourceList(FileResource fileResource);

    /**
     * 新增资源文件
     * 
     * @param fileResource 资源文件
     * @return 结果
     */
    public int insertFileResource(FileResource fileResource);

    /**
     * 修改资源文件
     * 
     * @param fileResource 资源文件
     * @return 结果
     */
    public int updateFileResource(FileResource fileResource);

    /**
     * 批量删除资源文件
     * 
     * @param ids 需要删除的资源文件主键集合
     * @return 结果
     */
    public int deleteFileResourceByIds(Integer[] ids);

    /**
     * 删除资源文件信息
     * 
     * @param id 资源文件主键
     * @return 结果
     */
    public int deleteFileResourceById(Integer id);
}
