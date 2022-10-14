package me.day14.practice.practice02;

public class Student {
    private String studentNo;
    private String name;

    private Integer score;

    public Student() {
    }

    public Student(String studentNo, String name, Integer score) {
        this.studentNo = studentNo;
        this.name = name;
        this.score = score;
    }

    public String getStudentNo() {
        return studentNo;
    }

    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNo='" + studentNo + '\'' +
                ", name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

