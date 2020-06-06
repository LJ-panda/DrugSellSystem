package com.clay.system.model.enity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/5/29 21:28
 * @Version 1.0
 *
 * 用户表
 */
@Data
@Entity
@Table(name = "t_user")
@SuppressWarnings("all")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "userName",columnDefinition = "varchar(15)")
    private String userName;

    @Column(name = "email",columnDefinition = "varchar(45)",nullable = false)
    private String email;

    @Column(name = "password",columnDefinition = "varchar(20)",nullable = false)
    private String password;

    //1 正常,-1 禁用
    @Column(name = "status",columnDefinition = "tinyint default 1",nullable = false)
    private int status;

    @Column(name = "description",columnDefinition = "text")
    private String description;

    //主要用于接收前端数据
    @Transient
    private List<Permission>permissions;
}
