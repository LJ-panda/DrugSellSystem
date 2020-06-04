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
 * @Date 2020/6/5 3:10
 * @Version 1.0
 *
 * 日志报表
 */
@Data
public class LogExcel
{
    @ExcelProperty(value = "日志ID")
    private int id;

    @ExcelProperty(value = "日志代码")
    private int type;

    @DateTimeFormat(value = StaticUtils.DATE_PATTERN)
    @ExcelProperty(value = "发生时间")
    private Date createTime;

    @ExcelProperty(value = "日志体")
    private String log;

}
