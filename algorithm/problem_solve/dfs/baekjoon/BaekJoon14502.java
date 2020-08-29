package com.algorithm.problem_solve.dfs.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon14502 {
    private static int[][] map = new int[8][8];
    private static boolean[][] visited = new boolean[8][8];

    private static int row, col;

    private static int[][] move = {
            {1, 0},
            {0, 1},
            {-1, 0},
            {0, -1}
    };

    private static int uninfected = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s[] = br.readLine().split(" ");

        row = Integer.parseInt(s[0]);
        col = Integer.parseInt(s[1]);

        for(int i=0; i < row; i++){
            String line[] = br.readLine().split(" ");
            for(int j=0; j < col; j++){
                map[i][j] = Integer.parseInt(line[j]);
            }
        }

        int mul = row * col;
        for(int i=0; i < mul-2; i++){
            if(map[i/col][i%col] != 0){
                continue;
            }
            map[i/col][i%col] = 1;

            for(int j=i+1; j < mul-1; j++){
                if(map[j/col][j%col] != 0){
                    continue;
                }
                map[j/col][j%col] = 1;
                for(int k=j+1; k < mul; k++){
                    if(map[k/col][k%col] != 0){
                        continue;

                    }
                    map[k/col][k%col] = 1;

                    solve();
                    map[k/col][k%col] = 0;
                }

                map[j/col][j%col] = 0;
            }
            map[i/col][i%col] = 0;
        }

        System.out.println(uninfected);

        br.close();
    }

    private static void solve(){
        for(int i=0; i < row; i++){
            for(int j=0; j < col; j++){
                if(map[i][j] == 2){
                    dfs(i, j);
                }
            }
        }

        int count = 0;

        for(int i=0; i < row; i++){
            for(int j=0; j < col; j++){
                if(map[i][j] == 1){
                    continue;
                }
                if(visited[i][j]){
                    visited[i][j] = false;
                } else {
                    count++;
                }
            }
        }
        uninfected = Math.max(uninfected, count);
    }

    private static void dfs(int r, int c){
        visited[r][c] = true;

        for(int i=0; i < 4; i++){
            int nextR = r + move[i][0];
            int nextC = c + move[i][1];
            if(isInRange(nextR, nextC) && !visited[nextR][nextC] && map[nextR][nextC] == 0){
                dfs(nextR, nextC);
            }
        }
    }

    private static boolean isInRange(int r, int c){
        return 0 <= r && r < row && 0 <= c && c < col;
    }
}
