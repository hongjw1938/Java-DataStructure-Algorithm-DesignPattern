package com.problemsolve.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1149 {
    static int td[][];
    static int rgb[][];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        rgb = new int[n][3];
        int dp[][] = new int[n][3];

        td = new int[n][3];
        for(int i=0; i < n; i++){
            String s[] = br.readLine().split(" ");
            rgb[i][0] = Integer.parseInt(s[0]);
            rgb[i][1] = Integer.parseInt(s[1]);
            rgb[i][2] = Integer.parseInt(s[2]);
            if(i == 0){
                dp[i][0] = td[i][0] = rgb[i][0];
                dp[i][1] = td[i][1] = rgb[i][1];
                dp[i][2] = td[i][2] = rgb[i][2];
            }
        }

        // Bottom-up
        for(int i=1; i < n; i++){
            dp[i][0] = Math.min(dp[i-1][1] + rgb[i][0], dp[i-1][2] + rgb[i][0]);
            dp[i][1] = Math.min(dp[i-1][0] + rgb[i][1], dp[i-1][2] + rgb[i][1]);
            dp[i][2] = Math.min(dp[i-1][0] + rgb[i][2], dp[i-1][1] + rgb[i][2]);
        }

        int ans = Integer.MAX_VALUE;
        for(int i=0; i < 3; i++){
            ans = Math.min(ans, dp[n-1][i]);
        }
        System.out.println(ans);

        // Top-Down
        int td_ans = Integer.MAX_VALUE;
        for(int i=0; i < 3; i++){
            td_ans = Math.min(td_ans, topDown(n-1, i));
        }

        System.out.println(td_ans);
        br.close();
    }
    private static int topDown(int n, int i){
        if(td[n][i] > 0) return td[n][i];

        return td[n][i] = Math.min(topDown(n-1, (i+1) % 3) + rgb[n][i], topDown(n-1, (i+2) % 3) + rgb[n][i]);
    }
}
