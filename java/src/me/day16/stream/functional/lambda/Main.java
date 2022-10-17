package me.day16.stream.functional.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(7, 5, 123, 5, 42, 95, 68, 30, 42);

        List<Integer> result = values.stream()
                .filter(number -> number < 50) // 50 미만인 수만 반환
                .distinct()                    // 중복 제거
                .sorted(Integer::compare)      // 오름차순 정렬
                .collect(Collectors.toList()); // 리스트에 저장

        System.out.println("result = " + result);
    }
}
