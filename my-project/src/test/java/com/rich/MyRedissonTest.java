package com.rich;

import org.junit.Test;
import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.core.RLock;

/**
 * Created by hanwang206326 on 2016/3/4.
 */
public class MyRedissonTest {

    @Test
    public void test1() throws Exception {
        Config config = new Config();
        config.useSingleServer().setTimeout(3000).setAddress("10.2.136.90:6379");
        Redisson redisson = Redisson.create(config);
        RLock lock = redisson.getLock("testRedisson");
        lock.lock();
        Thread.sleep(200000);
        try {
            System.out.println("Hello World");
        } finally {
            lock.unlock();
        }
        redisson.shutdown();
    }

    @Test
    public void test2() throws Exception {
        Config config = new Config();
        config.useSingleServer().setTimeout(3000).setAddress("10.2.136.90:6379");
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

        Thread.sleep(100000);
        try {
            System.out.println("Hello World");
        } finally {
            lock.unlock();
        }
        redisson.shutdown();
    }
}