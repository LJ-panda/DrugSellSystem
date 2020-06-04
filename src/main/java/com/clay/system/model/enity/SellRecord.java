package com.clay.system.model.enity;

import com.clay.system.utils.StaticUtils;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Objects;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/4 22:36
 * @Version 1.0
 *
 * 用于记录库存的扣减
 * 概论表
 * 因为该记录不存在两个需要重合的地方，所以全部字段均纳入hash
 */
@Data
@Entity
@Table(name = "t_sellRecord")
@SuppressWarnings("all")
public class SellRecord
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @DateTimeFormat(pattern = StaticUtils.DATE_PATTERN)
    @Column(name = "createTime",columnDefinition = "timestamp",nullable = false)
    private Date createTime;

    @Column(name = "operationUser",columnDefinition = "varchar(50) default '无名'")
    private String operationUser;

    @Column(name = "totalPrice",columnDefinition = "float",nullable = false)
    private float totalPrice;

    //订单码，根据对象生成
    @Column(name = "orderCode",columnDefinition = "int",nullable = false)
    private int orderCode;

    @Transient
    private List<SellRecordDetails>detailsList;

    public SellRecord()
    {
        this.createTime=new Date();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SellRecord that = (SellRecord) o;
        return id == that.id &&
                Float.compare(that.totalPrice, totalPrice) == 0 &&
                orderCode == that.orderCode &&
                Objects.equals(createTime, that.createTime) &&
                Objects.equals(operationUser, that.operationUser) &&
                Objects.equals(detailsList, that.detailsList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, createTime, operationUser, totalPrice, orderCode, detailsList);
    }
}
