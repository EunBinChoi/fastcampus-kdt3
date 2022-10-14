package me.day14.practice.practice02;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        System.out.println("===============================================================================");
        System.out.println("\t\t\t\t우선순위 큐");
        System.out.println("===============================================================================");
        // 우선순위가 존재하는 Queue (힙을 통해 구현)
        PriorityQueue<Student> priorityQueue = new PriorityQueue<>();


        // PriorityQueue Queue에 원소 추가
        priorityQueue.offer(new Student("20212222", "이순신", 85)); // 입학연도: 2021 + 들어간 순서: 1
        priorityQueue.offer(new Student("20211111", "자바킹", 100)); // 입학연도: 2021 + 들어간 순서: 2
        priorityQueue.offer(new Student("20213333", "이제이", 50)); // 입학연도: 2021 + 들어간 순서: 3
        priorityQueue.offer(new Student("20171234", "이텔리", 80)); // 입학연도: 2017 + 들어간 순서: 4
        priorityQueue.offer(new Student("20045555", "이초잉", 70)); // 입학연도: 2004 + 들어간 순서: 5


        while (!priorityQueue.isEmpty()) {
            Student pollStudent = priorityQueue.poll();
            System.out.println("pollStudent = " + pollStudent);
            System.out.println("priorityQueue = " + priorityQueue);
            System.out.println("priorityQueue.size() = " + priorityQueue.size());
            System.out.println();
        }
        System.out.println();
    }
}
