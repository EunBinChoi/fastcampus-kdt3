package me.day16.stream.pipeline.terminal.reduce;

import java.util.Arrays;
import java.util.List;

public class ReduceExample {
    public static void main(String[] args) {
//        List<Person> personList = Arrays.asList(
//                new Person("kim", 30),
//                new Person("lee", 20),
//                new Person("park", 50)
//        );

        List<Person> personList = Arrays.asList();

        // sum 이용
        int sum1 = personList.stream()
                .mapToInt(Person :: getAge)
                .sum(); // 요소가 없으면 0으로 출력



        // reduce(BinaryOperator<Integer> ac) 이용
        int sum2 = personList.stream()
                .map(Person::getAge)
                .reduce((a, b) -> a + b)
                .orElse(0);
        // a    b -> a + b
        // 30  20 -> 50
        // 50  50 -> 100


        // reduce(int identity, IntBinaryOperator op) 이용
        int sum3 = personList.stream()
                .map(Person :: getAge)
                .reduce(0, (a, b) -> a + b); // 요소가 없으면 0으로 출력
        // a    b -> a + b
        // 0   30 -> 30
        // 30  20 -> 50
        // 50  50 -> 100

        System.out.println("sum1: " + sum1);
        System.out.println("sum2: " + sum2);
        System.out.println("sum3: " + sum3);
    }
}
