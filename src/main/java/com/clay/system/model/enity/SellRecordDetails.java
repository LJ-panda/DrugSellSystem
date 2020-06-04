package com.clay.system.model.enity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/4 22:46
 * @Version 1.0
 *
 * 销售记录详情
 */
@Data
@Entity
@Table(name = "t_sellDetails")
@SuppressWarnings("all")
public class SellRecordDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //用于关联
    @Column(name = "orderCode",columnDefinition = "int",nullable = false)
    private int orderCode;

    @NotBlank(message = "必须有代码")
    //药物代码
    @Column(name = "drugCode",columnDefinition = "int",nullable = false)
    private int drugCode;

    @Positive(message = "数量必须大于0")
    //药物数量
    @Column(name = "drugNum",columnDefinition = "tinyint",nullable = false)
    private int drugNum;

    //该药品的单价
    @Column(name = "drugPrice",columnDefinition = "float",nullable = false)
    private float drugPrice;

}
