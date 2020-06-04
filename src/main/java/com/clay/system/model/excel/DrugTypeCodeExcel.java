package com.clay.system.model.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/5 2:19
 * @Version 1.0
 */
@Data
public class DrugTypeCodeExcel
{
    @ExcelProperty(value = "类型代码")
    private int typeId;

    @ExcelProperty(value = "类型名")
    private String name;

    @ExcelProperty(value = "类型说明")
    private String description;
}
