package me.day16.io.file.reader;

import java.io.*;

public class FileReaderExample {
    public static void main(String[] args) {
        final String path = FileReaderExample.class.getResource("").getPath();
        try (Reader reader = new FileReader(path + "input.txt") ) {


			/*int data = reader.read();
            System.out.print((char)data + ", ");
            System.out.println(data);
			// 1 바이트를 읽음 (더이상 읽을 수 없으면 -1 리턴)
			// 'a': 1바이트
			// '가': 2바이트 (euc-kr), 3바이트 (utf-8)

			while((data = reader.read()) != -1) {

				System.out.print((char)data + ", ");
				System.out.println(data);
				// enter: cr (13) + lf (10) (windows)
				// 		: cr (13) (mac)
			}*/

            char[] data = new char[10];
            int dataNo = reader.read(data);

            for (int i = 0; i < dataNo; i++) {
                System.out.print(data[i] + ", ");
                System.out.println((int)data[i]);
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
