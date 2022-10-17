package me.day16.stream.pipeline.intermediate.mapping;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class AsDoubleStreamAndBoxedExample {
    public static void main(String[] args) {

        int[] intArray = {1, 2, 3, 4, 5};

        // int[] 배열로부터 IntStream을 얻고 난 다음 int 요소를 double 요소로 타입 변환해서 DoubleStream 생성
        IntStream intStream = Arrays.stream(intArray);
        intStream
                .asDoubleStream()
                .forEach(d -> System.out.println(d));

        System.out.println();

        // int 요소를 Integer 객체로 박싱해서 Stream<Integer>를 생성
        intStream = Arrays.stream(intArray);
        intStream
                .boxed() // int -> Integer
                .forEach(obj -> System.out.println(obj.intValue()));
    }
}