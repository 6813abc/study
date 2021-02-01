package com.cyg.study.proxy;

import com.cyg.study.proxy.SmsService;

/**
 * @author cyg
 * @date 2021/2/1 16:18
 **/
public class SmsServiceImpl implements SmsService {
    public String send(String message) {
        System.out.println("send message:" + message);
        return message;
    }
}
