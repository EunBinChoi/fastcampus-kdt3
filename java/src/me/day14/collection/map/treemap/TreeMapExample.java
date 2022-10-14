package me.day14.collection.map.treemap;

import me.day14.collection.map.treemap.key.Key;
import me.day14.collection.map.treemap.value.Pen;

import java.util.*;

public class TreeMapExample {
    public static void main(String[] args) {
        // Set - 키가 hashCode()로 정의
        // Map - 원하는 값으로 키 지정 가능
        //       키와 값에 null을 허용
        Map<Integer, String> treeMap = new TreeMap<>();

        // 원소 추가 => put()
        // 원소를 추가할 때 이진 탐색 트리에 저장하여 키 (**) 크기 순서가 유지될 수 있도록 만듦 (정렬됨)
        // 이진 탐색 트리 중 레드-블랙 트리로 구현되어있음 (개략적으로 balanced tree) (https://code-lab1.tistory.com/62)
        for (int i = 10; i >= 1 ; i--) {
            if (!treeMap.containsKey(i)) {
                treeMap.put(i, Character.toString((i - 1) + 'a'));
            }
        }
        System.out.println("treeMap = " + treeMap);
        System.out.println("treeMap.size() = " + treeMap.size());
        System.out.println();

        // null도 추가 불가 (크기가 없음)
//        treeMap.put(null, "something");
//        System.out.println("treeMap = " + treeMap);
//        System.out.println("treeMap.size() = " + treeMap.size());
//        System.out.println();


        // 원소 접근 (키를 통해 접근)
        for (int key = 1; key <= 10; key++) {
            if (treeMap.containsKey(key)) {
                System.out.println("treeMap.get(key) = " + treeMap.get(key));
            }
        }
        System.out.println();


        // 원소 수정 (키를 접근해서 다른 값을 넣어주면 수정) => put()
        for (int key = 1; key <= 10; key++) {
            if (treeMap.containsKey(key)) {
                treeMap.put(key, treeMap.get(key).repeat(3));
            }
        }
        System.out.println("treeMap = " + treeMap);
        System.out.println("treeMap.size() = " + treeMap.size());
        System.out.println();

        // 원소 수정 => replace()
        treeMap.replace(-1, "a"); // -1과 같은 키는 없기 때문에 아무런 영향이 없음
        System.out.println("treeMap = " + treeMap);
        treeMap.replace(1, "abcde!@@");
        System.out.println("treeMap = " + treeMap);
        treeMap.replace(1, "abcde!@@", "abcde");
        System.out.println("treeMap = " + treeMap);
        System.out.println();

        // putAll()
        Map map = Map.of(3, "$$", 4, "!!", 100, "@@");
        treeMap.putAll(map);
        System.out.println("treeMap = " + treeMap);
        System.out.println("treeMap.size() = " + treeMap.size());
        System.out.println();


        // Map은 키 값이 인덱스를 대신하기 때문에 인덱스 개념이 없음 (인덱스가 없으므로 인덱스를 통해 원소를 검색하는 함수 없음)
        // Map 내부 반복하려면 반복자를 통해 반복함
        Iterator<Integer> iterator = treeMap.keySet().iterator();
        while (iterator.hasNext()) {
            Integer i = iterator.next();
            System.out.println("key => " + i + ", value => " + treeMap.get(i));
        }
        System.out.println();

        // 원소 반복하기
        for (Map.Entry<Integer, String> entry: treeMap.entrySet())
        {
            Integer key = entry.getKey();
            String value = entry.getValue();
            System.out.println( "key => " + key + ", value => " + value);
        }
        // value 값들만 보기
        System.out.println("treeMap.values() = " + treeMap.values());

        // 원소 유무 확인
        System.out.println("treeMap = " + treeMap);
        System.out.println("treeMap.containsKey(100) = " + treeMap.containsKey(100));
        System.out.println("treeMap.containsValue(\"aaa\") = " + treeMap.containsValue("aaa"));
        System.out.println();

        // 원소 삭제
        treeMap.remove(1);
        treeMap.remove(2);
        System.out.println("treeMap = " + treeMap);
        System.out.println("treeMap.size() = " + treeMap.size());
        System.out.println();
        
        treeMap.clear();
        System.out.println("treeMap = " + treeMap);
        System.out.println("treeMap.size() = " + treeMap.size());
        System.out.println();

        System.out.println("treeMap.isEmpty() = " + treeMap.isEmpty());
        System.out.println();

        //////////////////////////////////////////////////////////////////////////
        // TreeMap의 원소가 객체인 경우
        Map<Key, Pen> penMap = new TreeMap<>();


        // 원소 추가
        // 원소를 추가할 때 이진 탐색 트리에 저장하여 객체 크기 순서가 유지될 수 있도록 만듦 (정렬됨)
        // 이진 탐색 트리 중 레드-블랙 트리로 구현되어있음 (개략적으로 balanced tree) (https://code-lab1.tistory.com/62)
        // Comparable 인터페이스를 재정의하지 않으면 ClassCastException 발생 가능
        penMap.put(new Key("0001", "QS8879921031"), new Pen("0001", "파카", "red"));
        penMap.put(new Key("0002", "NS1230910000"), new Pen("0002", "빅", "black"));
        penMap.put(new Key("0003", "KS0000123123"), new Pen("0003", "파카", "blue"));
        penMap.put(new Key("0004", "SS1123124123"), new Pen("0004", "제브라", "red"));

        System.out.println("penMap = " + penMap);
        System.out.println("penMap.size() = " + penMap.size());
        System.out.println();

        Iterator<Integer> iterator1 = treeMap.keySet().iterator();
        while (iterator1.hasNext()) {
            Integer i = iterator1.next();
            System.out.println("key => " + i + ", value => " + treeMap.get(i));
        }
        System.out.println();


        //////////////////////////////////////////////////////////////////////////
        // Map (컬렉션) -> Array (객체 배열)
        Map<Integer, String> treeMap1 = new TreeMap<>();
        for (int i = 1; i <= 10 ; i++) {
            treeMap1.put(i, Character.toString((i-1) + 'a'));
        }
        System.out.println("treeMap1 = " + treeMap1);

        Integer[] keys = treeMap1.keySet().toArray(new Integer[0]);
        String[] values = treeMap1.values().toArray(new String[0]);
        Object[] objects = treeMap1.entrySet().toArray();
        Map.Entry<Integer, String>[] entries 
                = (Map.Entry<Integer, String>[]) treeMap1.entrySet().toArray(new Map.Entry[treeMap1.size()]);
        System.out.println("keys   = " + Arrays.toString(keys));
        System.out.println("values = " + Arrays.toString(values));
        System.out.println("objects = " + Arrays.toString(objects));
        System.out.println("entries = " + Arrays.toString(entries));
        System.out.println();

        Map<Integer, String> treeMap2 = new TreeMap<>(Map.ofEntries(entries));
        System.out.println("treeMap2 = " + treeMap2);


    }
}
