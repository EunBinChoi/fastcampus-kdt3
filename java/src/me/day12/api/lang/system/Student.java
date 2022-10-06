package me.day12.api.lang.system;

import me.day07.object.tostring.Semester;

import java.util.Arrays;

public class Student {
    /* auto-generated */
    private String ID;
    private String name;
    private static int ID_AUTO_GENERATER = 0;

    public Student() {
        ID_AUTO_GENERATER++;
        ID = String.format("%04d", (ID_AUTO_GENERATER));
    }

    public Student(String name) {
        ID_AUTO_GENERATER++;
        this.ID = String.format("%04d", (ID_AUTO_GENERATER));
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
