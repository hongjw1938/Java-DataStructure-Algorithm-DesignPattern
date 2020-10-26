package problem_solve.basic.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon12837 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        SegTree tree = new SegTree(n);
        StringBuilder sb = new StringBuilder();
        for(int i=0; i < q; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            if(a == 1){
                tree.update(1,1, n, p, x);
            } else {
                sb.append(tree.sum(1, 1, n, p, x)).append("\n");
            }
        }
        System.out.println(sb);
        br.close();
    }

    private static class SegTree{
        long tree[];
        int size = 0;

        public SegTree(int size){
            int h = (int) Math.ceil(Math.log(size) / Math.log(2));
            this.size = (int)Math.pow(2, h+1);
            this.tree = new long[this.size];
        }

        public long init(int[] nums, int node_idx, int start, int end){
            if(start == end){
                return this.tree[node_idx] = nums[start];
            }
            return this.tree[node_idx] = init(nums, node_idx *2, start, (start+end)/2)+
                    init(nums, node_idx*2+1, (start+end)/2+1, end);
        }

        public void update(int node_idx, int start, int end, int idx, int diff){
            if(idx < start || end < idx) return;

            tree[node_idx] += diff;
            if(start != end){
                update(node_idx*2, start, (start+end)/2, idx, diff);
                update(node_idx*2+1, (start+end)/2+1, end, idx, diff);
            }
        }

        public long sum(int node_idx, int start, int end, int left, int right){
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
