package com.rich.jdk8;

import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.LongUnaryOperator;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * Created by hanwang206326 on 16/1/21.
 */
public class practice2 {
    public static void main(String[] args) {
        //2
        /*String[] words = {"a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa"};
        System.out.println(Stream.of(words).sorted(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println("call compare");
                return 0;
            }
        }).limit(5));*/
        //4
        /*int[] values = {1, 4, 9, 16};
        IntStream intStream = IntStream.of(values);*/
        //5
        /*Stream<Long> longStream = LongStream.iterate(1l, (x) -> x + 1).boxed();*/
        //6
        /*String temp = "abcdefg";
        IntStream.range(0, temp.length()).boxed().map((x) -> temp.charAt(x)).forEach(System.out::println);*/
        //8
        //9
        ArrayList<String> test1 = new ArrayList<>();
        test1.add("test1");
        ArrayList<String> test2 = new ArrayList<>();
        test2.add("test2");
        ArrayList<String> test3 = new ArrayList<>();
        test2.add("test3");
        Stream<ArrayList<String>> stream = Stream.of(test1, test2, test3);
        /*Optional<ArrayList<String>> a1 = stream.reduce((x, y) -> {
            x.addAll(y);
            return x;
        });
        if (a1.isPresent()) {
            a1.get().stream().forEach(System.out::println);
        }*/
        /*ArrayList<String> a2 = stream.reduce(new ArrayList<String>(), (x, y) -> {
            x.addAll(y);
            return x;
        });
        a2.stream().forEach(System.out::println);*/
        /*ArrayList<String> a3 = new ArrayList<>();
        stream.forEach(new Consumer<ArrayList<String>>() {
            @Override
            public void accept(ArrayList<String> strings) {
                a3.addAll(strings);
            }
        });
        a3.stream().forEach(System.out::println);*/
    }
}
