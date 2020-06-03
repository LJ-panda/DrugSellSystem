package com.clay.system.utils;

import com.clay.system.model.enity.DrugStorage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/3 23:12
 * @Version 1.0
 */
class StaticUtilsTest
{
    @Test
    public void t()
    {
        DrugStorage storage01=new DrugStorage();
        storage01.setTypeCodeId(1);
        storage01.setSupplier(1244);
        storage01.setDrugNum(10);
        storage01.setDrugName("test");
        storage01.setDescription("dsafa");
        storage01.setSinglePrice(15);

        DrugStorage storage02=new DrugStorage();
        storage02.setTypeCodeId(1);
        storage02.setSupplier(1244);
        storage02.setDrugNum(10);
        storage02.setDrugName("test");
        storage02.setDescription("dsafa");
        storage02.setSinglePrice(15);

        System.out.println("01:"+storage01.hashCode()+"\t02:"+storage02.hashCode());
    }
}