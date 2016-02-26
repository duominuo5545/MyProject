package com.rich.concurrent;

import java.util.stream.Stream;

/**
 * Created by hanwang206326 on 2016/2/1.
 */
public class VolatileTest {
    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        Thread[] threads = new Thread[THREADS_COUNT];
        Stream.of(threads).map(thread -> {
            thread = new Thread(() -> {
                for (int j = 0; j < 10000; j++) {
                    increase();
                }
            });
            return thread;
        }).forEach(Thread::start);
        while (Thread.activeCount() > 2) {
            Thread.yield();
        }
        System.out.println(race);
    }
}
