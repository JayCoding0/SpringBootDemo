package com.example.demo.springSource.ioc;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Jay
 * @description
 * @date Created in 2022/7/6 10:37 下午
 */
public class MainStarter {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConfig.class);
        Car tank = context.getBean("&car", Car.class);
        System.out.println(tank.getName());
    }
}
