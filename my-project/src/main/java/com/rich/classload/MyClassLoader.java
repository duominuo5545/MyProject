package com.rich.classload;

/**
 * Created by hanwang206326 on 2016/3/1.
 */
public class MyClassLoader {
    public static void main(String[] args) {
        ClassLoader classLoader = MyClassLoader.class.getClassLoader();
        try {
            Class aClass = classLoader.loadClass("com.rich.classload.MyClassLoader");
            System.out.println(aClass.getName());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
