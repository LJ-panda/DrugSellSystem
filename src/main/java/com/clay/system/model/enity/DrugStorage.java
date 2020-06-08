package com.clay.system.model.enity;

import com.clay.system.utils.StaticUtils;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/5/29 20:42
 * @Version 1.0
 *
 *
 * 药品库存信息表
 * 应当记录一些药品核心信息
 * 别的信息通过表关联     例如类型代码、供应商
 */
@Data
@Entity
@Table(name = "t_drugStorage")
@SuppressWarnings("all")
public class DrugStorage
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //药品代码
    @Column(name = "drugCode",columnDefinition = "int",nullable = false)
    private int drugCode;
    //药物名
    @Column(name = "drugName",columnDefinition = "varchar(88)",nullable = false)
    private String drugName;

    //数量,件
    @Column(name = "drugNum",columnDefinition = "int default 0",nullable = false)
    private int drugNum;

    //新增单价字段，需要从写转换器工具方法
    @Column(name = "singlePrice",columnDefinition = "float",nullable = false)
    private float singlePrice;

    //添加时间
    @DateTimeFormat(pattern = StaticUtils.DATE_PATTERN)
    @Column(name = "createTime",columnDefinition = "timestamp")
    private Date createTime;

    //新增库存等的时间
    //两个 timestamp 字段会报错
    @DateTimeFormat(pattern = StaticUtils.DATE_PATTERN)
    @Column(name = "updatedTime",columnDefinition = "datetime")
    private Date updatedTime;

    //类型码的ID
    @Column(name = "typeCodeId",columnDefinition = "tinyint",nullable = false)
    private int typeCodeId;

    //供应商代码
    @Column(name = "supplier",columnDefinition = "int",nullable = false)
    private int supplier;

    //描述
    @Column(name = "description",columnDefinition = "text")
    private String description;


    //添加一个保质期
    @Column(name = "canUseTime",columnDefinition = "int",nullable = false)
    private int canUseTime;

}
