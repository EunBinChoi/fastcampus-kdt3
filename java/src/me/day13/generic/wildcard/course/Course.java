package me.day13.generic.wildcard.course;

import me.day13.generic.wildcard.course.register.Person;

import java.util.Arrays;
import java.util.Objects;



public class Course<T> {

    public enum RegisterStudentType { ANIMAL, PERSON, STUDENT, HIGH_STUDENT, UNIV_STUDENT, WORKER }

    private String courName;
    private RegisterStudentType registerStudentType;
    private T[] registerStudents;
    private int count = 0;
    private int size = 0;

    public Course() {
    }

    public Course(String courName, RegisterStudentType registerStudentType, int size) {
        this.courName = courName;
        this.registerStudentType = registerStudentType;
        this.registerStudents = (T[]) new Object[size];
        this.size = size;
    }

    public String getCourName() {
        return courName;
    }

    public void setCourName(String courName) {
        this.courName = courName;
    }

    public RegisterStudentType getRegisterStudentType() {
        return registerStudentType;
    }

    public void setRegisterStudentType(RegisterStudentType registerStudentType) {
        this.registerStudentType = registerStudentType;
    }

    public T[] getRegisterStudents() {
        return registerStudents;
    }

    public void setRegisterStudents(T[] registerStudents) {
        this.registerStudents = registerStudents;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public void add(T t) {
        if (count < size) {
            registerStudents[count] = (T) t;
            count++;

            System.out.println(t + " is added successfully.");
        } else {
            T[] copied = Arrays.copyOf(registerStudents, size);
            size *= 2;
            registerStudents = Arrays.copyOf(copied, size);
            add(t);
        }
    }


    public T remove(T t) {
        if (t == null) {
            System.out.println(t +" can't be removed successfully.");
            return null;
        }

        int index = -1;
        for (int i = 0; i < count; i++) {
            if (t instanceof Person) {
                if (registerStudents[i] != null) {
                    if (registerStudents[i].equals(t)) {
                        index = i;
                    }
                }
            }
        }
        T removeStudent = registerStudents[index];
        registerStudents[index] = null;

        for (int i = index+1; i < count; i++) {
            registerStudents[i-1] = registerStudents[i];
        }

        System.out.println(removeStudent + " is removed successfully.");
        return removeStudent;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Course<?> course = (Course<?>) o;
        return courName.equals(course.courName) && registerStudentType == course.registerStudentType && Arrays.equals(registerStudents, course.registerStudents);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(courName, registerStudentType);
        result = 31 * result + Arrays.hashCode(registerStudents);
        return result;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courName='" + courName + '\'' +
                ", registerStudentType=" + registerStudentType +
                ", registerStudents=" + Arrays.toString(registerStudents)  +
                '}';
    }
}
