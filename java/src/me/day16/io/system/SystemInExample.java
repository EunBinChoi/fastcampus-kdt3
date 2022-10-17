package me.day16.io.system;

import java.io.IOException;
import java.io.InputStream;

public class SystemInExample {
    public static void main(String[] args) {
        byte[] data = new byte[100];

        System.out.print("이름 : ");
        try (InputStream is = System.in) {
            // is.read(): 1 바이트를 읽어서 반환
            // is.read(byte[]): byte 배열만큼 읽고 실제 읽은 바이트 수 반환

            int bytes = is.read(data); // enter 포함됨
            String name = new String(data, 0, bytes - 1);
            // enter: cr (13) + lf (10) (windows) => bytes - 2
            // 		: cr (13) (mac) => bytes - 1

            System.out.println(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
