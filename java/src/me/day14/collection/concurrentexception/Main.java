package me.day14.collection.concurrentexception;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<String>();
        stringList.add("a");
        stringList.add("b");
        stringList.add("c");
        stringList.add("d");

        //error(stringList);
        solution0(stringList);
    }
    public static void error(List<String> stringList) {
        // 순회 중 삭제되는 경우
        // 순회 중 삭제되면 처음 순회하려고 했던 배열의 사이즈가 달라지면서 인덱스가 맞지 않아 생기는 오류
        System.out.println("stringList = " + stringList);
        for( String str : stringList ) {
            if ( str.equals("a") ) {
                stringList.remove(str); // modCount++ (modificationCount++)
            }
        }
        System.out.println("stringList = " + stringList);
    }
    public static void solution0(List<String> stringList) {
        // try-catch 작성
        // 스레드가 컬렉션을 반복하는 동안 컬렉션이 수정되서 나는 오류
        // 일반적으로 허용하지 않음
        // Iterator에서 해당 예외가 throw 되도록 되어있음
        System.out.println("stringList = " + stringList);
        try {
            for( String str : stringList ) {
                if ( str.equals("a") ) {
                    stringList.remove(str);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("stringList = " + stringList);
    }
    public static void solution1(List<String> stringList) {
        // remove 하고 break 로 빠져나가기
        // 1개의 element가 아닌 여러개의 element를 remove 하는 경우 한계가 존재
        System.out.println("stringList = " + stringList);
        for( String str : stringList ) {
            if ( str.equals("a") ) {
                stringList.remove(str);
                break;
            }
        }
        System.out.println("stringList = " + stringList);
    }
    public static void solution2(List<String> stringList) {
        // iterator를 통해 List 자체가 아닌 iterator를 제거
        // 멀티 쓰레드 환경에서는 오류 발생할 수도 있음
        System.out.println("stringList = " + stringList);
        Iterator<String> iterator = stringList.iterator();
        while(iterator.hasNext()) {
            String str = iterator.next(); // 현재 요소를 기본 컬렉션에서 제거 (next() 후에 호출)
            if ( str.equals("a") ) {
                iterator.remove();
            }
        }
        System.out.println("stringList = " + stringList);
    }
    public static void solution3(List<String> stringList) {
        List<String> copy = new CopyOnWriteArrayList<>(stringList);
        // ArrayList 요소 복사해서 전달
        // 내부를 변경하는 작업은 항상 복사본을 만들어서 수행하도록 구현
        // 내부의 배열은 절대 변경할 수 없음 (순회할 때 락 걸리지 않아 속도가 빠름)
        // 멀티 스레드 환경에서 안전
        // 대부분의 스레드는 주로 List를 읽고 소수의 스레드나 메소드내에서만 해당 List를 수정하는 경우에 유리

        // 모든 쓰기 동작 (add, set, remove, etc)시 원본배열에 있는 요소를 복사 (Copy)하여
        // 새로운 임시배열을 만들고 이 임시배열에 쓰기 동작을 수행 후 원본배열을 갱신함
        // 이 덕분에 읽기 (get, etc) 동작은 lock에서 자유로울 수 있게 됨
        // 읽기 Performance에서 CopyOnWriteArrayList 우월함
        System.out.println("copy = " + copy);
        for( String str : copy ) {
            if ( str.equals("a") ) {
                copy.remove(str);
            }
        }
        System.out.println("copy = " + copy);
    }

}
