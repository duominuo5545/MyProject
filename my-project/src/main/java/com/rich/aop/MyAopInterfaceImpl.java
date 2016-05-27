package com.rich.aop;

import org.springframework.stereotype.Service;

/**
 * Created by hanwang206326 on 2016/3/3.
 */
@Service
public class MyAopInterfaceImpl implements MyAopInterface {
    @Override
    public void create(String test) throws Exception {
        if (1 == 1) {
            throw new Exception("test");
        }
        System.out.println("create() is " + test);
    }
}
