package me.day14.collection.set.treeset;

import me.day14.collection.set.treeset.node.Pen;

import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;
import java.util.Set;

public class TreeSetExample {
    public static void main(String[] args) {
        Set<Integer> treeSet = new TreeSet<>();

        // 원소 추가
        // 원소를 추가할 때 이진 탐색 트리에 저장하여 객체 크기 순서가 유지될 수 있도록 만듦 (정렬됨)
        // 이진 탐색 트리 중 레드-블랙 트리로 구현되어있음 (개략적으로 balanced tree) (https://code-lab1.tistory.com/62)
        for (int i = 10; i >= 1 ; i--) {
            treeSet.add(i);
        }
        System.out.println("treeSet = " + treeSet);
        System.out.println("treeSet.size() = " + treeSet.size());
        System.out.println();

        // 원소 중복이 있으면 중복 제거

        /*
         [ 중복 제거하는 방법 ]

         1) 두 원소의 hashCode() => true
         2) 두 원소의 equals() => true
         두 원소는 동일하다고 가정하고 중복 정의 X
         */
        for (int i = 10; i >= 1 ; i--) {
            treeSet.add(i);
        }
        System.out.println("treeSet = " + treeSet);
        System.out.println("treeSet.size() = " + treeSet.size());
        System.out.println();

        // 컬렉션 요소 모두 추가 (합집합)
        System.out.println("treeSet.addAll(Set.of(100, 200)) = " + treeSet.addAll(Set.of(100, 200)));
        System.out.println("treeSet = " + treeSet);
        System.out.println("treeSet.size() = " + treeSet.size());
        System.out.println();

        // set은 hashCode()를 키 값으로 저장하기 때문에 인덱스 개념이 없음
        // set 내부 반복하려면 반복자를 통해 반복함
        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            System.out.println("iterator.next() = " + iterator.next());
        }
        System.out.println();

        // 인덱스가 없으므로 인덱스를 통해 원소를 검색하는 함수 없음
//        treeSet.add(1, Integer.valueOf(1));
//        treeSet.get()
//        treeSet.indexOf()
//        treeSet.lastIndexOf()
//        treeSet.subList(1, 2);
        treeSet.remove(Integer.valueOf(1)); // 인덱스를 통해 삭제하는 것이 아니라 2라는 object 삭제
        System.out.println("treeSet = " + treeSet);
        System.out.println("treeSet.size() = " + treeSet.size());
        System.out.println();

        // hashCode() 확인
        Iterator<Integer> iterator1 = treeSet.iterator();
        while (iterator1.hasNext()) {
            Integer i = iterator1.next();
            System.out.print(i.hashCode() + ", ");
        }
        System.out.println();
        System.out.println("treeSet.hashCode() = " + treeSet.hashCode()); // 내부 원소 다 더한 값
        System.out.println();

        // 원소 유무 확인
        System.out.println("treeSet = " + treeSet);
        System.out.println("treeSet.contains(10) = " + treeSet.contains(10));
        System.out.println("treeSet.containsAll(Set.of(4, 5, 6)) = " + treeSet.containsAll(Set.of(4, 5, 6)));
        System.out.println();

        // 두 컬렉션 교집합
        System.out.println("treeSet.retainAll(Set.of(1, 2, 3, 4)) = " + treeSet.retainAll(Set.of(1, 2, 3, 4)));
        System.out.println("treeSet = " + treeSet);
        System.out.println();


        // 컬렉션 원소 모두 삭제 (차집합)
        treeSet.removeAll(Set.of(1, 2, 3));
        System.out.println("treeSet = " + treeSet);
        System.out.println("treeSet.size() = " + treeSet.size());
        System.out.println();
        
        treeSet.clear();
        System.out.println("treeSet = " + treeSet);
        System.out.println("treeSet.size() = " + treeSet.size());
        System.out.println();

        System.out.println("treeSet.isEmpty() = " + treeSet.isEmpty());
        System.out.println();

        //////////////////////////////////////////////////////////////////////////
        // TreeSet의 원소가 객체인 경우
        Set<Pen> penSet = new TreeSet<>();


        // 원소 추가
        // 원소를 추가할 때 이진 탐색 트리에 저장하여 객체 크기 순서가 유지될 수 있도록 만듦 (정렬됨)
        // 이진 탐색 트리 중 레드-블랙 트리로 구현되어있음 (개략적으로 balanced tree) (https://code-lab1.tistory.com/62)
        penSet.add(new Pen("0001", "파카", "red")); // ClassCastException
        penSet.add(new Pen("0002", "빅", "black")); // ClassCastException
        penSet.add(new Pen("0003", "파카", "blue")); // ClassCastException
        penSet.add(new Pen("0004", "제브라", "red")); // ClassCastException
        // TODO: ClassCastException 발생 이유와 해결 방안을 제시하시오.

        System.out.println("penSet = " + penSet);
        System.out.println("penSet.size() = " + penSet.size());
        System.out.println();

        // set은 hashCode()를 키 값으로 저장하기 때문에 인덱스 개념이 없음
        // set 내부 반복하려면 반복자를 통해 반복함
        Iterator<Pen> iterator2 = penSet.iterator();
        while (iterator2.hasNext()) {
            System.out.println("iterator2.next() = " + iterator2.next());
        }
        System.out.println();


        //////////////////////////////////////////////////////////////////////////
        // Set (컬렉션) -> Array (객체 배열)
        Set<String> stringSet = new TreeSet<>();
        for (int i = 'a'; i <= 'z' ; i++) {
            stringSet.add(Character.toString(i));
        }
        System.out.println("stringSet = " + stringSet);

        String[] stringArray = stringSet.toArray(new String[stringSet.size()]);
        System.out.println("stringArray = " + Arrays.toString(stringArray));

        Set<String> stringSet1 = new TreeSet<>(Arrays.asList(stringArray));
        System.out.println("stringSet1 = " + stringSet1);


    }
}
