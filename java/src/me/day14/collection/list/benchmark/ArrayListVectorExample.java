package me.day14.collection.list.benchmark;

import java.util.ArrayList;
import java.util.Vector;

class MyArrayList<E> extends ArrayList<E> {
    @Override
    public boolean add(E e) {
        for (int i = 1; i <= 100; i++) {
            System.out.println("[ MyArrayList ] " +
                    Thread.currentThread().getName() + " : " + i);
        }
        return true;
    }
}

class MyVector<E> extends Vector<E> {
    @Override
    public synchronized boolean add(E e) { // synchronized
        for (int i = 1; i <= 100; i++) {
            System.out.println("[ MyVector ] " +
                    Thread.currentThread().getName() + " : " + i);
        }
        return true;
    }
}

public class ArrayListVectorExample {
    public static void main(String[] args) {
        MyArrayList<Integer> myArrayList = new MyArrayList<>();
        MyVector<Integer> myVector = new MyVector<>();

        Thread thread1 = new Thread("myArrayList-1") {
            @Override
            public void run() {
                myArrayList.add(100);
            }
        };
        Thread thread2 = new Thread("myArrayList-2") {
            @Override
            public void run() {
                myArrayList.add(100);
            }
        };
        Thread thread3 = new Thread("myVector-3") {
            @Override
            public void run() {
                myVector.add(100);
            }
        };
        Thread thread4 = new Thread("myVector-4") {
            @Override
            public void run() {
                myVector.add(100);
            }
        };
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
