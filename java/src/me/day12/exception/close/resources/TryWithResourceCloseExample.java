package me.day12.exception.close.resources;

import me.day12.exception.close.finallys.FinallyCloseExample;

import java.io.*;

public class TryWithResourceCloseExample {
    public static void main(String[] args) {
        // out directory absolute path
        final String PATH = TryWithResourceCloseExample.class.getResource("").getPath();
        final String FILENAME = "input.txt";

        // try 문을 벗어나면 try-with-resources의 try(...)안에 선언된 객체의 close() 메소드 호출함
        // finally 블록에 명시적으로 close() 호출할 필요 없음
        // try-with-resources에서 자동으로 close()가 호출되는 것은 AutoCloseable을 구현한 객체만 해당

        // 장점
        // - 코드를 짧고 간결하게 만들어 가독성이 좋고 유지보수가 쉬움
        // - 실수로 close를 빼먹는 경우 실수에 의한 버그 발생할 가능성이 적음
        try (
                FileInputStream fileInputStream = new FileInputStream(PATH+FILENAME) ;
                BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
            ) {

            int n = -1;
            while ((n = bufferedInputStream.read()) != -1) {
                System.out.print((char) n);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
