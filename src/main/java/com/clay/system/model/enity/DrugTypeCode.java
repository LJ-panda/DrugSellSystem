package com.clay.system.model.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/5/29 20:34
 * @Version 1.0
 *
 *
 * 药品分类代码表
 * id 字段表示这个类型代码在该表的唯一id
 * id 即为分类代码
 */
@Data
@Entity
@Table(name = "t_drugTypeCode")
@SuppressWarnings("all")
public class DrugTypeCode
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "类型名不可为空")
    //类型名
    @Column(name = "typeName",columnDefinition = "varchar(66) COMMENT '类型名字'",nullable = false)
    private String typeName;


    @Size(max = 150,message = "描述请控制在150字以内")
    @Column(name = "description",columnDefinition = "text COMMENT '关于类型的描述'")
    private String description;

}
