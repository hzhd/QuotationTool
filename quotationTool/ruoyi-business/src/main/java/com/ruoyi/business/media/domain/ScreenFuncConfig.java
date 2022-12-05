package com.ruoyi.business.media.domain;

import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

import io.swagger.annotations.ApiModelProperty;

public class ScreenFuncConfig extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value=" 记录主键")
    private Integer id;

    @ApiModelProperty(value=" 功能编码")
    @Excel(name = "功能编码")
    private String funcCode;
    @ApiModelProperty(value=" 功能名称")
    @Excel(name = "功能名称")
    private String funcName;
    @ApiModelProperty(value=" 内容布局")
    @Excel(name = "内容布局")
    private String contentLayout;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFuncCode() {
		return funcCode;
	}
	public void setFuncCode(String funcCode) {
		this.funcCode = funcCode;
	}
	public String getFuncName() {
		return funcName;
	}
	public void setFuncName(String funcName) {
		this.funcName = funcName;
	}
	public String getContentLayout() {
		return contentLayout;
	}
	public void setContentLayout(String contentLayout) {
		this.contentLayout = contentLayout;
	}
}
