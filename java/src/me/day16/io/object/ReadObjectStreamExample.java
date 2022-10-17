package me.day16.io.object;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class ReadObjectStreamExample {
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
        final String path = ReadObjectStreamExample.class.getResource("").getPath();

        try (
                InputStream fis = new FileInputStream(path + "students.dat");
                ObjectInputStream ois = new ObjectInputStream(fis);
        ) {

            List<Student> students = (List<Student>)ois.readObject();
            System.out.println(students);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}