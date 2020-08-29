package com.algorithm.problem_solve.bfs.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon2178 {

    // N * M 크기의 배열로 표현되는 미로의 최소 이동거리로 빠져나가기
    private static int[][] maze;
    private static boolean[][] visited;
    private static int[] moveY = {0, 1, 0, -1};
    private static int[] moveX = {1, 0, -1, 0};

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int y = scan.nextInt();
        int x = scan.nextInt();

        maze = new int[y][x];
        visited = new boolean[y][x];

        visited[0][0] = true;
        for(int i=0; i < y; i++){
            String line = scan.next();
            for(int j=0; j < x; j++){
                maze[i][j] = line.charAt(j) - '0';
            }
        }
        int moved = bfs(new MazePoint(0, 0));

        System.out.println(moved);
        scan.close();

    }

    private static int bfs(MazePoint mp){
        Queue<MazePoint> q = new LinkedList<>();
        q.add(mp);

        int ret_val = 1;
        Queue<MazePoint> subq = new LinkedList<>();

        int row_size = maze.length;
        int col_size = maze[0].length;

//        System.out.println("row : " + row_size + " , col : " + col_size);
        while(!q.isEmpty()){
            MazePoint actual = q.remove();
            int now_x = actual.getX();
            int now_y = actual.getY();


            for(int i=0; i < 4; i++){
                int nextX = now_x + moveX[i];
                int nextY = now_y + moveY[i];

                if(nextX == col_size-1 && nextY == row_size - 1){
                    ret_val++;
                    return ret_val;
                }

                if(0 <= nextX && nextX < col_size && 0 <= nextY && nextY < row_size
                        && !visited[nextY][nextX] && maze[nextY][nextX] == 1){
                    visited[nextY][nextX] = true;
                    subq.add(new MazePoint(nextY, nextX));
                }
            }

            if(q.isEmpty()){
                while(!subq.isEmpty()){
                    q.add(subq.remove());
                }
                ret_val++;
            }
        }
        return -1;
    }
}

class MazePoint{
    int y;
    int x;

    public MazePoint(int y, int x) {
        this.y = y;
        this.x = x;
    }

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
}