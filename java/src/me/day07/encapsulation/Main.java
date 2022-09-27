package me.day07.encapsulation;

public class Main {
    public static void main(String[] args) {
        NoEncapsulationExample noEncapsulationExample = new NoEncapsulationExample("bab", 30, "910308-1234567");
        System.out.println(noEncapsulationExample);

        noEncapsulationExample.age = -10000; // 외부에서 직접 접근해 데이터를 이상하게 수정할 수 있음
        noEncapsulationExample.name = null; // 외부에서 직접 접근해 데이터를 이상하게 수정할 수 있음
        noEncapsulationExample.registrationNumber = "121234-9234567";
        System.out.println(noEncapsulationExample);
        System.out.println();

        ///////////////////////////////////////////////////
        EncapsulationExample encapsulationExample = new EncapsulationExample("bab", 30, "910308-1234567");
        System.out.println(encapsulationExample);

        encapsulationExample.setAge(-10000);
        encapsulationExample.setName(null);
        encapsulationExample.setRegistrationNumber("121234-9234567");
        System.out.println(encapsulationExample);

    }
}
