package com.clay.system.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
public class ViewController
{
    /**
     * 登陆页面
     * @return
     */
    @GetMapping(value = "/user/toLogin")
    public String toLogin()
    {
        return "toLogin";
    }
}
