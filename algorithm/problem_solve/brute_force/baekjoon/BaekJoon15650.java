package com.algorithm.problem_solve.brute_force.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BaekJoon15650 {
    static int num[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]); int m = Integer.parseInt(s[1]);
        num = new int[m];
        getNext(0, n, m, 0);

        br.close();
    }
    private static void getNext(int index, int n, int m, int start){
        if(index == m){
            for(int p : num){
                System.out.print(p + " ");
            }
            System.out.println();
            return;
        } else if(index < m && n == start){
            return;
        }

        for(int s = start+1; s <= n; s++){
            num[index] = s;
            getNext(index+1, n, m, s);
        }
    }
}
