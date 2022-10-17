package me.day16.io.object;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 8428076779352261816L;


    // 직렬화할 때 static / transient 변수는 제외
    // transient
    // - 패스워드와 같은 보안정보가 직렬화 (Serialize) 과정에서 제외하고 싶은 경우에 적용
    // - 다양한 이유로 데이터를 전송을 하고 싶지 않을 때 선언
    // - 직렬화하면 null로 존재

    /*
     * serialVersionUID 필드: 클래스의 식별자
     *
     * 직렬화했던 클래스 UID 필드값 == 역직렬화할 클래스 UID 필드값
     * (두 값이 동일해야 직렬화한 객체를 역직렬화할 수 있음!)
     *
     * 같은 클래스는 UID 값이 동일 (UID 값은 명시적으로 지정)
     */


    public enum Gender { MALE, FEMALE; }
    public enum Grade { JUNIOR, SENIOR; }

    private String name;
    private Gender gender;
    private Grade grade;

    private Integer age;

    private static String staticVar; // 클래스에 포함. Serialize 제외
    private transient String regNum; // 보안 정보. null 값으로 설정

    public Student() {
    }

    public Student(String name, Gender gender, Grade grade, String regNum) {
        this.name = name;
        this.gender = gender;
        this.grade = grade;
        this.regNum = regNum;
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public static String getStaticVar() {
        return staticVar;
    }

    public static void setStaticVar(String staticVar) {
        Student.staticVar = staticVar;
    }

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", grade=" + grade +
                ", age=" + age +
                ", regNum='" + regNum + '\'' +
                '}';
    }
}
