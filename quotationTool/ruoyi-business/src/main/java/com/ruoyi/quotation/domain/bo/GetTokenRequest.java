package com.ruoyi.quotation.domain.bo;

import lombok.Data;

@Data
public class GetTokenRequest {
    private String secretkey;
    private String timestamp;
}
