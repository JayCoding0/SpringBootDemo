package com.example.demo.jdk.test;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @author Jay
 * @description
 * @date Created in 2020/2/27 5:05 下午
 */
public class MyClassLoader  {

    private int a =1;

    @Test
    public  void test1() {
        int b =2;

        test(b);
    }

    private   void test (int a){

        System.out.println(a);

    }

}
