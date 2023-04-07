package com.ruoyi.web.controller.tool;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @program: ruoyi
 * @description: bean配置
 * @author: yangjy
 * @create: 2022-02-19 15:30:28
 */
@Configuration
public class InitBean {


    @Bean
    public RestTemplate restTemplate() {
            return new RestTemplate();
    }
}
