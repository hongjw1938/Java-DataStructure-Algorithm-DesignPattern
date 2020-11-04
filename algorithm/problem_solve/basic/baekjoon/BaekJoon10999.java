package problem_solve.basic.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon10999{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        long nums[] = new long[n+1];
        for(int i=1; i <= n; i++){
            nums[i] = Long.parseLong(br.readLine());
        }
        SegTree tree = new SegTree(n);
        tree.init(nums, 1, 1, n);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < m+k; i++){
            st = new StringTokenizer(br.readLine());
            if(Long.parseLong(st.nextToken()) == 1){
                int idx1 = Integer.parseInt(st.nextToken());
                int idx2 = Integer.parseInt(st.nextToken());
                Long diff = Long.parseLong(st.nextToken());

                tree.update(1, 1, n, idx1, idx2, diff);
            } else {
                int left = Integer.parseInt(st.nextToken());
                int right = Integer.parseInt(st.nextToken());
                long result = tree.sum(1, 1, n, left, right);
                sb.append(result).append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }

    private static class SegTree{
        int size;
        long[] tree;
        long[] lazy;

        public SegTree(int n){
            int h = (int) Math.ceil(Math.log(n) / Math.log(2));
            this.size = (int)Math.pow(2, h+1);
            this.tree = new long[size];
            this.lazy = new long[size];
        }

        public long init(long[] nums, int node_idx, int start, int end){
            if(start == end){
                return tree[node_idx] = nums[start];
            }
            int mid = (start+end)/2;
            return tree[node_idx] = init(nums, node_idx*2, start, mid) +
                    init(nums, node_idx*2+1, mid+1, end);
        }

        private void lazy_update(int node_idx, int start, int end){
            if(lazy[node_idx] == 0){
                return;
            }

            tree[node_idx] += ((end - start +1) * lazy[node_idx]);
            if(end != start){
                lazy[node_idx * 2] += lazy[node_idx];
                lazy[node_idx * 2 + 1] += lazy[node_idx];
            }
            lazy[node_idx] = 0;
        }
        public void update(int node_idx, int start, int end, int left, int right, long diff){
            lazy_update(node_idx, start, end);
            if(right < start || left > end){
                return;
            }

            if(left <= start && end <= right){
                lazy[node_idx] += diff;
                lazy_update(node_idx, start, end);
                return;
            }
            update(node_idx * 2, start, (start+end)/2, left, right, diff);
            update(node_idx*2+1, (start+end)/2+1, end, left, right, diff);
            tree[node_idx] = tree[node_idx * 2] + tree[node_idx*2+1];
        }

        public long sum(int node_idx, int start, int end, int left, int right){
            lazy_update(node_idx, start, end);
            if(left > end || right < start){
                return 0;
            }

            if(left <= start && end <= right){
                return tree[node_idx];
            }

            return sum(node_idx*2, start, (start+end)/2, left, right) +
                    sum(node_idx*2+1, (start+end)/2+1, end, left, right);
        }
    }
}