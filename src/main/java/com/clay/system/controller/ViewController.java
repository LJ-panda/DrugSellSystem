package com.clay.system.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/2 15:37
 * @Version 1.0
 *
 * 视图控制器
 * 为前端提供视图
 */
@Slf4j
@Controller
@RequestMapping(value = "/view")
public class ViewController
{
    /**
     * 登陆页面
     * @return login.ftl
     */
    @GetMapping(value = "/user/toLogin")
    public String toLogin()
    {
        return "login";
    }

    /**
     * 登陆成功后进入用户主页
     * @return  index.ftl
     */
    @GetMapping(value = "/user/index")
    public String toIndex()
    {
        return "index";
    }

    /**
     * 用于前端获取详情表格部分
     * 没毛病
     * @return
     */
    @GetMapping(value = "/part/details")
    public String details()
    {
        log.info("details请求");
        return "part/details";
    }

    @GetMapping(value = "/part/record")
    public String record()
    {
        return "part/record";
    }

    @GetMapping(value = "/test")
    public String test()
    {
        return "Record02";
    }

    @GetMapping(value = "/part/table")
    public String table()
    {
        return "part/pageTable";
    }
}
