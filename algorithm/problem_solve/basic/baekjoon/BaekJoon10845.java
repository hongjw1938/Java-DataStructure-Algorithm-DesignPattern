package problem_solve.basic.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon10845 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Queue q = new Queue();

        StringBuilder sb = new StringBuilder();
        for(int i=0; i < N; i++){
            String[] line = br.readLine().split(" ");
            if(line[0].equals("push")){
                q.push(Integer.parseInt(line[1]));
            } else if(line[0].equals("pop")){
                sb.append(q.pop() + "\n");
            } else if(line[0].equals("size")){
                sb.append(q.size + "\n");
            } else if(line[0].equals("empty")){
                sb.append(q.empty() + "\n");
            } else if(line[0].equals("front")){
                sb.append(q.front() + "\n");
            } else {
                sb.append(q.back() + "\n");
            }
        }
        System.out.println(sb);
        br.close();
    }

    static class Queue{
        private int size;
        private Node front;
        private Node back;

        public Queue(){
            this.size = 0;
        }

        public void push(int val){
            Node node = new Node(val);
            if(size == 0){
                front = node;
                back = node;
            } else if(size == 1){
                front.setNext(node);
                back = node;
                back.setPrevious(front);
            } else {
                node.setPrevious(back);
                back = node;
                back.getPrevious().setNext(node);
            }
            size++;
        }
        public int pop(){
            int ret_val;
            if(size == 0){
                ret_val = -1;
            } else if(size == 1){
                ret_val = front.getValue();
                front = null;
                back = null;
                size--;
            } else {
                ret_val = front.getValue();
                front = front.getNext();
                size--;
            }

            return ret_val;
        }
        public int size(){
            return size;
        }
        public int empty(){
            if(size == 0){
                return 1;
            } else {
                return 0;
            }
        }
        public int front(){
            if(size == 0){
                return -1;
            }
            return front.getValue();
        }
        public int back(){
            if(size == 0){
                return -1;
            }
            return back.getValue();
        }
    }

    static class Node{
        private int element;
        private Node next;
        private Node previous;

        public Node(int val){
            this.element = val;
        }
        public int getValue(){
            return element;
        }

        public void setValue(int value){
            this.element = value;
        }

        public Node getNext(){
            return next;
        }
        public void setNext(Node next){
            this.next = next;
        }

        public Node getPrevious() { return previous; }
        public void setPrevious(Node previous) { this.previous = previous; }
    }
}