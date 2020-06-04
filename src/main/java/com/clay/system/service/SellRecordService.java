package com.clay.system.service;

import com.clay.system.exception.DrugSystemException;
import com.clay.system.model.enity.SellRecord;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/4 23:20
 * @Version 1.0
 *
 * 封装销售记录的服务
 * 订单概论服务
 */
public interface SellRecordService
{
    //存储一个记录
    void saveRecord(SellRecord record) throws DrugSystemException;
    //获取所有
    List<SellRecord>getAllRecord();
}
