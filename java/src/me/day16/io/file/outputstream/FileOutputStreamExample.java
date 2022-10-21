package me.day16.io.file.outputstream;

import me.day16.io.file.inputstream.FileInputStreamExample;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class FileOutputStreamExample {
    public static void main(String[] args) {
        final String path = FileOutputStreamExample.class.getResource("").getPath();

        final byte[] bytes = {'a', 'b', 'c', 'd', 'e', 'f', 'g'};

        try (OutputStream os = new FileOutputStream(path + "output.txt")) {
            // 파일이 없을 경우 파일을 생성
            // 이미 파일이 있을 경우에는 파일을 덮어씀

            os.write(bytes);
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
