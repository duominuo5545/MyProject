package com.rich.aop;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by hanwang206326 on 2016/3/4.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class MyAopInterfaceImplTest {

    @Autowired
    private MyAopInterface myAopInterface;
    @Test
    public void testCreate() throws Exception {
        /*ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyAopInterface myAopInterface = (MyAopInterface) ctx.getBean("myAopInterface");*/
        myAopInterface.create();
    }
}