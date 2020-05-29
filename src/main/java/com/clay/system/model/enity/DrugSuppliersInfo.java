package com.clay.system.model.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/5/29 20:56
 * @Version 1.0
 *
 * 供货商信息表
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_suppliers")
public class DrugSuppliersInfo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //供货啥名
    @Column(name = "name",columnDefinition = "varchar(66)",nullable = false)
    private String name;

    //商标
    @Column(name = "brand",columnDefinition = "varchar(20)",nullable = false)
    private String brand;

    //电话
    @Column(name = "phoneNum",columnDefinition = "varchar(11)",nullable = false)
    private String phoneNum;

    //Email
    @Column(name = "email",columnDefinition = "varchar(50)",nullable = false)
    private String email;

    //地址
    @Column(name = "address",columnDefinition = "varchar(120)",nullable = false)
    private String address;

    //供应商对象hashcode,在其它信息已设定的情况下
    @Column(name = "supplierCode",columnDefinition = "int",nullable = false)
    private int supplierCode;


}
