package com.rich;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rich on 16/8/19.
 */
public class Test3 {
    public static void main(String[] args) {
        System.out.print("请输入人数");
        List<Integer> l = new ArrayList<Integer>();
        for (int i = 1; i <= 100; i++) {
            l.add(i);
        }
        int point = 0, number = 1;
        while (l.size() > 1) {
            if (number % 3 == 0) {
                l.remove(point);
                --point;
            }
            ++point;
            ++number;
            if (point > l.size() - 1) {
                point = 0;
            }
        }
        System.out.println(number);
        System.out.println("最后剩下的人为" + l.get(0) + "号");
    }
}
