package com.cyg.study.proxy.dynamicProxy;

import com.cyg.study.proxy.SmsService;
import com.cyg.study.proxy.SmsServiceImpl;

import java.lang.reflect.Proxy;

/**
 * @author cyg
 * @date 2021/2/1 16:26
 **/
public class JdkProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标类的类加载
                target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个
                new DebugInvocationHandler(target)   // 代理对象对应的自定义 InvocationHandler
        );
    }

    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("java");
    }
}