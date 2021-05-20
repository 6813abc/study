package com.cyg.study.aspect;

/**
 * @author cyg
 * @date 2021/5/20 16:24
 **/

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;


@Aspect
@Component
@Order(1)
@Slf4j
public class WebLogAspect {
    //获取线程副本
    ThreadLocal<Long> startTime = new ThreadLocal<>();

    @Pointcut("execution(* com.cyg.study.controller.*.*(..))")
    public void weblog() {
    }

    @Before("weblog()")
    public void doBefore(JoinPoint joinPoint) {
        //获取请求报文头部元数据
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        //获取请求对象
        HttpServletRequest request = requestAttributes.getRequest();
        //记录控制器执行前的时间毫秒数
        startTime.set(System.currentTimeMillis());
        log.info("前置通知执行：");
        log.info("url:" + request.getRequestURL());
        log.info("method:" + request.getMethod());
        log.info("ip:" + request.getRemoteAddr());
        log.info("class_method:" + joinPoint.getSignature().getDeclaringTypeName() +
                "." + joinPoint.getSignature().getName());
        log.info("args:" + Arrays.toString(joinPoint.getArgs()));
    }

    @AfterReturning(returning = "ret", pointcut = "weblog()")
    public void doAfter(Object ret) {
        log.info("后置通知执行：");
        log.info("RESPONSE:" + ret);
        log.info("spend:" + (System.currentTimeMillis() - startTime.get()));
    }

}