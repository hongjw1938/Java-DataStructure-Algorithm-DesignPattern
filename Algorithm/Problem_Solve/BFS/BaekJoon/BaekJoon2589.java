package com.problemsolve.bfs.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon2589 {
    // 보물 지도를 발견한 후크 선장은 육지 / 바다로 표시된 지도에서
    // 상하좌우로 이웃한 육지로 이동하여 보물을 찾는데
    // 보물은 상호 간 최단 거리로 이동하는데 있어 가장 긴 시간 걸리는
    // 육지 두 곳에 나뉘어 묻혀있음. 두 곳 간의 최단 거리 이동 시간 구하기

    private static int width;
    private static int height;

    private static String map[];

    private static int[] movex = {1, 0, -1, 0};
    private static int[] movey = {0, 1, 0, -1};

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        height = scan.nextInt();
        width = scan.nextInt();

        scan.nextLine();
        map = new String[height];

        for(int i=0; i < height; i++){
            String next = scan.nextLine();
            map[i] = next;
        }

        int max_val = 0;
        // L일 때마다 bfs
        for(int i=0; i < height; i++){
            for(int j=0; j < width; j++) {
                if(map[i].charAt(j) == 'L'){
                    int retval = bfs(i, j);
                    max_val = Math.max(max_val, retval);
                }
            }
        }

        System.out.println(max_val);
        scan.close();
    }

    private static int bfs(int y, int x){

        boolean[][] visited = new boolean[height][width];
        visited[y][x] = true;
        int move = 0;

        Queue<MapPoint> q = new LinkedList<>();
        q.add(new MapPoint(y, x));

        Queue<MapPoint> subq = new LinkedList<>();
        while(!q.isEmpty()){

            MapPoint actual = q.remove();
            for(int i=0; i < 4; i++){
                int nexty = actual.y + movey[i];
                int nextx = actual.x + movex[i];

                if(nexty < 0 || nexty >= height) continue;
                if(nextx < 0 || nextx >= width) continue;

                if(visited[nexty][nextx]) continue;

                if(map[nexty].charAt(nextx) == 'L'){
                    visited[nexty][nextx] = true;

                    subq.add(new MapPoint(nexty, nextx));
                }
            }

            if(q.isEmpty() && !subq.isEmpty()){
                move++;
                while(!subq.isEmpty()){
                    q.add(subq.remove());
                }
            }
        }
        return move;
    }
}

class MapPoint{
    int y;
    int x;

    public MapPoint(int y, int x) {
        this.y = y;
        this.x = x;
    }
}