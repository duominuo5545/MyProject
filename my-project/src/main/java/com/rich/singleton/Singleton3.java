package com.rich.singleton;

/**
 * Created by hanwang206326 on 16/1/20.
 */
public class Singleton3 {
    private static class Singleton3Holder {
        private static Singleton3 singleton3 = new Singleton3();

        static {
            System.out.println("init Singleton3Holder");
        }
    }

    private Singleton3() {
    }

    static {
        System.out.println("init Singleton3");
    }

    public static Singleton3 getInstance() {
        return Singleton3Holder.singleton3;
    }

    public static void call() {
        System.out.println("call Singleton3");
    }
}
