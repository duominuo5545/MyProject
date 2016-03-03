package com.rich.cglib;

import net.sf.cglib.proxy.CallbackFilter;

import java.lang.reflect.Method;

/**
 * Created by hanwang206326 on 2016/3/2.
 */
public class MyProxyFilter implements CallbackFilter {
    @Override
    public int accept(Method method) {
        if (!"query".equalsIgnoreCase(method.getName())) {
            return 0;
        }
        return 1;
    }
}
