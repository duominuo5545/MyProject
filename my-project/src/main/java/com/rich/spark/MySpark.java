package com.rich.spark;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.api.java.function.FlatMapFunction;
import org.apache.spark.api.java.function.Function2;
import org.apache.spark.api.java.function.PairFunction;
import scala.Tuple2;

import java.util.Arrays;

/**
 * Created by hanwang206326 on 16/6/2.
 */
public class MySpark {
    public static void main(String[] args) {
        //SparkConf conf = new SparkConf().setMaster("local").setAppName("wordCount");
        SparkConf conf = new SparkConf().setMaster("local").setAppName("wordCount");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> input = sc.textFile("/Users/rich/gitignore");
        JavaRDD<String> words = input.flatMap(new FlatMapFunction<String, String>() {
            @Override
            public Iterable<String> call(String s) throws Exception {
                return Arrays.asList(s.split(" "));
            }
        });
        JavaPairRDD<String, Integer> counts = words.mapToPair(new PairFunction<String, String, Integer>() {
            @Override
            public Tuple2<String, Integer> call(String s) throws Exception {
                return new Tuple2<String, Integer>(s, 1);
            }
        }).reduceByKey(new Function2<Integer, Integer, Integer>() {
            @Override
            public Integer call(Integer integer, Integer integer2) throws Exception {
                return integer + integer2;
            }
        });
        System.out.println(counts.collect());

        JavaRDD<String> lines1 = sc.parallelize(Arrays.asList("pandas", "i like pandas"));

        JavaRDD<String> lines2 = sc.textFile("/user/hanwang206326/test.txt");
        JavaRDD<String> errorRDD = lines2.filter((x) -> {
            return x.contains("error");
        });
        JavaPairRDD<String, String> pairRDD = lines1.mapToPair(s -> {
            return new Tuple2<String, String>(s.split(" ")[0], s);
        });
    }
}
