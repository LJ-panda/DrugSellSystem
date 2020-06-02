package com.clay.system.exception.handler;

import com.clay.system.model.SystemResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.transaction.SystemException;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/2 15:16
 * @Version 1.0
 *
 * 全局异常处理器
 */
@Slf4j
@ResponseBody
@ControllerAdvice
public class GlobalExceptionHandler
{
    /**
     * 捕获锁定异常
     * @param lae
     * @return
     */
    @ExceptionHandler(LockedAccountException.class)
    public SystemResponse soultion01(LockedAccountException lae)
    {
        String msg=lae.getMessage();
        log.info("发生异常,信息：\t{}",msg);
        return new SystemResponse()
                .code(HttpStatus.LOCKED)
                .message(msg)
                .data(lae);
    }

    /**
     * 验证异常的处理器
     * 主要处理shiro验证时发生的登陆异常
     * @param ae
     * @return
     */
    @ExceptionHandler(AuthenticationException.class)
    public SystemResponse solution03(AuthenticationException ae)
    {
        String msg=ae.getMessage();
        log.info("发生异常，信息：\t{}",msg);
        return new SystemResponse()
                .code(HttpStatus.BAD_REQUEST)
                .message(msg)
                .data(ae);
    }

    /**
     * 其它的自定义异常处理器
     * @param se
     * @return
     */
    @ExceptionHandler(SystemException.class)
    public SystemResponse soultion02(SystemException se)
    {
        String msg=se.getMessage();
        log.info("发生异常，信息：\t{}",msg);
        return new SystemResponse()
                .code(HttpStatus.BAD_REQUEST)
                .message(msg)
                .data(se);
    }
}
