package com.clay.system.service;

import com.clay.system.model.enity.PurchaseRecord;
import com.clay.system.model.vo.BuyRecord;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/1 18:34
 * @Version 1.0
 *
 * 采购记录服务
 * 该接口主要是封装采购记录对象的处理
 * 另一个接口会封装详情处理 {@link DetailsService}
 * 实现类 {@link com.clay.system.service.imp.PurchaseServiceImp}
 *
 */
public interface RecordService
{
    //接收的是vo对象，需要转换
    int saveRecord(BuyRecord record);

    //通过采购吗获取记录
    PurchaseRecord queryARecordByCode(int code);

    List<PurchaseRecord> queryAllRecord();
}
