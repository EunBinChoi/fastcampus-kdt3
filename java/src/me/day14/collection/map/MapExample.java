package me.day14.collection.map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MapExample {
    public static void main(String[] args) {
        // Map은 인터페이스이기 때문에 객체 생성이나 추가, 삭제, 수정 연산 불가능 (UnsupportedOperationException)
        // Map은 인덱스가 없기 떄문에 인덱스가 필요한 메소드 호출 불가

//        Map<Integer, String> map = new Map<>(); // 불가능

        Map<Integer, String> streamMap = Stream.of(new Object[][] {
                { 1, "Java" },
                { 2, "JSP" },
                { 3, "Servlet" },
                { 4, "Spring" },
        }).collect(Collectors.toMap(data -> (Integer) data[0], data -> (String) data[1]));
        System.out.println("streamMap = " + streamMap);

        Map<String, String> streamMap2 = Stream.of(new String[][] {
                { "a", "Java" },
                { "b", "JSP" },
                { "c", "Servlet" },
                { "d", "Spring" },
        }).collect(Collectors.toMap(data -> data[0], data -> data[1]));
        System.out.println("streamMap2 = " + streamMap2);
        System.out.println();

        Map<Integer, String> map = Map.of(1, "a", 2, "b", 3, "c", 4, "d", 5, "e");

        // 원소 추가 => put()
        // 키 저장 순서가 유지되지 않을 수 있음
//        for (int i = 1; i <= 10 ; i++) {
//            map.put(i, Character.toString((i-1) + 'a'));
//        }
//        System.out.println("map = " + map);
//        System.out.println("map.size() = " + map.size());
//        System.out.println();



        // 원소 접근 (키를 통해 접근)
        for (int key = 1; key <= 5; key++) {
            System.out.println("map.get(key) = " + map.get(key));
        }
        System.out.println();

        // 원소 수정 (키를 접근해서 다른 값을 넣어주면 수정) => put()
//        for (int key = 1; key <= 5; key++) {
//            map.put(key, map.get(key).repeat(3));
//        }
//        System.out.println("map = " + map);
//        System.out.println("map.size() = " + map.size());
//        System.out.println();

        // 원소 수정 => replace()
//        map.replace(-1, "a"); // -1과 같은 키는 없기 때문에 아무런 영향이 없음
//        System.out.println("map = " + map);
//        map.replace(1, "abcde!@@");
//        System.out.println("map = " + map);
//        map.replace(1, "abcde!@@", "abcde");
//        System.out.println("map = " + map);
//        System.out.println();

        // putAll()
//        Map subMap = Map.of(3, "$$", 4, "!!", 100, "@@");
//        map.putAll(subMap);
//        System.out.println("map = " + map);
//        System.out.println("map.size() = " + map.size());
//        System.out.println();
//

        // Map은 키 값이 인덱스를 대신하기 때문에 인덱스 개념이 없음 (인덱스가 없으므로 인덱스를 통해 원소를 검색하는 함수 없음)
        // Map 내부 반복하려면 반복자를 통해 반복함
        Iterator<Integer> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            System.out.println("key => " + i + ", value => " + map.get(i));
        }
        System.out.println();

        // 원소 반복하기
        for (Map.Entry<Integer, String> entry: map.entrySet())
        {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println( "key => " + key + ", value => " + value);
        }
        // value 값들만 보기
        System.out.println("map.values() = " + map.values());

        // 원소 유무 확인
        System.out.println("map = " + map);
        System.out.println("map.containsKey(100) = " + map.containsKey(100));
        System.out.println("map.containsValue(\"aaa\") = " + map.containsValue("aaa"));
        System.out.println();

        // 원소 삭제
//        map.remove(1);
//        map.remove(2);
//        map.remove(null);
//        System.out.println("map = " + map);
//        System.out.println("map.size() = " + map.size());
//        System.out.println();

//        map.clear();
//        System.out.println("map = " + map);
//        System.out.println("map.size() = " + map.size());
//        System.out.println();

        System.out.println("map.isEmpty() = " + map.isEmpty());
        System.out.println();

        //////////////////////////////////////////////////////////////////////////
        // Map (컬렉션) -> Array (객체 배열)
        Map<Integer, String> hashMap1 = new HashMap<>();
        for (int i = 1; i <= 10 ; i++) {
            hashMap1.put(i, Character.toString((i-1) + 'a'));
        }
        System.out.println("hashMap1 = " + hashMap1);

        Integer[] keys = hashMap1.keySet().toArray(new Integer[0]);
        String[] values = hashMap1.values().toArray(new String[0]);
        Object[] objects = hashMap1.entrySet().toArray();
        Map.Entry<Integer, String>[] entries
                = (Map.Entry<Integer, String>[]) hashMap1.entrySet().toArray(new Map.Entry[hashMap1.size()]);
        System.out.println("keys   = " + Arrays.toString(keys));
        System.out.println("values = " + Arrays.toString(values));
        System.out.println("objects = " + Arrays.toString(objects));
        System.out.println("entries = " + Arrays.toString(entries));
        System.out.println();

        Map<Integer, String> hashMap2 = new HashMap<>(Map.ofEntries(entries));
        System.out.println("hashMap2 = " + hashMap2);


    }
}
