package me.day16.io.writer;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterWriteExample2 {
    public static void main(String[] args) {
        try {
            final String path = WriterWriteExample2.class.getResource("").getPath();
            Writer writer = new FileWriter(path + "output.txt");
            final char[] data = "가 나 다 라 마 바 사 아".toCharArray(); // 자바에서 한글 지원하기 때문에 (유니코드) 깨지지 않음
//            char[] data = "a b c d e f g h i j k".toCharArray(); // "a b c d e f g h i j k"을 한꺼번에 출력
            writer.write(data);
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
