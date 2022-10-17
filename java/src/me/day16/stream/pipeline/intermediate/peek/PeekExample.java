package me.day16.stream.pipeline.intermediate.peek;

import java.util.stream.IntStream;

public class PeekExample {
    public static void main(String[] args) {
        // 필터링 후 어떤 요소만 남았는지 확인하기 위해 peek()를 마지막에서 호출할 경우 스트림은 전혀 동작하지 않음
        IntStream.rangeClosed(1, 10)
                .filter(i -> i % 2 == 0)
                .peek(i -> System.out.print(i + ", "));

        // 요소 처리의 최종 단계가 합을 구하는 것이라면 peek() 메소드 호출 후 sum()을 호출해야만 정상적으로 동작함
        int sum = IntStream.rangeClosed(1, 10)
                .filter(i -> i % 2 == 0)
                .peek(i -> System.out.print(i + ", "))
                .sum();
        System.out.println("\nsum = " + sum);

        // forEach는 최종처리 메소드이기 때문에 파이프라인 마지막에 루핑하면서 정상적으로 동작
        IntStream.rangeClosed(1, 10)
                .filter(i -> i % 2 == 0)
                .forEach(i -> System.out.print(i + ", "));
    }
}
