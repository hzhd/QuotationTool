package com.ruoyi.screenSet.service;

import java.util.List;
import com.ruoyi.screenSet.domain.DHeritageComment;

/**
 * 非遗评论Service接口
 * 
 * @author huzd
 * @date 2022-09-21
 */
public interface IDHeritageCommentService 
{
    /**
     * 查询非遗评论
     * 
     * @param id 非遗评论主键
     * @return 非遗评论
     */
    public DHeritageComment selectDHeritageCommentById(Long id);

    /**
     * 查询非遗评论列表
     * 
     * @param dHeritageComment 非遗评论
     * @return 非遗评论集合
     */
    public List<DHeritageComment> selectDHeritageCommentList(DHeritageComment dHeritageComment);

    /**
     * 新增非遗评论
     * 
     * @param dHeritageComment 非遗评论
     * @return 结果
     */
    public int insertDHeritageComment(DHeritageComment dHeritageComment);

    /**
     * 修改非遗评论
     * 
     * @param dHeritageComment 非遗评论
     * @return 结果
     */
    public int updateDHeritageComment(DHeritageComment dHeritageComment);

    /**
     * 批量删除非遗评论
     * 
     * @param ids 需要删除的非遗评论主键集合
     * @return 结果
     */
    public int deleteDHeritageCommentByIds(Long[] ids);

    /**
     * 删除非遗评论信息
     * 
     * @param id 非遗评论主键
     * @return 结果
     */
    public int deleteDHeritageCommentById(Long id);
}
