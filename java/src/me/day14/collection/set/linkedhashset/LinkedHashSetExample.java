package me.day14.collection.set.linkedhashset;

import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Iterator;
import java.util.Set;

public class LinkedHashSetExample {
    public static void main(String[] args) {
        Set<Integer> linkedHashSet = new LinkedHashSet<>(3);

        // 원소 추가
        // hashCode()를 키 값으로 저장하기 때문에 저장 순서가 유지되지 않을 수 있지만 LinkedHashSet은 순서를 같이 저장하므로써 순서가 유지되게 만듦
        for (int i = 10; i >= 1 ; i--) {
            linkedHashSet.add(i);
        }
        System.out.println("linkedHashSet = " + linkedHashSet);
        System.out.println("linkedHashSet.size() = " + linkedHashSet.size());
        System.out.println();

        // 원소 중복이 있으면 중복 제거

        /*
         [ 중복 제거하는 방법 ]

         1) 두 원소의 hashCode() => true
         2) 두 원소의 equals() => true
         두 원소는 동일하다고 가정하고 중복 정의 X
         */
        for (int i = 10; i >= 1 ; i--) {
            linkedHashSet.add(i);
        }
        System.out.println("linkedHashSet = " + linkedHashSet);
        System.out.println("linkedHashSet.size() = " + linkedHashSet.size());
        System.out.println();

        // 컬렉션 요소 모두 추가 (합집합)
        System.out.println("linkedHashSet.addAll(Set.of(100, 200)) = " + linkedHashSet.addAll(Set.of(100, 200)));
        System.out.println("linkedHashSet = " + linkedHashSet);
        System.out.println("linkedHashSet.size() = " + linkedHashSet.size());
        System.out.println();

        // set은 hashCode()를 키 값으로 저장하기 때문에 인덱스 개념이 없음
        // set 내부 반복하려면 반복자를 통해 반복함
        Iterator<Integer> iterator = linkedHashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println("iterator.next() = " + iterator.next());
        }
        System.out.println();

        // 인덱스가 없으므로 인덱스를 통해 원소를 검색하는 함수 없음
//        linkedHashSet.add(1, Integer.valueOf(1));
//        linkedHashSet.get()
//        linkedHashSet.indexOf()
//        linkedHashSet.lastIndexOf()
//        linkedHashSet.subList(1, 2);
        linkedHashSet.remove(Integer.valueOf(1)); // 인덱스를 통해 삭제하는 것이 아니라 2라는 object 삭제
        System.out.println("linkedHashSet = " + linkedHashSet);
        System.out.println("linkedHashSet.size() = " + linkedHashSet.size());
        System.out.println();

        // hashCode() 확인
        Iterator<Integer> iterator1 = linkedHashSet.iterator();
        while (iterator1.hasNext()) {
            Integer i = iterator1.next();
            System.out.print(i.hashCode() + ", ");
        }
        System.out.println();
        System.out.println("linkedHashSet.hashCode() = " + linkedHashSet.hashCode()); // 내부 원소 다 더한 값
        System.out.println();

        // 원소 유무 확인
        System.out.println("linkedHashSet = " + linkedHashSet);
        System.out.println("linkedHashSet.contains(10) = " + linkedHashSet.contains(10));
        System.out.println("linkedHashSet.containsAll(Set.of(4, 5, 6)) = " + linkedHashSet.containsAll(Set.of(4, 5, 6)));
        System.out.println();

        // 두 컬렉션 교집합
        System.out.println("linkedHashSet.retainAll(Set.of(1, 2, 3, 4)) = " + linkedHashSet.retainAll(Set.of(1, 2, 3, 4)));
        System.out.println("linkedHashSet = " + linkedHashSet);
        System.out.println();


        // 컬렉션 원소 모두 삭제 (차집합)
        linkedHashSet.removeAll(Set.of(1, 2, 3));
        System.out.println("linkedHashSet = " + linkedHashSet);
        System.out.println("linkedHashSet.size() = " + linkedHashSet.size());
        System.out.println();
        
        linkedHashSet.clear();
        System.out.println("linkedHashSet = " + linkedHashSet);
        System.out.println("linkedHashSet.size() = " + linkedHashSet.size());
        System.out.println();

        System.out.println("linkedHashSet.isEmpty() = " + linkedHashSet.isEmpty());
        System.out.println();

        //////////////////////////////////////////////////////////////////////////
        // Set (컬렉션) -> Array (객체 배열)
        Set<String> stringSet = new LinkedHashSet<>();
        for (int i = 'a'; i <= 'z' ; i++) {
            stringSet.add(Character.toString(i));
        }
        System.out.println("stringSet = " + stringSet);

        String[] stringArray = stringSet.toArray(new String[stringSet.size()]);
        System.out.println("stringArray = " + Arrays.toString(stringArray));

        Set<String> stringSet1 = new LinkedHashSet<>(Arrays.asList(stringArray));
        System.out.println("stringSet1 = " + stringSet1);


    }
}
