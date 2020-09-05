package problem_solve.dynamic_programming.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon11057 {
    static int td[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dp[][] = new int[n + 1][10];

        // Bottom-up
        for (int i = 0; i < 10; i++) {
            dp[1][i] = 1;
        }
        for(int i=1; i <= n; i++) {
            for(int j=0; j < 10; j++) {
                for(int k=0; k <= j; k++) {
                    dp[i][j] += dp[i-1][k];
                    dp[i][j] %= 10007;
                }
            }
        }
        int sum = 0;
        for(int i=0; i < 10; i++) {
            sum += dp[n][i];
        }
        System.out.println(sum % 10007);

        // Top-Down
        td = new int[n+1][10];
        int td_sum =0;
        for(int i=0; i < 10; i++){
            td_sum += topDown(n, i);
            td_sum %= 10007;
        }
        System.out.println(td_sum);
        br.close();
    }
    private static int topDown(int n, int i){
        if(td[n][i] > 0) return td[n][i];
        if(n==1) return td[n][i] = 1;

        for(int k=0; k <= i; k++){
            td[n][i] = (td[n][i] + topDown(n-1, k)) % 10007;
        }
        return td[n][i];
    }
}
