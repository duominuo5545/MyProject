package com.rich.lambda;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by hanwang206326 on 16/1/17.
 */
public class MyLambda {
    public static void main(String[] args) {
        //1
        /*String[] arrayStr = {"a", "b", "c", "d", "e"};
        System.out.println("out:" + Thread.currentThread().getId());
        Arrays.sort(arrayStr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return Integer.compare(o1.length(), o2.length());
            }
        });
        Arrays.sort(arrayStr, (x, y) -> {
            System.out.println("inner:" + Thread.currentThread().getId());
            return Integer.compare(x.length(), y.length());
        });*/
        //2
        /*File file = new File("/Users/hanwang206326");
        File[] arrayFile = file.listFiles(File::isDirectory);
        for (int i = 0; i < arrayFile.length; i++) {
            System.out.println(arrayFile[i].getAbsoluteFile());
        }*/
        //3
        /*File file = new File("/Users/hanwang206326");
        String[] arrayStr = file.list(((dir, name) -> name.contains("jpg")));
        Stream.of(arrayStr).forEach(x -> System.out.println(x));*/
        //4
        /*File workFile = new File("/Users/hanwang206326/work");
        File zkFile = new File("/Users/hanwang206326/zookeeper-3.3.6");
        File[] c = new File[workFile.list().length + zkFile.list().length];
        System.arraycopy(workFile.listFiles(), 0, c, 0, workFile.listFiles().length);
        System.arraycopy(zkFile.listFiles(), 0, c, workFile.listFiles().length, zkFile.listFiles().length);
        Stream.of(c).forEach(x -> System.out.println(x.getAbsolutePath()));
        System.out.println("分割线----------------------------");
        Stream.of(c).sorted((first, second) -> second.getAbsolutePath().compareToIgnoreCase(first.getAbsolutePath())).forEach(x -> System.out.println(x));*/
        //6
        /*new Thread(RunnableEx.uncheck(() -> {
            System.out.println("xxxx");
            Thread.sleep(1000);
        })).start();*/
        //8
        /*String[] names = {"Peter", "Paul", "Mary"};
        List<Runnable> runners = new ArrayList<Runnable>();
        for (int i = 0; i < names.length; i++) {
            String name = names[i];
            runners.add(() -> System.out.println(name));
        }
        for (Runnable runnable : runners) {
            runnable.run();
        }*/
        //9
        Collection2<String> aaa = new Collection2Impl<>();

    }
}
