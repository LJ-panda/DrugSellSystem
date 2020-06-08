package com.clay.system.mapper;

import com.clay.system.model.enity.TimeOutDrug;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/8 20:55
 * @Version 1.0
 *
 * 药物过期实体的mapper
 */
@Repository
public interface DrugOutMapper
{
    int insert(TimeOutDrug drug);

    int insertAll(List<TimeOutDrug>drugs);

    List<TimeOutDrug>queryAll();

    List<TimeOutDrug>queryByTypeCode(int typeCode);

    List<TimeOutDrug>queryBySupplierCode(int supplierCode);
}
