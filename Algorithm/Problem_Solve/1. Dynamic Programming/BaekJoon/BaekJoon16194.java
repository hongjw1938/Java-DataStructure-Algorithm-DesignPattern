package com.problemsolve.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon16194 {
    static int p[];
    static int min[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        p = new int[N+1];
        min = new int[N+1];
        for(int i=1; i <= N; i++){
            p[i] = Integer.parseInt(s[i-1]);
            min[i] = Integer.MAX_VALUE;
        }

        getMin(N);
        System.out.println(min[N]);
        br.close();
    }
    private static void getMin(int n){
        for(int i=1; i <= n; i++){
            for(int j=1; j <= i; j++){
                if(min[i-j] + p[j] < min[i]){
                    min[i] = min[i-j] + p[j];
                }
            }
        }
    }
}
