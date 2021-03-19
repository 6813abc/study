package com.cyg.study.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author cyg
 * @date 2021/3/18 10:54
 **/
@Configuration
@EnableAsync
@Slf4j
public class ExecutorConfig {

    @Autowired
    VisiableThreadPoolTaskExecutor visiableThreadPoolTaskExecutor;

    @Bean
    public Executor asyncServiceExecutor() {
        log.info("start asyncServiceExecutor");
        ThreadPoolTaskExecutor executor = visiableThreadPoolTaskExecutor;
        //配置核心线程数
        executor.setCorePoolSize(5);
        //配置最大线程数
        executor.setMaxPoolSize(5);
        //配置队列大小
        executor.setQueueCapacity(5);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("async-service-");

        //拒绝策略
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.AbortPolicy());
        //执行初始化
        executor.initialize();

        return executor;
    }
}
