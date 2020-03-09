package com.problemsolve.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon13398 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        int[] a = new int[n+1];
        for(int i=1; i <=n ;i++){
            a[i] = Integer.parseInt(s[i-1]);
        }
        int ans = a[1];
        int[] left= new int[n+2];
        for(int i=1; i <=n ;i++){
            left[i] = a[i];
            left[i] = Math.max(left[i], left[i-1]+a[i]);
            if(left[i] > ans) ans = left[i];
        }

        int[] right = new int[n+2];
        for(int i=n; i >= 1; i--){
            right[i] = a[i];
            right[i] = Math.max(right[i], right[i+1] + a[i]);
        }
        for(int i=1; i <= n;i++){
            if(left[i-1] + right[i+1] > ans){
                ans = left[i-1] + right[i+1];
            }
        }
        System.out.println(ans);


        br.close();
    }
}
