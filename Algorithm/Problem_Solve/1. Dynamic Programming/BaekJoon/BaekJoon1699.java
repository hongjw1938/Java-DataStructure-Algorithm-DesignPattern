package com.problemsolve.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1699 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int s[] = new int[n+1];

        int square = 1;
        for(int i=1; i <= n; i++){
            int p = (int)Math.pow(square+1, 2);
            if(p == i){
                s[i] = 1;
                square++;
            } else {
                int x = square;
                while(x > 0){
                    int insert = s[i - (int)Math.pow(x, 2)] + 1;
                    if(s[i] == 0){
                        s[i] = insert;
                    }
                    s[i] = Math.min(s[i], insert);
                    x--;
                }
            }
        }
        System.out.println(s[n]);
        br.close();
    }
}
