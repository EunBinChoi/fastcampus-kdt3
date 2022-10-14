package me.day14.collection.map.hashmap;

import java.util.*;

public class HashMapExample {
    public static void main(String[] args) {
        // Set - 키가 hashCode()로 정의
        // Map - 원하는 값으로 키 지정 가능
        //       키와 값에 null을 허용
        Map<Integer, String> hashMap = new HashMap<>();

        // 원소 추가 => put()
        // 키 저장 순서가 유지되지 않을 수 있음
        for (int i = 1; i <= 10 ; i++) {
            if (!hashMap.containsKey(i)) {
                hashMap.put(i, Character.toString((i - 1) + 'a'));
            }
        }
        System.out.println("hashMap = " + hashMap);
        System.out.println("hashMap.size() = " + hashMap.size());
        System.out.println();

        // null도 추가 가능
        hashMap.put(null, "something");
        System.out.println("hashMap = " + hashMap);
        System.out.println("hashMap.size() = " + hashMap.size());
        System.out.println();


        // 원소 접근 (키를 통해 접근)
        for (int key = 1; key <= 10; key++) {
            if (hashMap.containsKey(key)) {
                System.out.println("hashMap.get(key) = " + hashMap.get(key));
            }
        }
        System.out.println();

        // 저장되지 않은 원소 접근
        System.out.println("hashMap.get(100) = " + hashMap.get(100)); // null

        // null이 키로 저장되어있기 때문에 통해 접근도 가능
        System.out.println("hashMap.get(null) = " + hashMap.get(null));
        System.out.println();


        // 원소 수정 (키를 접근해서 다른 값을 넣어주면 수정) => put()
        for (int key = 1; key <= 10; key++) {
            if (hashMap.containsKey(key)) {
                hashMap.put(key, hashMap.get(key).repeat(3));
            }
        }
        System.out.println("hashMap = " + hashMap);
        System.out.println("hashMap.size() = " + hashMap.size());
        System.out.println();

        ////////////////////////////////////////////////////////
        // 원소 수정 => replace()
        hashMap.replace(-1, "a"); // -1과 같은 키는 없기 때문에 아무런 영향이 없음
        System.out.println("hashMap = " + hashMap);
        hashMap.replace(1, "abcde!@@");
        System.out.println("hashMap = " + hashMap);
        hashMap.replace(1, "abcde!@@", "abcde");
        System.out.println("hashMap = " + hashMap);
        System.out.println();

        // putAll()
        Map map = Map.of(3, "$$", 4, "!!", 100, "@@");
        hashMap.putAll(map);
        System.out.println("hashMap = " + hashMap);
        System.out.println("hashMap.size() = " + hashMap.size());
        System.out.println();


        // Map은 키 값이 인덱스를 대신하기 때문에 인덱스 개념이 없음 (인덱스가 없으므로 인덱스를 통해 원소를 검색하는 함수 없음)
        // Map 내부 반복하려면 반복자를 통해 반복함
        Iterator<Integer> iterator = hashMap.keySet().iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            System.out.println("key => " + i + ", value => " + hashMap.get(i));
        }
        System.out.println();

        // 원소 반복하기
        for (Map.Entry<Integer, String> entry: hashMap.entrySet()) {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println( "key => " + key + ", value => " + value);
        }
        // key 값들만 보기
        System.out.println("hashMap.keySet() = " + hashMap.keySet());
        // value 값들만 보기
        System.out.println("hashMap.values() = " + hashMap.values());

        // 원소 유무 확인
        System.out.println("hashMap = " + hashMap);
        System.out.println("hashMap.containsKey(100) = " + hashMap.containsKey(100));
        System.out.println("hashMap.containsValue(\"aaa\") = " + hashMap.containsValue("aaa"));
        System.out.println();

        // 원소 삭제
        hashMap.remove(1);
        hashMap.remove(2);
        hashMap.remove(null);
        System.out.println("hashMap = " + hashMap);
        System.out.println("hashMap.size() = " + hashMap.size());
        System.out.println();
        
        hashMap.clear();
        System.out.println("hashMap = " + hashMap);
        System.out.println("hashMap.size() = " + hashMap.size());
        System.out.println();

        System.out.println("hashMap.isEmpty() = " + hashMap.isEmpty());
        System.out.println();

        //////////////////////////////////////////////////////////////////////////
        // Map (컬렉션) -> Array (객체 배열)
        Map<Integer, String> hashMap1 = new HashMap<>();
        for (int i = 1; i <= 10 ; i++) {
            hashMap1.put(i, Character.toString((i-1) + 'a'));
        }
        System.out.println("hashMap1 = " + hashMap1);

        Integer[] keys = hashMap1.keySet().toArray(new Integer[hashMap1.size()]);
        String[] values = hashMap1.values().toArray(new String[hashMap1.size()]);
        Object[] objects = hashMap1.entrySet().toArray();
        Map.Entry<Integer, String>[] entries = (Map.Entry<Integer, String>[]) hashMap1.entrySet().toArray(new Map.Entry[hashMap1.size()]);
        System.out.println("keys   = " + Arrays.toString(keys));
        System.out.println("values = " + Arrays.toString(values));
        System.out.println("objects = " + Arrays.toString(objects));
        System.out.println("entries = " + Arrays.toString(entries));
        System.out.println();

        Map<Integer, String> hashMap2 = new HashMap<>(Map.ofEntries(entries));
        System.out.println("hashMap2 = " + hashMap2);
    }
}
