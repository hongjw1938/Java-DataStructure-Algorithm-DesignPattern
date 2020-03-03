package com.problemsolve.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BaekJoon14002 {
    static int[] a;
    static int[] b;
    static int max_idx;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] s = br.readLine().split(" ");
        a = new int[n+1];
        b = new int[n+1];
        max_idx = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=1; i <= n; i++){
            a[i] = Integer.parseInt(s[i-1]);
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
            if(b[i] > b[max_idx]){
                max_idx = i;
            }
        }
        System.out.println(b[max_idx]);
        int max_b = b[max_idx];
        for(int i=n; i > 0; i--){
            if(b[i] == max_b){
                stack.push(a[i]);
                max_b--;
            }
        }
        while(!stack.isEmpty()){
            System.out.print(stack.pop() + " ");
        }
        br.close();
    }
}
