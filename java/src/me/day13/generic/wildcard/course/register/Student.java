package me.day13.generic.wildcard.course.register;

import java.util.Objects;

public class Student extends Person {
    protected String stuNo;
    protected String grade;

    public Student() {
    }

    public Student(String stuNo, String grade) {
        this.stuNo = stuNo;
        this.grade = grade;
    }

    public Student(String name, Gender gender, String regNum, String stuNo, String grade) {
        super(name, gender, regNum);
        this.stuNo = stuNo;
        this.grade = grade;
    }

    public String getStuNo() {
        return stuNo;
    }

    public void setStuNo(String stuNo) {
        this.stuNo = stuNo;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return stuNo.equals(student.stuNo) && grade.equals(student.grade);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), stuNo, grade);
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuNo='" + stuNo + '\'' +
                ", grade='" + grade + '\'' +
                ", name='" + name + '\'' +
                ", gender=" + gender +
                ", regNum='" + regNum + '\'' +
                '}';
    }
}
