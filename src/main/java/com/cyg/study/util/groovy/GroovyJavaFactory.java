package com.cyg.study.util.groovy;

import com.cyg.study.util.spring.CustomSpringContextUtil;
import groovy.lang.GroovyClassLoader;

/**
 * @author sun
 * @version 1.0
 * @Date 2017/6/17 11:46
 */
public class GroovyJavaFactory {

    private static GroovyClassLoader groovyClassLoader = new GroovyClassLoader();

    /**
     * 销毁某一个bean
     *
     * @param name
     * @return
     */
    public static boolean destroyInstance(String name) {
        return CustomSpringContextUtil.destroyPrototype(name);
    }

    /**
     * 加载某一个实例
     *
     * @param name
     * @param codeSource
     * @param aClass
     * @param <T>
     * @return
     */
    public static <T> T loadInstance(String name, String codeSource, Class<T> aClass) throws Exception {
        try {
            Object bean = CustomSpringContextUtil.getContext().getBean(name);
            return (T) bean;
        } catch (Exception e) {
            //bean还没有注册到spring.
            if (codeSource != null && codeSource.trim().length() > 0) {
                Class<?> clazz;
                try {
                    clazz = groovyClassLoader.parseClass(codeSource);
                } catch (Exception ee) {
                    throw new Exception("加载" + name + " 的源码到JVM中失败:", ee);
                }
                if (clazz != null) {
                    if (aClass.isAssignableFrom(clazz)) {
                        if (CustomSpringContextUtil.registerPrototype(name, clazz, null, null)) {
                            return (T) CustomSpringContextUtil.getContext().getBean(name);
                        }
                        throw new Exception("对" + name + " 注入到spring中,失败");
                    } else {
                        throw new ClassCastException("加载" + name + " 失败,并不是" + aClass.getName() + "的实现");
                    }
                }
                throw new Exception("对" + name + " 的源码到JVM中失败");
            } else {
                throw new IllegalArgumentException("加载" + name + " 失败,源码为空");
            }
        }
    }
}
