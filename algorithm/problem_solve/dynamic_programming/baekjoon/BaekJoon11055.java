package com.algorithm.problem_solve.dynamic_programming.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon11055 {
    static int num[];
    static int td[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");

        num = new int[n];
        for(int i=0; i < n; i++){
            num[i] = Integer.parseInt(s[i]);
        }

        // Bottom-up
        int dp[] = new int[n];
        int ans = 0;
        for(int i=0; i < n; i++){
            dp[i] = num[i];
            for(int j=i-1; j >=0; j--){
                if(num[i] > num[j]){
                    dp[i] = Math.max(dp[i], dp[j] + num[i]);
                }
            }
            if(dp[i] > dp[ans]){
                ans = i;
            }
        }
        System.out.println(dp[ans]);

        // Top-down
        td = new int[n];
        int td_ans = 0;
        topDown(n-1);
        for(int i=0; i < n; i++){
            td_ans = Math.max(td_ans, td[i]);
        }
        System.out.println(td_ans);
        br.close();
    }

    private static int topDown(int n){
        if(n == 0) return td[0] = num[0];
        if(td[n] > 0) return td[n];

        td[n] = num[n];
        for(int i = n-1; i >= 0; i--){
            if(num[i] < num[n]){
                td[n] = Math.max(td[n], topDown(i) + num[n]);
            } else {
                topDown(i);
            }
        }
        return td[n];
    }
}