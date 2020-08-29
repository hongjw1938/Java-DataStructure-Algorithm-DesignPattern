package com.algorithm.problem_solve.dynamic_programming.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon16194 {
    static int p[];
    static int min[];
    static int dp[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        p = new int[N+1];
        min = new int[N+1];
        dp = new int[N+1];

        for(int i=1; i <= N; i++){
            p[i] = Integer.parseInt(s[i-1]);
        }

        // Bottom-up
        for(int i=1; i <= N; i++){
            min[i] = p[i];
            for(int j=1; j <= i; j++){
                min[i] = Math.min(min[i], min[i-j] + min[j]);
            }
        }
        System.out.println(min[N]);
        System.out.println("---------------------------");
        // Top-Down
        System.out.println(topDown(N));
        br.close();
    }
    private static int topDown(int n){
        if(dp[n] > 0) return dp[n];
        if(n==1) return p[1];

        dp[n] = p[n];
        for(int i=1; i < n; i++){
            dp[n] = Math.min(dp[n], topDown(n-i) + p[i]);
        }
        return dp[n];
    }
}
