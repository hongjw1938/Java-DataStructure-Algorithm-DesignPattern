package com.problemsolve.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1932 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] dp = new int[500][500];
        int ans = 0;
        for(int i=0; i < n; i++){
            String[] s = br.readLine().split(" ");
            for(int j=0; j <= i; j++){
                int m = Integer.parseInt(s[j]);
                if(i==0) {
                    dp[i][j] = m;
                } else {
                    if(j==0){
                        dp[i][j] = dp[i-1][j] + m;
                    } else {
                        dp[i][j] = Math.max(dp[i-1][j-1] + m, dp[i-1][j] + m);
                    }
                }
                if(i==n-1){
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        System.out.println(ans);
        br.close();
    }
}
