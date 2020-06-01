package com.clay.system.model.vo;

import com.clay.system.model.enity.DrugSuppliersInfo;
import com.clay.system.utils.StaticUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/5/30 13:19
 * @Version 1.0
 *
 * 还应该封装供应商等信息
 */
@Data
@AllArgsConstructor
public class Drug
{
    private int id; //药品库id

    private int drugCode;

    private String drugName;  //药物名

    private int drugNum;

    private float singlePrice;

    private int typeCode;   //通过增添页下拉选取

    private DrugSuppliersInfo suppliersInfo;  //供应商

    private String description;

    @DateTimeFormat(pattern = StaticUtils.DATE_PATTERN)
    private Date createTime;            //添加时间

    public Drug()
    {
        this.createTime=new Date();
    }
}
