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
 *
 * 用户报表
 */
@Data
//@OnceAbsoluteMerge(lastRowIndex = 1,lastColumnIndex = 2,firstColumnIndex = 0,firstRowIndex = 1)
public class UserExcel
{
    @ExcelProperty(value = "用户名")
    private String name;


    @ExcelProperty(value = "邮箱")
    private String email;

    @ExcelProperty(value = "状态")
    private String status;

    @ExcelProperty(value = "描述")
    private String des;

}
