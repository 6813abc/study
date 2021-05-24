package com.cyg.study.bean;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
class BeanInitTest {

    @Autowired
    private BeanInit beanInit;
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(BeanInit.class);

    @Test
    void testMain() {
        context.close();
    }
}