package com.ruoyi.framework.sso;

//import com.bosch.ae.tooling.management.entities.User;
import com.ruoyi.common.core.domain.entity.SysUser;
import lombok.Data;

import java.io.Serializable;

/**
 * @author : JiangHua2@cn.bosch.com
 * @description:
 * @date : 12/22/2021  2:39 PM
 */
@Data
public class LoginResponse implements Serializable {
    private static final long serialVersionUID = 1L;

    private String token;

    private String screenName;

    private String role;

    private String permToIncentivePenalty = "1";

    private Integer needChangePassword;

    private String tokenHint;

    private Boolean needBind;

    private SysUser loginUser;

    private Long id;

}
