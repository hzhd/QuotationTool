package com.ruoyi.screenSet.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.screenSet.mapper.DHeritageCommentMapper;
import com.ruoyi.screenSet.domain.DHeritageComment;
import com.ruoyi.screenSet.service.IDHeritageCommentService;

/**
 * 非遗评论Service业务层处理
 * 
 * @author huzd
 * @date 2022-09-21
 */
@Service
public class DHeritageCommentServiceImpl implements IDHeritageCommentService 
{
    @Autowired
    private DHeritageCommentMapper dHeritageCommentMapper;

    /**
     * 查询非遗评论
     * 
     * @param id 非遗评论主键
     * @return 非遗评论
     */
    @Override
    public DHeritageComment selectDHeritageCommentById(Long id)
    {
        DHeritageComment dHeritageComment = dHeritageCommentMapper.selectDHeritageCommentById(id);
        return dHeritageComment;
    }

    /**
     * 查询非遗评论列表
     * 
     * @param dHeritageComment 非遗评论
     * @return 非遗评论
     */
    @Override
    public List<DHeritageComment> selectDHeritageCommentList(DHeritageComment dHeritageComment)
    {
        List<DHeritageComment> dHeritageCommentList = dHeritageCommentMapper.selectDHeritageCommentList(dHeritageComment);
        return dHeritageCommentList;
    }

    /**
     * 新增非遗评论
     * 
     * @param dHeritageComment 非遗评论
     * @return 结果
     */
    @Override
    public int insertDHeritageComment(DHeritageComment dHeritageComment)
    {
        dHeritageComment.setCreateTime(DateUtils.getNowDate());
        return dHeritageCommentMapper.insertDHeritageComment(dHeritageComment);
    }

    /**
     * 修改非遗评论
     * 
     * @param dHeritageComment 非遗评论
     * @return 结果
     */
    @Override
    public int updateDHeritageComment(DHeritageComment dHeritageComment)
    {
        dHeritageComment.setUpdateTime(DateUtils.getNowDate());
        return dHeritageCommentMapper.updateDHeritageComment(dHeritageComment);
    }

    /**
     * 批量删除非遗评论
     * 
     * @param ids 需要删除的非遗评论主键
     * @return 结果
     */
    @Override
    public int deleteDHeritageCommentByIds(Long[] ids)
    {
        return dHeritageCommentMapper.deleteDHeritageCommentByIds(ids);
    }

    /**
     * 删除非遗评论信息
     * 
     * @param id 非遗评论主键
     * @return 结果
     */
    @Override
    public int deleteDHeritageCommentById(Long id)
    {
        return dHeritageCommentMapper.deleteDHeritageCommentById(id);
    }
}
