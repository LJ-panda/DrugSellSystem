package com.clay.system.model.enity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

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
@Entity
@Table(name = "t_suppliers")
@SuppressWarnings("all")
public class DrugSuppliersInfo
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(max = 20,message = "供应商名称不可超过20字")
    @NotBlank(message = "供应商名称不可为空")
    //供应商名
    @Column(name = "name",columnDefinition = "varchar(66)",nullable = false)
    private String name;

    @Size(max = 15,message = "供应商商标不可超过15字")
    @NotBlank(message = "商标不可为空")
    //商标，无则和name相同
    @Column(name = "brand",columnDefinition = "varchar(20)",nullable = false)
    private String brand;

    @NotBlank(message = "联系电话不可为空")
    @Size(min = 5,max = 13,message = "电话请控制在长度5-13以内")
    //电话
    @Column(name = "phoneNum",columnDefinition = "varchar(11)",nullable = false)
    private String phoneNum;

    @Email(message = "请注意email格式")
    @Size(min = 5,max = 40,message = "邮箱长度请控制在5-40内")
    //Email
    @Column(name = "email",columnDefinition = "varchar(50)",nullable = false)
    private String email;

    @NotBlank(message = "联系地址不可为空")
    @Size(min = 2,max = 100,message = "联系地址长度请控制在2-100内")
    //地址
    @Column(name = "address",columnDefinition = "varchar(120)",nullable = false)
    private String address;

    //供应商对象hashcode,在其它信息已设定的情况下
    @Column(name = "supplierCode",columnDefinition = "int",nullable = false)
    private int supplierCode;
}
