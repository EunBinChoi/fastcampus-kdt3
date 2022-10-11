package me.day13.generic.wildcard.course.register;

import java.util.Objects;



public class Person {
    public enum Gender { MALE, FEMALE }

    protected String name;
    protected Gender gender;
    protected String regNum;

    public Person() {
    }

    public Person(String name, Gender gender, String regNum) {
        this.name = name;
        this.gender = gender;
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

    public String getRegNum() {
        return regNum;
    }

    public void setRegNum(String regNum) {
        this.regNum = regNum;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) && gender == person.gender && regNum.equals(person.regNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, regNum);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", regNum='" + regNum + '\'' +
                '}';
    }
}
