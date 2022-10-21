package me.day16.io.writer;

import java.io.*;

public class WriterWriteExample1 {
    public static void main(String[] args) {
        try {
            final String path = WriterWriteExample1.class.getResource("").getPath();
            Writer writer = new FileWriter(path + "output.txt");
            final char[] data = "가 나 다 라 마 바 사 아".toCharArray(); // 자바에서 한글 지원하기 때문에 (유니코드) 깨지지 않음
//            char[] data = "a b c d e f g h i j k".toCharArray(); // "a", "b", "c" ... "k"를 하나씩 출력
            for (int i = 0; i < data.length; i++) {
                writer.write(data[i]);
            }
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
