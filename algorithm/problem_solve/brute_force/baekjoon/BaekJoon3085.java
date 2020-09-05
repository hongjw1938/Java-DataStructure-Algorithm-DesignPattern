package problem_solve.brute_force.baekjoon;
import java.io.*;
public class BaekJoon3085{
    static char[][] bomboni;
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        bomboni = new char[n][n];
        for(int i=0; i < n; i++){
            bomboni[i] = br.readLine().toCharArray();
        }
        int ans = 0;
        for(int i=0; i < n; i++){
            for(int j=0; j < n; j++){
                // Horizontally change
                if(i < n-1){
                    swap(i, j, i+1, j);
                    ans = Math.max(ans, getMax(i, j));
                    ans = Math.max(ans, getMax(i+1, j));
                    swap(i, j, i+1, j);
                }

                if(j < n-1){
                    swap(i, j, i, j+1);
                    ans = Math.max(ans, getMax(i, j));
                    ans = Math.max(ans, getMax(i, j+1));
                    swap(i, j, i, j+1);
                }
            }
        }

        System.out.println(ans);
        br.close();
    }
    private static void swap(int y, int x, int ny, int nx){
        char temp = bomboni[y][x];
        bomboni[y][x] = bomboni[ny][nx];
        bomboni[ny][nx] = temp;
    }
    private static int getMax(int y, int x){
        char c = bomboni[y][x];

        int hcnt = 1;
        int wcnt = 1;

        // find left direction
        for(int i=x-1; i >= 0; i--){
            if(bomboni[y][i] != c){
                break;
            }
            hcnt++;
        }

        // find right direction
        for(int i=x+1; i < n; i++){
            if(bomboni[y][i] != c){
                break;
            }
            hcnt++;
        }

        // find up direction
        for(int i= y-1; i >= 0; i--){
            if(bomboni[i][x] != c){
                break;
            }
            wcnt++;
        }

        for(int i=y+1; i < n; i++){
            if(bomboni[i][x] != c){
                break;
            }
            wcnt++;
        }

        return Math.max(hcnt, wcnt);
    }
}