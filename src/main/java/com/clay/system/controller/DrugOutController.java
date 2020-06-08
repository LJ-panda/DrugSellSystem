package com.clay.system.controller;

import com.clay.system.annotation.Description;
import com.clay.system.model.SystemResponse;
import com.clay.system.service.DrugTimeOutService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/8 22:19
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/outdrug")
@AllArgsConstructor
@Api(value = "过期药物数据控制器")
public class DrugOutController
{
    private DrugTimeOutService outService;

    /**
     * 过期药物数据查询
     * @return
     */
    @ApiOperation(value = "获取过期药物数据",notes = "不过获取前请先查询库存，触发过期检测")
    @RequiresPermissions("outTimeDrug:query")
    @Description(description = "获取过期药物")
    @GetMapping(value = "/query")
    public SystemResponse query()
    {
        return new SystemResponse()
                .success()
                .message("ok")
                .data(outService.getAll());
    }
}
