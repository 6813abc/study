package com.cyg.study.base.copy.shallowCopy;

/**
 * 浅拷贝
 *
 * @author cyg
 * @date 2021/5/24 11:25
 **/
public class ShallowCopy {

    public static void main(String[] args) throws CloneNotSupportedException {
        Course course = new Course("1", "修改前");
        Student student = new Student(1, course);

        Student studentCopy = (Student) student.clone();
        studentCopy.setScore(2);
        //对studentCopy修改影响原student对象的引用属性和数组，不影响基本属性和String类型
        Course courseCopy = studentCopy.getCourse();
        courseCopy.setId("2");
        courseCopy.setName("修改后");
        System.out.println("student:" + student);
        System.out.println("studentCopy:" + studentCopy);
    }
}
