package com.ruoyi.framework.sso;


import cn.hutool.core.date.DateUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;

import java.net.URL;
import java.util.ArrayList;

/**
 * @author : tao.xu3@cn.bosch.com
 * @description:
 * @date : 3/13/2020  1:24 PM
 */
public class CommonUtil {

    static boolean isNullOrEmpty(String s) {
        return s == null || s.isEmpty();
    }

    static void checkArgument(boolean arg, String message) {
        if (!arg) {
            throw new IllegalArgumentException(String.valueOf(message));
        }
    }

    public static boolean domainValidate(String url, String domain){
        URL uri = null;
        try {
            uri = new URL(url);
            String host = uri.getProtocol() + "://" + uri.getHost();
            if(domain.contains(host)){
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public  static boolean isDate(Object dateObj){
        try{
            if(ArrayList.class.isAssignableFrom(dateObj.getClass())){
                ArrayList dateRange = (ArrayList)dateObj;
                if(!CollectionUtils.isEmpty(dateRange)){
                    dateRange.forEach(date ->{
                        DateUtil.parse(String.valueOf(date));
                    });
                }
            }else if(StringUtils.isNotEmpty(String.valueOf(dateObj))){
                DateUtil.parse(String.valueOf(dateObj));
            }else{
                return false;
            }
            return true;
        }catch(Exception e){
            return false;
        }
    }
}
