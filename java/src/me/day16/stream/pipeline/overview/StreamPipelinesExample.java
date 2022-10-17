package me.day16.stream.pipeline.overview;


import java.util.Arrays;
import java.util.List;

public class StreamPipelinesExample {
    public static void main(String[] args) {
        List<Person> personList = Arrays.asList(
                new Person("kelly", 30, Person.Gender.FEMALE),
                new Person("sally", 20, Person.Gender.FEMALE),
                new Person("john", 26, Person.Gender.MALE)
        );
        double average = personList.stream()
                .filter(p -> p.getGender() == Person.Gender.MALE)
                .mapToInt(p -> p.getAge())
                .average()
                .getAsDouble();
        System.out.println("male's average age = " + average);

    }
}
