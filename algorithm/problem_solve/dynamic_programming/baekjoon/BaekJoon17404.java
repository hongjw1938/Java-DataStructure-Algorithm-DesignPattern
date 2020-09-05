package problem_solve.dynamic_programming.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BaekJoon17404 {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int rgb[][] = new int[n][3];
        int dp[][] = new int[n][3];
        for(int i=0; i < n; i++){
            String s[] = br.readLine().split(" ");
            for (int j=0; j < 3; j++){
                rgb[i][j] = Integer.parseInt(s[j]);
            }
        }

        int ans = Integer.MAX_VALUE;
        for(int i=0; i < 3; i++){
            for(int j=0; j < 3; j++){
                if(i==j){
                    dp[0][j] = rgb[0][j];
                } else {
                    dp[0][j] = 1000 * 1000 + 1;
                }
            }
            for(int j=1; j < n; j++){
                dp[j][0] = Math.min(dp[j-1][1], dp[j-1][2]) + rgb[j][0];
                dp[j][1] = Math.min(dp[j-1][0], dp[j-1][2]) + rgb[j][1];
                dp[j][2] = Math.min(dp[j-1][0], dp[j-1][1]) + rgb[j][2];
            }

            for(int j=0; j < 3; j++){
                if(i == j){
                    continue;
                }
                ans = Math.min(ans, dp[n-1][j]);
            }
        }

        System.out.println(ans);
        br.close();
    }
}
