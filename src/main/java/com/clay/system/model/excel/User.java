package com.clay.system.model.excel;

import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.write.style.ContentLoopMerge;
import com.alibaba.excel.annotation.write.style.OnceAbsoluteMerge;
import lombok.Data;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/5 1:54
 * @Version 1.0
 */
@Data
@OnceAbsoluteMerge(lastRowIndex = 1,lastColumnIndex = 2,firstColumnIndex = 0,firstRowIndex = 1)
public class User
{
    @ExcelProperty(value = "name")
    private String name;


    @ExcelProperty(value = "age")
    private int age;

    @ExcelProperty(value = "描述")
    private String des;

}
