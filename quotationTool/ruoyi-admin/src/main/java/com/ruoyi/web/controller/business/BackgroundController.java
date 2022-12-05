package com.ruoyi.web.controller.business;

import com.ruoyi.business.domain.BackgroundInfo;
import com.ruoyi.business.service.BackgroundService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 背景图切换
 * @author: liu
 * @date: 2022/9/27
 */
@RestController
@RequestMapping(value = "/background/msg")
public class BackgroundController extends BaseController {


    @Autowired
    private BackgroundService backgroundService;


    /**
     * 显示图片位置
     * @author: liu
     * @date: 2022/9/27
     */
    @GetMapping
    public BackgroundInfo view(){
        BackgroundInfo view = backgroundService.view();
        return view;
    }


    /**
     * 修改图片
     * @author: liu
     * @date: 2022/9/27
     */
    @PostMapping
    public AjaxResult edit(@RequestBody BackgroundInfo backgroundInfo){
        backgroundService.edit(backgroundInfo);
        return success("修改成功");
    }

}
