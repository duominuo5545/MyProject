package com.rich.cglib;

/**
 * Created by hanwang206326 on 2016/3/1.
 */
public class MyClient {
    public static void main(String[] args) {
        /*BookServiceBean serviceBean = BookServiceFactory.getInstance();
        doMethod(serviceBean);*/
        /*MyCglibProxy myCglibProxy = new MyCglibProxy("boss");
        BookServiceBean bookServiceBean = (BookServiceBean) myCglibProxy.getDaoBean(BookServiceBean.class);
        bookServiceBean.create();*/
        BookServiceBean service = BookServiceFactory.getAuthInstanceByFilter(new MyCglibProxy("boss"));
        service.query();
        BookServiceBean service2 = BookServiceFactory.getProxyInstance(new MyCglibProxy("john"));
        service2.create();
    }

    public static void doMethod(BookServiceBean serviceBean) {
        serviceBean.create();
    }
}
