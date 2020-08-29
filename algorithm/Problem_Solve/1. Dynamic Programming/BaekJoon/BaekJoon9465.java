package com.problemsolve.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon9465 {
    static int td[][];
    static int sticker[][];
    static boolean done[][];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        sticker = new int[2][100001];
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
            }

            // Bottom-up
            for(int k=0; k < n; k++){
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

            // Top-Down
            td = new int[2][100001];
            done = new boolean[2][100001];
            int td_ans = 0;
            td[0][0] = sticker[0][0]; done[0][0] = true;
            td[1][0] = sticker[1][0]; done[1][0] = true;
            for(int j=0; j < 2; j++){
                td_ans = Math.max(td_ans, topDown(j, n-1));
            }
            System.out.println(td_ans);
        }

        br.close();
    }
    private static int topDown(int r, int c){
        if(done[r][c]) return td[r][c];
        if(c == 1) {
            done[r][c] = true;
            return td[r][c] = (td[(r+1)%2][c-1] + sticker[r][c]);
        }

        int dx = (r+1)%2;
        td[r][c] = Math.max(topDown(dx, c-2) + sticker[r][c], topDown(dx, c-1) + sticker[r][c]);
        done[r][c] = true;
        return td[r][c];

    }
}
