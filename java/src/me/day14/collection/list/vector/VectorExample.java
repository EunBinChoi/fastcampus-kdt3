package me.day14.collection.list.vector;

import java.util.*;

public class VectorExample {
    public static void main(String[] args) {
        List<Integer> vector = new Vector<>(); // 다형성
        System.out.println("vector.size() => " + vector.size());
        System.out.println();

        // 원소 추가
        for (int i = 1; i <= 10 ; i++) {
            vector.add(i);
        }
        System.out.println(vector);
        System.out.println("vector.size() => " + vector.size());
        System.out.println();

        // 원소 접근
        for (int i = 0; i < vector.size(); i++) {
            System.out.println("vector.get(i) = " + vector.get(i));;
        }
        System.out.println();

        // 원소 수정
        vector.set(1, 200);

        // 원하는 인덱스에 원소 추가
        vector.add(2, 100);
//        vector.add(-1, 100); // IndexOutOfBoundsException
//        vector.add(20, 100); // IndexOutOfBoundsException

//        vector.add(2, "abc"); // compile error. type mismatch.
        System.out.println(vector);
        System.out.println("vector.size() => " + vector.size());
        System.out.println();

        // 컬렉션 일부 반환
        List<Integer> subList = vector.subList(1, 5);
        System.out.println("subList = " + subList);

        // 반환된 컬렉션 일부를 모두 추가
        vector.addAll(subList);
        System.out.println(vector);
        System.out.println("vector.size() => " + vector.size());
        System.out.println();

        // 컬렉션 정렬
        vector.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });
        System.out.println(vector);
        System.out.println();

        // 일부 원소를 찾아 첫번째로 만난 원소의 인덱스 반환
        System.out.println("vector.indexOf(100) => " + vector.indexOf(100)); // 앞에서 부터 찾음
        System.out.println("vector.lastIndexOf(100) => " + vector.lastIndexOf(100)); // 뒤에서 부터 찾음
        System.out.println(vector);
        System.out.println();


        // 일부 원소 포함관계 확인
        System.out.println("vector.contains(3) => " + vector.contains(3));
        System.out.println(vector);
        System.out.println();

        // 일부 컬렉션 포함관계 확인
        System.out.println("vector.containsAll(List.of(3, 4, 5, 6, 7)) => " + vector.containsAll(List.of(3, 4, 5, 6, 7)));
        System.out.println(vector);
        System.out.println();

        // 현재 컬렉션과 주어진 컬렉션 사이의 교집합 반환
        System.out.println("vector.retainAll(List.of(3, 4, 5, 6, 7)) => " + vector.retainAll(List.of(3, 4, 5, 6, 7)));
        System.out.println(vector);
        System.out.println();

        // 현재 컬렉션과 주어진 컬렉션 사이의 차집합 반환
        System.out.println("vector.removeAll(List.of(3, 4)) => " + vector.removeAll(List.of(3, 4)));
        System.out.println(vector);
        System.out.println();

        // 컬렉션 원소 삭제
//        System.out.println("vector.remove(5) = " + vector.remove(5)); // IndexOutOfBoundsException
//        System.out.println("vector.remove(5) = " + vector.remove(-1)); // IndexOutOfBoundsException
//        System.out.println("vector.remove(5) = " + vector.remove(20)); // IndexOutOfBoundsException

        // 인덱스로 원소 삭제
        System.out.println("vector.remove(2) = " + vector.remove(2));

        // 값으로 원소 삭제
        System.out.println("vector.remove(Integer.valueOf(5)) = " + vector.remove(Integer.valueOf(5)));
        System.out.println(vector);
        System.out.println();

        // 컬렉션 clear
        vector.clear();
        System.out.println(vector);
        System.out.println("vector.size() => " + vector.size());
        System.out.println();

        // 컬렉션 비어있는지 확인
        System.out.println("vector.isEmpty() = " + vector.isEmpty());
        System.out.println();

        /////////////////////////////////////////////////////////////////////////
        // List (컬렉션) -> Array (객체 배열)
        List<String> stringList = new Vector<>();
        for (int i = 'a'; i <= 'z'; i++) {
            stringList.add(Character.toString(i));
        }
        System.out.println("stringList = " + stringList);

        String[] stringArray = stringList.toArray(new String[stringList.size()]);
        System.out.println("stringArray = " + Arrays.toString(stringArray));


        // Array (객체 배열) -> List (컬렉션)
        List<String> stringList1 = new Vector<>(Arrays.asList(stringArray));
        System.out.println("stringList1 = " + stringList1);

    }
}
