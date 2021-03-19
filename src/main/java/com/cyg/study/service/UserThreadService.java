package com.cyg.study.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

/**
 * @author cyg
 * @date 2021/3/18 10:55
 **/
@Service
@Slf4j
public class UserThreadService {

    @Async("asyncServiceExecutor")
    public void serviceTest() {
        log.info("开启执行一个Service, 这个Service执行时间为30s, threadId:{}", Thread.currentThread().getId());
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.info("执行完成一个Service, threadId:{}", Thread.currentThread().getId());
    }
}
