package com.problemsolve.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon11727 {
    static long min[] = new long[1001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        min[1] = 1; min[2] = 3;
        for(int i=3; i <= n; i++){
            min[i] = (min[i-2] + min[i-1] + min[i-2]) % 10007;
        }
        System.out.println(min[n]);
        br.close();
    }
}
