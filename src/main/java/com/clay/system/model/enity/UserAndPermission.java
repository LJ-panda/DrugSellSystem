package com.clay.system.model.enity;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/2 18:43
 * @Version 1.0
 */
@Data
@Entity
@Table(name = "t_userAndPermission")
@SuppressWarnings("all")
public class UserAndPermission
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "userId",columnDefinition = "int",nullable = false)
    private int userId;

    @Column(name = "pId",columnDefinition = "int",nullable = false)
    private int pId;
}
