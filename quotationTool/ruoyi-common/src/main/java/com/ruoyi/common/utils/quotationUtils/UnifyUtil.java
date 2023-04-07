package com.ruoyi.common.utils.quotationUtils;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @description: eshop请求
 * @author: huzd
 * @create: 2023-03-01 09:43:40
 */
@Component
public class UnifyUtil {
    private static final Logger LOGGER = LoggerFactory.getLogger(UnifyUtil.class);

    @Autowired
    private RestTemplate restTemplate;

    /**
     * 接口请求
     * @return
     */
    public String doPost(String sign, String url, String data){
        // 请求头设置,application/json格式的数据
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("sign", sign);

        //获取header
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("sign", sign);

        // 发送post请求，并打印结果，以String类型接收响应结果JSON字符串
        int i = 0;
        HttpResponse httpResponse;
        String result = "";
        while(i++ < 3) {
            try {
                long start = System.currentTimeMillis();
                httpResponse = HttpRequest.post(url)
                        .headerMap(headerMap,true)
                        .body(data)
                        .timeout(5000)
                        .execute();
                LOGGER.info("eshop响应时间{}",System.currentTimeMillis() - start);
            }catch (Exception e){
                LOGGER.error("eshop请求出错，失败第{}次！",i,e);
                continue;
            }
            if (httpResponse.getStatus() == HttpStatus.HTTP_OK) {
                result = httpResponse.body();
                LOGGER.info("eshop返回值{}",result);
                break;
            }
        }
        return result;
    }


    /**
     * 接口请求--推送eshop
     * @return
     */
    public String doPostData(String sign, String url, String data, String Authorization){
        // 请求头设置,application/json格式的数据
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
        headers.set("sign", sign);
        headers.set("Authorization", Authorization);

        //获取header
        Map<String, String> headerMap = new HashMap<>();
        headerMap.put("sign", sign);
        headerMap.put("Authorization", Authorization);

        // 发送post请求，并打印结果，以String类型接收响应结果JSON字符串
        int i = 0;
        HttpResponse httpResponse;
        String result = "";
        while(i++ < 3) {
            try {
                long start = System.currentTimeMillis();
                httpResponse = HttpRequest.post(url)
                        .headerMap(headerMap,true)
                        .body(data)
                        .timeout(5000)
                        .execute();
                LOGGER.info("eshop响应时间{}",System.currentTimeMillis() - start);
            }catch (Exception e){
                LOGGER.error("eshop请求出错，失败第{}次！",i,e);
                continue;
            }
            if (httpResponse.getStatus() == HttpStatus.HTTP_OK) {
                result = httpResponse.body();
                LOGGER.info("eshop返回值{}",result);
                break;
            }
        }
        return result;
    }


    /**
     * doPost
     * @param url 请求地址
     * @return
     *//*
    public  String doPost( String url){


        // 请求头设置,application/json格式的数据
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        //提交参数设置
        Map<String, Object> map = new HashMap<>();

        // 组装请求体
        HttpEntity<Map> request =
                new HttpEntity<>(map, headers);

        // 发送post请求，并打印结果，以String类型接收响应结果JSON字符串
        ResponseEntity<String> responseEntity = restTemplate.postForEntity(url, request, String.class);

        LOGGER.info("回调响应结果:{}",responseEntity.getBody());
        return responseEntity.getBody();
    }*/
}
