package com.clay.system.controller;

import com.clay.system.annotation.Description;
import com.clay.system.model.SystemResponse;
import com.clay.system.service.DrugStorageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/5 21:19
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/storage")
@AllArgsConstructor
public class DrugStorageController
{
    private DrugStorageService storageService;

    @RequiresPermissions(value = "storage:query")
    @Description(description = "药物库存数据获取")
    @GetMapping(value = "/query")
    public SystemResponse get()
    {
        return new SystemResponse()
                .success()
                .message("drugList")
                .data(storageService.getAll());
    }

    @RequiresPermissions(value = "storage:delete")
    @Description(description = "通过id删除药物")
    @GetMapping(value = "/del/{id}")
    public SystemResponse del(@PathVariable int id)
    {
        storageService.delById(id);
        return new SystemResponse()
                .success()
                .message("删除ok")
                .data(null);
    }
}
