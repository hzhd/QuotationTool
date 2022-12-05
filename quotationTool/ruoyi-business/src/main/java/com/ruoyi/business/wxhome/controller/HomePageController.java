package com.ruoyi.business.wxhome.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruoyi.business.common.domain.FileResource;
import com.ruoyi.business.common.mapper.FileResourceMapper;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/wx/home")
@Api(tags="微信客户端首页")
public class HomePageController extends BaseController{

	@Autowired
	private FileResourceMapper fileMapper;
	/**
	 * 查询首页轮播图
	 * @return
	 */
	@ApiOperation("查询首页轮播图")
	@GetMapping(path="/slideshow")
	public AjaxResult getHomeSlideshow(){
		FileResource args=new FileResource();
		args.setBizType(FileResource.BizTypeWXHomeSlideshow);
		List<FileResource> files=this.fileMapper.selectFileResourceList(args);
		List<String> payload=new ArrayList<String>();
		if(files!=null){
			for(FileResource file:files){
				payload.add(file.getFilePath());
			}
		}
		return AjaxResult.success(payload);
	}
}
