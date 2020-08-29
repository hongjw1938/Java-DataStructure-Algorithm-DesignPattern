package com.problemsolve.dfs.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon10026 {
    private static String[] map = new String[100];
    private static boolean[][] visited = new boolean[100][100];
    private static boolean[][] weakVisited = new boolean[100][100];
    private static int size;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        size = Integer.parseInt(br.readLine());

        for(int i=0; i < size; i++){
            map[i] = br.readLine();
        }

        int partition = 0;
        int weakPartition = 0;
        for(int i=0; i < size; i++){
            for(int j=0; j < size; j++){
                if(!visited[i][j]){
                    if(!weakVisited[i][j]){
                        weakPartition++;
                    }
                    dfs(i, j, map[i].charAt(j));
                    partition++;
                }
            }
        }

        System.out.println(partition + " " + weakPartition);
        br.close();

    }

    private static void dfs(int y, int x, char color){
        if(y < 0 || size <= y || x >= size || x < 0) return;
        if(color == 'R' || color == 'G'){
            weakDfs(y, x);
        }

        if(visited[y][x] || color != map[y].charAt(x)){
            return;
        }

        visited[y][x] = true;
        dfs(y+1, x, color);
        dfs(y, x+1, color);
        dfs(y-1, x, color);
        dfs(y, x-1, color);
    }

    private static void weakDfs(int y, int x){
        if(y < 0 || y >= size || x < 0 || x >= size || map[y].charAt(x) == 'B') return;
        if(weakVisited[y][x]) return;

        weakVisited[y][x] = true;
        weakDfs(y+1, x);
        weakDfs(y, x+1);
        weakDfs(y-1, x);
        weakDfs(y, x-1);

    }
}
