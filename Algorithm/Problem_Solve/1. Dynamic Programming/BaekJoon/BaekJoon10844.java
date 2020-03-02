package com.problemsolve.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon10844 {
    static int[][] d = new int[101][10];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for(int i=1; i <= 9; i++){
            d[1][i] = 1;
        }
        for(int i=2; i <= 100; i++){
            for(int j=0; j <= 9; j++){
                if(j==0){
                    d[i][j] += (d[i-1][j+1] % 1000000000);
                } else if(j==9){
                    d[i][j] += (d[i-1][j-1] % 1000000000);
                } else {
                    d[i][j] += (d[i-1][j-1] + d[i-1][j+1]) % 1000000000;
                }
            }
        }
        int ans=0;
        for(int i=0; i<=9;i++){
            ans = (ans + d[n][i]) % 1000000000;
        }
        System.out.println(ans);
        br.close();
    }
}
