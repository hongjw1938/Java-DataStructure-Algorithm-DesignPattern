package com.algorithm.problem_solve.brute_force.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon14500 {
    static int[][] paper;
    static boolean[][] flag;
    static int[][] dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line[] = br.readLine().split(" ");
        N = Integer.parseInt(line[0]); M = Integer.parseInt(line[1]);

        paper = new int[N][M];
        flag = new boolean[N][M];
        for(int i=0; i < N; i++){
            line = br.readLine().split(" ");
            for(int j=0; j < M; j++){
                paper[i][j] = Integer.parseInt(line[j]);
            }
        }

        int ans = 0;
        for(int i=0; i < N; i++){
            for(int j=0; j < M; j++){
                flag[i][j] = true;
                ans = Math.max(ans, getMax(i, j, 0, 0));
                flag[i][j] = false;
                ans = Math.max(ans, getFy(i, j));
            }
        }
        System.out.println(ans);
        br.close();
    }
    private static int getMax(int i, int j, int sum, int move){
        if(move == 4) return sum;

        int current = sum + paper[i][j];
        int ans = 0;

        for(int n=0; n < dir.length; n++){
            int ni = i + dir[n][0]; int nj = j + dir[n][1];
            if(0 <= ni && ni < N && 0 <= nj && nj < M && !flag[ni][nj]){
                flag[ni][nj] = true;
                ans = Math.max(ans, getMax(ni, nj, current, move+1));
                flag[ni][nj] = false;
            }
        }

        return ans;
    }
    private static int getFy(int i, int j){
        int base = paper[i][j];

        int max = 0;
        for(int k=0; k < dir.length; k++){
            for(int n=0; n < dir.length; n++){
                for(int m=0; m < dir.length; m++){
                    if(k == n || k == m || n == m){
                        continue;
                    }
                    int ni1 = i + dir[k][0]; int nj1 = j + dir[k][1];
                    int ni2 = i + dir[n][0]; int nj2 = j + dir[n][1];
                    int ni3 = i + dir[m][0]; int nj3 = j + dir[m][1];
                    if(ni1 < 0 || ni1 >= N || nj1 < 0 || nj1 >= M || ni2 < 0 || ni2 >= N || nj2 < 0 || nj2 >= M || ni3 < 0 || ni3 >= N || nj3 < 0 || nj3 >= M ){
                        continue;
                    }
                    max = Math.max(max, base + paper[ni1][nj1] + paper[ni2][nj2] + paper[ni3][nj3]);
                }
            }
        }
        return max;
    }
}
