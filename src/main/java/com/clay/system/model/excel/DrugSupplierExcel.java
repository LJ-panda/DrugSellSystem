package com.clay.system.model.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/5 2:15
 * @Version 1.0
 *
 * 供应商报表 excel
 */
@Data
public class DrugSupplierExcel
{
    @ExcelProperty(value = "供应商ID")
    private int id;

    @ExcelProperty(value = "供应商代码")
    private int supplierCode;

    @ExcelProperty(value = "名称")
    private String name;

    @ExcelProperty(value = "商标")
    private String brand;

    @ExcelProperty(value = "联系电话")
    private String phoneNum;

    @ExcelProperty(value = "邮箱")
    private String email;

    @ExcelProperty(value = "地址")
    private String address;
}
