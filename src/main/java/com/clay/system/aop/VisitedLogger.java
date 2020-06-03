package com.clay.system.aop;

import com.clay.system.model.LogType;
import com.clay.system.service.LogService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.stereotype.Component;

/**
 * @Author clay
 * @Email wandererchen.xyz@foxmail.com
 * @Blog www.wandererchen.xyz
 * @Date 2020/6/2 17:31
 * @Version 1.0
 *
 *
 * 考虑在该对象中设置一个队列
 * 用于缓存日志
 * 当日志满一定量的时候进行加锁写库
 * 否则每次直接写库可能会导致比较缓慢
 */
@Slf4j
@Aspect
@Component
@AllArgsConstructor
@EnableAspectJAutoProxy
public class VisitedLogger extends BaseAop
{
    private LogService logService;

    //value = "execution(* com.clay.system.controller.*.*(..))"
    //通过注解来实现
    @Pointcut(value = "@annotation(com.clay.system.annotation.Description)")
    public void pointCut(){}

    @Around("pointCut()")
    public Object visitedHandler(ProceedingJoinPoint point) throws Throwable
    {
        Object[]args=point.getArgs();
        String methodName=point.getSignature().getName();
        String description=getDescription(point.getTarget().getClass(),
                (MethodSignature) point.getSignature());

        log.info("接口方法 {}\t 描述为 {} 被请求，参数为 {}",
                methodName, description, args);

        Object obj=point.proceed(args);
        logService.saveLog(initLog(description,LogType.VISITED));
        return obj;
    }
}
