package me.day12.api.util.arrays;

import java.util.Objects;

public class Person implements Cloneable, Comparable<Person> {
    private String name;
    private Gender gender;
    private String birthdate;
    private String registrationNumber;

    public Person() {}

    public Person(String name, Gender gender, String birthdate, String registrationNumber) {
        this.name = name;
        this.gender = gender;
        this.birthdate = birthdate;
        this.registrationNumber = registrationNumber;
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

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) && gender == person.gender && Objects.equals(birthdate, person.birthdate) && Objects.equals(registrationNumber, person.registrationNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, gender, birthdate, registrationNumber);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", gender=" + gender +
                ", birthdate='" + birthdate + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return new Person(name, gender, birthdate, registrationNumber);
    }

    @Override
    public int compareTo(Person o) {
        if (this.name.compareTo(o.name) < 0) return -1;
        else if (this.name.compareTo(o.name) == 0) return this.birthdate.compareTo(o.birthdate);
        else return 1;
    }
}

