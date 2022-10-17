package me.day16.io.object;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class WriteObjectStreamExample {
    public static void main(String[] args) {
        /* 객체 입출력
         * - 객체는 문자가 아니기 때문에 바이트 기반 스트림으로 출력
         * - 객체의 필드들을 줄 세워야 함
         * - 직렬화 (serialization)
         * : 객체의 필드들이 일렬로 줄 세워서 연속적인 바이트로 변경
         *
         * - 역직렬화 (deserialization)
         * : 연속적인 바이트를 다시 객체로 복원하는 것
         * */

        // .dat: data file (binary 형식)
        final String path = WriteObjectStreamExample.class.getResource("").getPath();

        try (
                OutputStream fos = new FileOutputStream(path + "students.dat");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {

            List<Student> students = Arrays.asList(
                    new Student("sally", Student.Gender.FEMALE, Student.Grade.SENIOR, "971010-2012234"),
                    new Student("kain", Student.Gender.MALE, Student.Grade.JUNIOR, "980810-1212231"),
                    new Student("kalin", Student.Gender.MALE, Student.Grade.SENIOR, "910420-1042314"));
            oos.writeObject(students);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}