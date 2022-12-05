package com.ruoyi.business.common.service;

/**
 * 系统缓存数据管理
 * @author zhouyanzhao
 *
 */
public interface ICacheService {
	
	public static String DicCodePicType="pic_type";
	public static String DicCodeStadium="stadium";
	public static String DicCodeTeam="team";
	public static String DicCodeTeamType="team_type";
	/**
	 * 查询字典项的label
	 * @param dicCode 字典编码
	 * @param itemValue 字典项目的value
	 * @return
	 */
	public String getDicItemLabel(String dicCode,String itemValue);
}
