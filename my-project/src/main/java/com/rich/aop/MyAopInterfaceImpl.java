package com.rich.aop;

import org.springframework.stereotype.Service;

/**
 * Created by hanwang206326 on 2016/3/3.
 */
@Service
public class MyAopInterfaceImpl implements MyAopInterface {
    @Override
    public void create() {
        System.out.println("create() is running");
    }
}
