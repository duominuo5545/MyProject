package com.rich.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Service;

/**
 * Created by hanwang206326 on 2016/3/3.
 */
@Aspect
@Service
public class MyInterceptor {
    @Pointcut("execution(* com.rich.aop.MyAopInterfaceImpl.*(..))")
    private void anyMethod() { //定义一个切入点

    }

    @Before("anyMethod()")
    public void doAccessCheck() {
        System.out.println("前置通知");
    }

    @AfterReturning("anyMethod()")
    public void doAfter() {
        System.out.println("后置通知");
    }

    @After("anyMethod()")
    public void after() {
        System.out.println("最终通知");
    }

    @AfterThrowing("anyMethod()")
    public void doAfterThrow() {
        System.out.println("例外通知");
    }

    @Around("anyMethod()")
    public Object doBasicProfiling(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("进入环绕通知");
        Object object = proceedingJoinPoint.proceed();//执行该方法
        System.out.println("退出方法");
        return object;
    }

}
