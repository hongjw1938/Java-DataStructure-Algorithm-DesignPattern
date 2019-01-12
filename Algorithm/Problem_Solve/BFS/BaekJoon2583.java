package com.problemsolve.bfs;


import java.util.*;

public class BaekJoon2583 {

    // 모눈종이에 직사각형을 그리고 나뉘는 부분
    // 에 대한 개수와 크기 구하기
    private static boolean[][] visited;
    private static List<Integer> list = new ArrayList<>();
    private static int y;
    private static int x;

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        y = scan.nextInt();
        x = scan.nextInt();
        int rectangles = scan.nextInt();

        visited = new boolean[y][x];

        for(int i=0; i < rectangles; i++){
            int x1 = scan.nextInt();
            int y1 = scan.nextInt();

            int x2 = scan.nextInt();
            int y2 = scan.nextInt();

            for(int j=x1; j < x2; j++){
                for(int k=y1; k < y2; k++){
                    visited[k][j] = true;
                }
            }
        }

        for(int i=0; i < y; i++){
            for(int j=0; j < x; j++){
                if(!visited[i][j]){
                    list.add(bfs(j, i));
                }
            }
        }

        Collections.sort(list);
        int size = list.size();
        System.out.println(size);

        for(int i=0; i < size; i++){
            System.out.print(list.get(i) + " ");
        }
    }

    public static int bfs(int s_x , int s_y){
        Queue<Point> q = new LinkedList<>();

        Point p = new Point(s_x, s_y);
        q.add(p);
        int ret_val = 1;

        visited[s_y][s_x] = true;

        int[] go_x = {0, -1, 0, 1};
        int[] go_y = {-1, 0, 1, 0};
        while(!q.isEmpty()){
            Point now = q.remove();

            for(int go = 0; go < 4; go++){
                int nextX = now.getX() + go_x[go];
                int nextY = now.getY() + go_y[go];

                if(nextX >= 0 && nextX < x && nextY >= 0 && nextY < y && !visited[nextY][nextX]){
                    q.add(new Point(nextX, nextY));
                    visited[nextY][nextX] = true;
                    ret_val++;
                }
            }
        }
        return ret_val;
    }
}


class Point{
    private int x;
    private int y;

    Point(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
}