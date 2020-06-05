package com.clay.system.service;

import com.clay.system.model.enity.DrugStorage;

import java.util.List;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/1 20:31
 * @Version 1.0
 */
public interface DrugStorageService
{
    void saveDrugs(List<DrugStorage> storageList);

    void updateNum(DrugStorage storage);  //数据库中有完全相同的库存时进行更新

    DrugStorage getByCode(int code);

    List<DrugStorage> getAll();
}
