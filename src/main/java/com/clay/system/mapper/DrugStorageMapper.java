package com.clay.system.mapper;

import com.clay.system.model.enity.DrugStorage;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/5/30 19:46
 * @Version 1.0
 *
 * 药品库存映射
 */
@Repository
public interface DrugStorageMapper
{
    int insertDrugInfo(DrugStorage drugStorage);

    List<DrugStorage>queryAll();

    List<DrugStorage>queryByType(int typeCode);

    List<DrugStorage>queryBySupplier(int supplierCode);

    List<DrugStorage>queryById(int id);

    int insertAll(List<DrugStorage>drugStorages);

    DrugStorage queryByCode(int drugCode);

    int update(DrugStorage drugStorage);
}
