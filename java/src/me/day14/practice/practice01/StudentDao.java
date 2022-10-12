package me.day14.practice.practice01;

import javax.xml.crypto.Data;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Predicate;

public class StudentDao {
    private static StudentDao studentDao;

    public static StudentDao getInstance() {
        if (studentDao == null) {
            studentDao = new StudentDao();
        }
        return studentDao;
    }

    public Student select(Predicate<Object> condition) {
        // TODO: condition에 맞는 학생들만 select
        return null;
    }


    public Map<String, Student> select() {
        // TODO: 전체 학생들 select
        return null;
    }


    public boolean insert(Student student) {
        // TODO: 인자로 들어온 Student 객체 insert
        return false;
    }

    public boolean insert(Map<String, Student> students) {
        // TODO: 인자로 들어온 Student 객체들 모두 insert
        return false;
    }

//    public boolean update(Predicate<Object> condition, DataBase.Column column, Object value) {
//         TODO: condition에 맞는 학생들만 update
//        return false;
//    }

    public boolean delete() {
        // TODO: 전체 학생들 delete
        return false;
    }

    public boolean delete(Predicate<Object> condition) {
        // TODO: condition에 맞는 학생들만 delete
        return false;
    }

}