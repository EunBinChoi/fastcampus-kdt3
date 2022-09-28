package me.day08.statics.uses;

import me.day07.object.tostring.Semester;

public class StudentMain {
    public static void main(String[] args) {
        System.out.println("학생 수 = " + Student.getNumOfStudent());

        Student[] students = new Student[10];
        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(Character.toString('a' + i),
                    Semester.values()[i % Semester.values().length]);
            System.out.println("학생 수 = " + Student.getNumOfStudent());
            System.out.println(students[i]);
            System.out.println();
        }
    }
}
