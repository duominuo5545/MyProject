package com.rich.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by hanwang206326 on 2016/3/4.
 */
public class MyJedis1 {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("10.2.140.1", 6379); //redis服务地址和端口号
        jedis.setex("testKey", 5, "testValue");
    }
}
