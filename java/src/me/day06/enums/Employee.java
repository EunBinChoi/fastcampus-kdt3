package me.day06.enums;

import java.util.Objects;

public class Employee {
    /* ID is auto-generated */
    private String ID;
    private String name;
    private Position position;
    private Department department;
    public static final String COMPANY = "GOOGLE";
    private static int total = 0;

    public Employee() {
        this.ID = String.format("%04d", (total+1));
        total++;
    }

    public Employee(String name) {
        this.ID = String.format("%04d", (total+1));
        this.name = name;
        total++;
    }

    public Employee(String name, Position position, Department department) {
        this.ID = String.format("%04d", (total+1));
        this.name = name;
        this.position = position;
        this.department = department;
        total++;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(ID, employee.ID) && Objects.equals(name, employee.name) && position == employee.position && department == employee.department;
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, name, position, department);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", position=" + position +
                ", department=" + department +
                '}';
    }
}

