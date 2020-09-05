package problem_solve.dynamic_programming.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon2133 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n+1];

        int ans = 0;
        if (n % 2 == 0){
            dp[2] = 3;
            dp[0] = 1;
            for(int i = 4; i <= n ;i+=2){
                for(int j=2; j <= i; j += 2){
                    int std = j== 2 ? 3 : 2;
                    dp[i] += std * dp[i-j];
                }
            }
            ans = dp[n];
        }

        System.out.println(ans);
        br.close();
    }
}
