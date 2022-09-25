package me.day06.function;

import me.day06.enums.Employee;
import me.day06.enums.Department;
import me.day06.enums.Position;

public class StaticFunctionExample {
    public static final int NUM_EMPLOYEE = 30;
    public static void main(String[] args) {
        Employee[] employees = new Employee[NUM_EMPLOYEE];


        for (int i = 0; i < employees.length; i++) {
            int randomPosition = (int)(Math.random() * Position.values().length);
            int randomDepartment = (int)(Math.random() * Department.values().length);

            employees[i] = new Employee(
                    Character.toString((char)((i) % ('z'-'a' + 1) + 'a')),
                    Position.values()[randomPosition],
                    Department.values()[randomDepartment]);
        }
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }

        Position mostPosition = findPositionNameWithMostPeople(employees);
        Department mostDepartment = findDepartmentNameWithMostPeople(employees);
        System.out.println("mostPosition = " + mostPosition);
        System.out.println("mostDepartment = " + mostDepartment);
    }
    public static Position findPositionNameWithMostPeople(Employee[] employees) {
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

    public static Department findDepartmentNameWithMostPeople(Employee[] employees) {
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
