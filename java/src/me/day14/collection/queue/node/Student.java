package me.day14.collection.queue.node;

public class Student implements Comparable<Student> {
    private String studentNo;
    private String name;

    public Student() {
    }

    public Student(String studentNo, String name) {
        this.studentNo = studentNo;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentNo='" + studentNo + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public int compareTo(Student o) {
        return this.studentNo.compareTo(o.studentNo);
    }
}
