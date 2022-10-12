package me.day14.collection.list.arraylist;

import java.util.*;

public class ArrayListExample {
    public static void main(String[] args) {
        List<Integer> arrayList = new ArrayList<>(2); // 다형성
        System.out.println("arrayList.size() => " + arrayList.size());
        System.out.println();

        // 원소 추가
        for (int i = 1; i <= 10 ; i++) {
            arrayList.add(i);
        }
        System.out.println(arrayList);
        System.out.println("arrayList.size() => " + arrayList.size());
        System.out.println();

        // 원소 접근
        for (int i = 0; i < arrayList.size(); i++) {
            System.out.println("arrayList.get(i) = " + arrayList.get(i));;
        }
        System.out.println();

        // 원소 수정
        arrayList.set(1, 200);

        // 원하는 인덱스에 원소 추가
        arrayList.add(2, 100);
//        arrayList.add(-1, 100); // IndexOutOfBoundsException
//        arrayList.add(20, 100); // IndexOutOfBoundsException

//        arrayList.add(2, "abc"); // compile error. type mismatch.
        System.out.println(arrayList);
        System.out.println("arrayList.size() => " + arrayList.size());
        System.out.println();

        // 컬렉션 일부 반환
        List<Integer> subList = arrayList.subList(1, 5);
        System.out.println("subList = " + subList);

        // 반환된 컬렉션 일부를 모두 추가
        arrayList.addAll(subList); // 마지막에 addAll
        System.out.println(arrayList);
        System.out.println("arrayList.size() => " + arrayList.size());
        System.out.println();

        // 컬렉션 정렬
        arrayList.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        });
        arrayList.sort(null); // new ArrayList<Integer>()
        System.out.println("sort() => " + arrayList);
        Collections.sort(arrayList, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(o1, o2);
            }
        }); // Comparable (natural ordering)
        System.out.println("sort() => " + arrayList);
        System.out.println(arrayList);
        System.out.println();

        // 일부 원소를 찾아 첫번째로 만난 원소의 인덱스 반환
        System.out.println("arrayList.indexOf(100) => " + arrayList.indexOf(100)); // 앞에서 부터 찾음
        System.out.println("arrayList.lastIndexOf(100) => " + arrayList.lastIndexOf(100)); // 뒤에서 부터 찾음
        System.out.println(arrayList);
        System.out.println();


        // 일부 원소 포함관계 확인
        System.out.println("arrayList.contains(3) => " + arrayList.contains(3));
        System.out.println(arrayList);
        System.out.println();

        // 일부 컬렉션 포함관계 확인
        System.out.println("arrayList.containsAll(List.of(3, 4, 5, 6, 7)) => " +
                arrayList.containsAll(List.of(3, 4, 5, 6, 7)));
        System.out.println(arrayList);
        System.out.println();

        // 현재 컬렉션과 주어진 컬렉션 사이의 교집합 반환
        System.out.println("arrayList.retainAll(List.of(3, 4, 5, 6, 7)) => "
                + arrayList.retainAll(List.of(3, 4, 5, 6, 7)));
        System.out.println(arrayList);
        System.out.println();

        // 현재 컬렉션과 주어진 컬렉션 사이의 차집합 반환
        System.out.println("arrayList.removeAll(List.of(3, 4)) => " + arrayList.removeAll(List.of(3, 4)));
        System.out.println(arrayList);
        System.out.println();

        // 컬렉션 원소 삭제
//        System.out.println("arrayList.remove(5) = " + arrayList.remove(5)); // IndexOutOfBoundsException
//        System.out.println("arrayList.remove(5) = " + arrayList.remove(-1)); // IndexOutOfBoundsException
//        System.out.println("arrayList.remove(5) = " + arrayList.remove(20)); // IndexOutOfBoundsException

        // 인덱스로 원소 삭제
        System.out.println("arrayList.remove(2) = "
                + arrayList.remove(2));

        // 값으로 원소 삭제
        System.out.println("arrayList.remove(Integer.valueOf(5)) = "
                + arrayList.remove(Integer.valueOf(5)));
//        arrayList.remove(2); // index (remove(int))
//        arrayList.remove(Integer.valueOf(2)); // element (remove(Integer))

        System.out.println(arrayList);
        System.out.println();

        // 컬렉션 clear
        arrayList.clear();
        System.out.println(arrayList);
        System.out.println("arrayList.size() => " + arrayList.size());
        System.out.println();

        // 컬렉션 비어있는지 확인
        System.out.println("arrayList.isEmpty() = " + arrayList.isEmpty());
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
