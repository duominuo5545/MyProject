package com.rich;

import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by hanwang206326 on 16/1/12.
 */
public class MyJedis {
    private static ReentrantLock lock = new ReentrantLock();
    private static ShardedJedisPool pool;

    public static void main(String[] args) {
        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
        shards.add(new JedisShardInfo("10.16.2.45", 6379));
        shards.add(new JedisShardInfo("10.16.2.45", 6380));
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(1024);
        config.setMaxIdle(100);
        config.setMinIdle(0);
        config.setMaxWaitMillis(-1L);
        config.setTestOnBorrow(false);
        config.setTestOnReturn(false);
        config.setTestWhileIdle(true);
        config.setMinEvictableIdleTimeMillis(10000L);
        config.setNumTestsPerEvictionRun(10);
        config.setTimeBetweenEvictionRunsMillis(60000L);
        lock.lock();
        try {
            pool = new ShardedJedisPool(config, shards, ShardedJedis.DEFAULT_KEY_TAG_PATTERN);
            ShardedJedis jedis = pool.getResource();
            jedis.set("myJedis", "111111");
            System.out.println(jedis.get("myJedis"));
            jedis.close();
        } finally {
            lock.unlock();
        }
    }
}
