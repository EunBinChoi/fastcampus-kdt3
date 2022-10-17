package me.day16.stream.stream;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {
    public static void main(String[] args) throws IOException {
        // streamFromCollection();
        // streamFromStrArray();
        // streamFromIntArray();
        // streamFromIntRange();
//         streamFromFile();
        streamFromDirectory();
    }

    public static void streamFromCollection() {
        List<Student> studentList = Arrays.asList(
                new Student("kelly", 90),
                new Student("john" , 100),
                new Student("smith", 70)
        );
        studentList.stream() // 컬렉션에서 스트림 얻기
                .forEach(s -> System.out.println("s = " + s));
    }

    public static void streamFromStrArray() {
        String[] strings = { "string1", "string2", "string3" };
        List<String> stringList = Arrays.stream(strings) // 배열에서 스트림 얻기
                .map(s -> Character.toString(s.charAt(s.length() - 1)))
                .collect(Collectors.toList());
        System.out.println("stringList = " + stringList);
    }

    public static void streamFromIntArray() {
        int[] ints = {90, 97, 20, 30, 35, 80, 90, 95, 95, 97, 98};
        boolean isEven = Arrays.stream(ints) // 배열에서 스트림 얻기
                .allMatch(i -> i % 2 == 0);
        System.out.println("isEven = " + isEven);
    }

    public static void streamFromIntRange() {
        IntStream stream = IntStream.rangeClosed(1, 100); // 정수 범위를 통해 스트림 얻기
        int total = stream.sum();
        System.out.println("total = " + total);
    }


    public static void streamFromFile() throws IOException {
        Path userPath = Paths.get(System.getProperty("user.dir"));
        System.out.println("userPath = " + userPath);

        List<Path> pathList = Files.walk(userPath) // 디렉토리 스트림 얻음
                .collect(Collectors.toList());
        //System.out.println(pathList);

        Path path = pathList.stream()
                .filter(p -> p.toFile().isFile())
                .filter(p -> p.toFile().getName().endsWith(".md"))
                .findFirst().get();
        System.out.println("path = " + path);
        System.out.println();

        // Files.lines() 메소드를 이용하여 파일 스트림 얻음
        System.out.println("=============================================");
        Stream<String> fileStream = Files.lines(path, Charset.defaultCharset());
        fileStream.forEach( System.out::println ); // 메소드 참조 (s -> System.out.println(s))와 동일
        System.out.println("\n\n");

        System.out.println("=============================================");
        // BufferedReader lines() 메소드 이용 (이후 학습)
        FileReader fileReader = new FileReader(path.toFile());
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        Stream<String> fileStream2 = bufferedReader.lines();
        fileStream2.forEach( System.out::println ); // 메소드 참조 (s -> System.out.println(s))와 동일
    }

    public static void streamFromDirectory() throws IOException {
        Path userPath = Paths.get(System.getProperty("user.dir"));
        System.out.println("userPath = " + userPath);

        Stream<Path> stream = Files.list(userPath); // 디렉토리 스트림 얻음
        stream.forEach( p -> System.out.println(p.getFileName()) ); // 서브 디렉토리 이름 또는 파일 이름 리턴
    }
}
