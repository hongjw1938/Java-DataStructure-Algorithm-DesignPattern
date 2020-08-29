package com.data_structure.queue;

public class Main {
    public static void main(String[] args){
        Employee employee = new Employee("Jane", "Jones", 12);
        Employee employee1 = new Employee("John", "Doe", 23);
        Employee employee2 = new Employee("Mary", "Smith", 25);
        Employee employee3 = new Employee("Mike","Wilson", 32);
        Employee employee4 = new Employee("Bill", "End", 64);


        ArrayBackedQueue queue = new ArrayBackedQueue(5);
        queue.add(employee);
        queue.add(employee2);
        queue.remove();
        queue.add(employee2);
        queue.remove();
        queue.add(employee3);
        queue.remove();
        queue.add(employee4);

    }
}
