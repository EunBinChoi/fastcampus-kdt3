package me.day16.io.writer;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class WriterWriteExample4 {
    public static void main(String[] args) {
        try {
            final String path = WriterWriteExample4.class.getResource("").getPath();
            Writer writer = new FileWriter(path + "output.txt");
            final String str = "안녕하세요. 파일 입출력 예제입니다.";
//            writer.write(str);
            writer.write(str, 1, 12);
            writer.flush();
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
