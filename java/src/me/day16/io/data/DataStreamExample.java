package me.day16.io.data;

import me.day16.io.buffered.BufferedStreamExample;

import java.io.*;

public class DataStreamExample {
    public static void main(String[] args) {

        // out directory absolute path
        final String path = DataStreamExample.class.getResource("").getPath();

        try (
                OutputStream fos = new FileOutputStream(path + "input.dat"); // 이진 파일
                DataOutputStream dos = new DataOutputStream(fos);

                InputStream fis = new FileInputStream(path + "input.dat"); // 이진 파일
                DataInputStream dis = new DataInputStream(fis)
        ) {

            dos.writeUTF("김자바");
            dos.writeInt(30);
            dos.writeDouble(12.34);

            // 파일에 쓴 순서대로 읽어야 함
            String name = dis.readUTF();
            int age = dis.readInt();
            double weight = dis.readDouble();

            System.out.println(name);
            System.out.println(age);
            System.out.println(weight);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
