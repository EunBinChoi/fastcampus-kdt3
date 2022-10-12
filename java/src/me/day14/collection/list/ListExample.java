package me.day14.collection.list;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ListExample {
    public static void main(String[] args) {
        // List는 인터페이스이기 때문에 객체 생성이나 추가, 삭제, 수정 연산 불가능 (UnsupportedOperationException)

        List<Integer> intStreamList = IntStream.range(1, 11).mapToObj(i -> Integer.valueOf(i)).collect(Collectors.toList());
        System.out.println("intStreamList = " + intStreamList);
        System.out.println();

//        List<Integer> list = new List<>(); // 불가능
        List<Integer> list = List.of(1, 2, 3, 4); // interface
        System.out.println("list.size() => " + list.size());
        System.out.println();

        // 원소 추가
//        for (int i = 1; i <= 10 ; i++) {
//            list.add(i);
//        }
//        System.out.println(list);
//        System.out.println("list.size() => " + list.size());
//        System.out.println();

        // 원소 접근
        for (int i = 0; i < list.size(); i++) {
            System.out.println("list.get(i) = " + list.get(i));;
        }
        System.out.println();

        // 원소 수정
//        list.set(1, 200);

        // 원하는 인덱스에 원소 추가
//        list.add(2, 100);
//        list.add(-1, 100); // IndexOutOfBoundsException
//        list.add(20, 100); // IndexOutOfBoundsException

//        list.add(2, "abc"); // compile error. type mismatch.
//        System.out.println(list);
//        System.out.println("list.size() => " + list.size());
//        System.out.println();

        // 컬렉션 일부 반환
        List<Integer> subList = list.subList(1, 2);
        System.out.println("subList = " + subList);

        // 반환된 컬렉션 일부를 모두 추가
//        list.addAll(subList);
//        System.out.println(list);
//        System.out.println("list.size() => " + list.size());
//        System.out.println();

        // 컬렉션 정렬
//        list.sort(new Comparator<Integer>() {
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return Integer.compare(o1, o2);
//            }
//        });
//        System.out.println(list);
//        System.out.println();

        // 일부 원소를 찾아 첫번째로 만난 원소의 인덱스 반환
        System.out.println("list.indexOf(100) => " + list.indexOf(100)); // 앞에서 부터 찾음
        System.out.println("list.lastIndexOf(100) => " + list.lastIndexOf(100)); // 뒤에서 부터 찾음
        System.out.println(list);
        System.out.println();

        // 일부 원소 포함관계 확인
        System.out.println("list.contains(3) => " + list.contains(3));
        System.out.println(list);
        System.out.println();

        // 일부 컬렉션 포함관계 확인
        System.out.println("list.containsAll(List.of(3, 4, 5, 6, 7)) => " + list.containsAll(List.of(3, 4, 5, 6, 7)));
        System.out.println(list);
        System.out.println();

        // 현재 컬렉션과 주어진 컬렉션 사이의 교집합 반환
//        System.out.println("list.retainAll(List.of(3, 4, 5, 6, 7)) => " + list.retainAll(List.of(3, 4, 5, 6, 7)));
//        System.out.println(list);
//        System.out.println();

        // 현재 컬렉션과 주어진 컬렉션 사이의 차집합 반환
//        System.out.println("list.removeAll(List.of(3, 4)) => " + list.removeAll(List.of(3, 4)));
//        System.out.println(list);
//        System.out.println();

        // 컬렉션 원소 삭제
//        System.out.println("list.remove(5) = " + list.remove(5)); // IndexOutOfBoundsException
//        System.out.println("list.remove(5) = " + list.remove(-1)); // IndexOutOfBoundsException
//        System.out.println("list.remove(5) = " + list.remove(20)); // IndexOutOfBoundsException

        // 인덱스로 원소 삭제
//        System.out.println("list.remove(2) = " + list.remove(2));

        // 값으로 원소 삭제
//        System.out.println("list.remove(Integer.valueOf(5)) = " + list.remove(Integer.valueOf(5)));
//        System.out.println(list);
//        System.out.println();

        // 컬렉션 clear
//        list.clear();
//        System.out.println(list);
//        System.out.println("list.size() => " + list.size());
//        System.out.println();

        // 컬렉션 비어있는지 확인
        System.out.println("list.isEmpty() = " + list.isEmpty());
        System.out.println();


    }
}
