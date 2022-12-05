package com.ruoyi.business.team.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.business.GlobalConstant;
import com.ruoyi.business.common.domain.FileResource;
import com.ruoyi.business.common.mapper.FileResourceMapper;
import com.ruoyi.business.common.service.ICacheService;
import com.ruoyi.business.common.service.IFileResourceService;
import com.ruoyi.business.team.controller.TeamVO;
import com.ruoyi.business.team.domain.Team;
import com.ruoyi.business.team.mapper.TeamMapper;
import com.ruoyi.business.team.service.ITeamService;
import com.ruoyi.common.utils.DateUtils;

/**
 * 团队管理Service业务层处理
 * 
 * @author zhouyz
 * @date 2022-11-28
 */
@Service
public class TeamServiceImpl implements ITeamService 
{
    @Autowired
    private TeamMapper teamMapper;
    @Autowired
    private FileResourceMapper fileMapper;
    @Autowired
    private IFileResourceService fileService;

    /**
     * 查询团队管理
     * 
     * @param id 团队管理主键
     * @return 团队管理
     */
    @Override
    public TeamVO selectTeamById(Integer id)
    {
    	TeamVO team=teamMapper.selectTeamById(id);
    	if(team!=null){
    		this.loadFileResource(team);
    	}    		
        return team;
    }

    /**
     * 查询团队管理列表
     * 
     * @param team 团队管理
     * @return 团队管理
     */
    @Override
    public List<TeamVO> selectTeamList(Team team)
    {
    	if(team!=null){
    		if(team.getMinMemberNum()!=null&&team.getMinMemberNum()==0)
    			team.setMinMemberNum(null);
    		if(team.getMaxMemberNum()!=null&&team.getMaxMemberNum()==0)
    			team.setMaxMemberNum(null);
    	}
    	List<TeamVO> list=teamMapper.selectTeamList(team);
    	if(list!=null){
    		this.loadFileResource(list); 
    	}
    	return list;
    }
         

    /**
     * 新增团队管理
     * 
     * @param team 团队管理
     * @return 结果
     */
    @Override
    public int insertTeam(Team team)
    {
        team.setCreateTime(DateUtils.getNowDate());
        int count= teamMapper.insertTeam(team);
        this.fileService.replaceFileResource(team.getId(), FileResource.BizTypeTeamMinePic, 
        		FileResource.ContentTypePic, team.getMinePic());  
        this.fileService.replaceFileResource(team.getId(), FileResource.BizTypeTeamMineVideo, 
        		FileResource.ContentTypeVideo, team.getMineVideo());
        return count;
    }

    /**
     * 修改团队管理
     * 
     * @param team 团队管理
     * @return 结果
     */
    @Override
    public int updateTeam(Team team)
    {
        team.setUpdateTime(DateUtils.getNowDate());
        this.fileService.replaceFileResource(team.getId(), FileResource.BizTypeTeamMinePic, 
        		FileResource.ContentTypePic, team.getMinePic());  
        this.fileService.replaceFileResource(team.getId(), FileResource.BizTypeTeamMineVideo, 
        		FileResource.ContentTypeVideo, team.getMineVideo());
        return teamMapper.updateTeam(team);
    }

    /**
     * 批量删除团队管理
     * 
     * @param ids 需要删除的团队管理主键
     * @return 结果
     */
    @Override
    public int deleteTeamByIds(Integer[] ids)
    {
    	int count=0;
    	for(Integer id:ids){
    		count+=this.deleteTeamById(id);
    	}
        return count;
    }

    /**
     * 删除团队管理信息
     * 
     * @param id 团队管理主键
     * @return 结果
     */
    @Override
    public int deleteTeamById(Integer id)
    {
    	this.fileService.replaceFileResource(id, FileResource.BizTypeTeamMinePic, 
        		FileResource.ContentTypePic,null);  
        this.fileService.replaceFileResource(id, FileResource.BizTypeTeamMineVideo, 
        		FileResource.ContentTypeVideo, null);
        return teamMapper.deleteTeamById(id);
    }
    private void loadFileResource(List<TeamVO> teamList){
    	for(TeamVO team:teamList){
    		this.loadFileResource(team);
    	}
    }
    private void loadFileResource(TeamVO team){
    	FileResource args=new FileResource();
    	args.setBizType(FileResource.BizTypeTeamMinePic);
    	args.setBizId(team.getId());
    	List<FileResource> fileList=this.fileMapper.selectFileResourceList(args);
    	if(fileList!=null){
    		List<String> path=new ArrayList<String>();
    		for(FileResource file:fileList){
    			path.add(file.getFilePath());
    		}
    		team.setMinePic(path);
    	}    	
    	args.setBizType(FileResource.BizTypeTeamMineVideo);
    	fileList=this.fileMapper.selectFileResourceList(args);
    	if(fileList!=null){
    		List<String> path=new ArrayList<String>();
    		for(FileResource file:fileList){
    			path.add(file.getFilePath());
    		}
    		team.setMineVideo(path);
    	}
    }
    
}
