package me.day16.stream.parallel.benchmark;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// 순차 처리와 병렬 처리 성능 비교
public class SequentialVSParallelExample {
    // 요소 처리
    public static void work(int value) {
        try {
            Thread.sleep(100); // 값이 작을수록 순차처리가 더 빠름
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    // 순차 처리
    public static long testSequential(List<Integer> list) {
        long start = System.nanoTime();
        list.stream().forEach(i -> work(i));
        long end = System.nanoTime();
        return end - start;
    }

    // 병렬 처리
    public static long testParallel(List<Integer> list) {
        long start = System.nanoTime();
        list.stream().parallel().forEach(i -> work(i));
        long end = System.nanoTime();
        return end - start;
    }

    public static void main(String[] args) {
        // 소스 컬렉션
        List<Integer> list = IntStream.range(0, 10).boxed().collect(Collectors.toList());

        // 순차 스트림 처리 시간 구하기
        long timeSequential = testSequential(list);

        // 병렬 스트림 처리 시간 구하기
        long timeParallel = testParallel(list);

        if (timeSequential < timeParallel) {
            System.out.println("성능 테스트 결과: 순차 처리 더 빠름");
        } else {
            System.out.println("성능 테스트 결과: 병렬 처리 더 빠름");
        }
    }
}
