package problem_solve.dynamic_programming.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon1309 {
    static int[] td;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int dp[] = new int[n+1];
        dp[0] = 1; dp[1] = 3;

        // Bottom-up
        for(int i = 2; i <= n; i++){
            dp[i] = ((dp[i-1] * 2) % 9901 + dp[i-2]) % 9901;
        }

        System.out.println(dp[n]);

        // Top-Down
        td = new int[n+1];
        td[0] = 1; td[1] = 3;
        System.out.println(topDown(n));
        br.close();
    }
    private static int topDown(int n){
        if(td[n] > 0) return td[n];

        return td[n] = (topDown(n-2) + (topDown(n-1) * 2) % 9901) % 9901;
    }
}
