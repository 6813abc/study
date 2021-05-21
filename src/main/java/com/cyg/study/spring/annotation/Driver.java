package com.cyg.study.spring.annotation;

import lombok.Data;

/**
 * @author cyg
 * @date 2021/5/21 15:27
 **/
@Data
public class Driver {

    private Integer id;
    private String name;
    private Car car;
}
