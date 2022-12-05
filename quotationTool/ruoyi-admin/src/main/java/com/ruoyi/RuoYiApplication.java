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
        String banner = "         ollllo ollllllllllove       \n" +
                "          vllve  vlloveeeevllle      \n" +
                "           lle    lle       olo      \n" +
                "           lle    lle       vll      \n" +
                "           lle    lle       vll      \n" +
                "           lle    lle       olo      \n" +
                "           lle    lle      vlle      \n" +
                "           lle    lle    eoloe       \n" +
                "           lle    lle evlllo         \n" +
                "           lle    llollovvollv       \n" +
                "           lle    llve     elloe     \n" +
                "           lle    lle        llo     \n" +
                "    vov    lle    lle        vlle    \n" +
                "   vllo    lle    lle        ellv    \n" +
                "   ooe     lle    lle        elle    \n" +
                "   lv     ell     lle        olle    \n" +
                "   oo     vlo     lle       vllv     \n" +
                "   elve  vlle    vlloeeeevvlllv      \n" +
                "    eolllloe    ollllllllllove       \n" +
                "       ee                            ";
        System.out.println("(♥◠‿◠)ﾉﾞ  敬博启动成功   ლ(´ڡ`ლ)ﾞ  \n" + banner);
    }
}
