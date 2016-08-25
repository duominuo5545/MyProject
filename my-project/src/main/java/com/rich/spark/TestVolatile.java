package com.rich.spark;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by rich on 16/7/18.
 */
public class TestVolatile {
    private static volatile int IS_SERVER_OK = 1;

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Executors.newScheduledThreadPool(100).scheduleAtFixedRate(() -> {
                int times = 0;
                times++;
                System.out.println("times" + times);
                IS_SERVER_OK++;
                System.out.println(IS_SERVER_OK);
            }, 1, 10, TimeUnit.SECONDS);
        }
    }
}
