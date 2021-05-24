package com.cyg.study.base.copy.deepCopy;

/**
 * 深拷贝
 *
 * @author cyg
 * @date 2021/5/24 11:25
 **/
public class DeepCopy {

    public static void main(String[] args) throws CloneNotSupportedException {
        Course course = new Course("1", "修改前");
        Student student = new Student(1, course);

        Student studentCopy = (Student) student.clone();
        studentCopy.setScore(2);
        //对studentCopy修改不影响原来的student对象
        Course courseCopy = studentCopy.getCourse();
        courseCopy.setId("2");
        courseCopy.setName("修改后");
        System.out.println("student:" + student);
        System.out.println("studentCopy:" + studentCopy);
    }
}
