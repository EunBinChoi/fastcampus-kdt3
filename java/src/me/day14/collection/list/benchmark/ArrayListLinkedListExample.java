package me.day14.collection.list.benchmark;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ArrayListLinkedListExample {
    public static void main(String[] args) {
        List<String> arrayList = new ArrayList<>();
        List<String> linkedList = new LinkedList<>();

        //////////////////////////////////////////////////////////////////////////
        // 인덱스를 통해 원소 추가 (인덱스 0에 추가)
        long startTime;
        long endTime;
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            arrayList.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.println("[ArrayList  원소 추가] : " + String.format("%20d", (endTime - startTime)) + " [ms]");

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedList.add(0, String.valueOf(i));
        }
        endTime = System.nanoTime();
        System.out.println("[LinkedList 원소 추가] : " + String.format("%20d", (endTime - startTime)) + " [ms]");
        System.out.println();



        ////////////////////////////////////////////////////////////////////////////////////
        // 인덱스를 통해 원소 접근
        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            arrayList.get(i);
        }
        endTime = System.nanoTime();
        System.out.println("[ArrayList  원소 접근] : " + String.format("%20d", (endTime - startTime)) + " [ms]");

        startTime = System.nanoTime();
        for (int i = 0; i < 100000; i++) {
            linkedList.get(i);
        }
        endTime = System.nanoTime();
        System.out.println("[LinkedList 원소 접근] : " + String.format("%20d", (endTime - startTime)) + " [ms]");
    }
}
