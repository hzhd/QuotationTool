package com.ruoyi.framework.sso;

import com.auth0.jwk.Jwk;
import com.auth0.jwk.JwkException;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.ruoyi.framework.web.service.SysLoginService;
import com.ruoyi.system.service.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.util.*;

@Service
@Qualifier("Adfs2Login")
public class AdfsLoginTokenServiceImpl implements Oauth2LoginTokenService {
    private static final Logger log = LoggerFactory.getLogger(AdfsLoginTokenServiceImpl.class);
    @Value("${adfs.clientId}")
    private String clientId;

    @Value("${adfs.clientSecret}")
    private String clientSecret;

    @Value("${adfs.redirectUrl}")
    private String redirectUrl;

    @Value("${adfs.serverUrl}")
    private String serverUrl;

    @Value("${adfs.tokenEndpoint}")
    private String tokenEndpoint;

    @Value("${adfs.grantType}")
    private String grantType;

    @Value("${adfs.authorizeEndpoint}")
    private String authorizeEndpoint;

    @Value("${adfs.responseType}")
    private String responseType;

    @Value("${adfs.scope}")
    private String scope;

    @Value("${adfs.jwksEndpoint}")
    private String jwksEndpoint;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private SysLoginService userService;
    @Override
    public AdfsHttpResponse<LoginResponse> getOauth2Token(Oath2LoginRequest oath2LoginRequest) throws NoSuchAlgorithmException, InvalidKeySpecException, JwkException, UnsupportedEncodingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        MultiValueMap<String, String> map= new LinkedMultiValueMap<String, String>();
        map.add("code", oath2LoginRequest.getCode());
        map.add("client_id", clientId);
        map.add("redirect_uri", redirectUrl);
        map.add("grant_type", grantType);
        map.add("client_secret", clientSecret);

        HttpEntity<MultiValueMap<String, String>> request = new HttpEntity<MultiValueMap<String, String>>(map, headers);
        ResponseEntity<Oath2LoginTokenResponse> loginTokenResponse = restTemplate.postForEntity( serverUrl + tokenEndpoint, request , Oath2LoginTokenResponse.class );

        if(HttpStatus.OK == loginTokenResponse.getStatusCode()){

            DecodedJWT jwtIdToken = JWT.decode(loginTokenResponse.getBody().getId_token());
            PtarUrlJwkProvider provider = new PtarUrlJwkProvider(serverUrl + jwksEndpoint);
            Jwk jwk = provider.get(jwtIdToken.getKeyId());
            Algorithm algorithm = Algorithm.RSA256((RSAPublicKey) jwk.getPublicKey(), null);
            algorithm.verify(jwtIdToken);

            // Check expiration
            if (jwtIdToken.getExpiresAt().before(Calendar.getInstance().getTime())) {
                AdfsHttpResponse<LoginResponse> resp = new AdfsHttpResponse<>();
                resp.setStatus(HttpResponseEnum.AUTH_CIAM_TOKEN_EXPIRED.getResponseCode());
                resp.setMessage(HttpResponseEnum.AUTH_CIAM_TOKEN_EXPIRED.getResponseMSG());
                return resp;
            }

            String ciamAccount = jwtIdToken.getClaim("samaccountname").asString();
            ResultData resultData = userService.verifyLoginUserByBoschId(ciamAccount);
            AdfsHttpResponse<LoginResponse> resp = new AdfsHttpResponse<>();
            LoginResponse loginResponse = new LoginResponse();
            loginResponse.setToken((String) ((Map<String, Object>)resultData.getData()).get("token"));
            loginResponse.setNeedBind((Boolean)((Map<String, Object>)resultData.getData()).get("needBind"));
            loginResponse.setTokenHint(loginTokenResponse.getBody().getId_token());
            resp.setStatus((Integer) resultData.getCode());
            resp.setMessage(resultData.getMessage());
            resp.setData(loginResponse);
            return resp;
        }else{
            AdfsHttpResponse<LoginResponse> resp = new AdfsHttpResponse<>();
            resp.setStatus(HttpResponseEnum.AUTH_CIAM_TOKEN_REQUEST_FAILED.getResponseCode());
            resp.setMessage(HttpResponseEnum.AUTH_CIAM_TOKEN_REQUEST_FAILED.getResponseMSG()+":"+loginTokenResponse.getBody().toString());
            return resp;
        }
    }

    @Override
    public String getAuthorizeUrl(HttpServletRequest httpServletRequest) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        String state = UUID.randomUUID().toString();

        SecureRandom secureRandom = new SecureRandom();
        byte[] codeVerifier = new byte[32];
        secureRandom.nextBytes(codeVerifier);
        String codeVerifierString =  Base64.getUrlEncoder().withoutPadding().encodeToString(codeVerifier);

        byte[] bytes = codeVerifierString.getBytes("US-ASCII");
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        messageDigest.update(bytes, 0, bytes.length);
        byte[] digest = messageDigest.digest();
        String codeChallenge = Base64.getUrlEncoder().withoutPadding().encodeToString(digest);

        HttpSession session = httpServletRequest.getSession(true);
        session.setMaxInactiveInterval(5 * 60);//5 min
        session.setAttribute(session.getId()+ ":state",state);

        String encodedUrl = URLEncoder.encode(redirectUrl, StandardCharsets.UTF_8.toString());
        String authorizeRedirectUrl = serverUrl + authorizeEndpoint + "?client_id=" + clientId+
                "&response_type=" + responseType +
                "&redirect_uri=" + redirectUrl +
                "&response_mode=query" +
                "&scope=" + scope +
                "&state=" + state;
                //"&code_challenge=" + codeChallenge +
                //"&code_challenge_method=S256";

        return authorizeRedirectUrl;
    }
}
