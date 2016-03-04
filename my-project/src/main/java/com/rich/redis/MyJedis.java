package com.rich.redis;

import redis.clients.jedis.Jedis;

/**
 * Created by hanwang206326 on 2016/3/4.
 */
public class MyJedis {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("10.2.140.1", 6379); //redis服务地址和端口号
        /*String key = "mKey";
        jedis.set(key, "hello,redis!");
        String v = new String(jedis.get(key));
        String k2 = "count";
        jedis.incr(k2);
        jedis.incr(k2);
        System.out.println(v);
        System.out.println(new String(jedis.get(k2)));*/
        MyListener myListener = new MyListener();
        jedis.subscribe(myListener, "__keyevent@0__:expired");
    }
}
