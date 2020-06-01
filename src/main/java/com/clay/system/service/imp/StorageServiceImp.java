package com.clay.system.service.imp;

import com.clay.system.mapper.DrugStorageMapper;
import com.clay.system.model.enity.DrugStorage;
import com.clay.system.service.DrugStorageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/1 21:27
 * @Version 1.0
 */
@Slf4j
@Service
@AllArgsConstructor
public class StorageServiceImp implements DrugStorageService
{
    private DrugStorageMapper storageMapper;

    /**
     * 修改库存
     * 数据库中有，则更改数据
     * 否则就插入数据
     * @param storageList
     */
    @Override
    public void saveDrugs(List<DrugStorage> storageList)
    {
       storageList.forEach(drug->{
           if (getByCode(drug.getDrugCode())!=null)
           {
               updateNum(drug);
           }
           else
           {
               storageMapper.insertDrugInfo(drug);
           }
       });
    }

    @Override
    public void updateNum(DrugStorage storage)
    {
        storageMapper.update(storage);
    }

    @Override
    public DrugStorage getByCode(int code)
    {
        return storageMapper.queryByCode(code);
    }
}
