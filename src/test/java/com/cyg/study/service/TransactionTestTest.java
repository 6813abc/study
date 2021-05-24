package com.cyg.study.service;

import com.cyg.study.StudyApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = StudyApplication.class, webEnvironment = SpringBootTest.WebEnvironment.NONE)
@RunWith(SpringRunner.class)
class TransactionTestTest {


    @Autowired
    private TransactionTest transactionTest;

    @Test
    void testMain() {
        transactionTest.testMain();
    }
}