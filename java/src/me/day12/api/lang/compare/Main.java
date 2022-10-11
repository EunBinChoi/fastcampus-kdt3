package me.day12.api.lang.compare;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        final int NUM = 5;
        Person[] people = new Person[NUM];

        // person[i] 객체 생성
//        for (int i = 0; i < people.length; i++) {
//            people[i] = new Person();
//        }

        people[0] = new Person("cc", Gender.MALE, "881010", "881010-1112345");
        people[1] = new Person("aa", Gender.MALE, "990320", "990320-1354290");
        people[2] = new Person("ee", Gender.FEMALE, "970708", "970708-2533921");
        people[3] = new Person("aa", Gender.FEMALE, "970722", "970722-2387883");
        people[4] = new Person("zz", Gender.MALE, "980420", "980420-1101225");

        System.out.println("<이름 오름차순 정렬>");
        Arrays.sort(people);
        for (Person p: people) {
            System.out.println(p);
        }

        System.out.println("<성별로 정렬>");
        Arrays.sort(people, new ComparatorByGender());
        for (Person p: people) {
            System.out.println(p);
        }

        System.out.println("<생년월일 내림차순 정렬>");
        Arrays.sort(people, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
//                if (o1.getBirthdate().compareTo(o2.getBirthdate()) < 0) return 1;
//                else if (o1.getBirthdate().compareTo(o2.getBirthdate()) < 0) return 0;
//                else return -1;
                return o1.getBirthdate().compareTo(o2.getBirthdate()) * -1;
            }
        });
        for (Person p: people) {
            System.out.println(p);
        }
    }
}
