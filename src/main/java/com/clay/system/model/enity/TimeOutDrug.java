package com.clay.system.model.enity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/8 20:41
 * @Version 1.0
 *
 * 过期药物表
 * 目前的想法是在药物库存表里添加一个保质期字段
 * 保质期为天，
 * 然后每次查询库存的时候触发一个检测有没有过期的操作
 * 过期则触发一个库存删除和过期表写入事件
 */
@Data
@Entity
@Table(name = "t_timeOutDrug")
@SuppressWarnings("all")
public class TimeOutDrug
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "drugName",columnDefinition = "varchar(50)",nullable = false)
    private String drugName;

    @Column(name = "drugCode",columnDefinition = "int",nullable = false)
    private int drugCode;

    @Column(name = "drugNum",columnDefinition = "int",nullable = false)
    private int drugNum;

    @Column(name = "typeCode",columnDefinition = "tinyint",nullable = false)
    private int typeCode;

    @Column(name = "supplierCode",columnDefinition = "int",nullable = false)
    private int supplierCode;

    @Column(name = "singlePrice",columnDefinition = "float",nullable = false)
    private float singlePrice;

    @Column(name = "description",columnDefinition = "text")
    private String description;

}
