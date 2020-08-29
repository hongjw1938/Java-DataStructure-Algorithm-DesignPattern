package com.algorithm.problem_solve.dynamic_programming.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1463 {
    static int[] min = new int[1000001];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int X = Integer.parseInt(br.readLine());

        // Top-Down 방식 풀이
        System.out.println(topDown(X));

        // Bottom-up 방식 풀이
        System.out.println(bottomUp(X));
        br.close();
    }

    private static int bottomUp(int x){
        min[1] = 0;
        for(int i=2; i <= x; i++){
            min[i] = min[i-1] + 1;
            if(i % 2 == 0 && min[i] > min[i/2] + 1){
                min[i] = min[i/2] + 1;
            }
            if(i % 3 == 0 && min[i] > min[i/3] + 1){
                min[i] = min[i/3] + 1;
            }
        }
        return min[x];
    }

    private static int topDown(int x){
        if(x == 1){
            return 0;
        } else if(min[x] > 0){
            return min[x];
        }
        min[x] = topDown(x-1) + 1;
        if(x % 3 == 0){
            int temp = topDown(x / 3) + 1;
            if(min[x] > temp) min[x] = temp;
        }
        if(x % 2 == 0){
            int temp = topDown(x/2) + 1;
            if(min[x] > temp) min[x] = temp;
        }
        return min[x];
    }
}
