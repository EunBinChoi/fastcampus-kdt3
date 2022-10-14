package me.day14.practice.practice03;


import java.util.ArrayList;
import java.util.List;

public class Main {
    private static List<Student> studentList = new ArrayList<>();
    public static void main(String[] args) {

        studentList.add(new Student("20212222", "이순신", 85)); // 입학연도: 2021 + 들어간 순서: 1
        studentList.add(new Student("20211111", "자바킹", 100)); // 입학연도: 2021 + 들어간 순서: 2
        studentList.add(new Student("20213333", "이제이", 50)); // 입학연도: 2021 + 들어간 순서: 3
        studentList.add(new Student("20171234", "이텔리", 80)); // 입학연도: 2017 + 들어간 순서: 4
        studentList.add(new Student("20045555", "이초잉", 70)); // 입학연도: 2004 + 들어간 순서: 5
    }
    public static List<Student> upper(int score) {
        // TODO: 실습 3번 구현
        return null;
    }
    public static List<Student> lower(int score) {
        // TODO: 실습 3번 구현
        return null;
    }
    public static double average() {
        // TODO: 실습 3번 구현
        return 0.0;
    }
}
