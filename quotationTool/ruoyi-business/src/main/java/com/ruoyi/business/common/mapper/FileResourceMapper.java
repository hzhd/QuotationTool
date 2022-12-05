package com.ruoyi.business.common.mapper;

import java.util.List;
import com.ruoyi.business.common.domain.FileResource;

/**
 * 资源文件Mapper接口
 * 
 * @author ruoyi
 * @date 2022-11-28
 */
public interface FileResourceMapper 
{
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
     * 删除资源文件
     * 
     * @param id 资源文件主键
     * @return 结果
     */
    public int deleteFileResourceById(Integer id);

    /**
     * 批量删除资源文件
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteFileResourceByIds(Integer[] ids);
}
