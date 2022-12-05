package com.ruoyi.business.team.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.business.team.domain.Team;
import com.ruoyi.business.team.service.ITeamService;
import com.ruoyi.common.utils.poi.ExcelUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 团队管理Controller
 * 
 * @author zhouyz
 * @date 2022-11-28
 */
@RestController
@RequestMapping("/team/team")
@Api(tags="团队管理")
public class TeamController extends BaseController
{
    @Autowired
    private ITeamService teamService;

    /**
     * 查询团队管理列表
     */
   // @PreAuthorize("@ss.hasPermi('team:team:list')")
    @RequestMapping(path="/list",method={RequestMethod.POST,RequestMethod.GET})
    @ApiOperation(value="查询团队管理列表")
    public TableDataInfo list(@RequestBody Team team)
    {
        startPage();
        List<TeamVO> list = teamService.selectTeamList(team);
        return getDataTable(list);
    }

    /**
     * 导出团队管理列表
     */
    @ApiOperation(value="导出团队管理列表")
    @PreAuthorize("@ss.hasPermi('team:team:export')")
    @Log(title = "团队管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Team team)
    {
        List<TeamVO> list = teamService.selectTeamList(team);
        ExcelUtil<TeamVO> util = new ExcelUtil<TeamVO>(TeamVO.class);
        util.exportExcel(response, list, "团队管理数据");
    }

    /**
     * 获取团队管理详细信息
     */
    @PreAuthorize("@ss.hasPermi('team:team:query')")
    @GetMapping(value = "/{id}")
    @ApiOperation(value="查询团队详情")
    public AjaxResult getInfo(@PathVariable("id") Integer id)
    {
        return AjaxResult.success(teamService.selectTeamById(id));
    }

    /**
     * 新增团队管理
     */
    //@PreAuthorize("@ss.hasPermi('team:team:add')")
    @Log(title = "团队管理", businessType = BusinessType.INSERT)
    @PostMapping(value="/insert")
    @ApiOperation(value="新增团队")
    public AjaxResult add(@RequestBody Team team)
    {
        return toAjax(teamService.insertTeam(team));
    }

    /**
     * 修改团队管理
     */
    @PreAuthorize("@ss.hasPermi('team:team:edit')")
    @Log(title = "团队管理", businessType = BusinessType.UPDATE)
    @PostMapping(value="/edit")
    @ApiOperation(value="修改团队")
    public AjaxResult edit(@RequestBody Team team)
    {
        return toAjax(teamService.updateTeam(team));
    }

    /**
     * 删除团队管理
     */
    @PreAuthorize("@ss.hasPermi('team:team:remove')")
    @Log(title = "团队管理", businessType = BusinessType.DELETE)
    @PostMapping("/{ids}")
    @ApiOperation(value="删除团队")
    public AjaxResult remove(@PathVariable Integer[] ids)
    {
        return toAjax(teamService.deleteTeamByIds(ids));
    }
}
