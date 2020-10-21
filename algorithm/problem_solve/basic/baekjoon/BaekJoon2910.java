package problem_solve.basic.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2910 {
    static Node[] array = new Node[1000000001];
    static ListImpl[] list = new ListImpl[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int order = 1;
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            if(array[num] == null){
                Node newNode = new Node(num, order++, 1);
                array[num] = newNode;
                list[1].add(newNode);
            } else {
                int count = array[num].count++;
                list[count+1].add(list[count].pop(num));
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i=1; i <= n; i++){
            if(list[i] == null || list[i].size == 0){
                continue;
            }
            while(!list[i].isEmpty()){
                Node curr = list[i].popFirst();
                int count = curr.count;
                int num = curr.number;
                for(int j=0; j < count; j++){
                    sb.append(num).append(" ");
                }
            }
        }
        System.out.println(sb);

        br.close();
    }

    private static class ListImpl{
        Node head;
        Node tail;
        int size;

        public void add(Node node){
            if(this.isEmpty()){
                this.head = node;
                this.tail = node;
            } else{
                Node current = this.head;
                while(current.count < node.count){
                    if(current.next == null){
                        current.next = node;
                        this.tail = node;
                    }
                    current = current.next;
                }
                node.prev = current.prev.next;
                current.prev.next = node;
                current.prev = node;
                node.next = current;
            }
            this.size++;
        }

        public Node get(int number){
            Node current = this.head;
            while(current.number != number){
                current = current.next;
            }
            return current;
        }

        public Node pop(int number){
            Node match = this.get(number);
            if(this.tail.equals(match)){
                if(match.prev != null){
                    match.prev.next = null;
                    this.tail = match.prev;
                } else {
                    this.head = null;
                    this.tail = null;
                }
            } else if(this.head.equals(match)){
                if(match.next != null){
                    match.next.prev = null;
                    this.head = match.next;
                } else {
                    this.head = null;
                    this.tail = null;
                }
            } else {
                Node next = match.next;
                match.prev.next = match.next;
                next.prev = match.prev;
            }
            this.size--;
            return match;
        }

        public Node popFirst(){
            Node retNode = this.head;
            if(retNode.next == null){
                this.head = null;
            } else {
                this.head = retNode.next;
                retNode.next.prev = null;
            }
            this.size--;
            return retNode;
        }

        public boolean isEmpty(){
            return this.size == 0;
        }
    }

    private static class Node{
        int number;
        int order;
        int count;
        Node next;
        Node prev;

        public Node(int number, int order, int count){
            this.number = number;
            this.order = order;
            this.count = count;
        }

    }
}
