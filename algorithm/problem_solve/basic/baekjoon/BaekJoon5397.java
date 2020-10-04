package problem_solve.basic.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon5397 {
    public static void  main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i < t; i++){
            String keyLogger = br.readLine();

            QueueImpl pre_q = new QueueImpl();
            QueueImpl post_q = new QueueImpl();
            for(int j=0; j < keyLogger.length(); j++){
                char c = keyLogger.charAt(j);
                if(c == '<'){
                    if(pre_q.isEmpty()){
                        continue;
                    } else {
                        post_q.addFirst(pre_q.popLast().c);
                    }
                } else if(c == '>'){
                    if(post_q.isEmpty()){
                        continue;
                    } else {
                        pre_q.addLast(post_q.popFirst().c);
                    }
                } else if(c == '-'){
                    if(pre_q.isEmpty()){
                        continue;
                    } else {
                        pre_q.popLast();
                    }
                } else {
                    pre_q.addLast(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            while(!pre_q.isEmpty()){
                sb.append(pre_q.popFirst().c);
            }
            while(!post_q.isEmpty()){
                sb.append(post_q.popFirst().c);
            }
            System.out.println(sb);
        }

        br.close();
    }

    private static class QueueImpl{
        Node head;
        Node tail;
        int size = 0;

        public void addFirst(char c){
            Node newNode = new Node(c);
            if(this.size == 0){
                this.tail = newNode;
            } else {
                this.head.prev = newNode;
                newNode.next = this.head;
            }
            this.head = newNode;
            this.size++;
        }

        public void addLast(char c){
            Node newNode = new Node(c);
            if(this.size == 0){
                this.head = newNode;
            } else {
                this.tail.next = newNode;
                newNode.prev = this.tail;
            }
            this.tail = newNode;
            this.size++;
        }

        public Node popFirst(){
            Node retNode = this.head;
            if(isEmpty()){
                throw new NullPointerException();
            }

            if(this.size > 1){
                retNode.next.prev = null;
                this.head = retNode.next;
            } else {
                this.head = null;
                this.tail = null;
            }

            size--;
            return retNode;
        }

        public Node popLast(){
            Node retNode = this.tail;
            if(isEmpty()){
                throw new NullPointerException();
            }

            if(this.size > 1){
                retNode.prev.next = null;
                this.tail = retNode.prev;
            } else {
                this.head = null;
                this.tail = null;
            }
            size--;
            return retNode;
        }

        public boolean isEmpty(){
            return this.size==0;
        }
    }
    private static class Node{
        char c;
        Node next;
        Node prev;
        public Node(char c){
            this.c = c;
        }
    }
}