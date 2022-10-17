package me.day16.stream.pipeline.terminal.foreach;

import java.util.Arrays;

public class ForEachExample {
    public static void main(String[] args) {
        int[] ints = {10, 20, 30, 60, 15, 25, 31, 60};
        Arrays.stream(ints)
                .filter(i -> i % 3 == 0)
                .forEach(System.out :: println);

        Arrays.stream(ints)
                .filter(i -> i % 3 == 0)
                .forEachOrdered(System.out :: println); // 병렬 스트림에서 사용 (순서 보장이 안되는데 순서 보장해주기 위함)
    }
}
