package com.problemsolve.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon11053 {
    static int[] a;
    static int[] b;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        a = new int[n+1];
        b = new int[n+1];

        int max_idx = 0;
        String[] s = br.readLine().split(" ");
        for(int i=1; i <= n; i++){
            a[i] = Integer.parseInt(s[i-1]);

            int t = i;
            int m = 0;
            for(int j=i; j > 0; j--){
                if(a[i] > a[j] && b[m] < b[j]){
                    m = j;
                    if(max_idx == j){
                        break;
                    }
                }
            }
            b[i] = b[m] + 1;
            if(b[max_idx] < b[i]){
                max_idx = i;
            }
        }
        System.out.println(b[max_idx]);
        br.close();
    }
//    private static int topDown(int c_idx, int p_idx){
//        if(p_idx == 1 && a[c_idx] < a[p_idx]) return 0;
//        if(b[p_idx] > 0 && a[p_idx] < a[c_idx] ){
//            return b[p_idx];
//        }
//
//        return b[c_idx] = topDown(c_idx-1, p_idx-1) + 1;
//    }
}
