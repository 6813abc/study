package com.cyg.study.elasticsearch;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author cyg
 * @date 2021/4/22 16:32
 **/
@Data
@ToString
@NoArgsConstructor
public class Employee {

    private String id;
    private Long version;
    String firstName;
    String lastName;
    String age;
    String[] interests;
}
