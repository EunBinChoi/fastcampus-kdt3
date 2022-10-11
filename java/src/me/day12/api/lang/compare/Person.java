package me.day12.api.lang.compare;

import java.util.Objects;

public class Person implements Comparable<Person> {
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

    // 객체에 담긴 필드는 여러개가 있는데 이 중에서 어떤 걸 기준으로 정렬할 것인가를 정의하는 메소드
    // o1.compareTo(o2)
    // o1 < o2: 음수 반환
    // o1 == o2: 0 반환
    // o1 > o2: 양수 반환
    // {Person p1, Person p2, ..... Person pN};
    // Arrays.sort(people);
    // p1.compareTo(p2);
    @Override
    public int compareTo(Person o) {
        // 이름으로 오름차순
        if (this.name.compareTo(o.name) < 0) return -1;
        else if (this.name.compareTo(o.name) == 0) {
            // 생년월일로 오름차순
//            if (this.birthdate.compareTo(o.birthdate) < 0) return -1;
//            else if (this.birthdate.compareTo(o.birthdate) == 0) return 0;
//            else return 1;
            return this.birthdate.compareTo(o.birthdate);
        }
        else return 1;
    }
}
