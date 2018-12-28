package com.datastructure.list;

public class EmployeeDoublyLinkedList {
    private DLEmployeeNode head;
    private DLEmployeeNode tail;
    private int size;

    // head node 추가
    public void addToFront(Employee employee){
        DLEmployeeNode node = new DLEmployeeNode(employee);

        // 비어있다면
        if(head == null){
            tail = node;

            // 이미 Element가 들어있었다면
        } else {
            head.setPrevious(node);
            node.setNext(head);
        }

        head = node;
        size++;
    }

    // head node 제거
    public DLEmployeeNode removeFromFront(){
        if(isEmpty()){
            return null;
        }
        DLEmployeeNode removedNode = head;

        // 노드가 하나라면
        if(head.getNext() == null){
            tail = null;
            // 노드가 2개 이상이면
        } else {
            head.getNext().setPrevious(null);
        }
        head = head.getNext();
        size--;
        // 해당 노드 isolating
        removedNode.setNext(null);
        return removedNode;
    }

    //tail에 node 추가
    public void addToEnd(Employee employee){
        DLEmployeeNode node = new DLEmployeeNode(employee);
        if(tail == null){
            head = node;
        } else {
            tail.setNext(node);
            node.setPrevious(tail);
        }

        tail = node;
        size++;
    }

    // tail의 node 제거
    public DLEmployeeNode removeFromEnd(){
        if(isEmpty()){
            return null;
        }

        DLEmployeeNode removedNode = tail;
        // node가 한 개
        if(tail.getPrevious() == null){
            head = null;
        } else {
            tail.getPrevious().setNext(null);
        }
        tail = tail.getPrevious();
        size--;
        // isolating
        removedNode.setPrevious(null);
        return removedNode;
    }

    public int getSize(){
        return this.size;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void printList(){
        DLEmployeeNode current = head;
        System.out.print("Head -> ");
        while(current != null){
            System.out.print(current);
            System.out.print(" <-> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
}
