package com.rich.singleton;

/**
 * Created by hanwang206326 on 16/1/20.
 * 饿汉式
 */
public class Singleton2 {
    private static Singleton2 singleton2 = new Singleton2();

    private Singleton2() {
    }

    static {
        System.out.println("init Singleton2");
    }

    public static Singleton2 getInstance() {
        return singleton2;
    }
}
