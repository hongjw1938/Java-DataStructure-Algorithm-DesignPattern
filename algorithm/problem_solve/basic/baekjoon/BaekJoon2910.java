package problem_solve.basic.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class BaekJoon2910 {
    static ListImpl[] list = new ListImpl[1001];
    static Map<Integer, Node> map = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int order = 1;
        while(st.hasMoreTokens()){
            int num = Integer.parseInt(st.nextToken());
            if(map.containsKey(num)){
                Node node = map.get(num);
                node.count++;
                map.put(num, node);
            } else {
                Node newNode = new Node(num, order++, 1);
                map.put(num, newNode);
            }
        }

        for(Map.Entry<Integer, Node> entry : map.entrySet()){
            int count = entry.getValue().count;
            if(list[count] == null){
                list[count] = new ListImpl();
            }
            list[count].add(entry.getValue());
        }

        StringBuilder sb = new StringBuilder();
        for(int i=n; i >= 1; i--){
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
                while(current.order < node.order){
                    if(current.next == null){
                        current.next = node;
                        node.prev = current;
                        this.tail = node;
                        this.size++;
                        return;
                    }
                    current = current.next;
                }
                if(current.equals(this.head)){
                    current.prev = node;
                    node.next = current;
                    this.head = node;
                } else {
                    node.prev = current.prev;
                    current.prev.next = node;
                    current.prev = node;
                    node.next = current;
                }
            }
            this.size++;
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
