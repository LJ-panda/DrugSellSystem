package com.clay.system.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/1 18:30
 * @Version 1.0
 *
 * WEB配置
 * 主要用于定制化配置MVC
 * 此处用于添加静态资源等
 */
@Configuration
public class WebConfig implements WebMvcConfigurer
{
    /**
     * 添加静态资源
     * @param registry  静态资源处理器注册
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

    }
}
