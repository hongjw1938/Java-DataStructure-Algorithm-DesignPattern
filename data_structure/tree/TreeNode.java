package com.data_structure.tree;

public class TreeNode {
    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;

    public TreeNode(int data){
        this.data = data;
    }

    public void insert(int value){
        // 중복 값을 insert하지 못하도록
        if(value == data){
            return;
        }

        if(value < data){
            // left 자식 노드가 없다면
            if(leftChild == null){
                leftChild = new TreeNode(value);
            } else {
                // left subTree에서 insert를 다시 호출출
               leftChild.insert(value);
            }
        } else {
            if(rightChild == null){
                rightChild = new TreeNode(value);
            } else {
                rightChild.insert(value);
            }
        }
    }

    public TreeNode get(int value){
        if(value == data){
            return this;
        }

        if(value < data){
            if(leftChild != null){
                return leftChild.get(value);
            }
        } else {
            if(rightChild != null){
                return rightChild.get(value);
            }
        }

        return null;
    }

    public int min(){
        // left Child가 더 이상 없다면 해당 노드가 최소
        if(leftChild == null){
            return data;
        } else {
            return leftChild.min();
        }
    }

    public int max(){
        // right Child가 더 이상 없다면 해당 노드가 최대
        if(rightChild == null){
            return data;
        } else {
            return rightChild.max();
        }
    }

    public void traverseInOrder(){
        if(leftChild != null){
            leftChild.traverseInOrder();
        }
        System.out.print(data + ", ");
        if(rightChild != null){
            rightChild.traverseInOrder();
        }
    }

    public void traversePreOder(){
        System.out.print(data + ", ");
        if(leftChild != null){
            leftChild.traversePreOder();
        }
        if(rightChild != null){
            rightChild.traversePreOder();
        }
    }

    public void traversePostOrder(){
        if(leftChild != null){
            leftChild.traversePostOrder();
        }
        if(rightChild != null){
            rightChild.traversePostOrder();
        }
        System.out.print(data + ", ");
    }


    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}
