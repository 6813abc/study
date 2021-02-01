package com.cyg.study.jvm;

/**
 * @author cyg
 * @date 2021/2/1 11:12
 **/
public class ClassLoaderDemo extends ClassLoader{
    /**
     * 每个类加载都有一个父类加载器，我们通过下面的程序来验证。
     **/
    public static void main(String[] args) {
        System.out.println("ClassLodarDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader());
        System.out.println("The Parent of ClassLodarDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader().getParent());
        System.out.println("The GrandParent of ClassLodarDemo's ClassLoader is " + ClassLoaderDemo.class.getClassLoader().getParent().getParent());
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        return super.findClass(name);
    }
}
