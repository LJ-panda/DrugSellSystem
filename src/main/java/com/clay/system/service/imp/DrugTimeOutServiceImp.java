package com.clay.system.service.imp;

import com.clay.system.mapper.DrugOutMapper;
import com.clay.system.model.enity.TimeOutDrug;
import com.clay.system.service.DrugStorageService;
import com.clay.system.service.DrugTimeOutService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/8 21:25
 * @Version 1.0
 *
 * 药物过期服务具体实现
 * 依赖mapper：{@link DrugOutMapper}
 * 服务：{@link DrugStorageService}
 *
 * 还是通过查询库存向过期里写？
 */
@Slf4j
@Service
@AllArgsConstructor
public class DrugTimeOutServiceImp implements DrugTimeOutService
{
    private DrugOutMapper drugOutMapper;

    //private DrugStorageService storageService;

    /**
     * 持久化一个过期药物
     * @param drug 药物对象
     */
    @Override
    public void save(TimeOutDrug drug)
    {
        log.debug("过期药物服务层持久化药物，drug：{}",drug);
        drugOutMapper.insert(drug);
    }

    /**
     * 持久化一系列的对象
     * @param drugList list
     */
    @Override
    public void saveAll(List<TimeOutDrug> drugList) {
        log.debug("药物过期服务层持久化一批药物，drugList：{}",drugList);
        drugOutMapper.insertAll(drugList);
    }

    @Override
    public List<TimeOutDrug> getAll()
    {
        return drugOutMapper.queryAll();
    }

    @Override
    public List<TimeOutDrug> getByTypeCode(int typeCode) {
        return drugOutMapper.queryByTypeCode(typeCode);
    }

    @Override
    public List<TimeOutDrug> getBySupplierCode(int supplierCode) {
        return drugOutMapper.queryBySupplierCode(supplierCode);
    }
}
