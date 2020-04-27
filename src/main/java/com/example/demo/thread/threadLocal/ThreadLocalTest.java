package com.example.demo.thread.threadLocal;

/**
 * @author Jay
 * @description 线程变量
 * @date Created in 2019/10/29 19:00
 */
public class ThreadLocalTest {

    public static void main(String[] args) {
        ThreadLocal<String> local = new ThreadLocal<>();
        ThreadLocal<String> local1 = new ThreadLocal<>();

        local.set("test");
        local1.set("test1");
        String s = local.get();
        String s1 = local1.get();

        System.out.println(s+"---"+s1);
    }
}
