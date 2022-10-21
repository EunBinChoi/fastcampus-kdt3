package me.day16.io.inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class InputStreamReadExample2 {
    public static void main(String[] args) {
        try {
            final String path = InputStreamReadExample2.class.getResource("").getPath();
            InputStream inputSteam = new FileInputStream(path + "long.txt");
            int total = 0;
            int readByteNo = 0;
            byte[] readBytes = new byte[100];

            // 입력 스트림으로부터 100개 바이트가 들어온다면 read()는 100번 루핑 필요
            // 그러나 read(byte[] b) 메소드는 한 번 읽을 때 매개값으로 주어진 바이트 배열 길이만큼 읽기 때문에 루핑 횟수가 현저히 줄어듦
            // 많은 양의 바이트를 읽을 때는 read(byte[] b) 메소드를 사용하는 것이 좋음
            while ((readByteNo = inputSteam.read(readBytes)) != -1) {
                for (int i = 0; i < readByteNo; i++) {
                    System.out.print((char)readBytes[i]);
                }
                total += readByteNo;
            }
            System.out.println("\n\ntotal bytes = " + total + " byte");

            inputSteam.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
