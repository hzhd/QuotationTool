package com.ruoyi.common.utils.quotationUtils;

import com.ruoyi.common.utils.sign.Md5Utils;

/**
 * @author huzd
 * @date 2023-01-10 10:40
 */
public class EshopSign {

    public static String eshopSignGetToken(Long timestampParam, String clientSecretkey, String signSecretkey){

        //拼接字符串
        String clientSecretkeyStr = "secretkey" + clientSecretkey;
        String timestamp = "timestamp" + timestampParam;//"1677650112802";
        String signStr = signSecretkey + clientSecretkeyStr + timestamp + signSecretkey;
        //MD5 32位小写加密
        Md5Utils md5Utils = new Md5Utils();
        String resultStr = md5Utils.hash(signStr);
//        System.out.println("模式一：" + resultStr);

        //获取token返回模式一的数据
        return resultStr;
    }

    public static String eshopSignPushData(Long timestampParam, String signSecretkey){
        //MD5 32位小写加密
        Md5Utils md5Utils = new Md5Utils();
        //模式二的签名方法
        String timestamp2 = "timestamp" + String.valueOf(timestampParam+9);//"1677650112811";
        String signStr2 = signSecretkey + timestamp2 + signSecretkey;
        String resultStr2 = md5Utils.hash(signStr2);

        return resultStr2;
    }

    public static void main(String[] args) {
        //拼接字符串
        //测试环境
//        String signSecretkey = "0b741aac";
//        String clientSecretkey = "0178a456";
        //正式环境
        String signSecretkey = "0a665ccb";
        String clientSecretkey = "0145a111";
        String clientSecretkeyStr = "secretkey" + clientSecretkey;
        String timestamp = "timestamp" + "1677826033877";
        String signStr = signSecretkey + clientSecretkeyStr + timestamp + signSecretkey;
        //MD5 32位小写加密
        Md5Utils md5Utils = new Md5Utils();
        String resultStr = md5Utils.hash(signStr);
        System.out.println("模式一：" + resultStr);

        //模式二的签名方法
        String timestamp2 = "timestamp" + "1677826033886";
        String signStr2 = signSecretkey + timestamp2 + signSecretkey;
        String resultStr2 = md5Utils.hash(signStr2);
        System.out.println("模式二：" + resultStr2);

        //推送数据签名(这个暂时不用了)
        String paramStr = "param" + "[{\"id\":\"123\",\"product\":\"123\"}]";
        String signStrPush = signSecretkey + paramStr + timestamp + signSecretkey;
        String resultStrPush = md5Utils.hash(signStrPush);
        System.out.println("推送数据：" + resultStrPush);

        //sss
        String aa = "0b741aactimestamp16733361381680b741aac";

    }

}
