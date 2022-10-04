package me.day12.api.util.arrays;

import java.util.Arrays;

public class ObjectArraysCopyExample {
    public static void main(String[] args) {
        System.out.println();
        System.out.println();
        System.out.println("==================== 객체 배열 복사 ====================");
        final int NUM = 10;
        Person[] people = new Person[NUM];

        System.out.println("1-0. 객체 배열 초기화");
        for (int i = 0; i < people.length; i++) {
            String randomName = Character.toString((i) % ('z' - 'a' + 1) + 'a');
            Gender randomGender = Gender.values()[i % Gender.values().length];

            String randomMonth = String.format("%02d", (int)(Math.random() * 12) + 1);
            String randomDay = String.format("%02d", (int)(Math.random() * 30) + 1);
            String randomBirthdate = "90" + randomMonth + randomDay;
            String randomRegistrationNumber = randomBirthdate + "-" +
                    (randomGender == Gender.MALE ? 1 : 2) + String.format("%06d", ((int)(Math.random() * 900000)) + 100000);


            people[i] = new Person(randomName, randomGender, randomBirthdate, randomRegistrationNumber);
        }
        System.out.println(Arrays.toString(people));
        System.out.println();
        System.out.println();
        //////////////////////////////////////////////////////////////////////////

        System.out.println("1-1. 객체 배열 복사");
        Person[] peopleCopy = null;
        final int NEW_LENGTH = 10;
        try {
            peopleCopy = copyObjectArray(people, NEW_LENGTH);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        System.out.println("객체 배열 출력 = " + Arrays.toString(people)); // 일차원 배열 출력
        System.out.println("객체 배열 출력 = " + Arrays.toString(peopleCopy)); // 일차원 배열 출력
        System.out.println("배열 주소 비교 = " + (people == peopleCopy)); // 주소값 비교 false
        System.out.println("객체 주소 비교 = " + (isEqualsObjectAddress(people, peopleCopy))); // 객체 주소값 비교 false
        System.out.println("내용 비교 = " + Arrays.deepEquals(people, peopleCopy)); // 배열 내용 비교 true
        System.out.println();
        System.out.println();

    }
    public static Person[] copyObjectArray(Person[] original, int newLength) throws CloneNotSupportedException {
        Person[] copied = new Person[newLength];
        for (int i = 0; i < copied.length; i++) {
            copied[i] = (Person) original[i].clone();
        }
        return copied;
    }
    public static boolean isEqualsObjectAddress(Person[] original, Person[] object) {
        int minLength = Math.min(original.length, object.length);
        for (int i = 0; i < minLength; i++) {
            if (original[i] != object[i]) return false;
        }
        return true;
    }
}
