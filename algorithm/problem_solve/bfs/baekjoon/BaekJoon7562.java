package problem_solve.bfs.baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class BaekJoon7562 {

    // 체스판에 나이트가 이동하는 경로를 계산하여
    // 목표 지점에 도달하기 까지 걸리는 횟수 구하기

    private static boolean[][] visited;
    private static int[] moveX = {-1, 1, 2, -2, -1, 1, 2, -2};
    private static int[] moveY = {2, 2, 1, 1, -2, -2 ,-1, -1};

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int case_num = scan.nextInt();

        for(int i=0; i < case_num; i++){
            int size = scan.nextInt();

            visited = new boolean[size][size];

            int start_x = scan.nextInt();
            int start_y = scan.nextInt();

            ChessPoint startPoint = new ChessPoint(start_y, start_x);

            visited[start_y][start_x] = true;

            int target_x = scan.nextInt();
            int target_y = scan.nextInt();

            ChessPoint targetPoint = new ChessPoint(target_y, target_x);


            System.out.println(bfs(startPoint, targetPoint, size));
        }

        scan.close();
    }

    private static int bfs(ChessPoint sp, ChessPoint tp, int size){
        Queue<ChessPoint> q = new LinkedList<>();
        q.add(sp);

        int moved = 0;

        int target_x = tp.getX();
        int target_y = tp.getY();
        if(sp.getX() == target_x && sp.getY() == target_y){
            return moved;
        }

        Queue<ChessPoint> subq = new LinkedList<>();

        while(!q.isEmpty()){

            ChessPoint actual = q.remove();
            int start_x = actual.getX();
            int start_y = actual.getY();

            for(int i=0; i < 8; i++){
                int nextX = start_x + moveX[i];
                int nextY = start_y + moveY[i];

                if(0 > nextX || nextX >= size || 0 > nextY || nextY >= size){
                    continue;
                }


                if(nextX == target_x && nextY == target_y){
                    return ++moved;
                }

                if(!visited[nextY][nextX]){
                    visited[nextY][nextX] = true;
                    subq.add(new ChessPoint(nextY, nextX));
                }
            }

            if(q.size() == 0){
                moved++;
                while(!subq.isEmpty()){
                    q.add(subq.remove());
                }
            }

        }

        return 0;
    }
}

class ChessPoint{

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

    public ChessPoint(int y, int x) {
        this.y = y;
        this.x = x;
    }
}