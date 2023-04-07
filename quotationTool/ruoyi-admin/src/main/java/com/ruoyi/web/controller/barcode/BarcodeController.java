package com.ruoyi.web.controller.barcode;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpServletResponse;

import cn.hutool.extra.qrcode.QrCodeUtil;
import cn.hutool.extra.qrcode.QrConfig;
import com.google.zxing.common.BitMatrix;
import com.ruoyi.common.config.RuoYiConfig;
import com.ruoyi.common.qrcode.CreateQrcode;
import com.ruoyi.common.utils.file.FileUploadUtils;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.business.domain.Barcode;
import com.ruoyi.business.service.IBarcodeService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 生成二维码Controller
 * 
 * @author huzd
 * @date 2023-02-13
 */
@RestController
@RequestMapping("/barcode/barcode")
public class BarcodeController extends BaseController
{
    @Autowired
    private IBarcodeService barcodeService;

    @Value("${home_url}")
    private String home_url;

    /**
     * 查询生成二维码列表
     */
    @PreAuthorize("@ss.hasPermi('business:barcode:list')")
    @GetMapping("/list")
    public TableDataInfo list(Barcode barcode)
    {
        startPage();
        List<Barcode> list = barcodeService.selectBarcodeList(barcode);
        return getDataTable(list);
    }

    /**
     * 导出生成二维码列表
     */
    @PreAuthorize("@ss.hasPermi('business:barcode:export')")
    @Log(title = "生成二维码", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Barcode barcode)
    {
        List<Barcode> list = barcodeService.selectBarcodeList(barcode);
        ExcelUtil<Barcode> util = new ExcelUtil<Barcode>(Barcode.class);
        util.exportExcel(response, list, "生成二维码数据");
    }

    /**
     * 获取生成二维码详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:barcode:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(barcodeService.selectBarcodeById(id));
    }

    /**
     * 新增生成二维码
     */
    @PreAuthorize("@ss.hasPermi('business:barcode:add')")
    @Log(title = "生成二维码", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Barcode barcode) throws IOException {
        //保存之前生成二维码
//        @GetMapping("qrcode")
//        @Operation(summary = "生成二维码图片",method = "GET")
//        public void qrcode(HttpServletResponse response,
//            @RequestParam String message) throws IOException {
//        QrConfig config = new QrConfig();
//        config.setWidth(250);
//        config.setHeight(250);
//        config.setMargin(2);
//        OutputStream out = response.getOutputStream();
//        QrCodeUtil.generate(message,config,"jpg",out);
//        out.close();
//    }
        String content = "";
        int result = barcodeService.insertBarcode(barcode);
        //获取添加数据的id值
        if(result>0){
            content = barcode.getId() + "";
            //根据id值生成二维码
            content = home_url + "?id=" + content;
//        String logoPath = "C:/logo.png";
            String format = "jpg";
            int width = 800;
            int height = 800;
            BitMatrix bitMatrix = CreateQrcode.setBitMatrix(content, width, height);
            // 可通过输出流输出到页面,也可直接保存到文件
            OutputStream outStream = null;
//            String path = "D:/BSTherPro/qrcodeImg/qr_"+new Date().getTime()+".png";
            // 上传文件路径
            String filePath = RuoYiConfig.getUploadPath();
            String fileName = "qrcode/" + barcode.getId() + "_" + new Date().getTime()+".png";
            String path = filePath + "/" + fileName;
            String logoPath = filePath + "/logo.png";
            try {
                outStream = new FileOutputStream(new File(path));
                CreateQrcode.writeToFile(bitMatrix, format, outStream, logoPath);
                outStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
            String absPath = FileUploadUtils.getAbsoluteFile(filePath, fileName).getAbsolutePath();
            String visitPath = FileUploadUtils.getPathFileName(filePath, fileName);
            barcode.setBarcodePath(visitPath);
            barcode.setRemark(content);
            barcodeService.updateBarcode(barcode);
        }else{
            return error("新增数据失败");
        }

        return success(content);
    }

    /**
     * 修改生成二维码
     */
    @PreAuthorize("@ss.hasPermi('business:barcode:edit')")
    @Log(title = "生成二维码", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Barcode barcode) throws IOException {
        String content = "";
        content = barcode.getId() + "";
        //根据id值生成二维码
        content = home_url + "?id=" + content;
//        String logoPath = "C:/logo.png";
        String format = "jpg";
        int width = 800;
        int height = 800;
        BitMatrix bitMatrix = CreateQrcode.setBitMatrix(content, width, height);
        // 可通过输出流输出到页面,也可直接保存到文件
        OutputStream outStream = null;
//            String path = "D:/BSTherPro/qrcodeImg/qr_"+new Date().getTime()+".png";
        // 上传文件路径
        String filePath = RuoYiConfig.getUploadPath();
        String fileName = "qrcode/" + barcode.getId() + "_" + new Date().getTime()+".png";
        String path = filePath + "/" + fileName;
        String logoPath = filePath + "/logo.png";
        try {
            outStream = new FileOutputStream(new File(path));
            CreateQrcode.writeToFile(bitMatrix, format, outStream, logoPath);
            outStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        String absPath = FileUploadUtils.getAbsoluteFile(filePath, fileName).getAbsolutePath();
        String visitPath = FileUploadUtils.getPathFileName(filePath, fileName);
        barcode.setBarcodePath(visitPath);
        barcode.setRemark(content);
        barcodeService.updateBarcode(barcode);

        return success(content);
//        return toAjax(barcodeService.updateBarcode(barcode));
    }

    /**
     * 删除生成二维码
     */
    @PreAuthorize("@ss.hasPermi('business:barcode:remove')")
    @Log(title = "生成二维码", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(barcodeService.deleteBarcodeByIds(ids));
    }
}
