package com.problemsolve.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon11055 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int A[] = new int[n];
        int dp[] = new int[n];
        String[] s = br.readLine().split(" ");
        int ans = 0;
        for(int i=0; i < n; i++){
            A[i] = Integer.parseInt(s[i]);
            dp[i] = A[i];
            for(int j=i-1; j >=0; j--){
                if(A[i] > A[j]){
                    dp[i] = Math.max(dp[i], dp[j] + A[i]);
                }
            }
            if(dp[i] > dp[ans]){
                ans = i;
            }
        }
        System.out.println(dp[ans]);
        br.close();
    }
}
