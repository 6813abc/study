package com.cyg.study.spring.annotation;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/**
 * @author cyg
 * @Component和@Configuration作为配置类的差别
 * @date 2021/5/21 15:26
 **/
@Configuration
public class AnnotatedConfiguration {

    @Bean
    public Driver driver() {
        Driver driver = new Driver();
        driver.setId(1);
        driver.setName("driver");
        driver.setCar(car());
        return driver;
    }

    @Bean
    public Car car() {
        Car car = new Car();
        car.setId(1);
        car.setName("car");
        return car;
    }
}
