package me.day16.io.outputstream;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class OutputStreamWriteExample1 {
    public static void main(String[] args) {
        try {
            final String path = OutputStreamWriteExample1.class.getResource("").getPath();
            OutputStream outputStream = new FileOutputStream(path + "output.txt");
            final byte[] data = "가 나 다 라 마 바 사 아".getBytes(); // 자바에서 한글 지원하기 때문에 (유니코드) 깨지지 않음
//            byte[] data = "a b c d e f g h i j k".getBytes(); // "a", "b", "c" ... "k"를 하나씩 출력
            for (int i = 0; i < data.length; i++) {
                outputStream.write(data[i]);
            }
            outputStream.flush();
            outputStream.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
