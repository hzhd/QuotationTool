package com.ruoyi.quotation.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ruoyi.common.core.domain.entity.SysDept;
import com.ruoyi.common.core.redis.RedisCache;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.common.utils.quotationUtils.EshopSign;
import com.ruoyi.common.utils.quotationUtils.UnifyUtil;
import com.ruoyi.quotation.domain.bo.GetOrgListResponse;
import com.ruoyi.quotation.domain.bo.GetTokenRequest;
import com.ruoyi.quotation.domain.bo.PushEshopRequest;
import com.ruoyi.quotation.domain.bo.PushEshopResponse;
import com.ruoyi.quotation.service.EshopApiService;
import com.ruoyi.system.service.ISysDeptService;
import com.ruoyi.system.service.ISysUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * eshop接口对接
 * @author huzd
 * @date 2023-03-01 13:52
 */
@Service
public class EshopApiServiceImpl implements EshopApiService {

    private static final Logger log = LoggerFactory.getLogger(EshopApiServiceImpl.class);

    @Autowired
    private UnifyUtil unifyUtil;

    @Autowired
    private RedisCache redisCache;

    @Value("${get_token_url}")
    private String get_token_url;

    @Value("${push_eshop_url}")
    private String push_eshop_url;

    @Value("${client_secret}")
    private String client_secret;

    @Value("${sign_secret}")
    private String sign_secret;

    /**
     * 认证接口-获取Token
     *
     * @return token
     */
    @Override
    public String getToken() {
        //这里进行判断accesstoken是否过期，若是过期则是重新获取，若是不过期则直接读取redis中的数据
        String token = redisCache.getCacheObject("eshop_token");
        token = token==null ? "" : token;
        if(StringUtils.isEmpty(token)){
            Long timestamp = Calendar.getInstance().getTimeInMillis();
            GetTokenRequest getTokenRequest = new GetTokenRequest();
            getTokenRequest.setSecretkey(client_secret);
            getTokenRequest.setTimestamp(String.valueOf(timestamp+9));
            String getTokenRequestStr = JSONObject.toJSONString(getTokenRequest);
            //JSONObject jsonObject = (JSONObject) JSONObject.toJSON(getTokenRequest);
            /*String pattern = "yyyy-MM-dd'T'HH:mm:ssZZ";
            String timestamp = DateFormatUtils.format(new Date(), pattern);*/
            //String authorization = HMAC.hmacSha1Encrypt(timestamp+getTokenRequestStr, appSecret);
            String sign = EshopSign.eshopSignGetToken(timestamp, client_secret, sign_secret);
            String url = "https://eshop.5000m.com:40244/test-api/eshop/api/outi7e/token";
            String responseContent = unifyUtil.doPost(sign, url, getTokenRequestStr);
            //示例：{"data":{"accessToken":"ZWtuUnUva0F0SjcyenFGVUlDYkNBSFMzWkVTL09yMU4xQVhFM0pYTnkxb2FEN3NDZkN5TTBWRWRVUXBLbHBxbVFDZlBMVEl5M0FseGdJOTBTb3VWOCtCYWU2Rm8wV0ljT04vNkJ0ZTV2WU50V0lmMDAwQThoWHlWNXBHSnpEcDl5eTNibGlNclB0dCtqallySzRmNS9nPT0=bmhIaWlNaGJvYWYzQ0xrSTVoU201S0FXVkxWVjlmaVdVQ1ZpM2h6azYvZz0="},"code":"ES_2000","message":{"tip":"Request successful","detail":""},"version":"v1.0"}
            // {"resCode":0,"resMsg":"success","data":{"token":"06e0fe7114874a3dbf346ee95598a91a","expireTime":"0"}}
            if (StringUtils.isNotEmpty(responseContent)) {
                JSONObject parseObject = JSONObject.parseObject(responseContent);
                String resCode = parseObject.getString("code");
                if(resCode.equals("ES_2000")){
                    JSONObject dataJson = JSONObject.parseObject(parseObject.getString("data"));
                    token = dataJson.getString("accessToken");

                    redisCache.setCacheObject("eshop_token", token, 60*60*2, TimeUnit.SECONDS);
                }
            }else{
                log.info("获取token失败，返回数据{}", responseContent);
                return token;
            }
        }
        return token;
    }

    /**
     * eshop推送数据
     *
     * @return 推送结果
     */
    @Override
    public PushEshopResponse pushEshop(PushEshopRequest pushEshopRequest) {
        PushEshopResponse pushEshopResponse = new PushEshopResponse();
        //调用公共方法获取token
        String token = getTokenMethod();
        if(StringUtils.isEmpty(token)){
            token = "";
            log.info("获取token失败");
            return pushEshopResponse;
        }

        String pushEshopRequestStr = JSONObject.toJSONString(pushEshopRequest);
        Long timestamp = Calendar.getInstance().getTimeInMillis();
        //测试环境
//        String url = "https://eshop.5000m.com:40244/test-api/eshop/api/outi7e/quotation";
        //正式环境
//        String url = "https://eshop.bosch-climate.cn/oppty-api/eshop/api/outi7e/quotation";
        String url = push_eshop_url;
        log.info("eshop推送地址："+push_eshop_url);
        String sign = EshopSign.eshopSignPushData(timestamp, sign_secret);
        String Authorization = " Bearer " + token;
        pushEshopRequestStr = "{\"param\":[" + pushEshopRequestStr + "]," + "\"timestamp\":" + timestamp +"}";

        String responseContent = unifyUtil.doPostData(sign, url, pushEshopRequestStr,Authorization);
        if (StringUtils.isBlank(responseContent)) {
            log.info("推送eshop数据失败");
            return pushEshopResponse;
        }
        JSONObject parseObject = JSONObject.parseObject(responseContent);
        String code = parseObject.getString("code");
        if(!code.equals("ES_2000")){
            log.info("推送eshop失败");
            return pushEshopResponse;
        }
        pushEshopResponse.setCode(code);
        pushEshopResponse.setVersion(parseObject.getString("version"));
        JSONObject dataJson = JSONObject.parseObject(parseObject.getString("data"));
        pushEshopResponse.setStatus(dataJson.getString("status"));
        JSONObject messageJson = JSONObject.parseObject(parseObject.getString("message"));
        pushEshopResponse.setTip(messageJson.getString("tip"));
        pushEshopResponse.setDetail(messageJson.getString("detail"));

        log.info("推送eshop数据成功");

        return pushEshopResponse;
    }

    /**
     * 组织接口-获取组织结构
     *
     * @return 组织结构列表
     */
    @Override
    public List<GetOrgListResponse> getOrgList() {
        List<GetOrgListResponse> getOrgListResponseList = new ArrayList<GetOrgListResponse>();
        //调用公共方法获取token
        String token = getTokenMethod();
        if(StringUtils.isEmpty(token)){
            token = "";
            log.info("获取token失败");
            return getOrgListResponseList;
        }
//
//        GetOrgListRequest getOrgListRequest = new GetOrgListRequest();
//        getOrgListRequest.setClientId(clientId);
//        getOrgListRequest.setCurrPage(1);
//        getOrgListRequest.setPageSize(999999);
//        String getOrgListRequestStr = JSONObject.toJSONString(getOrgListRequest);
//        Long timestamp = Calendar.getInstance().getTimeInMillis()/1000;
//        String authorization = HMAC.hmacSha1Encrypt(timestamp+getOrgListRequestStr, appSecret);
//        //String responseContent = "{\"resCode\":0,\"resMsg\":\"success\",\"currPage\":1,\"pageSize\":100,\"totalCount\":1000,\"data\":[{\"id\":\"2000001\",\"orgName\":\"人事行政部\",\"orgCode\":\"2039112312\",\"parentId\":\"1000000\",\"orgPath\":\"1000000/2000001\",\"orgShortCn\":\"\",\"orgShortEn\":\"\",\"invented\":\"0\",\"order\":\"\",\"status\":\"1\",\"principal\":\"dh2001100280801,dh2001100280802\",\"weChatId\":\"zh202931018809\",\" dimension \":\"供应商\"},{\"id\":\"2000002\",\"orgName\":\"市场部\",\"orgCode\":\"2039112312\",\"parentId\":\"1000000\",\"orgPath\":\"1000000/2000002\",\"orgShortCn\":\"\",\"orgShortEn\":\"\",\"invented\":\"0\",\"order\":\"\",\"status\":\"1\",\"principal\":\"dh2001100280801,dh2001100280802\",\"weChatId\":\"zh202931018809\",\" dimension \":\"供应商\"}]}\n";
//        String url = getOrgList + "?authToken=" + token + "&clientId=" + clientId + "&timestamp=" + timestamp;
//        String responseContent = unifyUtil.doPost(authorization, url, getOrgListRequestStr);
        String responseContent = unifyUtil.doPost(null, null, null);
        if (StringUtils.isBlank(responseContent)) {
            log.info("获取组织结构失败");
            return getOrgListResponseList;
        }
        JSONObject parseObject = JSONObject.parseObject(responseContent);
        String resCode = parseObject.getString("resCode");
        if(!resCode.equals("0")){
            log.info("获取组织结构失败");
            return getOrgListResponseList;
        }
        //JSONObject dataJson = JSONObject.parseObject(parseObject.getString("data"));
        List<JSONObject> dataList = (List<JSONObject>) parseObject.get("data");
        dataList.forEach(item -> {
            GetOrgListResponse getOrgListResponse = new GetOrgListResponse();
            getOrgListResponse = JSONObject.toJavaObject(item, GetOrgListResponse.class);
            getOrgListResponseList.add(getOrgListResponse);
        });

        return getOrgListResponseList;
    }

    /**
     * 同步-组织列表信息
     *
     * @param getOrgListResponseList
     * @return int
     */
    @Override
    public int synOrgList(List<GetOrgListResponse> getOrgListResponseList) {
        List<SysDept> list = new ArrayList<>();
        if(!CollectionUtils.isEmpty(getOrgListResponseList)){
            getOrgListResponseList.forEach(item -> {
                SysDept sysDept = new SysDept();
                sysDept.setDeptId(Long.parseLong(item.getId()));
                sysDept.setParentId(Long.parseLong(item.getParentId()==null?"0":item.getParentId()));
                sysDept.setAncestors(item.getOrgPath()==null?"0":item.getOrgPath().replaceAll("/", ","));
                sysDept.setDeptName(item.getOrgName());
                //sysDept.setOrderNum(item.getOrder()==""?item.getOrder() : "0");
                sysDept.setLeader(item.getPrincipal());
                sysDept.setStatus("1".equals(item.getStatus())?"0":"1");
                sysDept.setCreateBy("syn");
                //处理一下数据的特殊情况及脏数据
                String replaceStr = sysDept.getAncestors();
                if(replaceStr.length()>0&&replaceStr.charAt(0)==','){
                    replaceStr=replaceStr.substring(1);
                }
                if(sysDept.getDeptId().equals("100012010109")){
                    replaceStr = "100012010099,100012010109";
                }
                sysDept.setAncestors(replaceStr);
                list.add(sysDept);
            });
        }
        if(list.size()>0){
            //批量插入之前先删除
            //sysDeptService.batchDelete(list);
            //批量插入部门信息
            return 0;//sysDeptService.insertDeptList(list);
        }else{
            return 0;
        }
    }

    /**
     * 认证接口-获取Token
     */
    public String getTokenMethod() {
        //这里进行判断accesstoken是否过期，若是过期则是重新获取，若是不过期则直接读取redis中的数据
        String token = redisCache.getCacheObject("eshop_token");
        token = token==null ? "" : token;
        if(StringUtils.isEmpty(token)){
            Long timestamp = Calendar.getInstance().getTimeInMillis();
            GetTokenRequest getTokenRequest = new GetTokenRequest();
            getTokenRequest.setSecretkey(client_secret);
            getTokenRequest.setTimestamp(String.valueOf(timestamp+9));
            String getTokenRequestStr = JSONObject.toJSONString(getTokenRequest);
            //JSONObject jsonObject = (JSONObject) JSONObject.toJSON(getTokenRequest);
            /*String pattern = "yyyy-MM-dd'T'HH:mm:ssZZ";
            String timestamp = DateFormatUtils.format(new Date(), pattern);*/
            //String authorization = HMAC.hmacSha1Encrypt(timestamp+getTokenRequestStr, appSecret);
            String sign = EshopSign.eshopSignGetToken(timestamp, client_secret, sign_secret);
            //获取token的地址
            String url = get_token_url;
            String responseContent = unifyUtil.doPost(sign, url, getTokenRequestStr);
            //示例：{"data":{"accessToken":"ZWtuUnUva0F0SjcyenFGVUlDYkNBSFMzWkVTL09yMU4xQVhFM0pYTnkxb2FEN3NDZkN5TTBWRWRVUXBLbHBxbVFDZlBMVEl5M0FseGdJOTBTb3VWOCtCYWU2Rm8wV0ljT04vNkJ0ZTV2WU50V0lmMDAwQThoWHlWNXBHSnpEcDl5eTNibGlNclB0dCtqallySzRmNS9nPT0=bmhIaWlNaGJvYWYzQ0xrSTVoU201S0FXVkxWVjlmaVdVQ1ZpM2h6azYvZz0="},"code":"ES_2000","message":{"tip":"Request successful","detail":""},"version":"v1.0"}
            // {"resCode":0,"resMsg":"success","data":{"token":"06e0fe7114874a3dbf346ee95598a91a","expireTime":"0"}}
            if (StringUtils.isNotEmpty(responseContent)) {
                JSONObject parseObject = JSONObject.parseObject(responseContent);
                String resCode = parseObject.getString("code");
                if(resCode.equals("ES_2000")){
                    JSONObject dataJson = JSONObject.parseObject(parseObject.getString("data"));
                    token = dataJson.getString("accessToken");

                    redisCache.setCacheObject("eshop_token", token, 60, TimeUnit.SECONDS);
                }
            }else{
                log.info("获取token失败，返回数据{}", responseContent);
                return token;
            }
        }
        return token;
    }
}
