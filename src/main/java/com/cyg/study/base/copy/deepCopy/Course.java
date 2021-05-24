package com.cyg.study.base.copy.deepCopy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author cyg
 * @date 2021/5/24 11:26
 **/
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Course implements Cloneable, Serializable {
    private String id;
    private String name;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
