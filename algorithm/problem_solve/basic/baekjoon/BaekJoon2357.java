package problem_solve.basic.baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon2357{
    static int[] arr = new int[100001];
    public static void main(String []args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        SegTree tree = new SegTree(n);
        StringBuilder sb = new StringBuilder();

        for(int i=1; i <= n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        tree.init(arr, 1, 1, n);

        for(int i=1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            Node target = tree.find(1, 1, n, a, b);
            sb.append(target.min).append(" ").append(target.max).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

    private static class SegTree{
        int size = 0;
        Node[] arr;
        int height;

        public SegTree(int n){
            this.height = (int)Math.ceil(Math.log(n) / Math.log(2));
            this.size = (int)Math.pow(2, height+1);

            this.arr = new Node[size];
        }

        public Node init(int nums[], int node_idx, int start, int end){
            if(start == end){
                Node newNode = new Node(nums[start], nums[start]);
                return this.arr[node_idx] = newNode;
            }
            int mid = (start+end)/2;
            Node leftChild = this.init(nums, node_idx*2, start, mid);
            Node rightChild = this.init(nums, node_idx*2+1, mid+1, end);

            int min = leftChild.min < rightChild.min ? leftChild.min : rightChild.min;
            int max = leftChild.max < rightChild.max ? rightChild.max : leftChild.max;

            Node newNode = new Node(min, max);
            return this.arr[node_idx] = newNode;
        }

        public Node find(int node_idx, int start, int end, int left, int right){
            if(left > end || right < start){
                return new Node(Integer.MAX_VALUE, Integer.MIN_VALUE);
            }
            if(left <= start && end <= right){
                return this.arr[node_idx];
            }

            int mid = (start+end)/2;
            Node leftChild = this.find(node_idx*2, start, mid, left, right);
            Node rightChild = this.find(node_idx*2+1, mid+1, end, left, right);

            int min = leftChild.min < rightChild.min ? leftChild.min : rightChild.min;
            int max = leftChild.max < rightChild.max ? rightChild.max : leftChild.max;

            return new Node(min, max);
        }
    }

    private static class Node{
        int min;
        int max;
        public Node(int min, int max){
            this.min = min;
            this.max = max;
        }
    }
}