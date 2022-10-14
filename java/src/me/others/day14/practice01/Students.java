package me.others.day14.practice01;

import java.util.HashMap;
import java.util.Map;

public class Students {
    private Map<String, Student> students;

    public Students() {
        students = new HashMap<>();
    }

    public Students(Map<String, Student> students) {
        this.students = students;
    }

    public Map<String, Student> getStudents() {
        return students;
    }

    public void setStudents(Map<String, Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Students{" +
                "students=" + students +
                '}';
    }
}
