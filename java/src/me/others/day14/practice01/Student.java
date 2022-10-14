package me.others.day14.practice01;

import java.util.Objects;

public class Student {
    private String sId;
    private String sPw;
    private String sName;
    private Integer sAge;
    private String sGender;
    private String sMajor;

    public Student() {
    }

    public Student(String sId, String sPw, String sName, Integer sAge, String sGender, String sMajor) {
        this.sId = sId;
        this.sPw = sPw;
        this.sName = sName;
        this.sAge = sAge;
        this.sGender = sGender;
        this.sMajor = sMajor;
    }

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsPw() {
        return sPw;
    }

    public void setsPw(String sPw) {
        this.sPw = sPw;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public Integer getsAge() {
        return sAge;
    }

    public void setsAge(Integer sAge) {
        this.sAge = sAge;
    }

    public String getsGender() {
        return sGender;
    }

    public void setsGender(String sGender) {
        this.sGender = sGender;
    }

    public String getsMajor() {
        return sMajor;
    }

    public void setsMajor(String sMajor) {
        this.sMajor = sMajor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return sId.equals(student.sId) && Objects.equals(sPw, student.sPw) && Objects.equals(sName, student.sName) && Objects.equals(sAge, student.sAge) && Objects.equals(sGender, student.sGender) && Objects.equals(sMajor, student.sMajor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sId, sPw, sName, sAge, sGender, sMajor);
    }

    @Override
    public String toString() {
        return "Student{" +
                "sId='" + sId + '\'' +
                ", sPw='" + sPw + '\'' +
                ", sName='" + sName + '\'' +
                ", sAge=" + sAge +
                ", sGender='" + sGender + '\'' +
                ", sMajor='" + sMajor + '\'' +
                '}';
    }
}
