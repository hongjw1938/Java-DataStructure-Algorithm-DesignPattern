package com.problemsolve.baekjoon.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon1012 {
    private static int[][] cabbages;
    private static boolean[][] visited;

    private static int[] moveX = {1, 0, -1, 0};
    private static int[] moveY = {0, -1, 0, 1};

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int caseNum = scan.nextInt();

        for(int i=0; i < caseNum; i++){
            int x = scan.nextInt();
            int y = scan.nextInt();

            cabbages = new int[y][x];
            visited = new boolean[y][x];

            int c_num = scan.nextInt();
            int worm = 0;

            for(int j=0; j < c_num; j++){
                int c_x = scan.nextInt();
                int c_y = scan.nextInt();

                cabbages[c_y][c_x] = 1;
            }

            for(int j=0; j < y; j++){
                for(int k=0; k < x; k++){
                    if(cabbages[j][k] == 1 && !visited[j][k] ){
                        worm++;
                        visited[j][k] = true;
                        bfs(j, k);
                    }
                }
            }
            System.out.println(worm);
        }


        scan.close();
    }

    private static void bfs(int s_y, int s_x){
        int y_size = cabbages.length;
        int x_size = cabbages[0].length;

        Queue<CabbagePoint> q = new LinkedList<>();
        q.add(new CabbagePoint(s_y, s_x));

        while(!q.isEmpty()){
            CabbagePoint actual = q.remove();
            int nowX = actual.getX();
            int nowY = actual.getY();

            for(int i=0; i < 4; i++){
                int nextX = nowX + moveX[i];
                int nextY = nowY + moveY[i];

                if(0 <= nextX && nextX < x_size && 0 <= nextY && nextY < y_size
                        && !visited[nextY][nextX] && cabbages[nextY][nextX] == 1){
                    visited[nextY][nextX] = true;
                    q.add(new CabbagePoint(nextY, nextX));
                }
            }
        }
    }
}

class CabbagePoint{
    int y;
    int x;

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

    public CabbagePoint(int y, int x) {
        this.y = y;
        this.x = x;
    }
}
