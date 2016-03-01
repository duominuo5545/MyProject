package com.rich.cglib;

import net.sf.cglib.proxy.Enhancer;

/**
 * Created by hanwang206326 on 2016/3/1.
 */
public class BookServiceFactory {
    private static BookServiceBean serviceBean = new BookServiceBean();

    private BookServiceFactory() {

    }

    public static BookServiceBean getInstance() {
        return serviceBean;
    }

    public static BookServiceBean getProxyInstance(MyCglibProxy myProxy) {
        Enhancer en = new Enhancer();
        //进行代理
        en.setSuperclass(BookServiceBean.class);
        en.setCallback(myProxy);
        //生成代理实例
        return (BookServiceBean) en.create();
    }
}
