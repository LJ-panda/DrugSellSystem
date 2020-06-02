package com.clay.system.controller;

import com.clay.system.annotation.Description;
import com.clay.system.model.SystemResponse;
import com.clay.system.model.enity.DrugSuppliersInfo;
import com.clay.system.service.SupplierService;
import lombok.AllArgsConstructor;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/2 17:16
 * @Version 1.0
 *
 * 供应商信息控制器
 * 需要服务：{@link SupplierService}
 */
//@Slf4j
@RestController
@RequestMapping(value = "/api/supplier")
@AllArgsConstructor
public class SupplierInfoController
{
    private SupplierService supplierService;

    /**
     * 获取所有供应商信息
     * 需要权限：supplierInfo:queryAll
     * @return
     */
    @RequiresPermissions("supplierInfo:queryAll")
    @Description(description = "获取所有供应商信息")
    @GetMapping(value = "/query")
    public SystemResponse getAll()
    {
        return new SystemResponse()
                .success()
                .message("ok")
                .data(supplierService.getAll());
    }

    /**
     * 根据代码获取供应商信息
     * 主要用于药物查询的时候
     * 需要权限：supplierInfo:query
     * @param code code
     * @return
     */
    @RequiresPermissions("supplierInfo:query")
    @Description(description = "根据代码获取供应商信息")
    @GetMapping(value = "/query/code/{code}")
    public SystemResponse queryByCode(@PathVariable int code)
    {
        return new SystemResponse()
                .success()
                .message("ok")
                .data(supplierService.getByCode(code));
    }

    /**
     * 新增后并返回新增的数据
     * 需要权限：supplierInfo:insert
     * @param suppliersInfo 数据
     * @return
     */
    @RequiresPermissions("supplierInfo:insert")
    @Description(description = "新增药物供应商")
    @PostMapping(value = "/add")
    public SystemResponse add(@Validated DrugSuppliersInfo suppliersInfo)
    {
        supplierService.saveSupplier(suppliersInfo);
        return new SystemResponse()
                .success()
                .message("ok")
                .data(supplierService.getAll());
    }
}
