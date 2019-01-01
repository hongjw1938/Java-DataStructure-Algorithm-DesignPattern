package com.datastructure.hashtable;

public class Main {
    public static void main(String[] args){
        Employee employee = new Employee("Jane", "Jones", 12);
        Employee employee1 = new Employee("John", "Doe", 23);
        Employee employee2 = new Employee("Mary", "Smith", 25);
        Employee employee3 = new Employee("Mike","Wilson", 32);
        Employee employee4 = new Employee("Bill", "End", 64);

        ArrayBackedHashTable ht = new ArrayBackedHashTable();
        ht.put(employee.getLastName(), employee);
        ht.put(employee1.getLastName(), employee1);
        ht.put(employee2.getLastName(), employee2);
        ht.put(employee3.getLastName(), employee3);
        ht.put(employee4.getLastName(), employee4);

        ht.remove(employee2.getLastName());
        ht.remove(employee3.getLastName());
        ht.printHashtable();

        System.out.println("Retrieve key Wilson : " + ht.get(employee3.getLastName()));
    }
}
