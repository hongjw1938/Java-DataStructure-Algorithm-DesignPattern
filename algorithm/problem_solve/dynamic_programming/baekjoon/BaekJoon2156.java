package problem_solve.dynamic_programming.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2156 {
    static int[] td;
    static int[] wine;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        wine = new int[n];
        int[] dp = new int[n];
        for(int i=0; i < n; i++) {
            wine[i] = Integer.parseInt(br.readLine());
        }
        // Bottom-up
        for(int i=0; i < n; i++){
            if(i==0){
                dp[0] = wine[0];
            } else if (i ==1) {
                dp[1] = wine[0] + wine[1];
            } else if (i==2){
                dp[2] = Math.max(dp[1], Math.max(dp[0] + wine[2], wine[1] + wine[2]));
            } else{
                dp[i] = Math.max(dp[i-1], Math.max(dp[i-2] + wine[i], dp[i-3] + wine[i-1] + wine[i]));
            }
        }
        System.out.println(dp[n-1]);

        // Top-Down
        td = new int[n];
        System.out.println(topDown(n-1));

        br.close();
    }

    private static int topDown(int n){
        if(td[n] > 0) return td[n];
        if(n == 0){
            return td[0] = wine[0];
        }
        if(n == 1) {
            return td[1] = wine[0] + wine[1];
        }
        if(n == 2) {
            return td[2] = Math.max(topDown(n-1), Math.max(wine[0] + wine[2], wine[1] + wine[2]));
        }

        td[n] = Math.max(topDown(n-1), Math.max(topDown(n-2) + wine[n], topDown(n-3) + wine[n-1] + wine[n]));
        return td[n];
    }
}
