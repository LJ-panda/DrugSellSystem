package com.clay.system.mapper;

import com.clay.system.model.enity.PurchaseRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/5/30 20:02
 * @Version 1.0
 *
 * 采购记录映射器
 */
@Repository
public interface PurchaseRecordMapper
{
    int insertRecord(PurchaseRecord record);

    List<PurchaseRecord> queryAll();

    List<PurchaseRecord> queryById(int id);

    PurchaseRecord queryByCode(int code);
}
