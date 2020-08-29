package com.data_structure.tree;

public class Main {
    public static void main(String[] args){
        BinarySearchTree intTree = new BinarySearchTree();
        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);
        intTree.insert(17);

        intTree.traversePreOrder();
        System.out.println();

//        System.out.println(intTree.get(27));
//        System.out.println(intTree.get(17));
//        System.out.println(intTree.get(8888));
//
//        System.out.println(intTree.min());
//        System.out.println(intTree.max());

        intTree.delete(15);
        intTree.traverseInOrder();
        System.out.println();

        intTree.delete(27);
        intTree.traverseInOrder();
        System.out.println();

        intTree.delete(8888);
        intTree.traverseInOrder();
        System.out.println();

    }


}
