package com.data_structure.hashTable;

import java.util.*;

public class ChallengeRemoveDupl {
    public static void main(String[] args){
        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee("Jane", "Jones", 123));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Mike", "Wilson", 45));
        employees.add(new Employee("Mary", "Smith", 5555));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Bill", "End", 3948));
        employees.add(new Employee("Jane", "Jones", 123));

        employees.forEach(e -> System.out.println(e));

        Map<Integer, Employee> employeeTable = new HashMap<>();
        ListIterator<Employee> iterator = employees.listIterator();

        List<Employee> remove = new ArrayList<>();

        while(iterator.hasNext()){
            Employee employee = iterator.next();
            if(employeeTable.containsKey(employee.getId())){
                remove.add(employee);

            } else {
                employeeTable.put(employee.getId(), employee);
            }
        }

        for(Employee employee : remove){
            employees.remove(employee);
        }

        System.out.println("----------------------");
        employees.forEach(e -> System.out.println(e));
    }
}
