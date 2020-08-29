package com.datastructure.list;

import java.util.Iterator;
import java.util.LinkedList;

public class LinkedListJDK {
    public static void main(String[] args){
        Employee employee = new Employee("John", "Doe", 4567);
        Employee employee2 = new Employee("Mary", "Smith", 22);
        Employee employee3 = new Employee("Jane", "Jones", 123);
        Employee employee4 = new Employee("Mike", "Wilson", 3245);
        Employee employee5 = new Employee("Bill", "End", 66);

        LinkedList<Employee> list = new LinkedList<>();
        list.addFirst(employee);
        list.addFirst(employee2);
        list.addFirst(employee3);
        list.addFirst(employee4);
        // 마지막에 추가됨. addLast로 해도 동일
        list.add(employee5);

        // 첫 node 제거
        list.removeFirst();

        // 마지막 node 제거
        list.removeLast();
        Iterator iter = list.iterator();

        System.out.print("HEAD -> ");
        while(iter.hasNext()){
            System.out.print(iter.next());
            System.out.print(" <-> ");
        }
        System.out.println("null");
//        for(Employee employees : list){
//            System.out.println(employees);
//        }
    }
}
