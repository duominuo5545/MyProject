package com.rich.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * Created by hanwang206326 on 2016/3/1.
 */
public class MyProxy {
    public static void main(String[] args) {
        MyInterface myInterface = new MyInterfaceImpl();
        InvocationHandler handler = new MyInvocationHandler(myInterface);
        MyInterface proxy = (MyInterface) Proxy.newProxyInstance(MyInterface.class.getClassLoader(), new Class[]{MyInterface.class}, handler);
        proxy.call();
    }
}
