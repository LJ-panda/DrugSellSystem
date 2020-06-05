package com.clay.system.model.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.write.style.OnceAbsoluteMerge;
import com.clay.system.utils.StaticUtils;
import lombok.Data;

import java.util.Date;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/5 2:33
 * @Version 1.0
 *
 * 药物采购报表详情
 */
@Data
//@OnceAbsoluteMerge(firstRowIndex = 1,lastRowIndex = 1,firstColumnIndex = 0,lastColumnIndex = 4)
public class DrugPurchaseExcel
{
    @ExcelProperty(value = "采购记录ID")
    private int id;

    @DateTimeFormat(value = StaticUtils.DATE_PATTERN)
    @ExcelProperty(value = "采购时间")
    private Date createTime;

    @ExcelProperty(value = "采购人")
    private String operationUser;

    @ExcelProperty(value = "采购代码")
    private int purchaseCode;

    @ExcelProperty(value = "采购总计价")
    private float totalPrice;

    @ExcelProperty(value = "采购小记")
    private String tip;


    //详情部分
    @ExcelProperty(value = "详情ID")
    private int detailId;

    @ExcelProperty(value = "药物代码")
    private int drugCode;

    @ExcelProperty(value = "药物数量")
    private int drugNum;

    @ExcelProperty(value = "本次采购单价")
    private float singlePrice;

    @ExcelProperty(value = "本种药物采购总价")
    private float detailsTotalPrice;

}
