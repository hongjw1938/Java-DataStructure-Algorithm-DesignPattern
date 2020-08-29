package com.algorithm.problem_solve.dynamic_programming.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon11054 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String s[] = br.readLine().split(" ");
        int a[] = new int[n+1];
        int b[] = new int[n+1];
        b[0] = Integer.MAX_VALUE;

        int asc[] = new int[n+1];
        int desc[] = new int[n+1];
        int ans = 0;
        for(int i=1; i <= n; i++){
            a[i] = Integer.parseInt(s[i-1]);
            b[i] = Integer.parseInt(s[i-1]);
            for(int j=i; j >= 0; j--){
                if(a[j] < a[i]){
                    asc[i] = Math.max(asc[i], asc[j]+1);
                }
                if(b[j] > b[i]){
                    desc[i] = Math.max(desc[i], Math.max(asc[j]+1, desc[j] + 1));
                }
            }
            ans = Math.max(asc[i], ans);
            ans = Math.max(desc[i], ans);
        }
        System.out.println(ans);

        br.close();
    }
}
