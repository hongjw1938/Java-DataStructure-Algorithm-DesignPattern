package problem_solve.basic.baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2161 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        QueueImpl q = new QueueImpl();
        for(int i=1; i <= n; i++){
            q.add(i);
        }

        int i = 0;
        while(!q.isEmpty()){
            if(i % 2 == 0){
               sb.append(q.pop().n).append(" ");
            } else {
                q.add(q.pop().n);
            }
            i++;
        }
        System.out.println(sb);
        br.close();
    }

    private static class QueueImpl{
        Node head;
        Node tail;
        int size = 0;

        public void add(int n){
            Node node = new Node(n);
            if(this.isEmpty()){
                head = node;
            } else {
                this.tail.next = node;
                node.prev = this.tail;
            }
            this.tail = node;
            this.size++;
        }

        public Node pop(){
            Node ret = this.head;

            if(this.size > 1){
                ret.next.prev = null;
                this.head = ret.next;
            } else {
                this.head = null;
                this.tail = null;
            }

            this.size--;
            return ret;
        }

        public boolean isEmpty(){
            return this.size == 0;
        }
    }

    private static class Node{
        int n;
        Node next;
        Node prev;

        public Node(int n){
            this.n = n;
        }
    }
}
