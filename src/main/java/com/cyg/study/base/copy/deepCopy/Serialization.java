package com.cyg.study.base.copy.deepCopy;


import java.io.*;

/**
 * 序列化实现深拷贝
 *
 * @author cyg
 * @date 2021/5/24 11:42
 **/
public class Serialization {

    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T clone(T obj) {
        T cloneObj = null;
        try {
            //写入字节流
            ByteArrayOutputStream out = new ByteArrayOutputStream();
            ObjectOutputStream obs = new ObjectOutputStream(out);
            obs.writeObject(obj);
            obs.close();
            //分配内存，写入原始对象，生成新对象
            ByteArrayInputStream ios = new ByteArrayInputStream(out.toByteArray());
            ObjectInputStream ois = new ObjectInputStream(ios);
            //返回生成的新对象
            cloneObj = (T) ois.readObject();
            ois.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cloneObj;
    }

    public static void main(String[] args) {
        Course course = new Course("1", "修改前");
        Student student = new Student(1, course);
        Student studentCopy = clone(student);
        studentCopy.setScore(2);
        //对studentCopy修改不影响原来的student对象
        Course courseCopy = studentCopy.getCourse();
        courseCopy.setId("2");
        courseCopy.setName("修改后");
        System.out.println("student:" + student);
        System.out.println("studentCopy:" + studentCopy);
    }
}
