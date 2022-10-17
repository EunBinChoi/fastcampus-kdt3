package me.day16.practice.practice03;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> stuList = new ArrayList<>();
        stuList.add(new Student("홍현희", Student.Gender.FEMALE, Student.Grade.SENIOR));
        stuList.add(new Student("제이쓴", Student.Gender.MALE, Student.Grade.SENIOR));
        stuList.add(new Student("김이나", Student.Gender.FEMALE, Student.Grade.JUNIOR));
    }
}
