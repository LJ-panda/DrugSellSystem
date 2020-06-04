package com.clay.system.model.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.clay.system.utils.StaticUtils;
import lombok.Data;

import java.util.Date;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/5 2:08
 * @Version 1.0
 *
 * 药物库存的excel报表模型
 */
@Data
public class DrugStorageExcel
{
    @ExcelProperty(value = "库存ID")
    private int id;

    @ExcelProperty(value = "药物名")
    private String drugName;

    @ExcelProperty(value = "药物代码")
    private int drugCode;

    @ExcelProperty(value = "库存数量")
    private int drugNum;

    @ExcelProperty(value = "单价")
    private float singlePrice;

    @ExcelProperty(value = "药物类型")
    private String drugType;

    @ExcelProperty(value = "供应商代码")
    private int supplierCode;

    @DateTimeFormat(value = StaticUtils.DATE_PATTERN)
    @ExcelProperty(value = "入库时间")
    private Date createTime;

    @ExcelProperty(value = "药物简介")
    private String description;
}
