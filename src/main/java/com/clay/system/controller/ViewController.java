package com.clay.system.controller;

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
}
