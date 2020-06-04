package com.clay.system.mapper;

import com.clay.system.model.enity.SellRecordDetails;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/4 23:13
 * @Version 1.0
 *
 * 订单详情mapper
 */
@Repository
public interface SellRecordDetailsMapper
{
    int insertDetails(SellRecordDetails recordDetails);

    List<SellRecordDetails>queryByOrderCode(int orderCode);
}
