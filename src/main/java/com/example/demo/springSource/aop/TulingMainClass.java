package com.example.demo.springSource.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Created by xsls on 2019/6/10.
 */
public class TulingMainClass {

    public static void main(String[] args) {

    	AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfig.class);

        Calculate calculate = (Calculate) ctx.getBean("tulingCalculate");
         int retVal = calculate.add(2,4);

    }
}
