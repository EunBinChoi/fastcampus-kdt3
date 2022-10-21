package me.day16.io.buffered;

import me.day12.exception.close.resources.TryWithResourceCloseExample;
import me.day16.io.file.writer.FileWriterExample;

import java.io.*;

public class BufferedStreamExample {
    public static void main(String[] args) {
        // out directory absolute path
        final String path = BufferedStreamExample.class.getResource("").getPath();
        /*
            Buffer 입출력 스트림: 입력/출력 성능 향상

             - 바이트 단위: BufferedInputStream, BufferedOutputStream
             - 문자 단위 :  BufferedReader, BufferedWriter
             - 자체적으로 입출력 불가능 (기존의 입출력 스트림에 연결해서 사용)
             - 버퍼의 사이즈 (8192)이 가득 찼을 때에만 입출력 수행
             - 마지막 버퍼에 남겨있는 데이터가 목적지로 가지 못할 수도 있음
             => flush() 수행해야 함!
         */

        try (
                InputStream fis = new FileInputStream(path + "dog.jpg");
                BufferedInputStream bis = new BufferedInputStream(fis);

                OutputStream fos = new FileOutputStream(path + "dog_copy.jpg");
                BufferedOutputStream bos = new BufferedOutputStream(fos);

        ) {

            // 이미지 복사
            int data;
            while ((data = bis.read()) != -1) {
                bos.write(data);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
