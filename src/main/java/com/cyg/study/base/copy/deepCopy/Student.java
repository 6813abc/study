package com.cyg.study.base.copy.deepCopy;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @author cyg
 * @date 2021/5/24 11:25
 **/
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Student implements Cloneable, Serializable {

    private int score;
    private Course course;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        Student student = (Student) super.clone();
        Course course = student.getCourse();
        student.setCourse((Course) course.clone());
        return student;
    }
}
