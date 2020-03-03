package com.problemsolve.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1912 {
    static int num[];
    static int max[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        num = new int[n];
        max = new int[n];
        String[] s = br.readLine().split(" ");
        for(int i=0; i < n; i++){
            num[i] = Integer.parseInt(s[i]);
        }
        max[0] = num[0];
        int max_val = max[0];
        for(int i=1; i < n; i++){
            max[i] = Math.max(max[i-1] + num[i], num[i]);
            max_val = Math.max(max_val, max[i]);
        }
        System.out.println(max_val);
        br.close();
    }
}
