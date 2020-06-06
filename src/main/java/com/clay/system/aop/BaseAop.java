package com.clay.system.aop;

import com.clay.system.annotation.Description;
import com.clay.system.model.LogType;
import com.clay.system.model.enity.SystemLog;
import org.aspectj.lang.reflect.MethodSignature;

import java.lang.reflect.Method;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/2 15:57
 * @Version 1.0
 */
public abstract class BaseAop
{
    /**
     * 获取控制器的接口描述
     * @param targetClass  Class对象
     * @param ms   ms
     * @return
     * @throws NoSuchMethodException
     */
    public String getDescription(Class<?>targetClass, MethodSignature ms)
            throws NoSuchMethodException
    {
        Method exeMethod=targetClass.getMethod(ms.getName(),ms.getParameterTypes());
        if (exeMethod!=null)
        {
            Description anon=exeMethod.getAnnotation(Description.class);
            if (anon!=null)
            {
                return anon.description();
            }
        }
        //logger.info("接口方法解析失败");
        return null;
    }

    /**
     * 封装的日志构建工具
     * @param msg 日志体
     * @param type  类型枚举
     * @return
     */
    public static SystemLog initLog(String msg, LogType type)
    {
        SystemLog log=new SystemLog();
        log.setLogType(type.getVal());
        log.setLogBody(msg==null?"无":msg);
        return log;
    }
}
