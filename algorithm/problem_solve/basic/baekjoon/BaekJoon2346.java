package problem_solve.basic.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon2346{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        QueueImpl q = new QueueImpl(n);
        int i = 1;
        while(st.hasMoreTokens()){
            Node newNode = new Node(Integer.parseInt(st.nextToken()), i);
            q.addBack(newNode);
            i++;
        }
        StringBuilder sb = new StringBuilder();
        while(q.size > 1){
            Node curr = q.popFront();
            int t = curr.n > 0 ? curr.n-1 : curr.n;
            if(t < 0){
                while(t < 0){
                    q.addFront(q.popBack());
                    t++;
                }
            } else {
                while(t > 0){
                    q.addBack(q.popFront());
                    t--;
                }
            }
            sb.append(curr.number).append(" ");
        }
        sb.append(q.popFront().number);
        System.out.println(sb);
        br.close();
    }

    private static class QueueImpl{
        int size;
        Node head;
        Node tail;
        int capacity;

        public QueueImpl(int n){
            this.capacity = n;
        }

        public void addFront(Node node){
            if(isEmpty()){
                this.tail = node;
            } else {
                this.head.prev = node;
                node.next = this.head;
            }
            this.head = node;
            this.size++;
        }

        public void addBack(Node node){
            if(isEmpty()){
                this.head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }
            this.tail = node;
            this.size++;
        }

        public Node popFront(){
            Node retNode = this.head;
            if(this.size > 1){
                this.head = this.head.next;
                this.head.prev = null;
            } else {
                this.head = null;
                this.tail = null;
            }
            this.size--;
            return retNode;
        }

        public Node popBack(){
            Node retNode = this.tail;
            if(this.size > 1){
                this.tail = this.tail.prev;
                this.tail.next = null;
            } else {
                this.head = null;
                this.tail = null;
            }
            this.size--;
            return retNode;
        }

        public boolean isEmpty(){
            return this.size==0;
        }
    }

    private static class Node{
        int n;
        int number;
        Node prev;
        Node next;
        public Node(int n, int number){
            this.n = n;
            this.number = number;
        }
    }
}