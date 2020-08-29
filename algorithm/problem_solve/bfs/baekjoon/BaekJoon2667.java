package com.algorithm.problem_solve.bfs.baekjoon;

import java.util.*;

public class BaekJoon2667 {
    // 아파트 단지 번호 붙이기

    private static String apart[];
    private static boolean visited[][];
    private static List<Integer> list;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        int size = Integer.parseInt(scan.nextLine());

        apart = new String[size];
        visited = new boolean[size][size];
        list = new ArrayList<>();

        for(int i=0; i < size; i++){
            apart[i] = scan.nextLine();
        }

        for(int i=0; i < size; i++){
            for(int j=0; j < size; j++){
                if(!visited[i][j] && apart[i].charAt(j) == '1'){
                    list.add(bfs(i, j, size));
                }
            }
        }

        Collections.sort(list);

        int s = list.size();
        System.out.println(s);
        for(int i=0; i < s; i++){
            System.out.println(list.get(i));
        }
    }

    public static int bfs(int y, int x, int size){

        Queue<Apart> q = new LinkedList<>();
        q.add(new Apart(x, y));
        visited[y][x] = true;
        int ret_val = 1;

        int[] moveX = {-1, 0, 1, 0};
        int[] moveY = {0, 1, 0, -1};

        while(!q.isEmpty()){
            Apart ap = q.remove();

            for(int i=0; i < 4; i++){
                int nextX = ap.getX() + moveX[i];
                int nextY = ap.getY() + moveY[i];

                if(0 <= nextX && nextX < size && 0 <= nextY && nextY < size && !visited[nextY][nextX] && apart[nextY].charAt(nextX) == '1'){
                    visited[nextY][nextX] = true;
                    q.add(new Apart(nextX, nextY));
                    ret_val++;
                }
            }
        }

        return ret_val;
    }
}


class Apart{

    private int x;
    private int y;

    Apart(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}