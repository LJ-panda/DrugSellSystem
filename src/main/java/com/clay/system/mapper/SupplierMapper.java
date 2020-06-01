package com.clay.system.mapper;

import com.clay.system.model.enity.DrugSuppliersInfo;
import com.clay.system.model.vo.Drug;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/5/30 19:49
 * @Version 1.0
 *
 * 供应商映射器
 */
@Repository
public interface SupplierMapper
{
    int insertSupplier(List<DrugSuppliersInfo>suppliersInfos);

    List<DrugSuppliersInfo>queryAll();

    DrugSuppliersInfo queryBySupplierCode(int code);

    int insert(DrugSuppliersInfo suppliersInfo);
}
