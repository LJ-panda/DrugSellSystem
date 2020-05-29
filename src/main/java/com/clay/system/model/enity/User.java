package com.clay.system.model.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_user")
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

    @Column(name = "status",columnDefinition = "tinyint default 1",nullable = false)
    private int status;

    @Column(name = "description",columnDefinition = "text")
    private String description;
}
