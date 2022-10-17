package me.day16.stream.parallel;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class ParallelExample {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "김", "이", "박", "최", "윤"
        );

        // 순차 처리
        Stream<String> stream = list.stream();
        stream.forEach(
                s -> print(s)
        );
        System.out.println();

        // 병렬 처리
        Stream<String> parallelStream = list.parallelStream();
        parallelStream.forEach(s -> print(s));
    }

    public static void print(String str) {
        System.out.println(str + " : " + Thread.currentThread().getName());
    }
}