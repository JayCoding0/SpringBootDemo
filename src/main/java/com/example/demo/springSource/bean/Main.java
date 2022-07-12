package com.example.demo.springSource.bean;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Jay
 * @description
 * @date Created in 2022/7/7 11:02 下午
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext annotationConfigApplicationContext =
                new AnnotationConfigApplicationContext(AppConfig.class);
        annotationConfigApplicationContext.destroy();
    }
}
