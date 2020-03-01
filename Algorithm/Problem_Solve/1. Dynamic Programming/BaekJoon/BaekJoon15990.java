package com.problemsolve.dynamic_programming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon15990 {
    static int d[][] = new int[100001][4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        d[1][1] = d[2][2] = d[3][1] = d[3][2] = d[3][3] = 1;
        for (int j = 4; j <= 100000; j++) {
            d[j][1] = d[j-1][2] + d[j-1][3];
            d[j][2] = d[j-2][1] + d[j-2][3];
            d[j][3] = d[j-3][1] + d[j-3][2];

            d[j][1] %= 1000000009;
            d[j][2] %= 1000000009;
            d[j][3] %= 1000000009;
        }
        for (int i = 0; i < T; i++) {
            int n = Integer.parseInt(br.readLine());
            System.out.println(((d[n][1] + d[n][2]) % 1000000009 + d[n][3]) % 1000000009);
        }
        br.close();
    }
}
