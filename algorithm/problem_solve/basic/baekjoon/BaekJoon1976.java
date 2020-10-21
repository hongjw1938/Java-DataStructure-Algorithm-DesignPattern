package problem_solve.basic.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BaekJoon1976 {
    static int[][] arr = new int[201][201];
    static boolean check[] = new boolean[201];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());


        StringTokenizer st;
        for(int i=1; i <= n; i++){
            st = new StringTokenizer(br.readLine());
            int j = 1;
            while(st.hasMoreTokens()){
                arr[i][j] = Integer.parseInt(st.nextToken());
                j++;
            }
        }
        st = new StringTokenizer(br.readLine());
        int first = Integer.parseInt(st.nextToken());
        check(first, n);

        boolean success = true;
        while(st.hasMoreTokens()){
            int next = Integer.parseInt(st.nextToken());
            if(!check[next]){
                success = false;
                break;
            }
        }

        System.out.println(success ? "YES" : "NO");

        br.close();
    }
    public static void check(int idx, int n){
        check[idx] = true;
        for(int i=0; i < arr[idx].length; i++){
            if(check[i] || arr[idx][i] == 0){
                continue;
            } else {
                check(i, n);
            }
        }
    }
}
