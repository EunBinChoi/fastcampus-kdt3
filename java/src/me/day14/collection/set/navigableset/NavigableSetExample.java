package me.day14.collection.set.navigableset;

import java.util.Iterator;
import java.util.NavigableSet;
import java.util.TreeSet;

public class NavigableSetExample {
    public static void main(String[] args) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 10; i >= 1 ; i--) {
            treeSet.add(i);
        }
        System.out.println("treeSet = " + treeSet);
        System.out.println("treeSet.size() = " + treeSet.size());
        System.out.println();

        System.out.println("treeSet.first() = " + treeSet.first()); // 가장 낮은 객체
        System.out.println("treeSet.last() = " + treeSet.last()); // 가장 높은 객체
        System.out.println();

        System.out.println("treeSet.lower(5) = " + treeSet.lower(5)); // 주어진 객체보다 바로 아래 객체
        System.out.println("treeSet.higher(5) = " + treeSet.higher(5)); // 주어진 객체보다 바로 위 객체
        System.out.println();

        // 주어진 객체와 동등한 객체 있으면 리턴, 아니면 주어진 객체 바로 아래 객체 리턴
        System.out.println("treeSet.floor(10) = " + treeSet.floor(10));
        // 주어진 객체와 동등한 객체 있으면 리턴, 아니면 주어진 객체 바로 아래 객체 리턴
        System.out.println("treeSet.floor(11) = " + treeSet.floor(11));
        System.out.println();

        // 주어진 객체와 동등한 객체 있으면 리턴, 아니면 주어진 객체 바로 위 객체 리턴
        System.out.println("treeSet.ceiling(1) = " + treeSet.ceiling(1));
        // 주어진 객체와 동등한 객체 있으면 리턴, 아니면 주어진 객체 바로 위 객체 리턴
        System.out.println("treeSet.ceiling(0) = " + treeSet.ceiling(0));
        System.out.println();

        // 제일 낮은 객체를 꺼내오고 컬렉션에서 제거
        System.out.println("treeSet.pollFirst() = " + treeSet.pollFirst());
        System.out.println("treeSet = " + treeSet);
        System.out.println("treeSet.size() = " + treeSet.size());
        System.out.println();

        // 제일 높은 객체를 꺼내오고 컬렉션에서 제거
        System.out.println("treeSet.pollLast() = " + treeSet.pollLast());
        System.out.println("treeSet = " + treeSet);
        System.out.println("treeSet.size() = " + treeSet.size());
        System.out.println();

        /////////////////////////////////////////////////////////////////
        // 내림차순
        Iterator<Integer> iterator = treeSet.descendingIterator();
        while (iterator.hasNext()) {
            int i = iterator.next();
            System.out.print(i + ", ");
        }
        System.out.println();

        // 오름차순
        Iterator<Integer> iterator2 = treeSet.iterator();
        while (iterator2.hasNext()) {
            int i = iterator2.next();
            System.out.print(i + ", ");
        }
        System.out.println();


        // 내림차순
        NavigableSet<Integer> navigableSet = treeSet.descendingSet();
        System.out.println("descending navigableSet = " + navigableSet);

        // 오름차순
        NavigableSet<Integer> navigableSet1 = treeSet.descendingSet().descendingSet();
        System.out.println("ascending navigableSet = " + navigableSet1);
        System.out.println();

        /////////////////////////////////////////////////////////////////
        // 주어진 객체보다 낮은 객체들을 NavigableSet으로 리턴
        // 주어진 객체 포함 여부는 2번째 매개값에 따라 달라짐
        NavigableSet<Integer> headSet = treeSet.headSet(5, true);
        System.out.println("headSet = " + headSet);

        // 주어진 객체보다 높은 객체들을 NavigableSet으로 리턴
        // 주어진 객체 포함 여부는 2번째 매개값에 따라 달라짐
        NavigableSet<Integer> tailSet = treeSet.tailSet(5, true);
        System.out.println("tailSet = " + tailSet);

        // 시작과 끝으로 주어진 객체 사이의 객체들을 NavigableSet으로 리턴
        // 시작과 끝 객체의 포함 여부는 2번째, 4번째 매개값에 따라 달라짐
        TreeSet<String> stringTreeSet = new TreeSet<>();
        stringTreeSet.add("a");
        stringTreeSet.add("b");
        stringTreeSet.add("c");
        stringTreeSet.add("d");
        stringTreeSet.add("f");
        stringTreeSet.add("z");

        //c에서 f사이의 단어 검색;
        NavigableSet<String> subset = stringTreeSet.subSet("c", true, "z", false);
        for(String word : subset) {
            System.out.println(word);
        }
    }
}
