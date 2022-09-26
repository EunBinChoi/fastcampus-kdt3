package me.day06.function;

import me.day06.enums.Department;
import me.day06.enums.Employee;
import me.day06.enums.Position;

public class InstanceFunctionExample {
    public static void main(String[] args) {
        Employees employees = new Employees();
        employees.random();
        System.out.println(employees);
        Position mostPosition = employees.findPositionNameWithMostPeople();
        Department mostDepartment = employees.findDepartmentNameWithMostPeople();
        System.out.println("mostPosition = " + mostPosition);
        System.out.println("mostDepartment = " + mostDepartment);
    }
}
