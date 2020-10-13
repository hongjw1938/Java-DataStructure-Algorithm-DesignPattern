package problem_solve.basic.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon10868 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int nums[] = new int[n+1];
        for(int i=1; i <= n; i++){
            int num = Integer.parseInt(br.readLine());
            nums[i] = num;
        }

        SegmentTree tree = new SegmentTree(n);
        tree.init(nums, 1, 1, n);

        StringBuilder sb = new StringBuilder();
        for(int i=1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            int minVal = tree.getMin(1, 1, n, a, b);
            sb.append(minVal).append("\n");
        }

        System.out.println(sb);
        br.close();
    }

    private static class SegmentTree{
        int[] arr;
        int capacity;

        public SegmentTree(int n){
            int h = (int)Math.ceil(Math.log(n) / Math.log(2));
            this.capacity = (int)Math.pow(2, h+1);
            this.arr = new int[this.capacity];
        }

        public int init(int[] nums, int node_idx, int start, int end){
            if(start==end){
                return this.arr[node_idx] = nums[start];
            }
            return this.arr[node_idx] = Math.min(init(nums, node_idx*2, start, (start+end)/2),
                    init(nums, node_idx*2+1, (start+end)/2+1, end));
        }

        public int getMin(int node_idx, int start, int end, int left, int right){
            if(left > end || right < start){
                return Integer.MAX_VALUE;
            }

            if(left <= start && end <= right){
                return this.arr[node_idx];
            }

            return Math.min(getMin(node_idx*2, start, (start+end)/2, left, right),
                    getMin(node_idx*2+1, (start+end)/2+1, end, left, right));
        }
    }
}
