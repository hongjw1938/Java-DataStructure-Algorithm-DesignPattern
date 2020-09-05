package problem_solve.brute_force.baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class BaekJoon15656{
    static int n, m;
    static int nums[], select[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        nums = new int[n]; select = new int[m];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i < n; i++){
            int next = Integer.parseInt(st.nextToken());
            int k;
            for(k = i; k > 0 && nums[k-1] > next; k--){
                nums[k] = nums[k-1];
            }
            nums[k] = next;
        }

        getNext(0);
        System.out.println(sb);
    }
    private static void getNext(int index){
        if(index == m){
            for(int p : select){
                sb.append(p).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i=0; i < n; i++){
            select[index] = nums[i];
            getNext(index+1);
        }
    }
}
