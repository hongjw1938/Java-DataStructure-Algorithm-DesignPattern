package com.problemsolve.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2193 {
    static long[][] d = new long[91][2];
    static long[][] dp = new long[91][2];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        d[1][1] = 1;
        dp[1][1] = 1;
        // Bottom-up
        for(int i=2; i <= N; i++){
            d[i][0] = d[i-1][0] + d[i-1][1];
            d[i][1] = d[i-1][0];
        }
        long ans = d[N][0] + d[N][1];
        System.out.println(ans);

        //Top-Down
        long top_ans = 0;
        for(int i=0; i < 2; i++){
            top_ans += topDown(N, i);
        }

        System.out.println(top_ans);
        br.close();
    }
    private static long topDown(int n, int digit){
        if(dp[n][digit] > 0 || (n==1 && digit==0)){
            return dp[n][digit];
        }

        if(digit == 1){
            dp[n][digit] = topDown(n-1, 0);
        } else if(digit == 0){
            dp[n][digit] = topDown(n-1, 0) + topDown(n-1,1);
        }
        return dp[n][digit];
    }
}
