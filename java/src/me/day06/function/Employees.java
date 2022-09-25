package me.day06.function;

import me.day06.enums.Department;
import me.day06.enums.Employee;
import me.day06.enums.Position;

import java.util.Arrays;

public class Employees {
    public static final int NUM_EMPLOYEE = 30;
    Employee[] employees = new Employee[NUM_EMPLOYEE];

    public Employees() {
        initialize();
    }
    public void initialize() {
        for (int i = 0; i < employees.length; i++) {
            employees[i] = new Employee();
        }
    }
    public void random() {
        for (int i = 0; i < employees.length; i++) {
            int randomPosition = (int)(Math.random() * Position.values().length);
            int randomDepartment = (int)(Math.random() * Department.values().length);

            employees[i].setName(Character.toString((char) ((i) % ('z'-'a' + 1) + 'a')));
            employees[i].setPosition(Position.values()[randomPosition]);
            employees[i].setDepartment(Department.values()[randomDepartment]);
        }
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employees employees1 = (Employees) o;
        return Arrays.equals(employees, employees1.employees);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(employees);
    }

    @Override
    public String toString() {
        return "Employees{" +
                "employees=" + Arrays.toString(employees) +
                '}';
    }

    public Position findPositionNameWithMostPeople() {
        int[] counts = new int[Position.values().length]; // 중복은 없다고 가정

        for (Employee employee: employees) {
            if (employee.getPosition() != null) {
                counts[employee.getPosition().ordinal()]++;
            }
        }
        int maxValue = -1;
        int maxIndex = -1;
        for (int i = 0; i < counts.length; i++) {
            if (maxValue < counts[i]) {
                maxValue = counts[i];
                maxIndex = i;
            }
        }
        return Position.values()[maxIndex];
    }

    public Department findDepartmentNameWithMostPeople() {
        int[] counts = new int[Department.values().length]; // 중복은 없다고 가정

        for (Employee employee: employees) {
            if (employee.getDepartment() != null) {
                counts[employee.getDepartment().ordinal()]++;
            }
        }
        int maxValue = -1;
        int maxIndex = -1;
        for (int i = 0; i < counts.length; i++) {
            if (maxValue < counts[i]) {
                maxValue = counts[i];
                maxIndex = i;
            }
        }
        return Department.values()[maxIndex];
    }
}
