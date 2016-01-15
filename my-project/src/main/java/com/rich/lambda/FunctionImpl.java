package com.rich.lambda;


import java.util.function.Function;

/**
 * Created by hanwang206326 on 16/1/15.
 */
public class FunctionImpl implements Function<String, String> {
    /**
     * Applies this function to the given argument.
     *
     * @param s the function argument
     * @return the function result
     */
    @Override
    public String apply(String s) {
        return s.toLowerCase();
    }
}
