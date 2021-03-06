package com.clay.system.model.enity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/1 18:27
 * @Version 1.0
 *
 * 可能会用到的权限表
 */
@Data
@Entity
@Table(name = "t_permission")
@SuppressWarnings("all")
public class Permission
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //@NotBlank(message = "")
    @Column(name = "name",nullable = false)
    private String name;


    @Column(name = "description",columnDefinition = "text")
    private String description;


}
