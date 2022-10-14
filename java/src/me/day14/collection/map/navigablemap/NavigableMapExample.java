package me.day14.collection.map.navigablemap;

import java.util.Arrays;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class NavigableMapExample {
    public static void main(String[] args) {
        TreeMap<Integer, String> treeMap = new TreeMap<>();
        int[] arr = new int[20];

        for (int i = 0; i < 20; i++) {
            int t = (int)(Math.random() * 100) + 1;
            arr[i] = t;
            treeMap.put(t, "foo" + t);
        }

        Arrays.sort(arr);


        int middle = arr[arr.length/2 - 1];

        for (Map.Entry<Integer, String> s: treeMap.entrySet()) {
            System.out.print(s.getKey() + ": " + s.getValue() + ", ");
        }
        System.out.println();
        System.out.println();

        System.out.println("middle key값 : " + middle);
        System.out.println("middle 값의 lowerEntry : " + treeMap.lowerEntry(middle).getKey() + "=" + treeMap.lowerEntry(middle).getValue());
        System.out.println("middle 값의 higherEntry : " + treeMap.higherEntry(middle).getKey() + "=" + treeMap.higherEntry(middle).getValue());
        System.out.println();

        System.out.println("middle 값을 기준으로 상위 entrySet ..");
        for (Map.Entry<Integer, String> s : treeMap.headMap(middle).entrySet()) {
            System.out.print(s.getKey() + ": " + s.getValue() + ", ");
        }
        System.out.println();
        System.out.println();

        System.out.println("middle 값을 포함하는 하위 entrySet ..");
        for (Map.Entry<Integer, String> s : treeMap.tailMap(middle).entrySet()) {
            System.out.print(s.getKey() + ": " + s.getValue() + ", ");
        }
        System.out.println();
        System.out.println();

        System.out.println("TreeMap의 최상단 노드 : " + treeMap.firstEntry().getKey() + ": " + treeMap.firstEntry().getValue());
        System.out.println("TreeMap의 최하단 노드 : " + treeMap.lastEntry().getKey() + ": " + treeMap.lastEntry().getValue());
        System.out.println();
        System.out.println();

        ///////////////////////////////////////////////////////////////

        TreeMap<Integer, String> treeMap2 = new TreeMap<>();
        int[] arr2 = new int[20];

        for (int i = 0; i < 20; i++) {
            int t = (int)(Math.random() * 100) + 1;
            arr2[i] = t;
            treeMap2.put(t, "age" + t);
        }

        for (Map.Entry<Integer, String> s: treeMap2.entrySet()) {
            System.out.print(s.getKey() + ": " + s.getValue() + ", ");
        }
        System.out.println();
        System.out.println();


        SortedMap<Integer, String> NavigableRangeMap = treeMap2.subMap(25 , true, 50, true);

        System.out.println("# 25살 ~ 50살의 범위 subMap entry ..");

        for (Map.Entry<Integer, String> s : NavigableRangeMap.entrySet()) {
            System.out.print(s.getKey() + ": " + s.getValue() + ", ");
        }

    }
}
