package com.clay.system.service;

import com.clay.system.model.enity.TimeOutDrug;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/8 21:19
 * @Version 1.0
 *
 * 药物过期的处理服务
 *
 */
public interface DrugTimeOutService
{
    void save(TimeOutDrug drug);

    void saveAll(List<TimeOutDrug>drugList);

    List<TimeOutDrug>getAll();

    List<TimeOutDrug>getByTypeCode(int typeCode);

    List<TimeOutDrug>getBySupplierCode(int supplierCode);
}
