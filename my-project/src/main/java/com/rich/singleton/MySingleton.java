package com.rich.singleton;

/**
 * Created by hanwang206326 on 16/1/20.
 */
public class MySingleton {
    public static void main(String[] args) {
        Singleton1 singleton1 = Singleton1.getInstance();
        Singleton2 singleton2 = Singleton2.getInstance();
        Singleton3 singleton3 = Singleton3.getInstance();
        Singleton4 singleton4 = Singleton4.getInstance();
    }
}
