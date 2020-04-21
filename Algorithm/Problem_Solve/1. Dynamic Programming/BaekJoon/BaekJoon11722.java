package com.problemsolve.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon11722 {
    static int[] num;
    static int[] td;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        num = new int[n];
        for(int i=0; i < n; i++){
            num[i] = Integer.parseInt(s[i]);
        }

        // Bottom-up
        int[] dp = new int[n];
        dp[0] = 1;
        for(int i=1; i < n; i++){
            dp[i] = 1;
            for(int j=0; j < i; j++){
                if(num[i] < num[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                } else if (num[i] == num[j]){
                    dp[i] = dp[j];
                }
            }
        }
        int ans = 0;
        for(int i=0; i < n; i++){
            ans = Math.max(ans, dp[i]);
        }
        System.out.println(ans);

        // Top-Down
        td = new int[n];
        topDown(n-1);
        int td_ans = 0;
        for(int i=0; i < n; i++){
            td_ans = Math.max(td_ans, td[i]);
        }

        System.out.println(td_ans);
        br.close();
    }
    private static int topDown(int n){
        if(n == 0) return td[n] = 1;
        if(td[n] > 0) return td[n];

        for(int i=n-1; i >= 0; i--){
            if(num[n] < num[i] && td[n] <= td[i]){
                td[n] = Math.max(td[n], topDown(i) + 1);
            } else if(num[n] == num[i]) {
                td[n] = Math.max(td[n], topDown(i));
            } else {
                topDown(i);
            }
        }
        return td[n] == 0 ? td[n] =1 : td[n];
    }
}
