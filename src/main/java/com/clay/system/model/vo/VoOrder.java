package com.clay.system.model.vo;

import com.clay.system.model.enity.SellRecordDetails;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/5 0:27
 * @Version 1.0
 *
 * 订单vo
 */
@Data
public class VoOrder
{
    @Positive(message = "不可小于等于0")
    private float totalPrice;
    @Valid
    private List<SellRecordDetails>details;
}
