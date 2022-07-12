package com.example.demo.springSource.bean;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author Jay
 * @description
 * @date Created in 2022/7/7 11:00 下午
 */
public class SpringBean implements InitializingBean,DisposableBean,BeanNameAware, BeanFactoryAware, BeanClassLoaderAware {

    @Autowired
    StudentServiceImpl studentService;

    public SpringBean() {
        System.out.println("SpringBean构造方法:" + studentService);
        System.out.println("SpringBean构造方法");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("destroy");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("setBeanClassLoader");
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("setBeanFactory");
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("setBeanName:" + studentService);
        System.out.println("setBeanName");
    }


    public void initMethod() {
        System.out.println("initMethod");
    }

    public void destroyMethod() {
        System.out.println("destroyMethod");
    }
}
