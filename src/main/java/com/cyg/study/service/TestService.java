package com.cyg.study.service;

import com.cyg.study.query.UserQuery;
import com.cyg.study.bean.StaticValue;
import com.cyg.study.dao.StaticValueDao;
import com.github.xiefusi.generator.persistence.model.Result;
import com.github.xiefusi.generator.persistence.model.Status;
import com.github.xiefusi.generator.persistence.util.IdUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * @author cyg
 * @date 2020/9/3 15:20
 **/
@Slf4j
@Service
public class TestService {

    private final StaticValueDao staticValueDao;

    public TestService(StaticValueDao staticValueDao) {
        this.staticValueDao = staticValueDao;
    }

    /**
     * @param key key
     **/
    @Transactional
    public StaticValue getByKey(String key) {
        log.info("第一次查询,查询数据库");
        staticValueDao.selectOne(key);
        log.info("第二次查询，查询缓存,依赖于事务");
        return staticValueDao.selectOne(key);
    }

    @Transactional
    public void findUser() {
        List<UserQuery> userQuerys = staticValueDao.findUser();
        for (UserQuery userQuery : userQuerys) {
            System.out.println(userQuery.getStaticId());
        }
        for (UserQuery userQuery : userQuerys) {
            //懒加载，需要的时候才去查询数据库
            System.out.println(userQuery.getStaticValue().getDefaultValue());
        }
    }

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
