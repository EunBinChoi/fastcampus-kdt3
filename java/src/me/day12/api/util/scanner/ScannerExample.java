package me.day12.api.util.scanner;

import me.day16.io.reader.ReaderReadExample1;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class ScannerExample {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scanner = new Scanner(System.in);
//        byte byteValue = scanner.nextByte();
//        short shortValue = scanner.nextShort();
//        int intValue = scanner.nextInt();
//        long longValue = scanner.nextLong();
//        float floatValue = scanner.nextFloat();
//        double doubleValue = scanner.nextDouble();
//        boolean booleanValue = scanner.nextBoolean();
//        char charValue = scanner.next().charAt(0);
//        String stringValue = scanner.next();
//        String stringValue2 = scanner.nextLine();

//        long longValue = scanner.nextLong(); // 92233720368547758079 // 오류
//        BigInteger bigInteger = scanner.nextBigInteger(); // 92233720368547758079
//        System.out.println("longValue = " + longValue);
//        System.out.println("bigInteger = " + bigInteger);
//        System.out.println();
//
//        double doubleValue = scanner.nextDouble(); // 123.45123124123123123123123123
//        BigDecimal bigDecimal = scanner.nextBigDecimal(); // 123.45123124123123123123123123
//        System.out.println("doubleValue = " + doubleValue);
//        System.out.println("bigDecimal = " + bigDecimal);
//        System.out.println();
//
//        String stringValue = scanner.next(); // "hello world"
//        String stringValue2 = scanner.nextLine(); // "hello world"
//        System.out.println("stringValue = " + stringValue);
//        System.out.println("stringValue2 = " + stringValue2);
//        System.out.println();
//        scanner.close();

        // out directory absolute path
        final String PATH = ScannerExample.class.getResource("").getPath();

        final String FILENAME = "input.txt";
        Scanner scanner1 = new Scanner(new File(PATH + FILENAME));
        
        while (scanner1.hasNext()) {
            String str = scanner1.next();
            System.out.println("str = " + str);
        }
        System.out.println();
        scanner1.close();


        final String INPUT1 = "1 fish 2 fish red fish blue fish";
        Scanner scanner2 = new Scanner(INPUT1).useDelimiter("\\s*fish\\s*");
        System.out.println(scanner2.nextInt());
        System.out.println(scanner2.nextInt());
        System.out.println(scanner2.next());
        System.out.println(scanner2.next());
        System.out.println();
        scanner2.close();


        final String INPUT2 = "1 fish 2 fish red fish blue fish";
        Scanner scanner3 = new Scanner(INPUT2);
        scanner3.findInLine("(\\d+) fish (\\d+) fish (\\w+) fish (\\w+)");
        MatchResult result = scanner3.match();
        for (int i = 0; i <= result.groupCount(); i++) {
            System.out.println(result.group(i));
        }
        scanner3.close();

    }
}
