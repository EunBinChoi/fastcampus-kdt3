package me.day07.practice.practice03;

public class Main {
    public static void main(String[] args) {
        EncapsulationExample encapsulationExample = new EncapsulationExample("bab", 30, "910308-1234567");
        System.out.println(encapsulationExample);

        encapsulationExample.setAge(-10000);
        encapsulationExample.setName(null);
//        encapsulationExample.setRegistrationNumber("121234-9234567");
        System.out.println(encapsulationExample);

    }
}