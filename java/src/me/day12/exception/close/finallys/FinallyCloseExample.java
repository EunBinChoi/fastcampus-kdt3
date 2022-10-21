package me.day12.exception.close.finallys;

import me.day12.api.util.scanner.ScannerExample;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FinallyCloseExample {
    public static void main(String[] args) {
        FileInputStream fileInputStream = null;
        BufferedInputStream bufferedInputStream = null;

        // out directory absolute path
        final String PATH = FinallyCloseExample.class.getResource("").getPath();
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
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (bufferedInputStream != null) {
                try {
                    bufferedInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
