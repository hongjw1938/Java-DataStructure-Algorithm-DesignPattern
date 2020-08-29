package com.problemsolve.bfs.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class BaekJoon2573 {

    // 지구 온난화로 인해 빙산이 녹고 있다. 빙산이 두 조각 이상이 되기 시작하는 년도는?
    private static int[][] icebergMap = new int[300][300];
    private static int N, M, year = 0;
    private static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static boolean[][] visited = new boolean[300][300];
    private static int icebergNum = 1;
    private static int[][] tempMap = new int[300][300];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] nm = br.readLine().split(" ");
        N = Integer.parseInt(nm[0]);
        M = Integer.parseInt(nm[1]);

        // Map을 그린다.
        for(int i=0; i < N; i++){
            String[] line = br.readLine().split(" ");
            for(int j=0; j < M; j++){
                icebergMap[i][j] = Integer.parseInt(line[j]);
            }
        }

        while(icebergNum < 2){
            getSplitNum();
            if(icebergNum >= 2 || icebergNum == 0){
                break;
            }

            for(int i=0; i < N; i++){
                for(int j=0; j < M; j++){
                    if(icebergMap[i][j] == 0){
                        continue;
                    }
                    calculate(i, j);
                }
            }
            melt();
        }

        System.out.println(year);

        br.close();
    }

    // 빙산을 녹일 수준 계산.
    private static void calculate(int y, int x){
        int surround = 0;
        for(int i=0; i < 4; i++){
            int ny = y + move[i][0];
            int nx = x + move[i][1];
            if(isInRange(ny, nx) && icebergMap[ny][nx] == 0){
                surround++;
            }
        }
        tempMap[y][x] = surround;

    }

    // 실제로 녹임
    private static void melt(){
        for(int i=0; i < N; i++){
            for(int j=0; j < M; j++){
                if(icebergMap[i][j] == 0){
                    continue;
                }
                if(icebergMap[i][j] - tempMap[i][j] < 0){
                    icebergMap[i][j] = 0;
                } else {
                    icebergMap[i][j] -= tempMap[i][j];
                }

            }
        }
        year++;
    }

    // 분리된 빙산의 개수를 구함
    private static void getSplitNum(){
        int num = 0;
        for(int i=0; i < N; i++){
            for(int j=0; j < M; j++){
                if(icebergMap[i][j] == 0 || visited[i][j]){
                    continue;
                }
                num++;
                bfs(i, j);
            }
        }
        icebergNum = num;;
        if(icebergNum >= 2){
            return;
        } else if(icebergNum == 0){
            year = 0;
            return;
        }

        for(int i=0; i < N; i++){
            for(int j=0; j < M; j++){
                visited[i][j] = false;
            }
        }
    }

    // bfs
    private static void bfs(int y, int x){
        visited[y][x] = true;
        Queue<IcebergPoint> q = new LinkedList<>();
        q.add(new IcebergPoint(y, x));

        while(!q.isEmpty()){
            IcebergPoint actual = q.remove();
            for(int i=0; i < 4; i++){
                int ny = actual.getY() + move[i][0];
                int nx = actual.getX() + move[i][1];

                if(isInRange(ny, nx) && !visited[ny][nx] && icebergMap[ny][nx] != 0){
                    visited[ny][nx] = true;
                    q.add(new IcebergPoint(ny, nx));
                }
            }

        }
    }

    // range 안에 있는지 확인
    private static boolean isInRange(int y, int x){
        return 0 <= y && y < N && 0 <= x && x <= M;
    }
}

class IcebergPoint{
    int y;
    int x;

    public IcebergPoint(int y, int x) {
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
