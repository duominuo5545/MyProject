package com.rich.lambda;

/**
 * Created by hanwang206326 on 16/1/13.
 */
@FunctionalInterface
public interface FunctionalIfac {
    int testFunc(int a, int b);

    default String getName() {
        return "hahaha default";
    }
}
