package com.cyg.study.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author cyg
 * @date 2021/5/24 16:58
 **/
@Component()
public class BeanInit {

    @PostConstruct
    public void beforeInitMethod() {
        System.out.println("BeanInit 初始化之前-------");
    }

    @PreDestroy
    public void beforeDestryMethod() {
        System.out.println("BeanInit 销毁之前-------");
    }
}
