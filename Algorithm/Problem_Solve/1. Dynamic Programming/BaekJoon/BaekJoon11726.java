package com.problemsolve.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon11726 {
    static long[] min = new long[1001];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        min[1] = 1;
        min[2] = 2;

        System.out.println(topDown(n));
        br.close();
    }
    private static long topDown(int n){
        if(n == 1 || n == 2){
            return min[n];
        }
        if(min[n] > 0){
            return min[n];
        }
        return min[n] = (topDown(n-2 ) + topDown(n-1)) % 10007;
    }
}
