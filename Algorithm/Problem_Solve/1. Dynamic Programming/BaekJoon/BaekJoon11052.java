package com.problemsolve.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon11052 {
    static int P[];
    static int max[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        P = new int[N+1];
        max = new int[N+1];
        String[] s = br.readLine().split(" ");
        for(int i=1; i <= N; i++){
            P[i] = Integer.parseInt(s[i-1]);
        }
        max[1] = P[1];
        System.out.println(topDown(N));
        br.close();
    }

    private static int topDown(int n){
        if(max[n] > 0){
            return max[n];
        }
        int temp = P[n];
        for(int i=1; i < n; i++){
            int c1 = topDown(n-i) + topDown(i);
            temp = Math.max(temp, c1);
        }
        max[n] = temp;
        return max[n];
    }
}
