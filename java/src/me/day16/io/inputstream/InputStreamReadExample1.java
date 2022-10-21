package me.day16.io.inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamReadExample1 {
    public static void main(String[] args) {
        try {
            final String path = InputStreamReadExample1.class.getResource("").getPath();
            InputStream inputStream = new FileInputStream(path + "input_kor.txt"); // 한국어 깨짐 (1 바이트씩 읽음)
//            InputStream inputStream = new FileInputStream(path + "input_eng.txt");
            int readByte;

            // 읽을 수 있는 마지막 바이트까지 루프를 돌며 한 바이트씩 읽음
            while ((readByte = inputStream.read()) != -1) {
                System.out.print((char) readByte);
            }

            inputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
