package com.clay.system.controller;

import com.clay.system.annotation.Description;
import com.clay.system.model.LogType;
import com.clay.system.model.SystemResponse;
import com.clay.system.service.LogService;
import lombok.AllArgsConstructor;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.validation.constraints.PositiveOrZero;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/2 17:50
 * @Version 1.0
 *
 * 日志控制器
 * 需要服务：{@link LogService}
 */
@Validated
@RestController
@RequestMapping(value = "/api/log")
@AllArgsConstructor
public class LogController
{
    private LogService logService;

    /**
     * 查询所有日志
     * 需要权限：log:queryAll
     * @return
     */
    @RequiresPermissions("log:queryAll")
    @Description(description = "日志查询")
    @GetMapping(value = "/query")
    public SystemResponse query()
    {
        return new SystemResponse()
                .success()
                .message("ok")
                .data(logService.getAllLog());
    }

    /**
     * 通过日志类型查询日志
     * 需要权限：log:query
     * @param type 类型代码
     * @return
     */
    @RequiresPermissions("log:query")
    @Description(description = "通过类型查询")
    @GetMapping(value = "/query/type/{type}")
    public SystemResponse queryByType(@PositiveOrZero(message = "类别不可小于0")
                                          @PathVariable int type)
    {
       Assert.isTrue(check(type),"查询类型异常");
        return new SystemResponse()
                .success()
                .message("ok")
                .data(logService.getAllByType(type));
    }

    /**
     * 检查查询日志的参数
     * @param type
     * @return
     */
    private boolean check(int type)
    {
        for (LogType logType:LogType.values())
        {
            if (logType.getVal()==type)
            {
                return true;
            }
        }
        return false;
    }
}
