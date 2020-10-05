package problem_solve.basic.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon11286 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        HeapImpl heap = new HeapImpl();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < n; i++){
            int x = Integer.parseInt(br.readLine());
            if(x == 0){
                if(heap.isEmpty()){
                    sb.append(0).append("\n");
                } else {
                    sb.append(heap.pop().num).append("\n");
                }
            } else {
                heap.add(x);
            }
        }
        System.out.println(sb);
        br.close();
    }

    private static class HeapImpl{
        int size = 0;
        int capacity = 100001;
        int lastIndex = 0;
        Node[] arr = new Node[this.capacity];

        public void add(int num){
            Node newNode = new Node(num);
            arr[++lastIndex] = newNode;
            aboveHeapify();
            size++;
        }

        public void aboveHeapify(){
            int currentIdx = this.lastIndex;
            Node current = this.arr[currentIdx];
            while(currentIdx > 1){
                Node parent = this.arr[currentIdx/2];
                if((parent.abs > current.abs) || (parent.abs == current.abs && parent.num > current.num)){
                    this.arr[currentIdx] = parent;
                } else {
                    break;
                }

                currentIdx /= 2;
            }
            this.arr[currentIdx] = current;
        }

        public Node pop(){
            Node retNode = this.arr[1];
            belowHeapify();

            size--;
            return retNode;
        }

        public void belowHeapify(){
            this.arr[1] = this.arr[lastIndex];
            this.arr[lastIndex] = null;
            lastIndex--;

            int currentIdx = 1;


            Node current = this.arr[currentIdx];
            while(currentIdx <= lastIndex){
                int leftIndex = currentIdx * 2;
                int rightIndex = currentIdx * 2 + 1;

                if(leftIndex > lastIndex){
                    break;
                }

                Node leftChild = this.arr[leftIndex];
                Node rightChild = this.arr[rightIndex];

                Node compareChild = rightChild == null ? leftChild : compare(leftChild, rightChild);
                int compareIdx = compareChild.equals(leftChild) ? leftIndex : rightIndex;
                if(current.abs > compareChild.abs || (current.abs == compareChild.abs && current.num > compareChild.num)){
                    this.arr[currentIdx] = compareChild;
                    this.arr[compareIdx] = current;
                }
                currentIdx = compareIdx;
            }
        }

        public Node compare(Node left, Node right){
            Node retNode = null;
            if(left.abs < right.abs){
                retNode = left;
            } else if(left.abs > right.abs){
                retNode = right;
            } else {
                if(left.num < right.num){
                    retNode = left;
                } else {
                    retNode = right;
                }
            }
            return retNode;
        }

        public boolean isEmpty(){
            return this.size == 0;
        }
    }

    private static class Node{
        int num;
        int abs;
        public Node(int num){
            this.num = num;
            this.abs = num < 0 ? num * -1 : num;
        }
    }
}
