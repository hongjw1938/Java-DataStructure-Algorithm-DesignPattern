package com.problemsolve.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon11057 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dp[][] = new int[n+1][10];
        int sum = 0;
        for(int i=1; i <= n; i++){
            int com = sum;
            for(int j=0; j < 10; j++){
                if(i==1 || j == 9) {
                    dp[i][j] = 1;
                    sum += dp[i][j] % 10007;
                } else if(i != 1 && j == 0) {
                    dp[i][j] = sum % 10007;
                } else {
                    com -= dp[i-1][j-1];
                    dp[i][j] = com % 10007;
                    sum += dp[i][j] % 10007;
                }
            }
        }
        for(int i=1; i <=n ;i++){
            for(int j=0; j < 10; j++){
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println(sum % 10007);
        br.close();
    }
}
