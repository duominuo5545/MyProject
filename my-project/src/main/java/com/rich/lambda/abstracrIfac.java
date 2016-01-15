package com.rich.lambda;

/**
 * Created by hanwang206326 on 16/1/13.
 */
public class abstracrIfac implements FunctionalIfac, FunctionalIfac2 {
    @Override
    public int testFunc(int a, int b) {
        return 0;
    }

    public String getName() {
        return FunctionalIfac.super.getName();
    }
}
