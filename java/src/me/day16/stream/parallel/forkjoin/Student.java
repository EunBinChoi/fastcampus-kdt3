package me.day16.stream.parallel.forkjoin;

class Student {
    public enum Gender { MALE, FEMALE }
    public enum City { SEOUL, BUSAN }

    private String name;
    private int score;
    private Gender gender;
    private City city;

    public Student(String name, int score, Gender gender) {
        this.name = name;
        this.score = score;
        this.gender = gender;
    }

    public Student(String name, int score, Gender gender, City city) {
        this.name = name;
        this.score = score;
        this.gender = gender;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public Gender getGender() {
        return gender;
    }

    public City getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", gender=" + gender +
                ", city=" + city +
                '}';
    }
}

