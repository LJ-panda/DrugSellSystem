package com.clay.system.model.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/9 1:19
 * @Version 1.0
 *
 * 过期药物报表
 */
@Data
public class DrugTimeOutExcel
{
    @ExcelProperty(value = "ID")
    private int id;

    @ExcelProperty(value = "药物名")
    private String drugName;

    @ExcelProperty(value = "药物代码")
    private int drugCode;

    @ExcelProperty(value = "类型")
    private String typeName;

    @ExcelProperty(value = "供应商代码")
    private int supplierCode;

    @ExcelProperty(value = "单价")
    private float singlePrice;

    @ExcelProperty(value = "描述")
    private String description;
}
