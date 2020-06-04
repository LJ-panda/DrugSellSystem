package com.clay.system.model.enity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/5/29 21:53
 * @Version 1.0
 *
 * 采购详情表
 * 采购记录中的某一种药品的详情
 */
@Data
@Entity
@Table(name = "t_purchaseDetails")
@SuppressWarnings("all")
public class PurchaseDetails
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //采购码,用于关联采购表
    @Column(name = "purchaseCode",columnDefinition = "int COMMENT '采购码'",nullable = false)
    private int purchaseCode;

    //药品代码
    @Column(name = "drugCode",columnDefinition = "int COMMENT '药物代码'",nullable = false)
    private int drugCode;

    //采购量
    @Column(name = "drugNum",columnDefinition = "int COMMENT '本次采购数'",nullable = false)
    private int drugNum;

    //单价
    @Column(name = "singlePrice",columnDefinition = "float COMMENT '采购单价'",nullable = false)
    private float singlePrice;

    @Column(name = "totalPrice",columnDefinition = "float COMMENT '本批药物采购总价'",nullable = false)
    private float totalPrice;
}
