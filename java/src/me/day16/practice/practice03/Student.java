package me.day16.practice.practice03;

public class Student {
    public enum Gender { MALE, FEMALE; }
    public enum Grade { JUNIOR, SENIOR; }

    private String name;
    private Gender gender;
    private Grade grade;

    public Student(String name, Gender gender, Grade grade) {
        super();
        this.name = name;
        this.gender = gender;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", gender=" + gender + ", grade=" + grade + "]";
    }

}