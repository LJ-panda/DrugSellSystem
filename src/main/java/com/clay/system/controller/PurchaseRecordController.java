package com.clay.system.controller;

import com.clay.system.annotation.Description;
import com.clay.system.model.SystemResponse;
import com.clay.system.model.vo.BuyRecord;
import com.clay.system.service.RecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
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
@Api(value = "采购记录控制器，涉及药物入库问题")
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
    @ApiOperation(value = "采购提交接口",notes = "提交采购的数据表格")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "tip",value = "采购备注",dataType = "String",defaultValue = "备注"),
            @ApiImplicitParam(name = "operationUser",value = "采购人",dataType = "String",defaultValue = "采购测试员"),
            @ApiImplicitParam(name = "drugs",value = "采购药物集合",dataType = "Drug")
    })
    @RequiresPermissions("purchaseRecord:insert")
    @Description(description = "新增采购记录")
    @PostMapping(value = "/add")
    public SystemResponse add(@RequestBody
                              @Validated BuyRecord record)
    {
        log.info("新增采购记录，data：{}",record);

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
    @ApiOperation(value = "查询所有采购记录")
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
