package com.rich.lambda;

import com.rich.lambda.Employee;
import com.rich.lambda.FunctionImpl;

import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.function.BiConsumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by hanwang206326 on 16/1/13.
 */
public class MySort {
    public static void main(String[] args) {
        String[] words = new String[]{"1", "2", "234", "23"};
        //Arrays.sort(new String[]{"1", "2", "234", "23"}, new LengthComparator());
        Arrays.sort(words, (first, second) -> Integer.compare(first.length(), second.length()));
        Arrays.sort(words, String::compareToIgnoreCase);
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
        /*int i = ff
        FunctionalIfac::testFunc;*/
        List<String> list = new ArrayList<String>();
        list.forEach(System.out::println);
        //Collection.nCopies(10, "Fred");
        Arrays.sort(words, Comparator.comparing(String::length));
        Stream<String> stream = new ArrayList<String>().stream().map(x -> new String(x + "aaaa"));

        Stream<String> echos = Stream.generate(() -> "Echo");

        Stream<Integer> longWords = list.stream().map(w -> w.length());

        Stream<Double> randoms = Stream.generate(Math::random).limit(100);
        System.out.println(randoms);


        List<String> uniqueWords = Stream.of("a", "b", "c", "d", "a").distinct().collect(Collectors.toList());


        Optional<String> largest = Stream.of(words).max(String::compareToIgnoreCase);
        if (largest.isPresent()) {
            System.out.println(largest.get());
        }
        boolean aWordStartsWithQ = Stream.of(words).parallel().map(x -> x.toLowerCase()).anyMatch(s -> s.startsWith("Q"));
        boolean aWordStartsWithX = Stream.of(words).parallel()
                .map(new Function<String, String>() {
                         @Override
                         public String apply(String s) {
                             return s.toLowerCase();
                         }
                     }
                ).anyMatch(new Predicate<String>() {
                               /**
                                * Evaluates this predicate on the given argument.
                                *
                                * @param s the input argument
                                * @return {@code true} if the input argument matches the predicate,
                                * otherwise {@code false}
                                */
                               @Override
                               public boolean test(String s) {
                                   return s.startsWith("Q");
                               }
                           }
                );

        Stream<String> streamQ = Stream.of(words).parallel().map(x -> x.toLowerCase());
        Stream<String> streamX = Stream.of(words).parallel().map(new FunctionImpl());
        boolean streamQbool = streamQ.anyMatch(s -> s.startsWith("Q"));
        boolean streamXbool = streamX.anyMatch(s -> s.startsWith("X"));

        System.out.println(aWordStartsWithQ);
        List<Employee> employees = new ArrayList<Employee>();
        int totalSalary = employees.stream().map(Employee::getSalary).reduce(0, (x, y) -> x + y);
        List<String> nameList = employees.stream().map(Employee::getName).collect(Collectors.toList());
        //double averageSalary = employees.stream().mapToInt(Employee::getSalary).average().getAsDouble();
        //averageSalary = employees.stream().collect(Collectors.averagingInt(Employee::getSalary));
        Map<Integer, List<Employee>> departEmployee = employees.stream().collect(Collectors.groupingBy(Employee::getDepartId));
        departEmployee.forEach(new BiConsumer<Integer, List<Employee>>() {
            @Override
            public void accept(Integer integer, List<Employee> employees) {
                System.out.println(integer + ":" + employees.stream().mapToInt(Employee::getSalary).average().getAsDouble());
            }
        });

        departEmployee.forEach((k, v) -> System.out.println(k + ":" + v.stream().mapToInt(Employee::getSalary).average().getAsDouble()));

        //Stream<Locale> locales = Stream.of(Locale.getAvailableLocales());
        //Map<String, Set<Locale>> countryToLocales = locales.collect(Collectors.groupingBy(Locale::getCountry, Collectors.toSet()));
        //Map<Boolean, List<Locale>> countryToLocales1 = locales.collect(Collectors.partitioningBy(x -> x.getLanguage().endsWith("en")));

        List<String> wordList = new ArrayList<String>();
        wordList.add("END");
        System.out.println(wordList);
        Stream<String> wordStreams = wordList.stream();
        wordStreams.forEach(s -> {
            if (s.length() > 12) wordList.remove(s);
        });
        System.out.println(wordList);
        unchecked(new Callable() {
            /**
             * Computes a result, or throws an exception if unable to do so.
             *
             * @return computed result
             * @throws Exception if unable to compute a result
             */
            @Override


            public Object call() throws Exception {
                return null;
            }
        });
        List<Father> fatherList = new ArrayList<>();
        String[] array = {"a", "b", "c"};
        Integer[] intArray = {1, 2, 3};
        for (final Integer i : intArray) {
            Stream.of(array).map(item -> intArray + i.toString()).forEach(System.out::println);
        }
    }

    public static <T> Supplier<T> unchecked(Callable<T> f) {
        return () -> {
            try {
                return f.call();
            } catch (Exception e) {
                throw new RuntimeException();
            } catch (Throwable t) {
                throw t;
            }
        };
    }
}
