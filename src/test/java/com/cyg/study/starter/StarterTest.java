package com.cyg.study.starter;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * 自定义Springboot-starter测试
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
class StarterTest {

    @Autowired
    private ThreadPoolExecutor MyThreadPool;

    @Test
    void testMain() {
        System.out.println(MyThreadPool.getCorePoolSize());
    }
}