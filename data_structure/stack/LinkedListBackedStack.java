package com.data_structure.stack;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedListBackedStack {

    // 실제 LinkedList를 기반으로 만들 것이므로 이 class를 사용
    private LinkedList<Employee> stack;

    public LinkedListBackedStack(){
        // 이는 기본적으로 양방향 연결리스트임. 따라서, 메모리에 이슈가 있을 수 있거나
        // 다른 방식을 선호한다면 ArrayDeque를 사용하거나 다른 방법을 찾을 것.
        stack = new LinkedList<>();
    }

    public void push(Employee employee){
        stack.push(employee);
    }

    public Employee pop(){
        return stack.pop();
    }

    public Employee peek(){
        return stack.peek();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public void printStack(){
        ListIterator<Employee> iterator = stack.listIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
