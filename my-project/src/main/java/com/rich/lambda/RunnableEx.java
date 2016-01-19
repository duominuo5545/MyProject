package com.rich.lambda;

/**
 * Created by hanwang206326 on 16/1/17.
 */
public interface RunnableEx {
    public void run() throws Exception;

    public static Runnable uncheck(RunnableEx runnableEx) {
        return () -> System.out.println("xxxx");
    }
}
