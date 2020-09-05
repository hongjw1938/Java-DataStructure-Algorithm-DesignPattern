package problem_solve.dynamic_programming.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2225 {
    static int[][] td;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] s = br.readLine().split(" ");
        int N = Integer.parseInt(s[0]);
        int K = Integer.parseInt(s[1]);

        int dp[][] = new int[N+1][K+1];
        for(int i=1; i <= N; i++){
            for(int j=1; j <= K; j++){
                if(j == 1){
                    dp[i][j] = 1;
                } else if(i == 1){
                    dp[i][j] = j;
                } else {
                    dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % 1000000000;
                }
            }
        }
        System.out.println(dp[N][K]);

        // Top-Down
        td = new int[N+1][K+1];
        System.out.println(topDown(N, K));

        br.close();
    }
    private static int topDown(int n, int k){
        if(td[n][k] > 0) return td[n][k];
        if(k == 1) return td[n][k] = 1;
        if(n == 1) return td[n][k] = k;

        return td[n][k] = (topDown(n-1, k) + topDown(n , k-1)) % 1000000000;
    }
}
