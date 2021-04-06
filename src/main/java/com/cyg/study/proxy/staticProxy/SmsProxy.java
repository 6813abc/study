package com.cyg.study.proxy.staticProxy;

import com.cyg.study.proxy.service.SmsService;
import com.cyg.study.proxy.impl.SmsServiceImpl;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author cyg
 * @date 2021/2/1 16:18
 **/
public class SmsProxy implements SmsService {
    private final SmsService smsService;

    public SmsProxy(SmsService smsService) {
        this.smsService = smsService;
    }

    @Override
    public String send(String message) {
        //调用方法之前，我们可以添加自己的操作
        System.out.println("before method send()");
        smsService.send(message);
        //调用方法之后，我们同样可以添加自己的操作
        System.out.println("after method send()");
        return null;
    }

    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //静态代理
        SmsService smsService = new SmsServiceImpl();
        SmsProxy smsProxy = new SmsProxy(smsService);
        smsProxy.send("SmsProxy");

        //反射
        Class<?> tagetClass = Class.forName("com.cyg.study.proxy.impl.SmsServiceImpl");
        SmsService targetObject = (SmsServiceImpl) tagetClass.newInstance();
        Method[] methods = tagetClass.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
        Method publicMethod = tagetClass.getDeclaredMethod("send", String.class);
        publicMethod.invoke(targetObject, "reflection");
    }
}
