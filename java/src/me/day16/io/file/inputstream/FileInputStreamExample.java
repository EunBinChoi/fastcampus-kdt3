package me.day16.io.file.inputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class FileInputStreamExample {
    public static void main(String[] args) {
        final String path = FileInputStreamExample.class.getResource("").getPath();
        try (InputStream is = new FileInputStream(path + "input.txt") ) {
            // FileNotFoundException

			/*int data = is.read();
            System.out.print((char)data + ", ");
            System.out.println(data);
			// 1 바이트를 읽음 (더이상 읽을 수 없으면 -1 리턴)
			// 'a': 1바이트
			// '가': 2바이트 (euc-kr), 3바이트 (utf-8)

			while((data = is.read()) != -1) {

				System.out.print((char)data + ", ");
				System.out.println(data);
				// enter: cr (13) + lf (10) (windows)
				// 		: cr (13) (mac)
			}*/

            byte[] data = new byte[10];
            int dataNo = is.read(data);

            for (int i = 0; i < dataNo; i++) {
                System.out.print((char)data[i] + ", ");
                System.out.println(data[i]);
            }

        } catch(FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch(IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
