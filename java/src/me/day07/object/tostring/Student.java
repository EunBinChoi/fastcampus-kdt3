package me.day07.object.tostring;

import java.util.Arrays;

public class Student {
    /* auto-generated */
    private String ID;
    private String name;
    private Semester currentSemester;
    private String[] takenCourses;

    public Student() {}

    public Student(String name, Semester currentSemester, String[] takenCourses) {
        this.name = name;
        this.currentSemester = currentSemester;
        this.takenCourses = takenCourses;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", currentSemester=" + currentSemester +
                ", takenCourses=" + Arrays.toString(takenCourses) +
                '}';
    }
}
