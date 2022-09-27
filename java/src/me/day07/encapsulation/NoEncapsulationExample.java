package me.day07.encapsulation;

public class NoEncapsulationExample {
    String name;
    int age;
    String registrationNumber;

    public NoEncapsulationExample() {}

    public NoEncapsulationExample(String name, int age, String registrationNumber) {
        this.name = name;
        this.age = age;
        this.registrationNumber = registrationNumber;
    }

    @Override
    public String toString() {
        return "NoEncapsulationExample{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", registrationNumber='" + registrationNumber + '\'' +
                '}';
    }
}
