package me.day14.collection.set.hashset;

import java.util.*;

public class HashSetExample {
    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>(3);

        // 원소 추가
        // hashCode()를 키 값으로 저장하기 때문에 저장 순서가 유지되지 않을 수 있음
        for (int i = 10; i >= 1 ; i--) {
            hashSet.add(i);
        }
        System.out.println("hashSet = " + hashSet);
        System.out.println("hashSet.size() = " + hashSet.size());
        System.out.println();

        // 원소 중복이 있으면 중복 제거

        /*
         [ 중복 제거하는 방법 ]

         1) 두 원소의 hashCode() => true
         2) 두 원소의 equals() => true
         두 원소는 동일하다고 가정하고 중복 정의 X
         */
        for (int i = 10; i >= 1 ; i--) {
            hashSet.add(i);
        }
        System.out.println("hashSet = " + hashSet);
        System.out.println("hashSet.size() = " + hashSet.size());
        System.out.println();

        // 컬렉션 요소 모두 추가 (합집합)
        System.out.println("hashSet.addAll(Set.of(100, 200)) = " + hashSet.addAll(Set.of(100, 200)));
        System.out.println("hashSet = " + hashSet);
        System.out.println("hashSet.size() = " + hashSet.size());
        System.out.println();

//        hashSet.get(i)

        // Set은 hashCode()를 키 값으로 저장하기 때문에 인덱스 개념이 없음
        // Set 내부 반복하려면 반복자를 통해 반복함
        Iterator<Integer> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println("iterator.next() = " + iterator.next());
        }
        System.out.println();

        // 인덱스가 없으므로 인덱스를 통해 원소를 검색하는 함수 없음
//        hashSet.add(1, Integer.valueOf(1));
//        hashSet.get()
//        hashSet.indexOf()
//        hashSet.lastIndexOf()
//        hashSet.subList(1, 2);
        hashSet.remove(Integer.valueOf(1)); // 인덱스를 통해 삭제하는 것이 아니라 1라는 object 삭제
        System.out.println("hashSet = " + hashSet);
        System.out.println("hashSet.size() = " + hashSet.size());
        System.out.println();

        // hashCode() 확인
        Iterator<Integer> iterator1 = hashSet.iterator();
        while (iterator1.hasNext()) {
            Integer i = iterator1.next();
            System.out.print(i.hashCode() + ", ");
        }
        System.out.println();
        System.out.println("hashSet.hashCode() = " + hashSet.hashCode()); // 내부 원소 다 더한 값
        System.out.println();

        // 원소 유무 확인
        System.out.println("hashSet = " + hashSet);
        System.out.println("hashSet.contains(10) = " + hashSet.contains(10));
        System.out.println("hashSet.containsAll(Set.of(4, 5, 6)) = " + hashSet.containsAll(Set.of(4, 5, 6)));
        System.out.println();

        // 두 컬렉션 교집합
        System.out.println("hashSet.retainAll(Set.of(1, 2, 3, 4)) = " + hashSet.retainAll(Set.of(1, 2, 3, 4)));
        System.out.println("hashSet = " + hashSet);
        System.out.println();


        // 컬렉션 원소 모두 삭제 (차집합)
        hashSet.removeAll(Set.of(1, 2, 3));
        System.out.println("hashSet = " + hashSet);
        System.out.println("hashSet.size() = " + hashSet.size());
        System.out.println();
        
        hashSet.clear();
        System.out.println("hashSet = " + hashSet);
        System.out.println("hashSet.size() = " + hashSet.size());
        System.out.println();

        System.out.println("hashSet.isEmpty() = " + hashSet.isEmpty());
        System.out.println();

        //////////////////////////////////////////////////////////////////////////
        // Set (컬렉션) -> Array (객체 배열)
        Set<String> stringSet = new HashSet<>();
        for (int i = 'a'; i <= 'z' ; i++) {
            stringSet.add(Character.toString(i));
        }
        System.out.println("stringSet = " + stringSet);

        String[] stringArray = stringSet.toArray(new String[stringSet.size()]);
        System.out.println("stringArray = " + Arrays.toString(stringArray));

        Set<String> stringSet1 = new HashSet<>(Arrays.asList(stringArray));
        System.out.println("stringSet1 = " + stringSet1);


    }
}
