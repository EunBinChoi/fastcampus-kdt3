package me.day16.stream.parallel.forkjoin;

import java.util.Arrays;
import java.util.List;

public class MaleStudentExample {
    public static void main(String[] args) {
        List<Student> studentList = Arrays.asList(
                new Student("홍길동", 40, Student.Gender.MALE),
                new Student("이텔리", 40, Student.Gender.FEMALE),
                new Student("김자바", 40, Student.Gender.MALE),
                new Student("홍길순", 40, Student.Gender.FEMALE)
        );
        MaleStudent maleStudent = studentList.stream().parallel()
                .filter(s -> s.getGender() == Student.Gender.MALE)
                .collect(MaleStudent::new, MaleStudent::accumulate, MaleStudent::combine);

        maleStudent.getList().stream()
                .forEach(s -> System.out.println(s.getName()));

        // MaleStudent(): 4명의 후보자
        // accumulate(): 후보자 중 성별이 남성인 2명이 쌓임
        // combine(): 4개로 나뉘었던 스레드가 병합됨 (combine() 3번 호출)
    }
}
