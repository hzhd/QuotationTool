package com.ruoyi.web.controller.screenSet;

import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.util.StringUtil;
import com.ruoyi.business.constant.PublishChannel;
import com.ruoyi.business.domain.BActivityInfo;
import com.ruoyi.business.domain.BIchInfo;
import com.ruoyi.business.domain.DSubscribePeople;
import com.ruoyi.business.mapper.BIchInfoMapper;
import com.ruoyi.business.mapper.CustMapper;
import com.ruoyi.business.service.IBActivityInfoService;
import com.ruoyi.business.service.IDSubscribePeopleService;
import com.ruoyi.business.team.controller.TeamVO;
import com.ruoyi.business.team.service.ITeamService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.BaseEntity;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * 慕课信息大屏设置Controller
 * 
 * @author huzd
 * @date 2022-09-21
 */
@Api(tags="信息大屏设置")
@RestController
@RequestMapping("/screenSet/action")
public class ActionSetController extends BaseController
{
    @Autowired
    private IBActivityInfoService bActivityInfoService;

    @Autowired
    private IDSubscribePeopleService idSubscribePeopleService;
    @Autowired
	private BIchInfoMapper fyxmMapper;
	@Autowired
    private ITeamService teamService;
	@Autowired
	private CustMapper custMapper;
	private ComparatorByPublishDate comparatorByPublishDate=new ComparatorByPublishDate();


    /**
     * 活动信息配置
     * @author huzd
     * @date 2022-09-21 14:59
     * @param bActivityInfo
     * @return com.ruoyi.common.core.page.TableDataInfo
     */
    @GetMapping("/listAction")
    public AjaxResult listAction(BActivityInfo bActivityInfo){
        List<BActivityInfo> list = bActivityInfoService.selectBActivityInfoList(bActivityInfo);
        return AjaxResult.success(list);
    }

    /**
     * 查询预约统计列表
     */
    @GetMapping("/nums")
    public AjaxResult nums(DSubscribePeople dSubscribePeople)
    {
        Map<String, Object> resultMap = new HashMap<>();
        List<DSubscribePeople> list = idSubscribePeopleService.selectDSubscribePeopleList(dSubscribePeople);
        int peopleNoSum = 0;
        for(DSubscribePeople item : list){
            try {
                peopleNoSum+=Integer.valueOf(item.getPeopleNo());
            } catch (NumberFormatException e) {
                continue;
            }
        }
        resultMap.put("subscribePeople", list);
        resultMap.put("peopleNoSum", peopleNoSum);
        return AjaxResult.success(resultMap);
    }
    

	/**
     * 获取待发布的非遗项目列表<br>
     * @param chanelCode 需要发布的目标渠道，见 {@link PublishChannel}
     * 
     */
    @ApiOperation(value=" 获取待发布的非遗项目列表")
    @GetMapping(value = "fyxm/{chanelCode}")
    public AjaxResult getFyxmToPublish(@PathVariable("chanelCode") String chanelCode)
    {
    	//****************************查询需要发布到目标渠道的非遗项目ID TODO
    	//****************************查询符合发布条件的非遗项目，并按发布时间倒序排列
    	List<BIchInfo> list=this.fyxmMapper.selectBIchInfoList(null);
    	if(list!=null){//按发布时间倒序排列
    		Collections.sort(list, comparatorByPublishDate);
    	}
        return AjaxResult.success(list);
    }
    /**
     * 查询待发布的剧团列表<br>
     * @param chanelCode 需要发布的目标渠道，见 {@link PublishChannel}
     * 
     */
    @ApiOperation(value="查询待发布的剧团列表")
    @GetMapping(value = "jtjs/{chanelCode}")
    public AjaxResult getTeamIntro(@PathVariable("chanelCode") String chanelCode){
    	List<TeamVO> list = teamService.selectTeamList(null);
    	if(list!=null){//按发布时间倒序排列
    		Collections.sort(list,comparatorByPublishDate);
    	}
        return AjaxResult.success(list);
    }
    /**
     * 统计各类团队数量<br>
     * @param chanelCode 需要发布的目标渠道，见 {@link PublishChannel}
     * 
     */
    @ApiOperation(value="统计各类团队数量")
    @GetMapping(value = "tdzb/{chanelCode}")
    public AjaxResult getTeamCountByType(@PathVariable("chanelCode") String chanelCode){
    	List<Map<String,Integer>> list=this.custMapper.getTeamCountByType();
    	return AjaxResult.success(list);
    }
    /**
     * 查询大屏的功能配置参数
     * @param funcCode 功能编码
     * @return
     */
    @ApiOperation(value="查询大屏的功能配置参数")
    @GetMapping(value="/config/get")
    public AjaxResult getScreenFuncConfig(String funcCode){
    	if(StringUtil.isEmpty(funcCode))
    		throw new IllegalArgumentException("缺少必需参数:funcCode");
    	return AjaxResult.success(this.custMapper.getScreenFuncConfig(funcCode));
    }
    /**
     * 按媒体发布时间倒序排列
     * @author zhouyanzhao
     *
     */
   private static class ComparatorByPublishDate implements Comparator<BaseEntity>{

	@Override
	public int compare(BaseEntity o1, BaseEntity o2) {
		Date date1=o1.getUpdateTime()==null?o1.getCreateTime():o1.getUpdateTime();
		if(date1==null)
			date1=new Date();
		Date date2=o2.getUpdateTime()==null?o2.getCreateTime():o2.getUpdateTime();
		if(date2==null)
			date2=new Date();
		return Long.valueOf(date2.getTime()-date1.getTime()).intValue();
	}
	   
   }

}
