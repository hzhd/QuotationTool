package com.ruoyi.business;

import org.springframework.context.ApplicationContext;

import com.ruoyi.business.common.service.ICacheService;

public class GlobalConstant {
	public static ApplicationContext appContext=null;
	public static ICacheService cacheService=null;
	
	public static void init(ApplicationContext appCon){
		appContext=appCon;
		cacheService=appContext.getBean(ICacheService.class);
	}
	
	
	
	
}
