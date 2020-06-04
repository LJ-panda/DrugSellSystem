package com.clay.system.model.enity;

import lombok.Data;

import javax.persistence.*;

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
public class SellRecordDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //用于关联
    @Column(name = "orderCode",columnDefinition = "int",nullable = false)
    private int orderCode;

    //药物代码
    @Column(name = "drugCode",columnDefinition = "int",nullable = false)
    private int drugCode;

    //药物数量
    @Column(name = "drugNum",columnDefinition = "tinyint",nullable = false)
    private int drugNum;

    //该药品的总价
    @Column(name = "drugPrice",columnDefinition = "float",nullable = false)
    private float drugPrice;

}
