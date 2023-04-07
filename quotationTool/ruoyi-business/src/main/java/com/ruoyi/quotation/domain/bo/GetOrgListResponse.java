package com.ruoyi.quotation.domain.bo;

import lombok.Data;

@Data
public class GetOrgListResponse {
   /* private Integer currPage;
    private Integer pageSize;
    private Integer totalCount;*/
    //部门ID
    private String id;
    //部门名称
    private String orgName;
    //部门code
    private String orgCode;
    //父节点 ID，若为 0，则为根节点
    private String parentId;
    //部门 path
    private String orgPath;
    //中文简称
    private String orgShortCn;
    //英文简称
    private String orgShortEn;
    //是否是虚拟组织 1 是，0 否
    private String invented;
    //组织的排序
    private String order;
    //组织的状态 1 可用，0 不可用
    private String status;
    //组织负责人 ID，多个以英文逗号“,”间隔
    private String principal;
    //企业微信组织 ID
    private String weChatId;
    //组织维度
    private String dimension;

}
