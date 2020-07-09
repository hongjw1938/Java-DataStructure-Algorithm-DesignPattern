package com.problemsolve.brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
public class BaekJoon15649{
    static boolean b[];
    static int num[];
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");
        int n = Integer.parseInt(s[0]); int m = Integer.parseInt(s[1]);
        b = new boolean[n+1];
        num = new int[m];
        getNext(0, n, m);

        br.close();
    }
    private static void getNext(int index, int n, int m){
        if(index == m){
            for(int p : num){
                System.out.print(p + " ");
            }
            System.out.println();
            return;
        }

        for(int i=1; i <= n; i++){
            if(b[i]){
                continue;
            }
            b[i] = true;
            num[index]  = i;
            getNext(index+1, n, m);
            b[i] = false;
        }
    }
}
