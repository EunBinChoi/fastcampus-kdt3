package me.day16.io.outputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamWriteExample3 {
    public static void main(String[] args) {
        try {
            final String path = OutputStreamWriteExample3.class.getResource("").getPath();
            OutputStream outputStream = new FileOutputStream(path + "output.txt");
            final byte[] data = "a b c d e f g h i j k".getBytes(); // "a b c d e f g h i j k"을 한꺼번에 출력
            outputStream.write(data, 2, 13); // "b c d e f g h"이 파일에 써짐
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
