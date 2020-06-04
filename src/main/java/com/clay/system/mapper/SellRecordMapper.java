package com.clay.system.mapper;

import com.clay.system.model.enity.SellRecord;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/4 23:03
 * @Version 1.0
 *
 * 销售记录的mapper
 */
@Repository
public interface SellRecordMapper
{
    int insertRecord(SellRecord record);

    List<SellRecord>queryAll();
}
