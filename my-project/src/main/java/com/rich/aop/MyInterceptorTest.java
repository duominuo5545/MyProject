package com.rich.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by hanwang206326 on 2016/3/3.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyInterceptorTest {

    @Autowired
    private MyAopInterface myAopInterface;

    @Test
    public void testDoAccessCheck() throws Exception {
        myAopInterface.create();
    }

    @Test
    public void testDoAfter() throws Exception {

    }

    @Test
    public void testAfter() throws Exception {

    }

    @Test
    public void testDoAfterThrow() throws Exception {

    }

    @Test
    public void testDoBasicProfiling() throws Exception {

    }
}