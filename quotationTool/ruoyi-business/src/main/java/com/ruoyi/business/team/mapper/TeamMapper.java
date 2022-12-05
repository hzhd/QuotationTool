package com.ruoyi.business.team.mapper;

import java.util.List;

import com.ruoyi.business.team.controller.TeamVO;
import com.ruoyi.business.team.domain.Team;

/**
 * 团队管理Mapper接口
 * 
 * @author zhouyz
 * @date 2022-11-28
 */
public interface TeamMapper 
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
     * 删除团队管理
     * 
     * @param id 团队管理主键
     * @return 结果
     */
    public int deleteTeamById(Integer id);

    /**
     * 批量删除团队管理
     * 
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteTeamByIds(Integer[] ids);
}
