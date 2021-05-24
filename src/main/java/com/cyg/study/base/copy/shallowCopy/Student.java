package com.cyg.study.base.copy.shallowCopy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author cyg
 * @date 2021/5/24 11:25
 **/
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Cloneable {

    private int score;
    private Course course;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
