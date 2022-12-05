package com.ruoyi.web.controller.wechat;

import com.ruoyi.business.domain.ZStadiumInfo;
import com.ruoyi.business.service.IZStadiumInfoService;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.core.domain.entity.SysDictData;
import com.ruoyi.common.core.page.TableDataInfo;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.system.service.ISysDictTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/wxapi/business")
public class WxBusinessController extends BaseController {

    @Autowired
    private IZStadiumInfoService izStadiumInfoService;
    @Autowired
    private ISysDictTypeService dictTypeService;

    /**
     * 查询场馆列表
     */
    @PostMapping("/stadiumList")
    public TableDataInfo stadiumList(@RequestBody ZStadiumInfo zStadiumInfo) {
        startPage();
        List<ZStadiumInfo> list = izStadiumInfoService.selectZStadiumInfoList(zStadiumInfo);
        return getDataTable(list);
    }

    /**
     * 查询场馆信息
     */
    @GetMapping("/getStadiumInfo")
    public AjaxResult getStadiumInfo(Long stadiumId) {
        ZStadiumInfo zStadiumInfo = izStadiumInfoService.selectZStadiumInfoByStadiumId(stadiumId);
        return AjaxResult.success(zStadiumInfo);
    }

    /**
     * 根据字典类型查询字典数据信息
     */
    @GetMapping(value = "/type/{dictType}")
    public AjaxResult dictType(@PathVariable String dictType)
    {
        List<SysDictData> data = dictTypeService.selectDictDataByType(dictType);
        if (StringUtils.isNull(data))
        {
            data = new ArrayList<SysDictData>();
        }
        return AjaxResult.success(data);
    }

    /**
     * 文化配送
     */
    @GetMapping("/getCulture")
    public AjaxResult getCulture(String type) {
        List<Map<String,String>> list = new ArrayList();
        if(type.equals("1")){
            Map map = new HashMap();
            map.put("imgUrl","https://bjetxgzv.cdn.bspapp.com/VKCEYUGU-uni-app-doc/d8590190-4f28-11eb-b680-7980c8a877b8.png");
            map.put("introduce","萨克斯基础课");
            list.add(map);
            Map map1 = new HashMap();
            map1.put("imgUrl","https://bjetxgzv.cdn.bspapp.com/VKCEYUGU-uni-app-doc/d8590190-4f28-11eb-b680-7980c8a877b8.png");
            map1.put("introduce","油画基础课");
            list.add(map1);
            Map map2 = new HashMap();
            map2.put("imgUrl","https://bjetxgzv.cdn.bspapp.com/VKCEYUGU-uni-app-doc/d8590190-4f28-11eb-b680-7980c8a877b8.png");
            map2.put("introduce","舞蹈基础课");
            list.add(map2);
        }else{
            Map map = new HashMap();
            map.put("imgUrl","https://bjetxgzv.cdn.bspapp.com/VKCEYUGU-uni-app-doc/d8590190-4f28-11eb-b680-7980c8a877b8.png");
            map.put("introduce","舞蹈课");
            list.add(map);
            Map map1 = new HashMap();
            map1.put("imgUrl","https://bjetxgzv.cdn.bspapp.com/VKCEYUGU-uni-app-doc/d8590190-4f28-11eb-b680-7980c8a877b8.png");
            map1.put("introduce","音乐课");
            list.add(map1);
            Map map2 = new HashMap();
            map2.put("imgUrl","https://bjetxgzv.cdn.bspapp.com/VKCEYUGU-uni-app-doc/d8590190-4f28-11eb-b680-7980c8a877b8.png");
            map2.put("introduce","浦东新区书法大赛");
            list.add(map2);
        }
        return AjaxResult.success(list);
    }

}
