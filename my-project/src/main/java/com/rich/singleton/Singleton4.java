package com.rich.singleton;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hanwang206326 on 16/1/20.
 */
public class Singleton4 {
    private static Singleton4 singleton4 = null;
    private static ReentrantLock lock = new ReentrantLock();

    static {
        System.out.println("init Singleton4");
    }

    private Singleton4() {
    }

    public static Singleton4 getInstance() {
        if (singleton4 == null) {
            lock.lock();
            if (singleton4 == null) {
                singleton4 = new Singleton4();
            }
            lock.unlock();
        }
        return singleton4;
    }
}
