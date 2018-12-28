package com.datastructure.list;

import java.util.LinkedList;
import java.util.List;

public class SinglyLinkedList {
    public static void main(String[] args){

        Employee employee = new Employee("John", "Doe", 4567);
        Employee employee2 = new Employee("Mary", "Smith", 22);
        Employee employee3 = new Employee("Jane", "Jones", 123);
        Employee employee4 = new Employee("Mike", "Wilson", 3245);

        EmployeeLinkedList list = new EmployeeLinkedList();
        list.addToFront(employee);
        list.addToFront(employee2);
        list.addToFront(employee3);
        list.addToFront(employee4);

        System.out.println(list.getSize());
        list.printList();

        list.removeFromFront();
        System.out.println(list.getSize());
        list.printList();
    }
}
