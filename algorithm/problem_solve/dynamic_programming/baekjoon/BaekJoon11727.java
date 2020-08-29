package com.algorithm.problem_solve.dynamic_programming.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon11727 {
    static long min[] = new long[1001];
    static long dp[] = new long[1001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        min[1] = dp[1] = 1; min[2] = dp[2] = 3;
        for(int i=3; i <= n; i++){
            dp[i] = (2 * dp[i-2] + dp[i-1]) % 10007;
        }
        System.out.println(dp[n]);

        System.out.println(topDown(n));
        br.close();
    }

    public static long topDown(int n){
        if(n == 1 || n == 2 || min[n] > 0) return min[n];
        return (2* topDown(n-2) + topDown(n-1)) % 10007;
    }
}
