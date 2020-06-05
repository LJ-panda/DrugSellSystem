package com.clay.system.controller;

import com.clay.system.annotation.Description;
import com.clay.system.service.ExcelService;
import lombok.AllArgsConstructor;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/5 12:56
 * @Version 1.0
 *
 * 提供报表生成服务的控制器
 * 依赖服务：{@link ExcelService}
 * 注意，需要权限
 */
@RestController
@RequestMapping(value = "/api/excel")
@AllArgsConstructor
public class ExcelController
{
    private ExcelService excelService;

    @RequiresPermissions("excel:query:log")
    @Description(description = "获取系统日志报表")
    @GetMapping(value = "/log")
    public void getLog(HttpServletResponse response)
            throws IOException {
        excelService.buildLogExcel(response);
    }

    @RequiresPermissions("excel:query:drugStorage")
    @Description(description = "获取药物库存报表")
    @GetMapping(value = "/drugStorage")
    public void getStorage(HttpServletResponse response) throws IOException {
        excelService.buildDrugStorageExcel(response);
    }

    @RequiresPermissions("excel:query:typeCode")
    @Description(description = "获取类型代码报表")
    @GetMapping(value = "/typeCode")
    public void getTypeCode(HttpServletResponse response) throws IOException {
        excelService.buildDrugTypeCodeExcel(response);
    }

    @RequiresPermissions("excel:query:purchaseRecord")
    @Description(description = "获取药物采购记录报表")
    @GetMapping(value = "/purchaseRecord")
    public void getDrugPurchase(HttpServletResponse response) throws IOException {
        excelService.buildDrugPurchaseExcel(response);
    }

    @RequiresPermissions("excel:query:sellRecord")
    @Description(description = "获取销售记录报表")
    @GetMapping(value = "/sellRecord")
    public void getSellRecord(HttpServletResponse response) throws IOException {
        excelService.buildDrugSellExcel(response);
    }

    @RequiresPermissions("excel:query:suppliers")
    @Description(description = "获取供应商报表")
    @GetMapping(value = "/suppliers")
    public void getSuppliers(HttpServletResponse response) throws IOException {
        excelService.buildDrugSupplierExcel(response);
    }
}
