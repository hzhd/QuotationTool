package com.ruoyi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;

import com.ruoyi.business.GlobalConstant;

/**
 * 启动程序
 * 
 * @author ruoyi
 */
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RuoYiApplication {

    public static void main(String[] args) {
        // System.setProperty("spring.devtools.restart.enabled", "false");
    	ApplicationContext appContext= SpringApplication.run(RuoYiApplication.class, args);
    	GlobalConstant.init(appContext);
    	//*************************************临时测试
//    	StadiumController controller=appContext.getBean(StadiumController.class);
//    	TableDataInfo data=controller.list(new Stadium());
//    	System.out.println(JSONObject.toJSONString(data));  
//    	PublishController controller=appContext.getBean(PublishController.class);
//    	AjaxResult result=controller.getTeamCountByType(null);
//    	System.out.println(JSONObject.toJSONString(result));
        //************************************
        String banner = "";
        //博世热力询价系统启动成功
        System.out.println("(♥◠‿◠)ﾉﾞ  Bosch thermal quotation system started successfully!   ლ(´ڡ`ლ)ﾞ  \n" + banner);
    }
}
