package com.problemsolve.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon15990 {
    static int d[][] = new int[100001][4];
    static int dp[][] = new int[100001][4];
    static int MOD = 1000000009;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        d[1][1] = d[2][2] = d[3][1] = d[3][2] = d[3][3] = 1;
        dp[1][1] = dp[2][2] = dp[3][1] = dp[3][2] = dp[3][3] = 1;

        // Bottom-up
        for (int i = 4; i <= 100000; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
        }

        int t = Integer.parseInt(br.readLine());
        StringBuilder ans = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            ans.append(((dp[n][1] + dp[n][2]) % MOD + dp[n][3]) % MOD).append('\n');
        }
        System.out.print(ans);


        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(((topDown(n, 1)+ topDown(n ,2)) % MOD + topDown(n, 3)) % MOD);
        }
        br.close();
    }
    private static int topDown(int n, int idx){
        if(n == 1 || n == 2 || n == 3) {
            return d[n][idx];
        }
        if(d[n][idx] > 0){
            return d[n][idx];
        }

        for(int i=1; i <= 3; i++){
            if(idx == 1 && i != idx){
                d[n][idx] = (d[n][idx] + topDown(n-1, i)) % MOD;
            } else if(idx == 2 && i != idx){
                d[n][idx] = (d[n][idx] + topDown(n-2, i)) % MOD;
            } else if(idx == 3 && i != idx){
                d[n][idx] = (d[n][idx] + topDown(n-3, i)) % MOD;
            }
        }
        return d[n][idx];
    }
}
