package com.cyg.example;

import org.omg.CORBA.TIMEOUT;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.DefaultManagedAwareThreadFactory;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author cyg
 * @date 2021/5/25 16:25
 **/
@Configuration
public class ThreadPoolAutoConfiguration {

    @Bean
    @ConditionalOnClass(ThreadPoolExecutor.class)//需要项目中存在ThreadPoolExecutor类，该类为jdk自带
    public ThreadPoolExecutor MyThreadPool() {
        return new ThreadPoolExecutor(10, 10, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10), new DefaultManagedAwareThreadFactory());
    }
}
