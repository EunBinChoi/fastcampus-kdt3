package me.day16.io.file.copy;

import me.day16.io.data.DataStreamExample;
import me.day16.io.file.outputstream.FileOutputStreamExample;

import java.io.*;

public class ImageCopyExample {
    public static void main(String[] args) {
        // out directory absolute path
        final String path = ImageCopyExample.class.getResource("").getPath();
        final String original = "dog.jpg";
        final String copy = "dog_copy.jpg";

        try (
                InputStream is = new FileInputStream(path + original);
                OutputStream os = new FileOutputStream(path + copy);
        ) {

            byte[] readBytes = new byte[256];
            int data;
            while ((data = is.read(readBytes)) != -1) {
                // read()의 반환값: 실제 읽은 바이트 수 (int)
                os.write(readBytes, 0, data);
                // 그림 파일 / 256이 나누어떨어지지 않기 때문에
                // 실제 읽은 바이트 수만큼 써야함
            }
        } catch (FileNotFoundException e) {
            System.out.println(e);
        } catch (IOException e) {
            System.out.println(e);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
