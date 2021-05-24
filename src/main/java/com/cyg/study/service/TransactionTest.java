package com.cyg.study.service;

import com.cyg.study.bean.Test1;
import com.cyg.study.bean.Test2;
import com.cyg.study.dao.Test1Dao;
import com.cyg.study.dao.Test2Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试事务的传播
 * 参看文档：https://zhuanlan.zhihu.com/p/148504094
 *
 * @author cyg
 * @date 2021/5/24 15:10
 **/
@Service
public class TransactionTest {

    @Autowired()
    TransactionTest transactionTest;
    final Test1Dao test1Dao;
    final Test2Dao test2Dao;

    public TransactionTest(Test1Dao test1Dao, Test2Dao test2Dao) {
        this.test1Dao = test1Dao;
        this.test2Dao = test2Dao;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void testMain() {
        Test1 test1 = new Test1();
        test1.setName("张三");
        test1.setAge(18);
        test1Dao.save(test1);
        transactionTest.testB();
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void testB() {
        Test2 test2 = new Test2();
        test2.setName("李四");
        test2.setAge(18);
        test2Dao.save(test2);
        System.out.println(1 / 0);
        Test2 test3 = new Test2();
        test3.setName("赵五");
        test3.setAge(18);
        test2Dao.save(test3);
    }
}
