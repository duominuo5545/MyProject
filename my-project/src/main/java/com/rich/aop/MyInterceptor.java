package com.rich.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Service;

/**
 * Created by hanwang206326 on 2016/3/3.
 */
@Aspect
@Service
public class MyInterceptor {
    @Pointcut("execution(* com.rich.aop.MyClass.*(..))")
    private void anyMethod() { //定义一个切入点

    }

    /*@Before("anyMethod()")
    public void doAccessCheck() {
        System.out.println("前置通知");
    }

    @AfterReturning(pointcut = "anyMethod()", returning = "result", argNames = "args")
    public void doAfter(Object args, Object result) {
        System.out.println("后置通知");
    }

    @After("anyMethod()")
    public void after() {
        System.out.println("最终通知");
    }

    @AfterThrowing("anyMethod()")
    public void doAfterThrow() {
        System.out.println("例外通知");
    }*/

    @Around("anyMethod()")
    public Object doBasicProfiling(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("进入环绕通知");
        Object[] args = proceedingJoinPoint.getArgs();
        for (Object object : args) {
            System.out.println(object);
        }
        System.out.println(proceedingJoinPoint.getSignature().getDeclaringTypeName() + "." + proceedingJoinPoint.getSignature().getName());
        Object object = null;
        try {
            object = proceedingJoinPoint.proceed();//执行该方法
            System.out.println("Object : " + object);
        } catch (Exception e) {
            System.out.println(e.getClass());
        }
        return object;
    }

}
