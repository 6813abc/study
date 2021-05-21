package com.cyg.study.spring.annotation;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnnotatedConfigurationTest {
    @Autowired
    private Car car;

    @Autowired
    private Driver driver;

    @Test
    public void contextLoads() {
        boolean result = driver.getCar() == car;
        System.out.println(result ? "同一个car" : "不同的car");
    }
}