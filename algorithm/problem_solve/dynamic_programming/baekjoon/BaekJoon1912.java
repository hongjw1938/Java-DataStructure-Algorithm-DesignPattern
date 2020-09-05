package problem_solve.dynamic_programming.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1912 {
    static int num[];
    static int max[];
    static int dp[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        num = new int[n];
        max = new int[n];
        dp = new int[n];
        String[] s = br.readLine().split(" ");
        for(int i=0; i < n; i++){
            num[i] = Integer.parseInt(s[i]);
        }
        
        // Bottom-up
        max[0] = num[0];
        int max_val = max[0];
        for(int i=1; i < n; i++){
            max[i] = Math.max(max[i-1] + num[i], num[i]);
            max_val = Math.max(max_val, max[i]);
        }
        System.out.println(max_val);
        
        // Top-down
        topDown(n-1);
        max_val = dp[0];
        for(int i=0; i < n; i++){
            max_val = Math.max(max_val, dp[i]);
        }
        System.out.println(max_val);
        br.close();
    }
    private static int topDown(int n){
        if(dp[n] > 0 || n == 0) return dp[n];
        
        dp[n] = Math.max(topDown(n-1) + num[n], num[n]);
        return dp[n];
    }
}
