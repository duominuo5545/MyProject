package com.rich;

import org.junit.Test;
import org.redisson.Config;
import org.redisson.Redisson;
import org.redisson.core.RLock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

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

    @Test
    public void test3() throws Exception {
        /*ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(2);
        Iterator<Integer> iterator = list.iterator();
        while (iterator.hasNext()) {
            Integer integer = iterator.next();
            if (integer == 2) {
                list.add(5);
                //list.set(0, 3);
            }
        }*/

        Map<String, Object> dataMap = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            dataMap.put(i + "", 123123);
        }
        for (Map.Entry<String, Object> entry : dataMap.entrySet()) {
            dataMap.put(entry.getKey(), "dasdsad");
        }
    }
}