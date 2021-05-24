package com.cyg.study.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author cyg
 * @date 2021/5/24 15:18
 **/
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Test1 {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private int age;
}