package me.day14.collection.set;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class SetExample {
    public static void main(String[] args) {
        // Set은 인터페이스이기 때문에 객체 생성이나 추가, 삭제, 수정 연산 불가능 (UnsupportedOperationException)
        // Set은 인덱스가 없기 떄문에 인덱스가 필요한 메소드 호출 불가

//        Set<Integer> set = new Set<Integer>(); // 불가능

        Set<Integer> intStreamSet = IntStream.range(1, 11).mapToObj(i -> i).collect(Collectors.toSet());
        System.out.println("intStreamSet = " + intStreamSet);
        System.out.println();

        Set<Integer> integerSet = Set.of(1, 2, 3, 4);
        System.out.println("integerSet = " + integerSet); // 순서 유지되지 않음

//        Set<Integer> integerSet1 = Set.of(1, 2, 3, 4, 1, 2, 3, 4); // 중복된 원소 존재. IllegalArgumentException 발생
//        System.out.println("integerSet1 = " + integerSet1);

        System.out.println("integerSet.size() => " + integerSet.size());
        System.out.println();

        // 원소 추가
//        for (int i = 1; i <= 10 ; i++) {
//            integerSet.add(i);
//        }
//        System.out.println(integerSet);
//        System.out.println("integerSet.size() => " + integerSet.size());
//        System.out.println();

        // 원소 접근
//        for (int i = 0; i < integerSet.size(); i++) {
//            System.out.println("integerSet.get(i) = " + integerSet.get(i));;
//        }
//        System.out.println();

        // 원소 수정
//        integerSet.set(1, 200);

        // 원하는 인덱스에 원소 추가
//        integerSet.add(2, 100);
//        integerSet.add(-1, 100); // IndexOutOfBoundsException
//        integerSet.add(20, 100); // IndexOutOfBoundsException

//        integerSet.add(2, "abc"); // compile error. type mismatch.
//        System.out.println(integerSet);
//        System.out.println("integerSet.size() => " + integerSet.size());
//        System.out.println();

        // 컬렉션 일부 반환
//        List<Integer> subList = integerSet.subList(1, 5);
//        System.out.println("subList = " + subList);

        // 반환된 컬렉션 일부를 모두 추가
//        integerSet.addAll(Set.of(500, 600));
//        System.out.println(integerSet);
//        System.out.println("integerSet.size() => " + integerSet.size());
//        System.out.println();

        // 컬렉션 정렬
//        integerSet.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return Integer.compare(o1, o2);
//            }
//        });
//        System.out.println(integerSet);
//        System.out.println();

        // 일부 원소를 찾아 첫번째로 만난 원소의 인덱스 반환
//        System.out.println("integerSet.indexOf(100) => " + integerSet.indexOf(100)); // 앞에서 부터 찾음
//        System.out.println("integerSet.lastIndexOf(100) => " + integerSet.lastIndexOf(100)); // 뒤에서 부터 찾음
//        System.out.println(integerSet);
//        System.out.println();


        // 일부 원소 포함관계 확인
        System.out.println("integerSet.contains(3) => " + integerSet.contains(3));
        System.out.println(integerSet);
        System.out.println();

        // 일부 컬렉션 포함관계 확인
        System.out.println("integerSet.containsAll(List.of(3, 4, 5, 6, 7)) => " + integerSet.containsAll(List.of(3, 4, 5, 6, 7)));
        System.out.println(integerSet);
        System.out.println();

        // 현재 컬렉션과 주어진 컬렉션 사이의 교집합 반환
//        System.out.println("integerSet.retainAll(List.of(3, 4, 5, 6, 7)) => " + integerSet.retainAll(List.of(3, 4, 5, 6, 7)));
//        System.out.println(integerSet);
//        System.out.println();

        // 현재 컬렉션과 주어진 컬렉션 사이의 차집합 반환
//        System.out.println("integerSet.removeAll(List.of(3, 4)) => " + integerSet.removeAll(List.of(3, 4)));
//        System.out.println(integerSet);
//        System.out.println();

        // 컬렉션 원소 삭제
//        System.out.println("integerSet.remove(5) = " + integerSet.remove(5)); // IndexOutOfBoundsException
//        System.out.println("integerSet.remove(5) = " + integerSet.remove(-1)); // IndexOutOfBoundsException
//        System.out.println("integerSet.remove(5) = " + integerSet.remove(20)); // IndexOutOfBoundsException


        // 값으로 원소 삭제
//        System.out.println("integerSet.remove(Integer.valueOf(5)) = " + integerSet.remove(Integer.valueOf(5)));
//        System.out.println(integerSet);
//        System.out.println();
//
        // 컬렉션 clear
//        integerSet.clear();
//        System.out.println(integerSet);
//        System.out.println("integerSet.size() => " + integerSet.size());
//        System.out.println();

        // 컬렉션 비어있는지 확인
        System.out.println("integerSet.isEmpty() = " + integerSet.isEmpty());
        System.out.println();

        /////////////////////////////////////////////////////////////////////////
        // List (컬렉션) -> Array (객체 배열)
        List<String> stringList = new ArrayList<>();
        for (int i = 'a'; i <= 'z'; i++) {
            stringList.add(Character.toString(i));
        }
        System.out.println("stringList = " + stringList);

        String[] stringArray = stringList.toArray(new String[stringList.size()]);
        System.out.println("stringArray = " + Arrays.toString(stringArray));


        // Array (객체 배열) -> List (컬렉션)
        List<String> stringList1 = new ArrayList<>(Arrays.asList(stringArray));
        System.out.println("stringList1 = " + stringList1);

    }
}
