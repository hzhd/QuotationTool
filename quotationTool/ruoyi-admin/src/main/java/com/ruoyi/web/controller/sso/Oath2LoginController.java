package com.ruoyi.web.controller.sso;

import com.google.common.hash.Hashing;
import com.ruoyi.framework.sso.*;
import org.apache.commons.lang3.BooleanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseCookie;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;
import org.springframework.web.util.WebUtils;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.nio.charset.StandardCharsets;
import java.time.Duration;

@RestController
@RequestMapping("/oauth2/login")
public class Oath2LoginController {

    private static final Logger log = LoggerFactory.getLogger(Oath2LoginController.class);

    @Autowired
    @Qualifier("Adfs2Login")
    private Oauth2LoginTokenService adfsLoginTokenService;

//    @Autowired
//    @Qualifier("Oauth2Login")
//    private Oauth2LoginTokenService ciamLoginTokenService;

    @Value("${home.page}")
    private String homePage;



    @RequestMapping(value = "/adfs/logout", method = RequestMethod.GET)
    public void adfsLogoutPage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        httpServletResponse.setStatus(302);
        httpServletResponse.setHeader("Location", homePage);
    }

    @RequestMapping(value = "/adfs_callback", method = RequestMethod.GET)
    public void adfsCallbackPage(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        httpServletResponse.setStatus(302);
        httpServletResponse.setHeader("Location", homePage);

        try {
            String state = httpServletRequest.getParameter("state");
            String code = httpServletRequest.getParameter("code");
            Cookie cookie = WebUtils.getCookie(httpServletRequest, "auth-state-token");
            String stateTokenCookie = cookie.getValue();
            String stateTokenSha256hex = Hashing.sha256()
                    .hashString(state, StandardCharsets.UTF_8)
                    .toString();

            if(StringUtils.isNotEmpty(stateTokenCookie)&&stateTokenCookie.equals(stateTokenSha256hex)){
                Oath2LoginRequest oath2LoginRequest = new Oath2LoginRequest();
                oath2LoginRequest.setCode(code);
                AdfsHttpResponse<LoginResponse> resp = adfsLoginTokenService.getOauth2Token(oath2LoginRequest);


                if(StringUtils.isNotEmpty(resp.getData().getToken())){
                    ResponseCookie tokenCookie = ResponseCookie.from("adfs-token", resp.getData().getToken()).path("/").maxAge(Duration.ofMinutes((long) 50))
                            .httpOnly(false).build();
                    httpServletResponse.addHeader("Set-Cookie", tokenCookie.toString());

                    //set bosch id token hint for logout
                    ResponseCookie respIdTokenHintCookie = ResponseCookie.from("adfs-token-hint", resp.getData().getTokenHint()).path("/").maxAge(Duration.ofMinutes((long) 50))
                            .httpOnly(false).build();
                    httpServletResponse.addHeader("Set-Cookie", respIdTokenHintCookie.toString());
                }

                String needBind = BooleanUtils.toString(resp.getData().getNeedBind(),"true",  "false", "false");

                ResponseCookie needBindCookie = ResponseCookie.from("needBind",needBind ).path("/").maxAge(Duration.ofMinutes((long) 50))
                        .httpOnly(false).build();

                httpServletResponse.addHeader("Set-Cookie", needBindCookie.toString());

                if(null !=resp.getData().getLoginUser()){

                    ResponseCookie userNameCookie = ResponseCookie.from("UserName", resp.getData().getLoginUser().getUserName()).path("/").maxAge(Duration.ofMinutes((long) 50))
                            .httpOnly(false).build();
                    ResponseCookie userId = ResponseCookie.from("UserId", resp.getData().getLoginUser().getUserId().toString()).path("/").maxAge(Duration.ofMinutes((long) 50))
                            .httpOnly(false).build();

                    httpServletResponse.addHeader("Set-Cookie", userNameCookie.toString());
                    httpServletResponse.addHeader("Set-Cookie", userId.toString());
                }
            }else{
                ResponseCookie errorCodeCookie = ResponseCookie.from("error_code", String.valueOf(HttpResponseEnum.AUTH_STATUS_INCONSISTENT.getResponseCode())).path("/").maxAge(Duration.ofMinutes((long) 50))
                        .httpOnly(false).build();
                ResponseCookie errorMsgCookie = ResponseCookie.from("error_msg", HttpResponseEnum.AUTH_STATUS_INCONSISTENT.getResponseMSG()).path("/").maxAge(Duration.ofMinutes((long) 50))
                        .httpOnly(false).build();

                httpServletResponse.addHeader("Set-Cookie", errorCodeCookie.toString());
                httpServletResponse.addHeader("Set-Cookie", errorMsgCookie.toString());
            }
        } catch (UsernameNotFoundException e) {
            log.error("adfs/get/token error",e);

            ResponseCookie errorCodeCookie = ResponseCookie.from("error_code", String.valueOf(HttpResponseEnum.USER_NOT_FOUND.getResponseCode())).path("/").maxAge(Duration.ofMinutes((long) 50))
                    .httpOnly(false).build();
            ResponseCookie errorMsgCookie = ResponseCookie.from("error_msg", "USER_NOT_FOUND").path("/").maxAge(Duration.ofMinutes((long) 50))
                    .httpOnly(false).build();

            httpServletResponse.addHeader("Set-Cookie", errorCodeCookie.toString());
            httpServletResponse.addHeader("Set-Cookie", errorMsgCookie.toString());
        }catch (Exception e) {
            log.error("adfs/get/token error",e);

            ResponseCookie errorCodeCookie = ResponseCookie.from("error_code", String.valueOf(HttpResponseEnum.FAILED.getResponseCode())).path("/").maxAge(Duration.ofMinutes((long) 50))
                    .httpOnly(false).build();
            ResponseCookie errorMsgCookie = ResponseCookie.from("error_msg", e.getMessage()).path("/").maxAge(Duration.ofMinutes((long) 50))
                    .httpOnly(false).build();

            httpServletResponse.addHeader("Set-Cookie", errorCodeCookie.toString());
            httpServletResponse.addHeader("Set-Cookie", errorMsgCookie.toString());
        }
    }

    @RequestMapping(value = "/adfs/authorize", method = RequestMethod.GET)
    public void method(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
        try{
            String ciamAuthorizeUrl = adfsLoginTokenService.getAuthorizeUrl(httpServletRequest);
            httpServletResponse.setHeader("Location", ciamAuthorizeUrl);

            MultiValueMap<String, String> parameters =
                    UriComponentsBuilder.fromUriString(ciamAuthorizeUrl).build().getQueryParams();
            String stateTokenSha256hex = Hashing.sha256()
                    .hashString(parameters.get("state").get(0), StandardCharsets.UTF_8)
                    .toString();

            String name = "auth-state-token";
            String value = stateTokenSha256hex;

            ResponseCookie cookie = ResponseCookie.from(name, value).path("/").maxAge(Duration.ofMinutes((long) 5))
                    .httpOnly(true).build();
            httpServletResponse.addHeader("Set-Cookie", cookie.toString());
            httpServletResponse.setStatus(302);
        }catch(Exception e){
            log.error(e.toString());
            httpServletResponse.setHeader("Location", homePage+"/#/login");
            httpServletResponse.setStatus(302);
        }

    }

}
