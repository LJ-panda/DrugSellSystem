package com.clay.system.model.vo;

import com.clay.system.utils.StaticUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/5/30 13:47
 * @Version 1.0
 *
 * 购买记录对象
 */
@Data
@AllArgsConstructor
public class BuyRecord
{
    private int id;

    private String tip;   //采购小记

    private int purchaseCode;  //采购码

    @DateTimeFormat(pattern = StaticUtils.DATE_PATTERN)
    private Date time;

    private List<Drug>drugs;   //采购的药品细节

    public BuyRecord()
    {
        time=new Date();
    }
}
