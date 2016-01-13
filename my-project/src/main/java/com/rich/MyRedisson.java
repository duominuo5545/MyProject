package com.rich;

import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.core.RLock;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;

/**
 * Created by hanwang206326 on 16/1/12.
 */
public class MyRedisson {
    public static void main(String[] args) throws InterruptedException {
        Config config = new Config();
        config.useSingleServer().setTimeout(3000).setAddress("localhost:6379");
        Redisson redisson = Redisson.create(config);
        RLock lock = redisson.getLock("testRedisson");
        /*try {
            if (lock.tryLock(30, 40, TimeUnit.SECONDS)) {

            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        lock.lock();
        //Thread.sleep(60000);
        /*lock.lock();
        Thread.sleep(60000);
        lock.lock();
        Thread.sleep(40000);
        lock.lock();*/
        try {
            System.out.println("Hello World");
        } finally {
            //lock.unlock();
        }
        //redisson.shutdown();
    }
}
