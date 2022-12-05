package com.ruoyi.business.team.service;

import java.util.List;

import com.ruoyi.business.team.controller.TeamVO;
import com.ruoyi.business.team.domain.Team;

/**
 * 团队管理Service接口
 * 
 * @author zhouyz
 * @date 2022-11-28
 */
public interface ITeamService 
{
    /**
     * 查询团队管理
     * 
     * @param id 团队管理主键
     * @return 团队管理
     */
    public TeamVO selectTeamById(Integer id);

    /**
     * 查询团队管理列表
     * 
     * @param team 团队管理
     * @return 团队管理集合
     */
    public List<TeamVO> selectTeamList(Team team);

    /**
     * 新增团队管理
     * 
     * @param team 团队管理
     * @return 结果
     */
    public int insertTeam(Team team);

    /**
     * 修改团队管理
     * 
     * @param team 团队管理
     * @return 结果
     */
    public int updateTeam(Team team);

    /**
     * 批量删除团队管理
     * 
     * @param ids 需要删除的团队管理主键集合
     * @return 结果
     */
    public int deleteTeamByIds(Integer[] ids);

    /**
     * 删除团队管理信息
     * 
     * @param id 团队管理主键
     * @return 结果
     */
    public int deleteTeamById(Integer id);
}
