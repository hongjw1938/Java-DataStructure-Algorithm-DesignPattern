package com.problemsolve.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1463 {
    static int[] min = new int[1000001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        // Top-Down 방식 풀이
        System.out.println(dp(X));

        br.close();
    }

    private static int dp(int x){
        if(x == 1){
            return 0;
        } else if(min[x] > 0){
            return min[x];
        }
        min[x] = dp(x-1) + 1;
        if(x % 3 == 0){
            int temp = dp(x / 3) + 1;
            if(min[x] > temp) min[x] = temp;
        }
        if(x % 2 == 0){
            int temp = dp(x/2) + 1;
            if(min[x] > temp) min[x] = temp;
        }
        return min[x];
    }
}
