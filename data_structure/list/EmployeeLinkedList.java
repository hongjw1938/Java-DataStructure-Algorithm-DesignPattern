package com.data_structure.list;

public class EmployeeLinkedList {
    private EmployeeNode head;
    private int size;

    // head node 추가
    public void addToFront(Employee employee){
        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        head = node;
        size++;
    }

    // head node 제거
    public EmployeeNode removeFromFront(){
        if(isEmpty()){
            return null;
        }
        EmployeeNode removedNode = head;
        head = head.getNext();
        size--;
        // 해당 노드 isolating
        removedNode.setNext(null);
        return removedNode;
    }

    public int getSize(){
        return this.size;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public void printList(){
        EmployeeNode current = head;
        System.out.print("Head -> ");
        while(current != null){
            System.out.print(current);
            System.out.print(" -> ");
            current = current.getNext();
        }
        System.out.println("null");
    }
}
