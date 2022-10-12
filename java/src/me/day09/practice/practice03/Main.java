package me.day09.practice.practice03;

import me.day09.practice.practice01.Electronic;

import java.util.Arrays;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Electronics electronics = new Electronics(new Electronic[]{
                new Electronic("", Electronic.Company.SAMSUNG, new Date(),
                        new Electronic.AuthMethod[]{Electronic.AuthMethod.PIN, Electronic.AuthMethod.FACE}),
                new Electronic( "", Electronic.Company.LG, new Date(),
                        new Electronic.AuthMethod[]{Electronic.AuthMethod.PIN, Electronic.AuthMethod.PATTERN}),
                new Electronic("", Electronic.Company.APPLE, new Date(),
                        new Electronic.AuthMethod[]{Electronic.AuthMethod.PIN}),
                new Electronic("", Electronic.Company.SAMSUNG, new Date(),
                        new Electronic.AuthMethod[]{Electronic.AuthMethod.PIN, Electronic.AuthMethod.FINGER}),
                new Electronic("", Electronic.Company.LG, new Date(),
                        new Electronic.AuthMethod[]{Electronic.AuthMethod.PIN, Electronic.AuthMethod.FINGER, Electronic.AuthMethod.PATTERN, Electronic.AuthMethod.FACE}),
                new Electronic("", Electronic.Company.APPLE, new Date(),
                        new Electronic.AuthMethod[]{Electronic.AuthMethod.PIN, Electronic.AuthMethod.FINGER})});


        ClassifiedElectronics[] classifiedElectronics = electronics.groupByCompanyName();
        for (int i = 0; i < classifiedElectronics.length; i++) {
            System.out.print("[ company => " + classifiedElectronics[i].getCompany() + " ], ");
            System.out.println("  count => " + classifiedElectronics[i].getCount());


            System.out.println(Arrays.toString(Arrays.copyOf(classifiedElectronics[i].getElectronics(), classifiedElectronics[i].getCount())));
            System.out.println();
        }

    }
}
