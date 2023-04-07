package com.ruoyi.quotation.domain.bo;

import lombok.Data;

@Data
public class GetTokenResponse {
    private String token;
    private String expireTime;
}
