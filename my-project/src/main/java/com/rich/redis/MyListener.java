package com.rich.redis;

import redis.clients.jedis.JedisPubSub;

/**
 * Created by hanwang206326 on 2016/3/4.
 */
public class MyListener extends JedisPubSub {
    /**
     * 取得订阅的消息后的处理
     *
     * @param channel
     * @param message
     */
    @Override
    public void onMessage(String channel, String message) {
        System.out.println("onMessage:" + channel + "=" + message);
    }

    /**
     * 取得按表达式的方式订阅的消息后的处理
     *
     * @param pattern
     * @param channel
     * @param message
     */
    @Override
    public void onPMessage(String pattern, String channel, String message) {

    }

    /**
     * 初始化订阅时候的处理
     *
     * @param channel
     * @param subscribedChannels
     */
    @Override
    public void onSubscribe(String channel, int subscribedChannels) {
        System.out.println("onSubscribe:" + channel + "=" + subscribedChannels);
    }

    /**
     * 取消订阅时候的处理
     *
     * @param channel
     * @param subscribedChannels
     */
    @Override
    public void onUnsubscribe(String channel, int subscribedChannels) {

    }

    /**
     * 取消按表达式的方式订阅时候的处理
     *
     * @param pattern
     * @param subscribedChannels
     */
    @Override
    public void onPUnsubscribe(String pattern, int subscribedChannels) {

    }

    /**
     * 初始化按表达式的方式订阅时候的处理
     *
     * @param pattern
     * @param subscribedChannels
     */
    @Override
    public void onPSubscribe(String pattern, int subscribedChannels) {

    }
}
