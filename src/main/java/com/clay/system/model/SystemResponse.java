package com.clay.system.model;

import org.springframework.http.HttpStatus;

import java.util.HashMap;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/5/29 20:29
 * @Version 1.0
 *
 *
 * 统一响应体
 */
public class SystemResponse extends HashMap<String, Object>
{
    public SystemResponse code(HttpStatus status)
    {
        this.put("code",status.value());
        return this;
    }

    public SystemResponse message(String msg)
    {
        this.put("msg",msg);
        return this;
    }

    public SystemResponse data(Object obj)
    {
        this.put("data",obj);
        return this;
    }

    public SystemResponse success()
    {
        this.put("code",HttpStatus.OK);
        return this;
    }

    public SystemResponse defaultResponse()
    {
        this.success()
                .message("OK")
                .data(null);
        return this;
    }
}
