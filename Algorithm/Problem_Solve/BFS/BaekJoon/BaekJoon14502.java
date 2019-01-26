package com.problemsolve.bfs.baekjoon;

import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon14502 {
    // 인체에 치명적 바이러스 연구하던 연구소의 바이러스 유출
    // 확산을 막기 위해 연구소에 벽 세움.
    private static int row;
    private static int col;
    private static int[][] map;
    private static int[][] tempMap;

    private static int[] dx = {1, 0, -1, 0};
    private static int[] dy = {0, 1, 0, -1};

    private static int unInfected;
    private static int infected = Integer.MAX_VALUE;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        row = scan.nextInt();
        col = scan.nextInt();

        map = new int[row][col];

        for(int i=0; i < row; i++){
            for(int j=0; j < col; j++){
                map[i][j] = scan.nextInt();
            }
        }

        tempMap = new int[row][col];
        for(int i=0; i < row; i++){
            for(int j=0; j < col; j++){
                if(map[i][j] == 0){
                    copyMap(tempMap, map);

                    tempMap[i][j] = 1;
                    putWall(tempMap,1);
                    tempMap[i][j] = 0;
                }
            }
        }

        System.out.println(unInfected);
        scan.close();
    }

    // 맵을 임시 맵으로 복사함.
    private static void copyMap(int[][] temp, int[][] original){
        for(int i=0; i < row; i++){
            for(int j=0; j < col; j++){
                temp[i][j] = original[i][j];
            }
        }
    }

    // 벽을 세움
    private static void putWall(int map[][], int cnt){

        // 벽 3개를 세웠으면
        if(cnt == 3){
            // 바이러스를 퍼뜨림
            spreadVirus();
            return;
        }


        for(int i=0; i < row; i++){
            for(int j=0; j < col; j++){
                if(map[i][j] == 0){
                    map[i][j] = 1;

                    putWall(map,cnt+1);

                    // 재귀적으로 호출하여 벽을 세우고 원래로 돌림
                    map[i][j] = 0;
                }
            }
        }
    }

    // 벽이 세워진 후 virus를 감염시킴
    private static void spreadVirus(){

        Queue<LabPoint> q = new LinkedList<>();

        int labMap[][] = new int[row][col];

        int currentInfection = 0;
        copyMap(labMap, tempMap);
        for(int i=0; i < row; i++){
            for(int j=0; j < col; j++){
                if(labMap[i][j] == 2){
                    q.add(new LabPoint(i, j));
                    currentInfection++;
                }
            }
        }

        while(!q.isEmpty()){
            LabPoint actual = q.remove();
            int cx = actual.getX();
            int cy = actual.getY();

            for(int k=0; k < 4; k++){
                int nx = cx + dx[k];
                int ny = cy + dy[k];

                if(nx < 0 || nx >= col || ny < 0 || ny >= row) continue;
                if(labMap[ny][nx] == 0){
                    q.add(new LabPoint(ny, nx));
                    labMap[ny][nx] = 2;
                    currentInfection++;
                    if(infected <= currentInfection){
                        return;
                    }
                }
            }
        }
        infected = currentInfection;

        int now_unInfected = 0;
        for(int i=0; i < row; i++){
            for(int j=0; j < col; j++){
                if(labMap[i][j] == 0){
                    now_unInfected++;
                }
            }
        }

        unInfected = Math.max(unInfected, now_unInfected);
    }

}

// 연구소의 x, y 지점을 나타내기 위한 class
class LabPoint{
    int y;
    int x;

    public LabPoint(int y, int x) {
        this.y = y;
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public int getX() {
        return x;
    }
}