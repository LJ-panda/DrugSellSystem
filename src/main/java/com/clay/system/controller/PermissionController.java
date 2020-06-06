package com.clay.system.controller;

import com.clay.system.annotation.Description;
import com.clay.system.mapper.PermissionMapper;
import com.clay.system.model.SystemResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/6 18:54
 * @Version 1.0
 */
@Slf4j
@RestController
@RequestMapping(value = "/api/per")
@AllArgsConstructor
public class PermissionController
{
    private PermissionMapper mapper;

    @Description(description = "获取所有权限")
    @GetMapping(value = "/query")
    public SystemResponse queryAll()
    {
        return new SystemResponse()
                .success()
                .message("ok")
                .data(mapper.queryAll());
    }
}
