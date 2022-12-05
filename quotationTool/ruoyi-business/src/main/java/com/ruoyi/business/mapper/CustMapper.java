package com.ruoyi.business.mapper;

import java.util.List;
import java.util.Map;

import com.ruoyi.business.media.domain.ScreenFuncConfig;

/**
 * 自定义sql接口
 * @author zhouyanzhao
 *
 */
public interface CustMapper {
	/**
	 * 按团队类型统计团队数量
	 * @return {teamType:'团队类型',teamNum:10}
	 */
	public List<Map<String,Integer>> getTeamCountByType();
	/**
	 * 根据功能编码查询大屏的功能配置参数
	 * @param funcCode
	 * @return
	 */
	public ScreenFuncConfig getScreenFuncConfig(String funcCode);
	/**
	 * 更新大屏的功能配置参数
	 * @param funcConfig
	 */
	public void replaceScreenFuncConfig(ScreenFuncConfig funcConfig);
	/**
	 * 查询数据字典项目label 
	 * @param args {dictType:'字典类型编码',dictValue:'项目值'}
	 * @return
	 */
	public List<String> selectDictLabel(Map<String,String> args);
}
