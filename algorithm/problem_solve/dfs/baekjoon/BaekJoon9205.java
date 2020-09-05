package problem_solve.dfs.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon9205 {
    // 송도에서 락 페스티벌 가는 도중 맥주 마시기

    /*
    1. 케이스 수, 편의점 수, 좌표를 순서대로 읽어들임
      - x, y 좌표를 50으로 나누어 몫 + 나머지 있는 경우 1씩 더하여 20이하면 happy로 끝
    2.
     */

    private static int con_num;
    private static Cordination[] cordinations;
    private static boolean isHappy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int test = Integer.parseInt(br.readLine());
        for(int i=0; i < test; i++){
            con_num = Integer.parseInt(br.readLine());

            cordinations = new Cordination[con_num+2];
            isHappy = false;
            for(int j=0; j <= con_num+1; j++){
                String line[] = br.readLine().split(" ");
                int y = Integer.parseInt(line[0]);
                int x = Integer.parseInt(line[1]);
                cordinations[j] = new Cordination(y, x);
            }
            isHappy = dfs(cordinations[0], 0);

            if(isHappy){
                System.out.println("happy");
            } else {
                System.out.println("sad");
            }

        }
        br.close();
    }

    private static boolean dfs(Cordination cord, int obj_num){
        int currentY = cord.y;
        int currentX = cord.x;

        boolean ret_bool = false;
        int diff;
        for(int i=obj_num+1; i < cordinations.length; i++){

            int nextY = cordinations[i].y;
            int nextX = cordinations[i].x;

            int diff_y = Math.abs(currentY - nextY);
            int diff_x = Math.abs(currentX - nextX);

            diff = diff_x + diff_y;
            if(diff < 1000 && i != con_num+1){
                ret_bool = dfs(cordinations[i], i);
            }
            if(diff < 1000 && i == con_num+1){
                ret_bool = true;
            }

            if(ret_bool){
                break;
            }
        }
        return ret_bool;
    }
}

class Cordination{
    int y;
    int x;
    boolean visited;

    public Cordination(int y, int x) {
        this.y = y;
        this.x = x;
        visited = false;
    }
}
