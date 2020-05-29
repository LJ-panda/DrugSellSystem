package com.clay.system.model.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

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
 * 别的信息通过表关联
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_drugStorage")
public class DrugStorage
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //药物名
    @Column(name = "drugName",columnDefinition = "varchar(88)",nullable = false)
    private String drugName;

    //数量
    @Column(name = "drugNum",columnDefinition = "int default 0",nullable = false)
    private int drugNum;

    //添加时间
    @Column(name = "createTime",columnDefinition = "timestamp",nullable = false)
    private Date createTime;

    //新增库存等的时间
    @Column(name = "updateTime",columnDefinition = "timestamp",nullable = false)
    private Date updateTime;

    //类型码的ID
    @Column(name = "typeCodeId",columnDefinition = "tinyint",nullable = false)
    private int typeCodeId;
}
