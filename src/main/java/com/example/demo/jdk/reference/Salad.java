package com.example.demo.jdk.reference;

import java.lang.ref.WeakReference;

/**
 * 继承实现弱引用
 */
public class Salad extends WeakReference<Apple> {
    public Salad(Apple apple) {
        super(apple);
    }
}
