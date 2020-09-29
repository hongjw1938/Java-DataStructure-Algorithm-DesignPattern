package problem_solve.basic.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon5430 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for(int i=0; i < t; i++){
            String inst = br.readLine();
            int leng = Integer.parseInt(br.readLine());
            String array = br.readLine();
            array = array.substring(1, array.length()-1);

            StringTokenizer st = new StringTokenizer(array, ",");

            LinkedListImpl list = new LinkedListImpl();
            while(st.hasMoreTokens()){
                list.add(Integer.parseInt(st.nextToken()));
            }

            int r = 0;
            boolean isError = false;
            for(int k=0; k < inst.length(); k++){
                char c = inst.charAt(k);
                if(c == 'R'){
                    r++;
                } else {
                    if(list.isEmpty()) {
                        isError = true;
                        break;
                    }
                    if(r % 2 == 0){
                        list.popFirst();
                    } else {
                        list.popBack();
                    }
                }
            }
            if(isError){
                sb.append("error\n");
            } else {
                sb.append("[");
                while(list.size > 1){
                    sb.append(r%2 == 0 ? list.popFirst().num : list.popBack().num);
                    sb.append(",");
                }
                if(!list.isEmpty()){
                    sb.append(r%2 == 0 ? list.popFirst().num : list.popBack().num);
                }
                sb.append("]\n");
            }
        }

        System.out.println(sb);
        br.close();
    }

    static class LinkedListImpl{
        int size = 0;
        Node head;
        Node tail;

        public void add(int num){
            Node node = new Node(num);
            if(isEmpty()){
                head = node;
            } else {
                tail.next = node;
                node.prev = tail;
            }
            tail = node;
            size++;
        }

        public Node popFirst(){
            Node retNode = head;
            if(size > 1){
                head.next.prev = null;
                head = head.next;
            }

            size--;
            return retNode;
        }

        public Node popBack(){
            Node retNode = tail;
            if(size > 1){
                tail.prev.next = null;
                tail = tail.prev;
            }

            size--;
            return retNode;
        }

        public boolean isEmpty(){
            return size == 0;
        }
    }
    static class Node{
        int num;
        Node prev;
        Node next;
        public Node(int num){
            this.num = num;
        }
    }
}
/*
4
RDD
4
[1,2,3,4]
D
1
[42]
RRD
6
[1,1,2,3,5,8]
D
0
[]

1
DRD
2
[1,3]
*/