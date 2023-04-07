package com.ruoyi.web.controller.eshop;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.business.domain.Barcode;
import com.ruoyi.business.service.impl.BarcodeServiceImpl;
import com.ruoyi.quotation.domain.Eshop;
import com.ruoyi.quotation.domain.bo.PushEshopRequest;
import com.ruoyi.quotation.domain.bo.PushEshopResponse;
import com.ruoyi.quotation.domain.bo.RecommendProducts;
import com.ruoyi.quotation.service.EshopApiService;
import com.ruoyi.quotation.service.IEshopService;
import io.netty.util.internal.StringUtil;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 推送数据Controller
 * 
 * @author huzd
 * @date 2023-03-01
 */
@RestController
@RequestMapping("/eshop/eshop")
public class EshopController extends BaseController
{
    @Autowired
    private IEshopService eshopService;

    @Autowired
    private EshopApiService eshopApiService;

    @Autowired
    private BarcodeServiceImpl barcodeService;

    /**
     * 查询推送数据列表
     */
    @PreAuthorize("@ss.hasPermi('eshop:eshop:list')")
    @GetMapping("/list")
    public TableDataInfo list(Eshop eshop)
    {
        startPage();
        List<Eshop> list = eshopService.selectEshopList(eshop);
        return getDataTable(list);
    }

    /**
     * 导出推送数据列表
     */
    @PreAuthorize("@ss.hasPermi('eshop:eshop:export')")
    @Log(title = "推送数据", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Eshop eshop)
    {
        List<Eshop> list = eshopService.selectEshopList(eshop);
        ExcelUtil<Eshop> util = new ExcelUtil<Eshop>(Eshop.class);
        util.exportExcel(response, list, "推送数据数据");
    }

    /**
     * 获取推送数据详细信息
     */
    @PreAuthorize("@ss.hasPermi('eshop:eshop:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(eshopService.selectEshopById(id));
    }

    /**
     * 新增推送数据---单独eshop推送使用
     */
//    @PreAuthorize("@ss.hasPermi('eshop:eshop:add')")
//    @Log(title = "推送数据", businessType = BusinessType.INSERT)//要去掉，不然会出现记录日志的时候，使用切片，找不到用户信息的问题。
    @PostMapping
    public AjaxResult add(@RequestBody Eshop eshop)
    {
        //推送之前校验手机号
        String isUnique = eshopService.checkPhoneUnique(eshop.getCustomerphone()==null?"":eshop.getCustomerphone());
        if(StringUtil.isNullOrEmpty(isUnique)){
            return error("数据错误");
        }else{
            if("0".equals(isUnique)){
                return error("已存在相同手机号");
            }
        }
        PushEshopRequest pushEshopRequest = new PushEshopRequest();
        PushEshopResponse pushEshopResponse = new PushEshopResponse();
        //添加之前进行推送
        if(eshop==null){
            return error("添加数据格式错误");
        }else {
            pushEshopRequest.setClueSource(eshop.getCluesource());
            pushEshopRequest.setClueQenerationTime(eshop.getClueqenerationtime());
            pushEshopRequest.setRegionName(eshop.getRegionname());
            pushEshopRequest.setCustomerName(eshop.getCustomername());
            pushEshopRequest.setCustomerPhone(eshop.getCustomerphone());
            pushEshopRequest.setProvince(eshop.getProvince());
            pushEshopRequest.setCity(eshop.getCity());
            pushEshopRequest.setCounty(eshop.getCounty());
            pushEshopRequest.setAddress(eshop.getAddress());
            pushEshopRequest.setProblemDescription(eshop.getProblemdescription());
            pushEshopRequest.setProduct(eshop.getProduct());

            pushEshopResponse = eshopApiService.pushEshop(pushEshopRequest);
        }
        if(!pushEshopResponse.getCode().equals("ES_2000")){
            eshop.setRemark("推送失败");
            return error("eshop数据推送失败");
        }
        eshop.setRemark("推送成功");

        return toAjax(eshopService.insertEshop(eshop));
    }

    /**
     * 新增推送数据--报价流程使用
     */
//    @PreAuthorize("@ss.hasPermi('eshop:eshop:add')")
//    @Log(title = "推送数据", businessType = BusinessType.INSERT)//要去掉，不然会出现记录日志的时候，使用切片，找不到用户信息的问题。
    @PostMapping("addQuotation")
    public AjaxResult addQuotation(@RequestBody Eshop eshop)
    {
        //根据推送的qrcodeId号获取二维码信息
        Long qrcodeId = eshop.getQrcodeId();
        Barcode barcode = new Barcode();
        if(qrcodeId==null){
            return error("数据错误，请重新报价");
        }else{
            barcode = barcodeService.selectBarcodeById(qrcodeId);
        }
        //eshop.setRegionname(barcode.getArea());
        //eshop.setProvince(barcode.getProvence());
        //eshop.setCity(barcode.getCity());
        eshop.setResponsibleperson(barcode.getSalesName());
        eshop.setDistributorname(barcode.getDealerName());
        eshop.setDatasource(barcode.getSource());
//        eshop.setCluesource("quote");
        eshop.setCluesource(barcode.getSource());
        eshop.setClueqenerationtime(new Date());
        //推送之前校验手机号
        String isUnique = eshopService.checkPhoneUnique(eshop.getCustomerphone()==null?"":eshop.getCustomerphone());
        if(StringUtil.isNullOrEmpty(isUnique)){
            return error("数据错误");
        }else{
            if("0".equals(isUnique)){
                return error("已存在相同手机号");
            }
        }
        PushEshopRequest pushEshopRequest = new PushEshopRequest();
        PushEshopResponse pushEshopResponse = new PushEshopResponse();
        //添加之前进行推送
        if(eshop==null){
            return error("添加数据格式错误");
        }else {
            //start模板推送字段
            pushEshopRequest.setClueSource(eshop.getCluesource());
            pushEshopRequest.setClueQenerationTime(eshop.getClueqenerationtime());
            pushEshopRequest.setRegionName(eshop.getRegionname());
            pushEshopRequest.setCustomerName(eshop.getCustomername());
            pushEshopRequest.setCustomerPhone(eshop.getCustomerphone());
            pushEshopRequest.setProvince(eshop.getProvince());
            pushEshopRequest.setCity(eshop.getCity());
            pushEshopRequest.setCounty(eshop.getCounty());
            pushEshopRequest.setAddress(eshop.getAddress());
            pushEshopRequest.setProblemDescription(eshop.getProblemdescription());
            pushEshopRequest.setProduct(eshop.getProduct());
            pushEshopRequest.setFavoriteHeating(eshop.getFavoriteheating());
            pushEshopRequest.setBuildingArea(eshop.getBuildingarea());
            //end模板推送字段


//            pushEshopRequest.setRegionName(barcode.getArea());
//            pushEshopRequest.setProvince(barcode.getProvence());
//            pushEshopRequest.setCity(barcode.getCity());
            pushEshopRequest.setResponsiblePerson(barcode.getSalesName());
            pushEshopRequest.setDistributorName(barcode.getDealerName());
            pushEshopRequest.setDataSource(barcode.getSource());

            //报价流程推送数据
            pushEshopRequest.setInstallationTypeName(eshop.getInstallationtypename());
            pushEshopRequest.setAuxiliaryMaterialsType(eshop.getAuxiliarymaterialstype());
            pushEshopRequest.setBuildingArea(eshop.getBuildingarea());
            pushEshopRequest.setSprinklerQuantity(eshop.getSprinklerquantity());
            pushEshopRequest.setBoilerPower(eshop.getBoilerpower());
            pushEshopRequest.setCustomerAppellation(eshop.getCustomerappellation());
            pushEshopRequest.setFavoriteHeating(eshop.getFavoriteheating());
//            pushEshopRequest.setClueSource("quote");
            pushEshopRequest.setClueSource(barcode.getSource());
            pushEshopRequest.setClueQenerationTime(new Date());
            List<RecommendProducts> recommendProductsList = new ArrayList<RecommendProducts>();
            RecommendProducts recommendProducts1 = new RecommendProducts();
            recommendProducts1.setId("1");
            recommendProducts1.setProductGroup(eshop.getProductgroup1());
            recommendProducts1.setProduct(eshop.getProduct1());
            recommendProducts1.setPrice(eshop.getPrice1());
            recommendProductsList.add(recommendProducts1);
            RecommendProducts recommendProducts2 = new RecommendProducts();
            recommendProducts2.setId("2");
            recommendProducts2.setProductGroup(eshop.getProductgroup2());
            recommendProducts2.setProduct(eshop.getProduct2());
            recommendProducts2.setPrice(eshop.getPrice2());
            recommendProductsList.add(recommendProducts2);

            pushEshopRequest.setRecommendProducts(recommendProductsList);

            pushEshopResponse = eshopApiService.pushEshop(pushEshopRequest);
        }
        if(!pushEshopResponse.getCode().equals("ES_2000")){
            eshop.setRemark("推送失败");
            return error("eshop数据推送失败");
        }
        eshop.setRemark("推送成功");

        return toAjax(eshopService.insertEshop(eshop));
    }

    /**
     * 修改推送数据
     */
    @PreAuthorize("@ss.hasPermi('eshop:eshop:edit')")
    @Log(title = "推送数据", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Eshop eshop)
    {
        PushEshopRequest pushEshopRequest = new PushEshopRequest();
        PushEshopResponse pushEshopResponse = new PushEshopResponse();
        //修改之前进行推送
        if(eshop==null){
            return error("修改数据格式错误");
        }else {
            pushEshopRequest.setClueSource(eshop.getCluesource());
            pushEshopRequest.setClueQenerationTime(eshop.getClueqenerationtime());
            pushEshopRequest.setRegionName(eshop.getRegionname());
            pushEshopRequest.setCustomerName(eshop.getCustomername());
            pushEshopRequest.setCustomerPhone(eshop.getCustomerphone());
            pushEshopRequest.setProvince(eshop.getProvince());
            pushEshopRequest.setCity(eshop.getCity());
            pushEshopRequest.setCounty(eshop.getCounty());
            pushEshopRequest.setAddress(eshop.getAddress());
            pushEshopRequest.setProblemDescription(eshop.getProblemdescription());
            pushEshopRequest.setProduct(eshop.getProduct());
            pushEshopRequest.setFavoriteHeating(eshop.getFavoriteheating());
            pushEshopRequest.setBuildingArea(eshop.getBuildingarea());
            pushEshopResponse = eshopApiService.pushEshop(pushEshopRequest);
        }
        if(!pushEshopResponse.getCode().equals("ES_2000")){
            eshop.setRemark("推送失败");
        }
        eshop.setRemark("推送成功");

        return toAjax(eshopService.updateEshop(eshop));
    }

    /**
     * 删除推送数据
     */
    @PreAuthorize("@ss.hasPermi('eshop:eshop:remove')")
    @Log(title = "推送数据", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(eshopService.deleteEshopByIds(ids));
    }
}
