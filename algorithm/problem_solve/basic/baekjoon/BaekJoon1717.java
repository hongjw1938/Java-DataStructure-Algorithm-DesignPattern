package problem_solve.basic.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1717 {
    static int[] bucket;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        bucket = new int[n+1];
        for(int i=0; i < bucket.length; i++){
            bucket[i] = i;
        }

        StringBuilder sb = new StringBuilder();
        for(int i=0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int inst = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());

            if(inst == 0){
                merge(l, r);
            } else {
                int left_parent = find(l);
                int right_parent = find(r);
                if(left_parent == right_parent){
                    sb.append("YES\n");
                } else {
                    sb.append("NO\n");
                }
            }
        }
        System.out.println(sb);
        br.close();
    }

    public static void merge(int left, int right){
        int left_parent = find(left);
        int right_parent = find(right);
        if(left_parent == right_parent){
            return;
        }
        if(left_parent < right_parent){
            bucket[right_parent] = left_parent;
        } else{
            bucket[left_parent] = right_parent;
        }

    }
    public static int find(int num){
        if(num == bucket[num]){
            return num;
        }
        return bucket[num] = find(bucket[num]);
    }
}
