package com.problemsolve.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon10844 {
    static int[][] d = new int[101][10];
    static int[][] dp = new int[101][10];
    static int MOD = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=1; i <= 9; i++){
            d[1][i] = 1;
            dp[1][i] = 1;
        }

        // Bottom-up
        for(int i=2; i <= 100; i++){
            for(int j=0; j <= 9; j++){
                if(j==0){
                    d[i][j] += (d[i-1][j+1] % MOD);
                } else if(j==9){
                    d[i][j] += (d[i-1][j-1] % MOD);
                } else {
                    d[i][j] += (d[i-1][j-1] + d[i-1][j+1]) % MOD;
                }
            }
        }
        int ans=0;
        for(int i=0; i<=9;i++){
            ans = (ans + d[n][i]) % MOD;
        }
        System.out.println(ans);

        // Top-Down
        int top_ans = 0;
        for(int i=0; i <= 9; i++){
            top_ans = (top_ans + topDown(n, i)) % MOD;
        }
        System.out.println(top_ans);
        br.close();
    }

    private static int topDown(int n, int digit){
        if(dp[n][digit] > 0 || (n == 1 && digit == 0)){
            return dp[n][digit];
        }
        if(digit == 0){
            dp[n][digit] += (topDown(n-1, digit+1) % MOD);
        } else if(digit == 9){
            dp[n][digit] += (topDown(n-1, digit-1) % MOD);
        } else {
            dp[n][digit] += ((topDown(n-1, digit-1) + topDown(n-1, digit+1)) % MOD);
        }

        return dp[n][digit];
    }
}
