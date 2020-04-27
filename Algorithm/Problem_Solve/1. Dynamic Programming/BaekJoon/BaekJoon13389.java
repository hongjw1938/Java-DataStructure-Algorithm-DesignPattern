package com.problemsolve.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon13398 {
    static int num[];
    static long td_dp[][];
    static final int MIN = Integer.MIN_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        num = new int[n+1];
        for(int i=1; i <=n ;i++){
            num[i] = Integer.parseInt(s[i-1]);
        }

        // Bottom-up
        long dp[][] = new long[n+1][2];
        dp[0][0] = dp[0][1] = -1001;

        long ans = MIN;
        for(int i=1; i <= n; i++){
            for(int j=0; j < 2; j++){
                if(num[i] < 0){
                    dp[i][j] = num[i];
                } else {
                    dp[i][j] = dp[i-1][j] + num[i];
                }
            }
            dp[i][1] = Math.max(dp[i-1][0], dp[i-1][1] + num[i]);
            ans = Math.max(ans, Math.max(dp[i][0], dp[i][1]));
        }
        System.out.println(ans);
        br.close();
    }
}
