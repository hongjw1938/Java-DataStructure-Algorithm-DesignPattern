package com.problemsolve.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1932 {
    static int[][] td;
    static boolean[][] td_bool;
    static int[][] nums;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        nums = new int[n+1][n+1];
        int[][] dp = new int[n+1][n+1];
        for(int i=1; i <= n; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 1; j <= i; j++) {
                int m = Integer.parseInt(s[j-1]);
                nums[i][j] = m;
            }
        }
        // Bottom-up
        dp[1][1] = nums[1][1];
        int ans = 0;
        for(int i=1; i < n; i++){
            for(int j=1; j <= i; j++){
                dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j] + nums[i+1][j]);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j] + nums[i+1][j+1]);
            }
        }

        for(int j=1; j <= n; j++){
            ans = Math.max(ans, dp[n][j]);
        }
        
        System.out.println(ans);

        // Top-Down
        td = new int[n+1][n+1];
        td_bool = new boolean[n+1][n+1];
        td[1][1] = nums[1][1];
        td_bool[1][1] = true;

        for(int i=1; i <= n; i++){
            topDown(n, i);
        }

        int td_ans = 0;
        for(int j=1; j <= n; j++){
            td_ans = Math.max(td_ans, td[n][j]);
        }
        System.out.println(td_ans);

        br.close();
    }

    private static int topDown(int i, int j){
        if(td_bool[i][j]) return td[i][j];
        if(i==1) return td[i][j];

        if(j <= 1){
            td[i][j] = topDown(i-1, j) + nums[i][j];
        } else {
            td[i][j] = Math.max(topDown(i-1, j-1) + nums[i][j], topDown(i-1, j) + nums[i][j]);
        }
        td_bool[i][j] = true;
        return td[i][j];
    }
}
