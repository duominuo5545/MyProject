package com.rich.aop;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by hanwang206326 on 2016/3/3.
 */
public class MyAopInterfaceImplTest {
    /*@Autowired
    private MyAopInterface myAopInterface;*/

    @Test
    public void testCreate() throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyAopInterface myAopInterface = (MyAopInterface) ctx.getBean("myAopInterface");
        myAopInterface.create();
    }
}