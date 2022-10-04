package me.day12.api.lang.clone;

import me.day07.object.compare.Gender;
import me.day07.object.compare.Person;

public class ObjectCopyMain {
    public static void main(String[] args) {
        // clone method 이용
        ObjectCopyExample objectCopyExample1 = new ObjectCopyExample(10, "abc",
                new Person[] {
                        new Person("a", Gender.MALE, "19880101", "19880101-1234567"),
                        new Person("b", Gender.FEMALE, "19900320", "19900320-2345678"),
                        new Person("c", Gender.FEMALE, "19960830", "19960830-2012020")});
        ObjectCopyExample objectCopyExample2 = null;
        try {
            objectCopyExample2 = objectCopyExample1.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("주소값 비교 = " + (objectCopyExample1 == objectCopyExample2));
        System.out.println(objectCopyExample1);
        System.out.println(objectCopyExample2);
        System.out.println();
        System.out.println("주소값 비교 = " + (objectCopyExample1.getPersonArray() == objectCopyExample2.getPersonArray()));

        // 원소값 수정
        objectCopyExample1.getPersonArray()[0].setName("d");
        System.out.println(objectCopyExample1.getPersonArray()[0]);
        System.out.println(objectCopyExample2.getPersonArray()[0]);
        System.out.println();

        ////////////////////////////////////////////////////////////////////////////////
        // getNewInstance static method 이용
        ObjectCopyExample objectCopyExample3 = new ObjectCopyExample(10, "abc",
                new Person[] {
                        new Person("a", Gender.MALE, "19880101", "19880101-1234567"),
                        new Person("b", Gender.FEMALE, "19900320", "19900320-2345678"),
                        new Person("c", Gender.FEMALE, "19960830", "19960830-2012020")});
        ObjectCopyExample objectCopyExample4 = ObjectCopyExample.getNewInstance(objectCopyExample3);
        objectCopyExample3.getPersonArray()[0].setName("d");
        System.out.println(objectCopyExample3.getPersonArray()[0]);
        System.out.println(objectCopyExample4.getPersonArray()[0]);

    }
}
