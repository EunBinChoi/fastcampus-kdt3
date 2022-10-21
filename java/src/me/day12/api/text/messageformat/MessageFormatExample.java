package me.day12.api.text.messageformat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Paths;
import java.text.MessageFormat;
import java.text.ParseException;
import java.util.Scanner;

public class MessageFormatExample {
    public static void main(String[] args) throws ParseException, IOException {
        // From Person[] to Strings
        String pattern ="VALUES (\"{0}\",''{1}'',{2},''{3}'')";
        Person[] people = { new Person("a", Person.Gender.MALE, "971212", "971212-1234567"),
                new Person("b", Person.Gender.FEMALE, "990825", "990825-2001234"),
                new Person("c", Person.Gender.MALE, "930310", "930310-1001234") };
        String[] peopleString = new String[people.length];

        for (int i = 0; i < people.length; i++) {
            peopleString[i] = MessageFormat.format(pattern,
                    people[i].getName(), people[i].getGender(), people[i].getBirthdate(), people[i].getRegistrationNumber());
            System.out.println("i = " + i + ", pepleString[i] = " + peopleString[i]);
        }
        System.out.println();

        MessageFormat messageFormat = new MessageFormat(pattern);
        Person[] peopleParse = new Person[peopleString.length];
        for (int i = 0; i < peopleString.length; i++) {
            Object[] objects = messageFormat.parse(peopleString[i]);
            peopleParse[i] = new Person((String) objects[0], Person.Gender.valueOf((String) objects[1]), (String) objects[2], (String) objects[3]);
            System.out.println("i = " + i + ", peopleParse[i] = " + peopleParse[i]);
        }
        System.out.println();

        /////////////////////////////////////////////////////
        /////////////////////////////////////////////////////
        // 파일에서 읽어오기
        // out directory absolute path
        final String PATH = MessageFormatExample.class.getResource("").getPath();
        System.out.println(PATH);

        final String FILENAME = "input.txt";
        String pattern2 = "name: {0}, age: {1}";
        Scanner scanner = new Scanner(new File(PATH + FILENAME));

        MessageFormat messageFormat2 = new MessageFormat(pattern2);

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            Object[] objects = messageFormat2.parse(line);
            String results = MessageFormat.format(pattern2, objects);
            System.out.println("results = " + results);
        }
        scanner.close();
    }
}
