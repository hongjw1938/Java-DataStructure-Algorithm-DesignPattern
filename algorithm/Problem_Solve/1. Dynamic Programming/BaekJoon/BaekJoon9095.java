package com.problemsolve.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon9095 {
    static int[] num = new int[12];
    static int[] dp = new int[12];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        num[1] = dp[1] = 1; num[2] = dp[2] = 2; num[3] = dp[3] = 4;
        for(int i=0; i < T; i++){
            int n = Integer.parseInt(br.readLine());
            for(int j=4; j <= n; j++){
                num[j] = num[j-1] + num[j-2] + num[j-3];
            }
            System.out.println(num[n]);
            System.out.println("----------------");
            System.out.println(topDown(n));
        }

        br.close();
    }
    public static int topDown(int n){
        if(n == 1 || n == 2 || n == 3){
            return dp[n];
        }
        if(dp[n] > 0){
            return dp[n];
        }
        return topDown(n-1) + topDown(n-2) + topDown(n-3);
    }
}
