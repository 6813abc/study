package com.cyg.study.util.spring;

import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.PropertyValue;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.config.TypedStringValue;
import org.springframework.beans.factory.support.AbstractAutowireCapableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.support.AbstractRefreshableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 获取Spring上下文环境的工具 <!-- 这个bean主要是为了得到ApplicationContext 所以它不需要其它属性--> <bean class="org.ing.springutil.MyApplicationContextUtil" />
 *
 * @author SUN
 * @version 1.0
 * @Date 2010-2-20 上午10:37:50
 */
@Component
public class CustomSpringContextUtil implements ApplicationContextAware, ApplicationListener<ContextRefreshedEvent> {

    private static Map contexts = new HashMap();

    private static Boolean isCGLIB = null;

    private static boolean springInited = false;       //增加了一个变量用来表示spring是否已经启动完毕

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {

        String webName = getClassloader().getResource("").getPath();
        contexts.put(webName, context);
        ClassLoader parentloader = getClassloader().getParent();
        if (parentloader != null) {
            URL url = parentloader.getResource("");
            if (url != null) {
                webName = url.getPath();
                contexts.put(webName, context);
            }
        }

        // this.context = context;
    }

    /**
     * 获取Spring上下文
     *
     * @return
     */
    public static ApplicationContext getContext() {
        String webName = getClassloader().getResource("").getPath();
        Object object = contexts.get(webName);
        if (object == null) {
            ClassLoader parentloader = getClassloader().getParent();
            if (parentloader != null) {
                URL url = parentloader.getResource("");
                if (url != null) {
                    webName = url.getPath();
                    object = contexts.get(webName);
                }
            }
        }
        return (ApplicationContext) object;
    }

    /**
     * 获取Spring上下文,根据configLocation
     *
     * @param configLocation
     * @return
     */
    public static ApplicationContext getContext(String configLocation) {

        String webName = getClassloader().getResource("").getPath();
        Object object = contexts.get(webName);

        if (object == null) {
            object = new ClassPathXmlApplicationContext(configLocation);
            contexts.put(webName, object);
        }

        if (object != null) {
            return (ApplicationContext) object;
        } else {
            return null;
        }
    }

    public static boolean registerPrototype(String beanName, Class clazz, Map<String, String> refProperty, Map<String, Object> valueProperty) {
        return registerPrototype(beanName, clazz, refProperty, valueProperty, null, null);
    }

    /**
     * 动态的注册一个bean到Spring上下文中.这个bean是非单例的
     *
     * @param beanName
     * @param clazz
     * @param refProperty    <property name="xxx" ref="xxxx"/>
     * @param valueProperty  <property name="xxx" value="xxxx"/>
     * @param constructorRef 构造器的参数, 按照顺序来
     * @return
     */
    public static boolean registerPrototype(String beanName, Class clazz, Map<String, String> refProperty, Map<String, Object> valueProperty, List<String> constructorRef, List<Object> constructorValue) {
        ApplicationContext applicationContext = getContext();

        if (applicationContext instanceof ConfigurableApplicationContext) {
            //将applicationContext转换为ConfigurableApplicationContext  
            ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) applicationContext;

            BeanDefinitionRegistry beanDefinitionRegistry = (BeanDefinitionRegistry) configurableApplicationContext
                    .getBeanFactory();

            BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(clazz);
            beanDefinitionBuilder.setAutowireMode(AutowireCapableBeanFactory.AUTOWIRE_BY_TYPE);

            if (refProperty != null) {
                for (Map.Entry<String, String> entry : refProperty.entrySet()) {
                    beanDefinitionBuilder.addPropertyReference(entry.getKey(), entry.getValue());
                }
            }

            if (valueProperty != null) {
                for (Map.Entry<String, Object> entry : valueProperty.entrySet()) {
                    beanDefinitionBuilder.addPropertyValue(entry.getKey(), entry.getValue());
                }
            }

            if (constructorRef != null) {
                for (String s : constructorRef) {
                    beanDefinitionBuilder.addConstructorArgReference(s);
                }
            }

            if (constructorValue != null) {
                for (Object o : constructorValue) {
                    beanDefinitionBuilder.addConstructorArgValue(o);
                }
            }

            beanDefinitionBuilder.setScope("prototype");
            beanDefinitionRegistry.registerBeanDefinition(beanName, beanDefinitionBuilder.getRawBeanDefinition());
            return true;
        }
        return false;
    }

    /**
     * 动态的注册一个bean到Spring上下文中.这个bean是单例的
     *
     * @param beanName
     * @param instance
     * @return
     */
    public static boolean registerSingleton(String beanName, Object instance) {
        ApplicationContext applicationContext = getContext();

        if (applicationContext instanceof AbstractRefreshableApplicationContext) {
            ConfigurableListableBeanFactory beanDefinitionRegistry = ((AbstractRefreshableApplicationContext) applicationContext).getBeanFactory();
            beanDefinitionRegistry.registerSingleton(beanName, instance);
            return true;
        } else if (applicationContext instanceof ConfigurableApplicationContext) {
            ConfigurableListableBeanFactory beanFactory = ((ConfigurableApplicationContext) applicationContext).getBeanFactory();
            beanFactory.registerSingleton(beanName, instance);
            return true;
        }

        return false;
    }

    /**
     * 取消一个bean的注册
     *
     * @param beanName
     * @return
     */
    public static boolean destroyPrototype(String beanName) {
        ApplicationContext applicationContext = getContext();

        if (applicationContext instanceof ConfigurableApplicationContext) {
            //将applicationContext转换为ConfigurableApplicationContext  
            ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) applicationContext;

            BeanDefinitionRegistry beanDefinitionRegistry = (BeanDefinitionRegistry) configurableApplicationContext
                    .getBeanFactory();

            beanDefinitionRegistry.removeBeanDefinition(beanName);
            return true;
        }
        return false;
    }

    public static boolean destroySingleton(String beanName) {
        ApplicationContext applicationContext = getContext();

        Object instance = applicationContext.getBean(beanName);

        if (instance != null && applicationContext instanceof AbstractRefreshableApplicationContext) {
            ConfigurableListableBeanFactory beanDefinitionRegistry = ((AbstractRefreshableApplicationContext) applicationContext).getBeanFactory();
            beanDefinitionRegistry.destroyBean(instance);
            return true;
        } else if (instance != null && applicationContext instanceof ConfigurableApplicationContext) {
            /*单利类要用这样的方式 才能去掉*/
            ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) applicationContext;
            AbstractAutowireCapableBeanFactory beanDefinitionRegistry = (AbstractAutowireCapableBeanFactory) configurableApplicationContext
                    .getBeanFactory();
            try {
                beanDefinitionRegistry.destroySingleton(beanName);
            } catch (Exception e) {
                e.printStackTrace();
            }

            return true;
        }

        return false;
    }

    /**
     * 判断事务的代理是否是采用的CGLIB
     *
     * @return boolean
     */
    public static Boolean isCglibProxy() throws ClassNotFoundException {

        if (isCGLIB == null) {
            synchronized (CustomSpringContextUtil.class) {
                if (isCGLIB == null) {
                    Class clazz = null;
                    ClassNotFoundException e = null;
                    try {
                        clazz = Class.forName("org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator");
                    } catch (ClassNotFoundException e1) {
                        e = e1;
                        try {
                            ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
                            if (classLoader != null) {
                                clazz = classLoader.loadClass("org.springframework.aop.framework.autoproxy.BeanNameAutoProxyCreator");
                            }
                        } catch (ClassNotFoundException e2) {
                            e = e2;
                        }
                    }
                    if (e != null) {
                        throw e;
                    }

                    Map<String, Object> map = CustomSpringContextUtil.getContext().getBeansOfType(clazz);
                    String proxy = map.keySet().iterator().next();
                    BeanDefinition bdf = ((ConfigurableApplicationContext) CustomSpringContextUtil.getContext()).getBeanFactory().getBeanDefinition(proxy);
                    MutablePropertyValues mutablePropertyValues = bdf.getPropertyValues();
                    PropertyValue propertyValue = mutablePropertyValues.getPropertyValue("proxyTargetClass");
                    if (propertyValue != null) {
                        Object value = propertyValue.getValue();
                        if (value instanceof TypedStringValue) {
                            isCGLIB = Boolean.valueOf(((TypedStringValue) value).getValue());
                        }
                    }
                }
            }
        }

        if (isCGLIB == null) {
            return null;
        } else {
            return isCGLIB.booleanValue();
        }
    }

    /**
     * 判断系统是否启动完毕,使用的是 监听spring的contextRefreshed事件
     * 2014-06-11 09:49:47 孙翔
     *
     * @param event
     */
    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        /*在系统接收到spring的refreshed事件以后,也就是启动完毕后.修改springInited的值*/
        springInited = true;
    }

    /**
     * 判断系统是否启动完毕
     *
     * @return
     */
    public static boolean isSpringInited() {
        return springInited;
    }

    /**
     * Thread.currentThread().getContextClassLoader(); 这个在 JDK1.8的 parallelStream的情况下,有可能是空的.因此这个时候就只能去获取 CustomSpringContextUtil.class的
     *
     * @return
     */
    private static ClassLoader getClassloader() {
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader == null) {
            contextClassLoader = CustomSpringContextUtil.class.getClassLoader();
        }
        return contextClassLoader;
    }
}
