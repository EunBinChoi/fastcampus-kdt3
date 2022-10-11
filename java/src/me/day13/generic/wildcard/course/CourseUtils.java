package me.day13.generic.wildcard.course;

import me.day13.generic.wildcard.course.register.Animal;
import me.day13.generic.wildcard.course.register.Person;

public interface CourseUtils {
    static void registerPersonCourse(Course<? extends Person> course) {
        System.out.println(course + " is registered successfully.\n\n");
    }
    static void registerAnimalCourse(Course<? extends Animal> course) {
        System.out.println(course + " is registered successfully.\n\n");
    }

}
