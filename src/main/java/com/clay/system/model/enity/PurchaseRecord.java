package com.clay.system.model.enity;

import com.clay.system.utils.StaticUtils;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/5/29 21:11
 * @Version 1.0
 *
 * 采购记录表
 */
@Data
@Entity
@Table(name = "t_purchaseRecord")
@SuppressWarnings("all")
public class PurchaseRecord
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    //小记录，用于描述本次采购记录
    @Column(name = "tip",columnDefinition = "text")
    private String tip;

    //采购时间
    @DateTimeFormat(pattern = StaticUtils.DATE_PATTERN)
    @Column(name = "time",columnDefinition = "timestamp")
    private Date time;

    //操作者
    @Column(name = "operationUser",columnDefinition = "varchar(55)")
    private String operationUser;

    //采购码，用于本次的整个采购对象的hash,和详情表关联
    @Column(name = "purchaseCode",columnDefinition = "int",nullable = false)
    private int purchaseCode;

    @Column(name = "totalPrice",columnDefinition = "float",nullable = false)
    private float totalPrice;

}
