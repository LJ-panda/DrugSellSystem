package com.clay.system.service;

import com.clay.system.model.enity.DrugSuppliersInfo;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/1 20:35
 * @Version 1.0
 */
public interface SupplierService
{
    void saveSupplier(DrugSuppliersInfo suppliersInfo);

    void saveSuppliers(List<DrugSuppliersInfo> suppliersInfos);

    DrugSuppliersInfo getByCode(int code);

    List<DrugSuppliersInfo> getAll();
}
