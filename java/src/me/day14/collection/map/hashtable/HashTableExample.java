package me.day14.collection.map.hashtable;

import java.util.*;

public class HashTableExample {
    public static void main(String[] args) {
        // Set - 키가 hashCode()로 정의
        // Map - 원하는 값으로 키 지정 가능
        //       키와 값에 null을 허용
        Map<Integer, String> hashTable = new Hashtable<>();

        // 원소 추가 => put()
        // 키 저장 순서가 유지되지 않을 수 있음
        for (int i = 1; i <= 10 ; i++) {
            if (!hashTable.containsKey(i)) {
                hashTable.put(i, Character.toString((i - 1) + 'a'));
            }
        }
        System.out.println("hashTable = " + hashTable);
        System.out.println("hashTable.size() = " + hashTable.size());
        System.out.println();

        // null도 추가 불가
//        hashTable.put(null, "something");
//        System.out.println("hashTable = " + hashTable);
//        System.out.println("hashTable.size() = " + hashTable.size());
//        System.out.println();


        // 원소 접근 (키를 통해 접근)
        for (int key = 1; key <= 10; key++) {
            if (hashTable.containsKey(key)) {
                System.out.println("hashTable.get(key) = " + hashTable.get(key));
            }
        }
        System.out.println();


        // 원소 수정 (키를 접근해서 다른 값을 넣어주면 수정) => put()
        for (int key = 1; key <= 10; key++) {
            if (hashTable.containsKey(key)) {
                hashTable.put(key, hashTable.get(key).repeat(3));
            }
        }
        System.out.println("hashTable = " + hashTable);
        System.out.println("hashTable.size() = " + hashTable.size());
        System.out.println();

        // 원소 수정 => replace()
        hashTable.replace(-1, "a"); // -1과 같은 키는 없기 때문에 아무런 영향이 없음
        System.out.println("hashTable = " + hashTable);
        hashTable.replace(1, "abcde!@@");
        System.out.println("hashTable = " + hashTable);
        hashTable.replace(1, "abcde!@@", "abcde");
        System.out.println("hashTable = " + hashTable);
        System.out.println();

        // putAll()
        Map map = Map.of(3, "$$", 4, "!!", 100, "@@");
        hashTable.putAll(map);
        System.out.println("hashTable = " + hashTable);
        System.out.println("hashTable.size() = " + hashTable.size());
        System.out.println();


        // Map은 키 값이 인덱스를 대신하기 때문에 인덱스 개념이 없음 (인덱스가 없으므로 인덱스를 통해 원소를 검색하는 함수 없음)
        // Map 내부 반복하려면 반복자를 통해 반복함
        Iterator<Integer> iterator = hashTable.keySet().iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            System.out.println("key => " + i + ", value => " + hashTable.get(i));
        }
        System.out.println();

        // 원소 반복하기
        for (Map.Entry<Integer, String> entry: hashTable.entrySet())
        {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println( "key => " + key + ", value => " + value);
        }
        // value 값들만 보기
        System.out.println("hashTable.values() = " + hashTable.values());

        // 원소 유무 확인
        System.out.println("hashTable = " + hashTable);
        System.out.println("hashTable.containsKey(100) = " + hashTable.containsKey(100));
        System.out.println("hashTable.containsValue(\"aaa\") = " + hashTable.containsValue("aaa"));
        System.out.println();

        // 원소 삭제
        hashTable.remove(1);
        hashTable.remove(2);
        System.out.println("hashTable = " + hashTable);
        System.out.println("hashTable.size() = " + hashTable.size());
        System.out.println();
        
        hashTable.clear();
        System.out.println("hashTable = " + hashTable);
        System.out.println("hashTable.size() = " + hashTable.size());
        System.out.println();

        System.out.println("hashTable.isEmpty() = " + hashTable.isEmpty());
        System.out.println();

        //////////////////////////////////////////////////////////////////////////
        // Map (컬렉션) -> Array (객체 배열)
        Map<Integer, String> hashTable1 = new Hashtable<>();
        for (int i = 1; i <= 10 ; i++) {
            hashTable1.put(i, Character.toString((i-1) + 'a'));
        }
        System.out.println("hashTable1 = " + hashTable1);

        Integer[] keys = hashTable1.keySet().toArray(new Integer[0]);
        String[] values = hashTable1.values().toArray(new String[0]);
        Object[] objects = hashTable1.entrySet().toArray();
        Map.Entry<Integer, String>[] entries 
                = (Map.Entry<Integer, String>[]) hashTable1.entrySet().toArray(new Map.Entry[hashTable1.size()]);
        System.out.println("keys   = " + Arrays.toString(keys));
        System.out.println("values = " + Arrays.toString(values));
        System.out.println("objects = " + Arrays.toString(objects));
        System.out.println("entries = " + Arrays.toString(entries));
        System.out.println();

        Map<Integer, String> hashTable2 = new Hashtable<>(Map.ofEntries(entries));
        System.out.println("hashTable2 = " + hashTable2);

    }
}
