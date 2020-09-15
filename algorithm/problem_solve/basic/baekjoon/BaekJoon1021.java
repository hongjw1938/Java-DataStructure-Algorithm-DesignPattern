package problem_solve.basic.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1021 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        CircularQueue q = new CircularQueue();
        for(int i=1; i <= n; i++){
            q.add(i);
        }

        st = new StringTokenizer(br.readLine());
        int ans = 0;

        for(int i=0; i < m; i++){
            int idx = Integer.parseInt(st.nextToken());
            if(q.head.idx == idx){
                q.pop();
                continue;
            }

            int left = 0;
            Node current = q.head;
            while(current.idx != idx){
                current = current.next;
                left++;
            }

            int right = q.size - left;

            if(left <= right){
                ans += left;
                while(q.head.idx != idx){
                    q.leftRotate();
                }
            } else {
                ans += right;
                while(q.head.idx != idx){
                    q.rightRotate();
                }
            }
            q.pop();
        }

        System.out.println(ans);
        br.close();
    }

    static class CircularQueue{
        int size=0;
        Node head;
        Node tail;

        public void add(int idx){
            Node newNode = new Node(idx);

            newNode.next = head;
            newNode.prev = tail;
            if(size == 0){
                head = newNode;
                tail = newNode;
            } else {
                head.prev = newNode;
                tail.next = newNode;

                tail = newNode;
            }

            size++;
        }

        public Node pop(){
            if(size == 0){
                throw new NullPointerException();
            }
            Node retNode = head;
            head = retNode.next;

            if(size > 1){
                head.prev = tail;
                tail.next = head;
            }

            size--;
            return retNode;
        }

        public void leftRotate(){
            tail = head;
            head = head.next;
        }

        public void rightRotate(){
            head = tail;
            tail = tail.prev;
        }
    }

    static class Node{
        int idx;
        Node prev;
        Node next;

        public Node(int idx){
            this.idx = idx;
        }
    }
}
