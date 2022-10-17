package me.day16.stream.basics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

class Student {
    private String name;
    private Integer score;

    public Student() {
    }

    public Student(String name, Integer score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public Integer getScore() {
        return score;
    }


    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", score=" + score +
                '}';
    }
}

public class StreamExample {
    public static void main(String[] args) {

        evenNum();
        concat();
        average();

    }
    public static void evenNum() {
        //////////////////////////////////////////////////////////
        // List<Integer>
        List<Integer> integerList = new ArrayList<>(List.of(1, 2, 3, 4));

        // 일반 반복문 (외부 반복자)를 이용해서 짝수만 출력
        for (int i = 0; i < integerList.size(); i++) {
            int integer1 = integerList.get(i) ;
            if (integer1 % 2 == 0) {
                System.out.print(integer1 + ", ");
            }
        }
        System.out.println();

        // Iterator 이용해서 짝수만 출력
        Iterator<Integer> integerIterator = integerList.iterator();
        while (integerIterator.hasNext()) {
            int integer2 = integerIterator.next();
            if (integer2 % 2 == 0) {
                System.out.print(integer2 + ", ");
            }
        }
        System.out.println();

        // 스트림을 이용해서 짝수만 출력
        integerList.stream()
                .mapToInt(i -> Integer.valueOf(i))
                .filter(i -> i % 2 == 0)
                .forEach(i -> System.out.print(i + ", "));
        System.out.println('\n');
    }
    public static void concat() {
        //////////////////////////////////////////////////////////
        // List<String>
        List<String> stringList = List.of("a", "b", "c", "d", "e");

        // 일반 반복문 (외부 반복자)를 이용해서 문자열 결합
        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i = 0; i < stringList.size(); i++) {
            stringBuilder1.append(stringList.get(i));
        }
        String concat1 = stringBuilder1.toString();
        System.out.println("concat1 = " + concat1);

        // Iterator 이용해서 문자열 결합
        StringBuilder stringBuilder2 = new StringBuilder();
        Iterator<String> stringIterator = stringList.iterator();
        while(stringIterator.hasNext()) {
            stringBuilder2.append(stringIterator.next());
        }
        String concat2 = stringBuilder2.toString();
        System.out.println("concat2 = " + concat2);

        // 스트림을 이용해서 문자열 합치기
        String concat3 = stringList.stream().collect(Collectors.joining());
        System.out.println("concat3 = " + concat3);

        System.out.println();
    }
    public static void average() {
        //////////////////////////////////////////////////////////
        // List<Member>
        final int STUDENT_NUM = 10;
        List<Student> studentList = new ArrayList<>();

        // 객체 초기화
        for (int i = 0; i < STUDENT_NUM; i++) {
            studentList.add(new Student(Character.toString(i + 'a'), (int)(Math.random() * 101)));
        }
        //System.out.println("studentList = " + studentList);

        // 일반 반복문 (외부 반복자)를 이용해서 학생 성적 평균
        double average1 = 0.0;
        for (int i = 0; i < studentList.size(); i++) {
            average1 += studentList.get(i).getScore();
        }
        average1 /= studentList.size();
        System.out.println("average1 = " + average1);

        // Iterator 이용해서 학생 성적 평균
        double average2 = 0.0;
        Iterator<Student> iterator1 = studentList.iterator();
        while (iterator1.hasNext()) {
            Student student = iterator1.next();
            average2 += student.getScore();
        }
        average2 /= studentList.size();
        System.out.println("average2 = " + average2);

        // 스트림을 이용해서 학생 성적 평균
        double average3 = studentList.stream()
                .mapToInt(s -> s.getScore())
                .average()
                .getAsDouble();
        System.out.println("average3 = " + average3);
    }

}
