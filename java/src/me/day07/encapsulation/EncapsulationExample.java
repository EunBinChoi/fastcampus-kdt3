package me.day07.encapsulation;

public class EncapsulationExample {
    private String name;
    private int age;
    private String registrationNumber;

    public EncapsulationExample() {}

    public EncapsulationExample(String name, int age, String registrationNumber) {
        this.name = name;
        this.age = age;
        this.registrationNumber = registrationNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.equals("")) return;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0 || age > 100) return;
        this.age = age;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        if (registrationNumber == null || registrationNumber.equals("")) return;
        final String REGSTRATION_REGEX = "^\\d{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|[3][01])\\-[1-4][0-9]{6}$";
        if (!registrationNumber.matches(REGSTRATION_REGEX)) return;

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
