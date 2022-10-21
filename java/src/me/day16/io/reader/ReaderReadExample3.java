package me.day16.io.reader;

import java.io.*;

public class ReaderReadExample3 {
    public static void main(String[] args) {
        try {
            final String path = ReaderReadExample3.class.getResource("").getPath();
            Reader reader = new FileReader(path + "long.txt"); //  정상 출력
            int total = 0;
            int readCharNo = 0;
            char[] cbuf = new char[100];

            while ((readCharNo = reader.read(cbuf, 1, 5)) != -1) {
                for (int i = 1; i < readCharNo; i++) {
                    System.out.print(cbuf[i]);
                }
                total += readCharNo;
            }
            System.out.println("\n\ntotal bytes = " + total + " byte");
            System.out.println();
            reader.close();

            // 파일 다 읽으면 파일 포인터가 파일의 가장 마지막을 가르키기 때문에 다시 모든 값 초기화
            reader = new FileReader(path + "long.txt");
            total = 0;
            while ((readCharNo = reader.read(cbuf, 0, 10)) != -1) {
                for (int i = 0; i < readCharNo; i++) {
                    System.out.print(cbuf[i]);
                }
                total += readCharNo;
            }
            System.out.println("\n\ntotal bytes = " + total + " byte");
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
