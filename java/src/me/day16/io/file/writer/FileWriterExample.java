package me.day16.io.file.writer;

import java.io.*;

public class FileWriterExample {
    public static void main(String[] args) {
        final String path = FileWriterExample.class.getResource("").getPath();
        final String[] sentences = {":(\n", ":)\n", "TT\n", "^^\n"};

        try (Writer writer = new FileWriter(path + "output.txt", true)) {
            // 파일이 없을 경우 파일을 생성
            // 이미 파일이 있을 경우에는 파일을 덮어씀

            writer.write("good day\n");
            writer.write("nice day\n");

            for (int i = 0; i < sentences.length; i++) {
                writer.write(sentences[i]);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
