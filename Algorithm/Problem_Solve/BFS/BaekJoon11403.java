package com.problemsolve.bfs;

import java.util.*;

public class BaekJoon11403 {
    // 가중치 없는 방향 그래프 G가 주어질 때, 모든 정점 (i, j)에 대해서, i에서 j로
    // 가는 경로가 있는지 없는지 구하는 프로그램 작성
    private static int[][] neighbors;
    private static int[][] path;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int vertex_num = scan.nextInt();

        neighbors = new int[vertex_num][vertex_num];
        path = new int[vertex_num][vertex_num];

        for(int i=0; i < vertex_num; i++){
            for(int j=0; j < vertex_num; j++){
                neighbors[i][j] = scan.nextInt();
            }
        }

        for(int i=0; i < vertex_num; i++){
            boolean[] visited = new boolean[vertex_num];
            bfs(i, visited);
        }

        for(int i=0; i < path.length; i++){
            for(int j=0; j < path[i].length; j++){
                System.out.print(path[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void bfs(int startIndex, boolean[] visited){
        Queue<Integer> q = new LinkedList<>();

        q.add(startIndex);

        while(!q.isEmpty()){
            int row[] = neighbors[q.remove()];

            for(int colIndex = 0; colIndex < row.length; colIndex++){
                if(row[colIndex] == 1 && visited[colIndex] != true){
                    path[startIndex][colIndex] = 1;
                    visited[colIndex] = true;

                    q.add(colIndex);
                }
            }

        }
    }
}
