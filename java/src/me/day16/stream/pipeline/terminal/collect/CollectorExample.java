package me.day16.stream.pipeline.terminal.collect;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

class Student {
    public enum Gender { MALE, FEMALE }
    public enum City { SEOUL, BUSAN }

    private String name;
    private int score;
    private Gender gender;
    private City city;

    public Student(String name, int score, Gender gender) {
        this.name = name;
        this.score = score;
        this.gender = gender;
    }

    public Student(String name, int score, Gender gender, City city) {
        this.name = name;
        this.score = score;
        this.gender = gender;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public Gender getGender() {
        return gender;
    }

    public City getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", gender=" + gender +
                ", city=" + city +
                '}';
    }
}

public class CollectorExample {
    public static void main(String[] args) {
        List<Student> totalList = Arrays.asList(
                new Student("김철수", 10, Student.Gender.MALE),
                new Student("이영희", 6, Student.Gender.FEMALE),
                new Student("박철수", 10, Student.Gender.MALE),
                new Student("최영희", 6, Student.Gender.FEMALE)
        );

        // 남학생들만 묶어서 Lit 생성
        List<Student> maleList = totalList.stream()
                .filter(s -> s.getGender() == Student.Gender.MALE)
                .collect(Collectors.toList());
        maleList.stream()
                .forEach(s -> System.out.println(s.getName()));
        System.out.println();

        // 여학생들만 묶어서 HashSet 생성
        Set<Student> femaleSet = totalList.stream()
                .filter(s -> s.getGender() == Student.Gender.FEMALE)
                .collect(Collectors.toCollection(HashSet::new));
        femaleSet.stream()
                .forEach(s -> System.out.println(s.getName()));
    }
}
