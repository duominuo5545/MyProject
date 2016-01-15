package com.rich.lambda;

import java.util.Comparator;

/**
 * Created by hanwang206326 on 16/1/13.
 */
public class LengthComparator implements Comparator<String> {
    public int compare(String o1, String o2) {
        return Integer.compare(o1.length(), o2.length());
    }
}
