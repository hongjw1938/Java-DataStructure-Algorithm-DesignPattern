package com.datastructure.list;

import java.util.List;

public class Vector {
    public static void main(String[] args){
        List<Employee> employeeList = new java.util.Vector<>();
        employeeList.add(new Employee("Jane", "Jones", 123));
        employeeList.add(new Employee("John", "Doe", 4567));
        employeeList.add(new Employee("Mary", "Smith", 22));
        employeeList.add(new Employee("Mike", "Wilson", 3245));

        employeeList.forEach(employee -> System.out.println(employee));
    }
}
