package me.day08.statics.uses;

import me.day07.object.tostring.Semester;

public class Student {
    private String ID;
    private String name;
    private Semester currentSemester;

    private static int numOfStudent = 0;

    public Student() { numOfStudent++; }

    public Student(String ID, String name, Semester currentSemester) {
        this.ID = ID;
        this.name = name;
        this.currentSemester = currentSemester;
        numOfStudent++;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Semester getCurrentSemester() {
        return currentSemester;
    }

    public void setCurrentSemester(Semester currentSemester) {
        this.currentSemester = currentSemester;
    }

    public static int getNumOfStudent() {
        return numOfStudent;
    }

    public static void setNumOfStudent(int numOfStudent) {
        Student.numOfStudent = numOfStudent;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", currentSemester=" + currentSemester +
                '}';
    }
}
