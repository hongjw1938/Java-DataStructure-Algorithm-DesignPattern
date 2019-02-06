package com.datastructure.stack;

public class Main {
    public static void main(String[] args){
//        ArrayBackedStack stack = new ArrayBackedStack(10);

        LinkedListBackedStack stack = new LinkedListBackedStack();
        stack.push(new Employee("Jane", "Jones", 12));
        stack.push(new Employee("John", "Doe", 23));
        stack.push(new Employee("Mary", "Smith", 25));
        stack.push(new Employee("Mike","Wilson", 32));
        stack.push(new Employee("Bill", "End", 64));

        System.out.println(stack.peek());
        stack.printStack();

        System.out.println("Popped : " + stack.pop());
        System.out.println(stack.peek());
    }
}
