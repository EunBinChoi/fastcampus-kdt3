package me.day12.api.util.arrays;

import java.util.Arrays;

public class ArraysSearchExample {
    public static void main(String[] args) {
        // binarySearch(): 배열 안에서 원소 값을 찾아 인덱스 반환
        // 조건: 배열 원소 오름차순 정렬 (**)
        // https://minhamina.tistory.com/127

        System.out.println("1-1. Arrays.binarySearch(int[])");
        int[] ints = {98, 70, 60, 90};
        Arrays.sort(ints);
        System.out.println("일차원 배열 원소 출력 = " + Arrays.toString(ints));

        final int findElement1 = 50;
        int index1 = Arrays.binarySearch(ints, findElement1);
        System.out.println("index1 = " + index1);
        if (index1 < 0) {
            System.out.printf(">> ints 배열에 %d는 없습니다.\n", findElement1);
        } else {
            System.out.printf(">> ints 배열에 %d는 있습니다.\n", findElement1);
            System.out.printf(">> ints[%d] = %d\n", index1, findElement1);
        }
        System.out.println();
        System.out.println();
        /////////////////////////////////////////////////////////////////

        System.out.println("1-2. Arrays.binarySearch(String[])");
        String[] strings = {"abcd", "ABCD", "Zzz", "zzz"};
        Arrays.sort(strings);
        System.out.println("일차원 배열 원소 출력 = " + Arrays.toString(strings));

        final String findElement2 = "ABC";
        int index2 = Arrays.binarySearch(strings, findElement2);
        System.out.println("index2 = " + index2);
        if (index2 < 0) {
            System.out.printf(">> strings 배열에 %s는 없습니다.\n", findElement2);
        } else {
            System.out.printf(">> strings 배열에 %s는 있습니다.\n", findElement2);
            System.out.printf(">> strings[%d] = %s\n", index2, findElement2);
        }
        System.out.println();
        System.out.println();

        /////////////////////////////////////////////////////////////////
        System.out.println("1-3. Arrays.binarySearch(Person[])");
        Person[] people = { new Person("zz", Gender.FEMALE, "950126", "950126-2001234"),
                new Person("foo", Gender.MALE, "931210", "931210-1121131"),
                new Person("abc", Gender.MALE, "900722", "900722-1331782") };
        Arrays.sort(people);
        System.out.println("일차원 배열 원소 출력 = " + Arrays.toString(people));

        final Person findElement3 =  new Person("foz", Gender.MALE, "931210", "931210-1121131");
        int index3 = Arrays.binarySearch(people, findElement3);
        System.out.println("index3 = " + index3);
        if (index3 < 0) {
            System.out.printf(">> people 배열에 %s는 없습니다.\n", findElement3);
        } else {
            System.out.printf(">> people 배열에 %s는 있습니다.\n", findElement3);
            System.out.printf(">> people[%d] = %s\n", index3, findElement3);
        }

    }
}
