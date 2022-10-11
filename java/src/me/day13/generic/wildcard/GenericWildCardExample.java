package me.day13.generic.wildcard;

import me.day13.generic.wildcard.course.*;
import me.day13.generic.wildcard.course.register.*;

public class GenericWildCardExample {
    public static void main(String[] args) {
        Course<Person> personCourse = new Course<>("제테크 시작하기", Course.RegisterStudentType.PERSON, 5);
        Course<Student> studentCourse = new Course<>("스크래치 프로그래밍", Course.RegisterStudentType.STUDENT, 5);
        Course<Worker>  workerCourse = new Course<>("실무 자동화를 위한 프로그래밍", Course.RegisterStudentType.WORKER, 5);
        Course<HighStudent> highStudentCourse = new Course<>("대학 입시를 위한 SW 경진대회 대비", Course.RegisterStudentType.HIGH_STUDENT, 5);
        Course<UnivStudent> univStudentCourse = new Course<>("OOP 프로그래밍", Course.RegisterStudentType.UNIV_STUDENT, 5);
        Course<Animal> animalCourse = new Course<>("반려동물 사회성 기르기", Course.RegisterStudentType.ANIMAL, 5);


        Person person = new Person();
        personCourse.add(person);
//        studentCourse.add(person); // 컴파일 오류.
//        workerCourse.add(person); // 컴파일 오류.
//        highStudentCourse.add(person); // 컴파일 오류.
//        univStudentCourse.add(person); // 컴파일 오류.
//        animalCourse.add(person); // 컴파일 오류.
        System.out.println();

        Student student = new Student();
        personCourse.add(student);
        studentCourse.add(student);
//        workerCourse.add(student); // 컴파일 오류.
//        highStudentCourse.add(student); // 컴파일 오류.
//        univStudentCourse.add(student); // 컴파일 오류.
//        animalCourse.add(student); // 컴파일 오류.
        System.out.println();


        Worker worker = new Worker();
        personCourse.add(worker);
//        studentCourse.add(worker); // 컴파일 오류.
        workerCourse.add(worker);
//        highStudentCourse.add(worker); // 컴파일 오류.
//        univStudentCourse.add(worker); // 컴파일 오류.
//        animalCourse.add(worker); // 컴파일 오류.
        System.out.println();


        HighStudent highStudent = new HighStudent();
        personCourse.add(highStudent);
        studentCourse.add(highStudent);
//        workerCourse.add(highStudent); // 컴파일 오류.
        highStudentCourse.add(highStudent);
//        univStudentCourse.add(highStudent); // 컴파일 오류.
//        animalCourse.add(highStudent); // 컴파일 오류.
        System.out.println();


        UnivStudent univStudent = new UnivStudent();
        personCourse.add(univStudent);
        studentCourse.add(univStudent);
//        workerCourse.add(univStudent); // 컴파일 오류.
//        highStudentCourse.add(univStudent); // 컴파일 오류.
        univStudentCourse.add(univStudent);
//        animalCourse.add(univStudent); // 컴파일 오류.
        System.out.println();

        Animal animal = new Animal();
//        personCourse.add(animal); // 컴파일 오류.
//        studentCourse.add(animal); // 컴파일 오류.
//        workerCourse.add(animal); // 컴파일 오류.
//        highStudentCourse.add(animal); // 컴파일 오류.
//        univStudentCourse.add(animal); // 컴파일 오류.
        animalCourse.add(animal);

        System.out.println("\n\n========================================================= " +
                "register person course results =========================================================");
        CourseUtils.registerPersonCourse(personCourse);
        CourseUtils.registerPersonCourse(studentCourse);
        CourseUtils.registerPersonCourse(workerCourse);
        CourseUtils.registerPersonCourse(highStudentCourse);
        CourseUtils.registerPersonCourse(univStudentCourse);
//        CourseUtils.registerPersonCourse(animalCourse); // 컴파일 오류.

        System.out.println("\n\n========================================================= " +
                "register animal course results =========================================================");
//        CourseUtils.registerAnimalCourse(personCourse); // 컴파일 오류.
//        CourseUtils.registerAnimalCourse(studentCourse); // 컴파일 오류.
//        CourseUtils.registerAnimalCourse(workerCourse); // 컴파일 오류.
//        CourseUtils.registerAnimalCourse(highStudentCourse); // 컴파일 오류.
//        CourseUtils.registerAnimalCourse(univStudentCourse); // 컴파일 오류.
        CourseUtils.registerAnimalCourse(animalCourse);

    }
}
