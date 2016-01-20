package com.rich.singleton;

/**
 * Created by hanwang206326 on 16/1/20.
 * 懒汉式
 */
public class Singleton1 {
    private static Singleton1 singleton1 = null;

    private Singleton1() {
    }

    static {
        System.out.println("init Singleton1");
    }

    public static synchronized Singleton1 getInstance() {
        if (singleton1 == null) {
            singleton1 = new Singleton1();
        }
        return singleton1;
    }
}
