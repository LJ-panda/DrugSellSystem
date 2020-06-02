package com.clay.system.service.imp;

import com.clay.system.mapper.SupplierMapper;
import com.clay.system.model.enity.DrugSuppliersInfo;
import com.clay.system.service.SupplierService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/1 20:55
 * @Version 1.0
 *
 * 供应商服务
 */
@Slf4j
@Service
@AllArgsConstructor
public class SupplierServiceImp implements SupplierService
{
    private SupplierMapper supplierMapper;

    @Override
    public void saveSupplier(DrugSuppliersInfo suppliersInfo)
    {
        if (Objects.nonNull(getByCode(suppliersInfo.getSupplierCode())))
        {
            log.debug("供应商：{}\t已存在",suppliersInfo);
            return;
        }
        supplierMapper.insert(suppliersInfo);
    }

    @Override
    public void saveSuppliers(List<DrugSuppliersInfo> suppliersInfos)
    {
        suppliersInfos.forEach(this::saveSupplier);
    }

    /**
     * 查询供应商表里有没有该供应商
     * @param code 供应商代码
     * @return
     */
    @Override
    public DrugSuppliersInfo getByCode(int code)
    {
        return supplierMapper.queryBySupplierCode(code);
    }

    @Override
    public List<DrugSuppliersInfo> getAll() {
        return supplierMapper.queryAll();
    }
}
