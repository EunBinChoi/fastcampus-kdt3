package me.day16.stream.pipeline.intermediate.filter;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamFilterExample {
    public static void main(String[] args) {
        // 1 ~ 10이 중복 저장된 컬렉션에서 중복을 제거하고 홀수만 필터링해서 컬렉션에 저장하는 예제
        System.out.print("1 ~ 10 중복 저장 => ");
        List<Integer> numbers = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList()); // 1 ~ 10 저장
        numbers.addAll(numbers); // 1 ~ 10 중복 저장
        System.out.println(numbers);

        System.out.print("중복 제거 => ");
        numbers.stream()
                .distinct()
                .forEach(i -> System.out.print(i + ", "));
        System.out.println();

        System.out.print("필터링 => ");
        numbers.stream()
                .filter(i -> i % 2 == 1)
                .forEach(i -> System.out.print(i + ", "));
        System.out.println();

        System.out.print("중복 제거 후 필터링해서 컬렉션 저장 => ");
        numbers = numbers.stream()
                .distinct() // 중복 제거
                .filter(i -> i % 2 == 1) // 홀수 필터링
                .collect(Collectors.toList());
        System.out.println(numbers);
    }
}
