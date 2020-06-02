package com.clay.system.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/2 15:54
 * @Version 1.0
 *
 *
 * 描述注解
 * 用于描述控制器的每一个接口
 * 用于全局访问日志等
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Description
{
    String description() default "接口描述";
}
