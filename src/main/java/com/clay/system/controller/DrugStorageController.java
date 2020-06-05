package com.clay.system.controller;

import com.clay.system.model.SystemResponse;
import com.clay.system.service.DrugStorageService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
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

    @GetMapping(value = "/query")
    public SystemResponse get()
    {
        return new SystemResponse()
                .success()
                .message("ok")
                .data(storageService.getAll());
    }
}
