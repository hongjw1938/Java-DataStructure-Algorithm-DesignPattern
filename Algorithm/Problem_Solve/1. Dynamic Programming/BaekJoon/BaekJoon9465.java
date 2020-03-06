package com.problemsolve.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon9465 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int sticker[][] = new int[2][100000];
        int dp[][] = new int[2][100001];
        for(int i=0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            String[] s = br.readLine().split(" ");
            for(int k=0; k < n; k++){
                sticker[0][k] = Integer.parseInt(s[k]);
            }
            s = br.readLine().split(" ");
            for(int k=0; k < n; k++){
                sticker[1][k] = Integer.parseInt(s[k]);
                if(k == 0){
                    dp[0][k] = sticker[0][k];
                    dp[1][k] = sticker[1][k];
                } else if (k == 1){
                    dp[0][k] = dp[1][k-1] + sticker[0][k];
                    dp[1][k] = dp[0][k-1] + sticker[1][k];
                } else {
                    dp[0][k] = Math.max(dp[1][k-1] + sticker[0][k], dp[1][k-2] + sticker[0][k]);
                    dp[1][k] = Math.max(dp[0][k-1] + sticker[1][k], dp[0][k-2] + sticker[1][k]);
                }
            }
            int ans = Math.max(dp[0][n-1], dp[1][n-1]);
            System.out.println(ans);
        }

        br.close();
    }
}
