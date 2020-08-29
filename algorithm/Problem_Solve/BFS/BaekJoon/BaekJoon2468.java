package com.problemsolve.baekjoon.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon2468 {

    private static int[][] region;
    private static boolean[][] visited;
    private static int moveX[] = {0, 1, 0, -1};
    private static int moveY[] = {1, 0, -1, 0};

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int size = scan.nextInt();
        region = new int[size][size];

        int highest = 0;
        for(int i=0; i < size; i++){
            for(int j=0; j < size; j++){
                region[i][j] = scan.nextInt();
                highest = Math.max(highest, region[i][j]);
            }
        }

        int max_val = 0;
        for(int raining=0; raining <= 100; raining++){
            if(highest <= raining) break;
            visited = new boolean[size][size];

            for(int i=0; i < size; i++){
                for(int j=0; j < size; j++){
                    if(region[i][j] <= raining){
                        visited[i][j] = true;
                    }
                }
            }

            RegionPoint rp;

            int safeRegion = 0;

            for(int i=0; i < size; i++){
                for(int j=0; j < size; j++){
                    if(!visited[i][j]){
                        rp = new RegionPoint(i, j);
                        visited[i][j] = true;
                        safeRegion++;
                        bfs(rp, raining, size);
                    }
                }
            }
            max_val = Math.max(max_val, safeRegion);
        }

        System.out.println(max_val);
        scan.close();
    }

    private static void bfs(RegionPoint rp, int r, int size){
        Queue<RegionPoint> q = new LinkedList<>();
        q.add(rp);

        while(!q.isEmpty()){
            RegionPoint actual = q.remove();
            int now_y = actual.getY();
            int now_x = actual.getX();

            for(int i=0; i < 4; i++){
                int nextY = now_y + moveY[i];
                int nextX = now_x + moveX[i];

                if(0 <= nextX && nextX < size && 0 <= nextY && nextY < size
                    && !visited[nextY][nextX]){
                    q.add(new RegionPoint(nextY, nextX));
                    visited[nextY][nextX] = true;
                }
            }
        }
    }
}


class RegionPoint{
    private int y;
    private int x;

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public RegionPoint(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
