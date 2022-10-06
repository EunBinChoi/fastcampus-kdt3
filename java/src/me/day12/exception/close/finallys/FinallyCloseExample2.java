package me.day12.exception.close.finallys;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FinallyCloseExample2 implements Close {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;

        final String PATH = FinallyCloseExample2.class.getResource("").getPath();
        final String FILENAME = "input.txt";
        try {
            fileInputStream = new FileInputStream(PATH + FILENAME);
            bufferedInputStream = new BufferedInputStream(fileInputStream);

            int n = -1;
            while ((n = bufferedInputStream.read()) != -1) {
                System.out.print((char) n);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            Close.close(fileInputStream);
            Close.close(bufferedInputStream);
        }
    }
}
