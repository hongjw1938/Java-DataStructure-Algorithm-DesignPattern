package problem_solve.basic.baekjoon;

import java.io.*;
import java.util.*;
public class BaekJoon1302 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PQ pq = new PQ();

        Map<String, Integer> map = new HashMap<>();
        for(int i=0; i < n; i++){
            String str = br.readLine();
            if(!map.containsKey(str)){
                map.put(str, 1);
            } else {
                int a = map.get(str)+1;
                map.replace(str, a);
            }
        }

        for(Map.Entry<String, Integer> entry : map.entrySet()){
            Node newNode = new Node(entry.getKey(), entry.getValue());
            pq.add(newNode);
        }

        PriorityQueue<String> pq2 = new PriorityQueue<>();
        int num = pq.peek().n;
        while(!pq.isEmpty() && pq.peek().n == num){
            pq2.add(pq.pop().str);
        }
        System.out.println(pq2.poll());
        br.close();
    }

    private static class Node implements Comparable<Node>{
        String str;
        int n;
        public Node(String str, int n){
            this.str = str;
            this.n = n;
        }

        @Override
        public int compareTo(Node node){
            return this.n - node.n;
        }
    }
    private static class PQ{
        Node[] arr = new Node[1001];
        int size = 0;
        int lastIndex = 0;

        public void add(Node node){
            arr[++lastIndex] = node;
            aboveHeapify();
            size++;
        }

        public boolean isEmpty(){
            return this.size == 0;
        }

        public void aboveHeapify(){
            Node replace = arr[lastIndex];

            int current = lastIndex;
            while(current > 1 && arr[current / 2].compareTo(replace) < 0){
                arr[current] = arr[current/2];
                current /= 2;
            }
            arr[current] = replace;
        }

        public Node pop(){
            Node ret = arr[1];
            arr[1] = arr[lastIndex--];
            belowHeapify();
            this.size--;
            return ret;
        }

        public Node peek(){
            return this.arr[1];
        }

        public void belowHeapify(){
            Node replace = arr[1];

            int current = 1;
            while(current <= lastIndex){
                int leftIdx = current * 2;
                int rightIdx = current * 2 + 1;
                if(leftIdx > lastIndex){
                    break;
                }

                int swapIdx = 0;
                Node swapChild = null;
                if(rightIdx > lastIndex){
                    Node leftChild = arr[leftIdx];
                    if(replace.compareTo(leftChild) < 0){
                        swapChild = leftChild;
                        swapIdx = leftIdx;
                    }
                } else {
                    Node leftChild = arr[leftIdx];
                    Node rightChild = arr[rightIdx];

                    Node targetChild = leftChild.compareTo(rightChild) > 0 ? leftChild : rightChild;
                    int targetIdx = leftChild.compareTo(rightChild) > 0 ? leftIdx : rightIdx;

                    if(replace.compareTo(targetChild) < 0){
                        swapIdx = targetIdx;
                        swapChild = targetChild;
                    }
                }
                if(swapIdx != 0){
                    arr[swapIdx] = replace;
                    arr[current] = swapChild;
                    current = swapIdx;
                } else {
                    break;
                }
            }
        }
    }
}
