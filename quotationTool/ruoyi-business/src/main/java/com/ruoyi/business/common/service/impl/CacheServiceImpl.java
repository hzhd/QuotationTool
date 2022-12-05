package com.ruoyi.business.common.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.business.common.service.ICacheService;
import com.ruoyi.business.mapper.CustMapper;
import com.ruoyi.business.stadium.domain.Stadium;
import com.ruoyi.business.stadium.mapper.StadiumMapper;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.mapper.SysDictDataMapper;

@Service
public class CacheServiceImpl implements ICacheService{

	@Autowired
	private SysDictDataMapper dictMapper;
	@Autowired
	private StadiumMapper stadiumMapper;
	@Autowired
	private CustMapper custMapper;
	@Override
	public String getDicItemLabel(String dicCode, String itemValue) {
		if(StringUtils.isEmpty(dicCode)||StringUtils.isEmpty(itemValue))
			return "未知";
		else if(dicCode.equalsIgnoreCase(ICacheService.DicCodeStadium)){
			Stadium stadium=this.stadiumMapper.selectStadiumById(Long.valueOf(itemValue));
			if(stadium==null)
				return "未知";
			else
				return stadium.getStadiumName();
		}
		else{
			Map<String,String> args=new HashMap<String,String>();
			args.put("dictType", dicCode);
			args.put("dictValue", itemValue);
			List<String> list=this.custMapper.selectDictLabel(args);
			if(list==null||list.size()==0)
				return "未知字典项目"+itemValue;
			return list.get(0);
		}
			
	}

}
