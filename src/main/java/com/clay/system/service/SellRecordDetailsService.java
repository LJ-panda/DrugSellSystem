package com.clay.system.service;

import com.clay.system.exception.DrugSystemException;
import com.clay.system.model.enity.SellRecordDetails;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/4 23:22
 * @Version 1.0
 *
 * 销售详情服务
 */
public interface SellRecordDetailsService
{
    void saveDetails(List<SellRecordDetails>detailsList) throws DrugSystemException;

    List<SellRecordDetails>getByOrderCode(int orderCode);
}
