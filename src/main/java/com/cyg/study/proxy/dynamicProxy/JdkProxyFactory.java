package com.cyg.study.proxy.dynamicProxy;

import com.cyg.study.proxy.service.SmsService;
import com.cyg.study.proxy.impl.SmsServiceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author cyg
 * @date 2021/2/1 16:26
 **/
public class JdkProxyFactory {
    public static Object getProxy(Object target) {
        return Proxy.newProxyInstance(target.getClass().getClassLoader(), // 目标类的类加载
                target.getClass().getInterfaces(),  // 代理需要实现的接口，可指定多个
                new DebugInvocationHandler(target)   // 代理对象对应的自定义 InvocationHandler
        );
    }

    //实现纯接口的代理，不要实现类也行，模拟mybatis没有接口实现类的动态代理
    public static Object getInterfaceProxy() {
        return Proxy.newProxyInstance(SmsService.class.getClassLoader(), new Class[]{SmsService.class}, (proxy, method, args1) -> {
            //method.invoke(SmsService.class, args);
            System.out.println("start----");
            System.out.println("这里做自己的事情");
            System.out.println("end----");
            return "111";
        });
    }

    public static void main(String[] args) {
        SmsService smsService = (SmsService) JdkProxyFactory.getProxy(new SmsServiceImpl());
        smsService.send("JdkProxyFactory");
        SmsService smsService1 = (SmsService) getInterfaceProxy();
        smsService1.send("111");
    }
}
