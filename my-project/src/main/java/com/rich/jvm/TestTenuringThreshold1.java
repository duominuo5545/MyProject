package com.rich.jvm;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * Created by rich on 16/7/23.
 * -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=1 -XX:+PrintTenuringDistribution
 */
public class TestTenuringThreshold1 {
    private static final int _1MB = 1024 * 1024;

    private static final LoadingCache<String, byte[]> localCache = CacheBuilder.newBuilder()
            .maximumSize(100).expireAfterWrite(10, TimeUnit.MINUTES).build(
                    new CacheLoader<String, byte[]>() {
                        @Override
                        public byte[] load(String args) throws Exception {
                            return new byte[_1MB / 4];
                        }
                    }
            );

    public static void main(String[] args) throws ExecutionException {
        for (int i = 0; i < 20; i++) {
            localCache.get(String.valueOf(i));
        }
    }
}
