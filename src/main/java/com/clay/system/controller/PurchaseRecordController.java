package com.clay.system.controller;

import com.clay.system.annotation.Description;
import com.clay.system.model.SystemResponse;
import com.clay.system.model.vo.BuyRecord;
import com.clay.system.service.RecordService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/2 16:11
 * @Version 1.0
 *
 * 采购记录控制器
 *
 * 需要服务：{@link RecordService}
 *
 */
@Slf4j
//@Validated
@RestController
@RequestMapping(value = "/api/record")
@AllArgsConstructor
public class PurchaseRecordController
{
    private RecordService recordService;

    /**
     * 新增采购记录
     * 需要效验
     * 权限：purchaseRecord:insert
     * @param record 记录
     * @return
     */
    @RequiresPermissions("purchaseRecord:insert")
    @Description(description = "新增采购记录")
    @PostMapping(value = "/add")
    public SystemResponse add(@RequestBody
                              @Validated BuyRecord record)
    {
        log.debug("新增采购记录，data：{}",record);

        recordService.saveRecord(record);
        return new SystemResponse()
                .success()
                .message("ok")
                .data(null);
    }

    /**
     * 查询所有的采购记录
     * 需要权限：purchaseRecord:queryAll
     * @return
     */
    @RequiresPermissions("purchaseRecord:queryAll")
    @Description(description = "查询All采购记录")
    @GetMapping(value = "/query")
    public SystemResponse getAll()
    {
        return new SystemResponse()
                .success()
                .message("ok")
                .data(recordService.queryAllRecord());
    }



}
