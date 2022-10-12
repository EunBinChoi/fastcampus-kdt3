package me.day14.collection.map.benchmark;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Vector;

class MyHashMap<K, V> extends HashMap<K, V> {
    @Override
    public V put(K key, V value) {
        for (int i = 1; i <= 100; i++) {
            System.out.println("[ MyVector ] " +
                    Thread.currentThread().getName() + " : " + i);
        }
        return value;
    }
}

class MyHashtable<K, V> extends Hashtable<K, V> {
    @Override
    public synchronized V put(K key, V value) {
        for (int i = 1; i <= 100; i++) {
            System.out.println("[ MyVector ] " +
                    Thread.currentThread().getName() + " : " + i);
        }
        return value;
    }
}

public class HashMapHashtableExample {
    public static void main(String[] args) {
        MyHashMap<Integer, Integer> myHashMap = new MyHashMap<>();
        MyHashtable<Integer, Integer> myHashtable = new MyHashtable<>();

        Thread thread1 = new Thread("myHashMap-1") {
            @Override
            public void run() {
                myHashMap.put(100, 100);
            }
        };
        Thread thread2 = new Thread("myHashMap-2") {
            @Override
            public void run() {
                myHashMap.put(100, 100);
            }
        };
        Thread thread3 = new Thread("myHashtable-3") {
            @Override
            public void run() {
                myHashtable.put(100, 100);
            }
        };
        Thread thread4 = new Thread("myHashtable-4") {
            @Override
            public void run() {
                myHashtable.put(100, 100);
            }
        };
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
