package com.rich.jdk8;

import java.awt.*;
import java.util.Comparator;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

/**
 * Created by hanwang206326 on 16/1/23.
 */
public class practice3 {
    public static void main(String[] args) {
        //2
        /*Lock lock = new ReentrantLock();
        withLock(lock, () -> System.out.println("hahaha"));*/
        //10
        UnaryOperator<String> unaryOperator = new UnaryOperator<String>() {
            @Override
            public String apply(String s) {
                return null;
            }
        };
        //unaryOperator.compose()

    }

    private static void withLock(Lock lock, Runnable runnable) {
        lock.lock();
        try {
            runnable.run();
        } finally {
            lock.unlock();
        }
    }

    private static Comparator<String> comparatorStr(int asc) {
        return (x, y) -> (x.compareTo(y)) * asc;
    }

}
