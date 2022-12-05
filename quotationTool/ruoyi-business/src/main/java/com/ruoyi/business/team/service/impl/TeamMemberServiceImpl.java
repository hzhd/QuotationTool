package com.ruoyi.business.team.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.business.team.controller.TeamVO;
import com.ruoyi.business.team.domain.Team;
import com.ruoyi.business.team.domain.TeamMember;
import com.ruoyi.business.team.mapper.TeamMapper;
import com.ruoyi.business.team.mapper.TeamMemberMapper;
import com.ruoyi.business.team.service.ITeamMemberService;
import com.ruoyi.common.utils.DateUtils;

/**
 * 团队成员Service业务层处理
 * 
 * @author zhouyz
 * @date 2022-11-28
 */
@Service
public class TeamMemberServiceImpl implements ITeamMemberService 
{
    @Autowired
    private TeamMemberMapper teamMemberMapper;
    @Autowired
    private TeamMapper teamMapper;

    /**
     * 查询团队成员
     * 
     * @param id 团队成员主键
     * @return 团队成员
     */
    @Override
    public TeamMember selectTeamMemberById(Integer id)
    {
        return teamMemberMapper.selectTeamMemberById(id);
    }

    /**
     * 查询团队成员列表
     * 
     * @param teamMember 团队成员
     * @return 团队成员
     */
    @Override
    public List<TeamMember> selectTeamMemberList(TeamMember teamMember)
    {
        return teamMemberMapper.selectTeamMemberList(teamMember);
    }

    /**
     * 新增团队成员
     * 
     * @param teamMember 团队成员
     * @return 结果
     */
    @Override
    public int insertTeamMember(TeamMember teamMember)
    {
    	this.changeTeamMemberNum(teamMember.getTeamId(),1);
        return teamMemberMapper.insertTeamMember(teamMember);
    }

    /**
     * 修改团队成员
     * 
     * @param teamMember 团队成员
     * @return 结果
     */
    @Override
    public int updateTeamMember(TeamMember teamMember)
    {
        teamMember.setUpdateTime(DateUtils.getNowDate());
        return teamMemberMapper.updateTeamMember(teamMember);
    }

    /**
     * 批量删除团队成员
     * 
     * @param ids 需要删除的团队成员主键
     * @return 结果
     */
    @Override
    public int deleteTeamMemberByIds(Integer[] ids)
    {
    	if(ids==null||ids.length==0)
    		return 0;
    	TeamMember teamMember=this.teamMemberMapper.selectTeamMemberById(ids[0]);
    	if(teamMember==null)
    		throw new IllegalArgumentException("没有匹配的成员记录");
    	this.changeTeamMemberNum(teamMember.getTeamId(),-1*ids.length);
        return teamMemberMapper.deleteTeamMemberByIds(ids);
    }

    /**
     * 删除团队成员信息
     * 
     * @param id 团队成员主键
     * @return 结果
     */
    @Override
    public int deleteTeamMemberById(Integer id)
    { 
    	TeamMember teamMember=this.teamMemberMapper.selectTeamMemberById(id);
    	if(teamMember==null)
    		throw new IllegalArgumentException("没有匹配的成员记录");
    	teamMember.setCreateTime(DateUtils.getNowDate());
    	this.changeTeamMemberNum(teamMember.getTeamId(),-1);
        return teamMemberMapper.deleteTeamMemberById(id);
    }
    /**
     * 更新团队成员数
     * @param teamId 团队记录ID
     * @param memberNum 需要增减的成员数量
     */
    private void changeTeamMemberNum(Integer teamId,int memberNum){
    	if(teamId==null)
    		throw new IllegalArgumentException("成员缺少必需的归属团队参数");
    	TeamVO team=this.teamMapper.selectTeamById(teamId);
    	if(team==null)
    		throw new IllegalArgumentException("成员的归属团队不存在");
    	Team updatedTeam=new Team();
    	updatedTeam.setId(team.getId());
    	updatedTeam.setRecVersion(team.getRecVersion());
    	updatedTeam.setMemberNum(team.getMemberNum()+memberNum); 	        
        this.teamMapper.updateTeam(updatedTeam);
    }
}
