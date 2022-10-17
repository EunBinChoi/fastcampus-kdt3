package me.day16.stream.parallel.benchmark;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

// 스트림 소스 종류에 따른 성능 비교
public class ArrayListVSLinkedListExample {
    // 요소 처리
    public static void work(int value) {
        // nothing to work
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
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> linkedList = new LinkedList<>();

        for (int i = 0; i < 1000000; i++) { // 요소 개수가 적으면 LinkedList가 더 빠름
            arrayList.add(i);
            linkedList.add(i);
        }

        // 워밍업
        long arrayListParallel = testParallel(arrayList);
        long linkedListParallel = testParallel(linkedList);

        if (arrayListParallel < linkedListParallel) {
            System.out.println("성능 테스트 결과: ArrayList 처리가 더 빠름");
        } else {
            System.out.println("성능 테스트 결과: LinkedList 더 빠름");
        }
    }
}
