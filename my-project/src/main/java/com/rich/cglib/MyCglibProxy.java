package com.rich.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by hanwang206326 on 2016/3/1.
 */
public class MyCglibProxy implements MethodInterceptor {
    public Enhancer enhancer = new Enhancer();
    private String name;

    public MyCglibProxy(String name) {
        this.name = name;
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("调用的方法是：" + method.getName());
        //用户进行判断
        if (!"boss".equals(name)) {
            System.out.println("你没有权限！");
            return null;
        }
        Object result = methodProxy.invokeSuper(o, objects);
        return result;
    }
}
