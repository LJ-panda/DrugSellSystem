package com.clay.system.model.enity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/5/29 20:34
 * @Version 1.0
 * 药品分类代码表
 * id 字段表示这个类型代码在该表的唯一id
 * id 即为分类代码
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "t_drugTypeCode")
public class DrugTypeCode
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "typeName",columnDefinition = "varchar(66)",nullable = false)
    private String typeName;


    @Column(name = "description",columnDefinition = "text")
    private String description;

}
