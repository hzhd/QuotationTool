package com.ruoyi.business.team.service;

import java.util.List;
import com.ruoyi.business.team.domain.TeamMember;

/**
 * 团队成员Service接口
 * 
 * @author zhouyz
 * @date 2022-11-28
 */
public interface ITeamMemberService 
{
    /**
     * 查询团队成员
     * 
     * @param id 团队成员主键
     * @return 团队成员
     */
    public TeamMember selectTeamMemberById(Integer id);

    /**
     * 查询团队成员列表
     * 
     * @param teamMember 团队成员
     * @return 团队成员集合
     */
    public List<TeamMember> selectTeamMemberList(TeamMember teamMember);

    /**
     * 新增团队成员
     * 
     * @param teamMember 团队成员
     * @return 结果
     */
    public int insertTeamMember(TeamMember teamMember);

    /**
     * 修改团队成员
     * 
     * @param teamMember 团队成员
     * @return 结果
     */
    public int updateTeamMember(TeamMember teamMember);

    /**
     * 批量删除团队成员
     * 
     * @param ids 需要删除的团队成员主键集合
     * @return 结果
     */
    public int deleteTeamMemberByIds(Integer[] ids);

    /**
     * 删除团队成员信息
     * 
     * @param id 团队成员主键
     * @return 结果
     */
    public int deleteTeamMemberById(Integer id);
}
