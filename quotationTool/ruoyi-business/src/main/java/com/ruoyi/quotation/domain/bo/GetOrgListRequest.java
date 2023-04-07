package com.ruoyi.quotation.domain.bo;


import lombok.Data;

@Data
public class GetOrgListRequest {
    private String clientId;
    private Integer currPage;
    private Integer pageSize;
}
