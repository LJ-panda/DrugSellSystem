package com.clay.system.exception.handler;

import com.clay.system.aop.BaseAop;
import com.clay.system.exception.DrugSystemException;
import com.clay.system.model.LogType;
import com.clay.system.model.SystemResponse;
import com.clay.system.service.LogService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.LockedAccountException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/2 15:16
 * @Version 1.0
 *
 * 全局异常处理器
 * 需要服务：{@link LogService}
 */
@Slf4j
@ResponseBody
@ControllerAdvice
@AllArgsConstructor
public class GlobalExceptionHandler
{
    private LogService logService;

    /**
     * 捕获锁定异常
     * @param lae exception
     * @return
     */
    @ExceptionHandler(LockedAccountException.class)
    public SystemResponse soultion01(LockedAccountException lae)
    {
        String msg=lae.getMessage();
        log.info("发生异常,信息：\t{}",msg);
        logService.saveLog(BaseAop.initLog(msg, LogType.EXCEPTION));
        return new SystemResponse()
                .code(HttpStatus.LOCKED)
                .message(msg)
                .data(null);
    }

    /**
     * 验证异常的处理器
     * 主要处理shiro验证时发生的登陆异常
     * @param ae exception
     * @return
     */
    @ExceptionHandler(AuthenticationException.class)
    public SystemResponse solution03(AuthenticationException ae)
    {
        String msg=ae.getMessage();
        log.info("发生异常，信息：\t{}",msg);
        logService.saveLog(BaseAop.initLog(msg, LogType.EXCEPTION));
        return new SystemResponse()
                .code(HttpStatus.BAD_REQUEST)
                .message(msg)
                .data(null);
    }

    /**
     * 其它的自定义异常处理器
     * @param se exception
     * @return
     */
    @ExceptionHandler(DrugSystemException.class)
    public SystemResponse soultion02(DrugSystemException se)
    {
        String msg=se.getMessage();
        log.info("发生异常，信息：\t{}",msg);
        logService.saveLog(BaseAop.initLog(msg, LogType.EXCEPTION));
        return new SystemResponse()
                .code(HttpStatus.BAD_REQUEST)
                .message(msg)
                .data(null);
    }

    /**
     * 其它
     * @param e exception
     * @return
     */
    @ExceptionHandler(Exception.class)
    public SystemResponse soultion04(Exception e)
    {
        String msg=e.getMessage();
        log.info("发生异常，信息：\t{}",msg);
        logService.saveLog(BaseAop.initLog(msg, LogType.EXCEPTION));
        return new SystemResponse()
                .code(HttpStatus.BAD_REQUEST)
                .message(msg)
                .data(null);
    }

}
