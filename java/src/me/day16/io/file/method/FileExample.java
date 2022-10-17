package me.day16.io.file.method;

import me.day16.io.data.DataStreamExample;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileExample {
    public static void main(String[] args) throws IOException {
        final String path = FileExample.class.getResource("").getPath();

        // 현재 디렉토리에 폴더 생성
        final String newDirName = "newFolder";
        File dir = new File(path + newDirName);
        if(!dir.exists()) dir.mkdir();
        // mkdir: make directory

        // 현재 디렉토리에 파일 생성
        final String newFileName = "newFile.txt";
        File file = new File(dir + File.separator + newFileName);
        if(!file.exists()) file.createNewFile();
        //if(file.exists()) file.delete(); // 생성한 파일 삭제


        // 현재 디렉토리에 파일 리스트 확인
        File currDir = new File(path);
        File[] files = currDir.listFiles();
        for(File f : files) {
            System.out.println(f);
        }
        System.out.println();

        // 재귀적으로 디렉토리 탐색
        searchFile(new File("./"));


        // OS가 무엇인지에 따라서 파일 구분자가 다름
        // \: 윈도우
        // /: MacOS
        System.out.println(File.separator);
    }
    private static void searchFile(File file) {
        if (file.isDirectory()) {
            File[] files = file.listFiles();

            for (File f : files) {
                System.out.println(f);
                searchFile(f);
            }
        }
    }
}
