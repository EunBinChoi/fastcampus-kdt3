package me.day14.collection.map.linkedhashmap;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Iterator;
import java.util.Map;

public class LinkedHashMapExample {
    public static void main(String[] args) {
        // Set - 키가 hashCode()로 정의
        // Map - 원하는 값으로 키 지정 가능
        //       키와 값에 null을 허용
        Map<Integer, String> linkedHashMap = new LinkedHashMap<>();

        // 원소 추가 => put()
        // 키 저장 순서가 유지
        for (int i = 1; i <= 10 ; i++) {
            if (!linkedHashMap.containsKey(i)) {
                linkedHashMap.put(i, Character.toString((i - 1) + 'a'));
            }
        }
        System.out.println("linkedHashMap = " + linkedHashMap);
        System.out.println("linkedHashMap.size() = " + linkedHashMap.size());
        System.out.println();

        // null도 추가 가능
        linkedHashMap.put(null, "something");
        System.out.println("linkedHashMap = " + linkedHashMap);
        System.out.println("linkedHashMap.size() = " + linkedHashMap.size());
        System.out.println();


        // 원소 접근 (키를 통해 접근)
        for (int key = 1; key <= 10; key++) {
            if (linkedHashMap.containsKey(key)) {
                System.out.println("linkedHashMap.get(key) = " + linkedHashMap.get(key));
            }
        }
        System.out.println();

        // null이 키로 저장되어있기 때문에 통해 접근도 가능
        System.out.println("linkedHashMap.get(null) = " + linkedHashMap.get(null));
        System.out.println();


        // 원소 수정 (키를 접근해서 다른 값을 넣어주면 수정) => put()
        for (int key = 1; key <= 10; key++) {
            if (linkedHashMap.containsKey(key)) {
                linkedHashMap.put(key, linkedHashMap.get(key).repeat(3));
            }
        }
        System.out.println("linkedHashMap = " + linkedHashMap);
        System.out.println("linkedHashMap.size() = " + linkedHashMap.size());
        System.out.println();

        // 원소 수정 => replace()
        linkedHashMap.replace(-1, "a"); // -1과 같은 키는 없기 때문에 아무런 영향이 없음
        System.out.println("linkedHashMap = " + linkedHashMap);
        linkedHashMap.replace(1, "abcde!@@");
        System.out.println("linkedHashMap = " + linkedHashMap);
        linkedHashMap.replace(1, "abcde!@@", "abcde");
        System.out.println("linkedHashMap = " + linkedHashMap);
        System.out.println();

        // putAll()
        Map map = Map.of(3, "$$", 4, "!!", 100, "@@");
        linkedHashMap.putAll(map);
        System.out.println("linkedHashMap = " + linkedHashMap);
        System.out.println("linkedHashMap.size() = " + linkedHashMap.size());
        System.out.println();


        // Map은 키 값이 인덱스를 대신하기 때문에 인덱스 개념이 없음 (인덱스가 없으므로 인덱스를 통해 원소를 검색하는 함수 없음)
        // Map 내부 반복하려면 반복자를 통해 반복함
        Iterator<Integer> iterator = linkedHashMap.keySet().iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            System.out.println("key => " + i + ", value => " + linkedHashMap.get(i));
        }
        System.out.println();

        // 원소 반복하기
        for (Map.Entry<Integer, String> entry: linkedHashMap.entrySet())
        {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println( "key => " + key + ", value => " + value);
        }
        // value 값들만 보기
        System.out.println("linkedHashMap.values() = " + linkedHashMap.values());

        // 원소 유무 확인
        System.out.println("linkedHashMap = " + linkedHashMap);
        System.out.println("linkedHashMap.containsKey(100) = " + linkedHashMap.containsKey(100));
        System.out.println("linkedHashMap.containsValue(\"aaa\") = " + linkedHashMap.containsValue("aaa"));
        System.out.println();

        // 원소 삭제
        linkedHashMap.remove(1);
        linkedHashMap.remove(2);
        linkedHashMap.remove(null);
        System.out.println("linkedHashMap = " + linkedHashMap);
        System.out.println("linkedHashMap.size() = " + linkedHashMap.size());
        System.out.println();
        
        linkedHashMap.clear();
        System.out.println("linkedHashMap = " + linkedHashMap);
        System.out.println("linkedHashMap.size() = " + linkedHashMap.size());
        System.out.println();

        System.out.println("linkedHashMap.isEmpty() = " + linkedHashMap.isEmpty());
        System.out.println();

        //////////////////////////////////////////////////////////////////////////
        // Map (컬렉션) -> Array (객체 배열)
        Map<Integer, String> linkedHashMap1 = new LinkedHashMap<>();
        for (int i = 1; i <= 10 ; i++) {
            linkedHashMap1.put(i, Character.toString((i-1) + 'a'));
        }
        System.out.println("linkedHashMap1 = " + linkedHashMap1);

        Integer[] keys = linkedHashMap1.keySet().toArray(new Integer[0]);
        String[] values = linkedHashMap1.values().toArray(new String[0]);
        Object[] objects = linkedHashMap1.entrySet().toArray();
        Map.Entry<Integer, String>[] entries 
                = (Map.Entry<Integer, String>[]) linkedHashMap1.entrySet().toArray(new Map.Entry[linkedHashMap1.size()]);
        System.out.println("keys   = " + Arrays.toString(keys));
        System.out.println("values = " + Arrays.toString(values));
        System.out.println("objects = " + Arrays.toString(objects));
        System.out.println("entries = " + Arrays.toString(entries));
        System.out.println();

        Map<Integer, String> linkedHashMap2 = new LinkedHashMap<>(Map.ofEntries(entries));
        System.out.println("linkedHashMap2 = " + linkedHashMap2);


    }
}
