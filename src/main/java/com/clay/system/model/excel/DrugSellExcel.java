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
 * @Date 2020/6/5 2:26
 * @Version 1.0
 *
 * 药物销售报表
 */
@Data
public class DrugSellExcel
{
    @ExcelProperty(value = "销售组ID")
    private int id;

    @DateTimeFormat(value = StaticUtils.DATE_PATTERN)
    @ExcelProperty(value = "交易时间")
    private Date createTime;

    @ExcelProperty(value = "操作人")
    private String operationUser;

    @ExcelProperty(value = "订单码")
    private int orderCode;

    @ExcelProperty(value = "整单总价")
    private float totalPrice;

    @ExcelProperty(value = "单内详情ID")
    private int detailsId;

    @ExcelProperty(value = "单内药物代码")
    private int drugCode;

    @ExcelProperty(value = "单内药物数量")
    private int drugNum;

    @ExcelProperty(value = "单内该药物单价")
    private float drugPrice;



}
