package com.problemsolve.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon15988 {
    static int td[];
    static int mod = 1000000009;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        int dp[] = new int[1000001];
        dp[1] = 1; dp[2] = 2; dp[3] = 4;
        for(int i =4; i <= 1000000; i++){
            dp[i] = ((dp[i-1] + dp[i-2])% mod + dp[i-3]) % mod;
        }
        for(int i=0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[n]);
        }

        td = new int[1000001];
        for(int i=0; i < t; i++){
            int n = Integer.parseInt(br.readLine());
            System.out.println(topDown(n));
        }
        br.close();
    }

    private static int topDown(int n){
        if(td[n] > 0) return td[n];
        if(n == 1) return td[n] = 1;
        if(n == 2) return td[n] = 2;
        if(n == 3) return td[n] = 4;

        return td[n] = ((topDown(n-1) + topDown(n-2)) % mod + topDown(n-3))%mod;

    }
}
