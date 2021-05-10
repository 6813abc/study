package com.cyg.study.concurrent.distributedId;

import com.github.xiefusi.generator.persistence.model.Result;
import com.github.xiefusi.generator.persistence.model.Status;
import com.github.xiefusi.generator.persistence.util.IdUtil;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 封装了美团的leaf-parent，分布式id生成，依赖数据库
 *
 * @author cyg
 * @date 2021/5/10 11:27
 **/
@Configuration
public class LeafParent {
    public void test() throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(3);
        List<Long> ids = new ArrayList<>();
        ids = Collections.synchronizedList(ids);
        List<Long> finalIds = ids;
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Result result = IdUtil.get("orderId");
                if (Status.SUCCESS.equals(result.getStatus())) {
                    long orderId = result.getId();
                    finalIds.add(orderId);
                }
            }
            countDownLatch.countDown();
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Result result = IdUtil.get("orderId");
                if (Status.SUCCESS.equals(result.getStatus())) {
                    long orderId = result.getId();
                    finalIds.add(orderId);
                }
            }
            countDownLatch.countDown();
        });
        Thread thread3 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                Result result = IdUtil.get("orderId");
                if (Status.SUCCESS.equals(result.getStatus())) {
                    long orderId = result.getId();
                    finalIds.add(orderId);
                }
            }
            countDownLatch.countDown();
        });
        thread1.start();
        thread2.start();
        thread3.start();
        countDownLatch.await();
        System.out.println(ids.size());
        System.out.println(ids);
    }
}
