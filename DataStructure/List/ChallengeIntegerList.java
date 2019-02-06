package com.datastructure.list;

public class ChallengeIntegerList {
    public static void main(String[] args) {
        // 도전과제 2
        // 아래의 Integer 들이 입력되는데 순서대로 node가 정렬되도록 할 것
        Integer one = 1;
        Integer two = 2;
        Integer three = 3;
        Integer four = 4;

        IntegerLinkedList list = new IntegerLinkedList();
        list.insertSorted(three);
        list.printList();
        list.insertSorted(two);
        list.printList();
        list.insertSorted(one);
        list.printList();
        list.insertSorted(four);
        list.printList();
    }
}
